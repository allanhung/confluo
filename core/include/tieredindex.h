#ifndef TIEREDINDEX_H_
#define TIEREDINDEX_H_

#include <atomic>
#include <array>

#include "entrylist.h"

namespace slog {
template<typename T, size_t SIZE = 65536>
class indexlet {
 public:
  typedef std::atomic<T*> atomic_ref;

  indexlet() {
    for (uint32_t i = 0; i < SIZE; i++) {
      idx_[i].store(NULL, std::memory_order_release);
    }
  }

  ~indexlet() {
    for (uint32_t i = 0; i < SIZE; i++) {
      delete idx_[i].load(std::memory_order_acquire);
    }
  }

  T* operator[](const uint32_t i) {
    if (idx_[i].load() == NULL) {
      T* item = new T();
      T* null_ptr = NULL;

      // Only one thread will be successful in replacing the NULL reference with newly
      // allocated item.
      if (!std::atomic_compare_exchange_strong_explicit(
          &idx_[i], &null_ptr, item, std::memory_order_release,
          std::memory_order_release)) {
        // All other threads will deallocate the newly allocated item.
        delete item;
      }
    }

    return idx_[i].load(std::memory_order_acquire);
  }

  T* at(const uint32_t i) const {
    return idx_[i].load(std::memory_order_acquire);
  }

  size_t size() {
    return SIZE;
  }

  size_t storage_size() {
    size_t tot_size = SIZE * sizeof(atomic_ref);
    for (uint32_t i = 0; i < SIZE; i++) {
      if (idx_[i].load(std::memory_order_acquire) != NULL) {
        tot_size += idx_[i].load(std::memory_order_acquire)->storage_size();
      }
    }
    return tot_size;
  }

 private:
  std::array<atomic_ref, SIZE> idx_;
};

template<size_t SIZE>
class __index_depth1 {
 public:
  entry_list* get(uint64_t key) {
    return idx_[key];
  }

  void add_entry(uint64_t key, uint64_t val) {
    entry_list* list = get(key);
    list->push_back(val);
  }

  size_t max_size() {
    return SIZE;
  }

  size_t storage_size() {
    return idx_.storage_size();
  }

 private:
  indexlet<entry_list, SIZE> idx_;
};

template<size_t SIZE1, size_t SIZE2>
class __index_depth2 {
 public:
  entry_list* get(uint64_t key) {
    indexlet<entry_list, SIZE2>* ilet = idx_[key / SIZE2];
    return (*ilet)[key % SIZE2];
  }

  void add_entry(uint64_t key, uint64_t val) {
    entry_list* list = get(key);
    list->push_back(val);
  }

  size_t max_size() {
    return SIZE1 * SIZE2;
  }

  size_t storage_size() {
    return idx_.storage_size();
  }

 private:
  indexlet<indexlet<entry_list, SIZE2>, SIZE1> idx_;
};

typedef __index_depth1 <256> __index1;
typedef __index_depth1 <65536> __index2;
typedef __index_depth2 <65536, 256> __index3;
typedef __index_depth2 <65536, 65536> __index4;

}
#endif /* TIEREDINDEX_H_ */

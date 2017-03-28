#include "server/log_store_client.h"
#include "benchmark.h"
#include "logger.h"
#include "assertions.h"
#include "cmd_parse.h"
#include "time_utils.h"
#include "rand_utils.h"

using namespace ::datastore;

#define DATA_SIZE 64

class ls_server_benchmark : public utils::bench::benchmark<log_store_client> {
 public:
  ls_server_benchmark(const std::string& output_dir, size_t load_records,
                      const std::string& host, int port)
      : utils::bench::benchmark<log_store_client>(output_dir) {
    ds_.connect(host, port);
    PRELOAD_RECORDS = load_records;
    for (size_t i = 0; i < load_records; i++)
      ds_.append(append_data());
  }

  static std::string append_data() {
    return std::string(DATA_SIZE, 'x');
  }

  static std::string update_data() {
    return std::string(DATA_SIZE, 'x');
  }

  static void append(log_store_client& client) {
    client.append(append_data());
  }

  static void get(log_store_client& client) {
    std::string ret;
    client.get(ret, utils::rand_utils::rand_int64(PRELOAD_RECORDS));
  }

  static void update(log_store_client& client) {
    client.update(utils::rand_utils::rand_int64(PRELOAD_RECORDS),
                  update_data());
  }

  static void invalidate(log_store_client& client) {
    client.invalidate(utils::rand_utils::rand_int64(PRELOAD_RECORDS));
  }

  DEFINE_BENCH(append)
  DEFINE_BENCH(get)
  DEFINE_BENCH(update)
  DEFINE_BENCH(invalidate)

 private:
  static uint64_t PRELOAD_RECORDS;
};

uint64_t ls_server_benchmark::PRELOAD_RECORDS = 0;

int main(int argc, char** argv) {
  cmd_options opts;
  opts.add(
      cmd_option("num-threads", 't', false).set_default("1").set_description(
          "Number of benchmark threads"));
  opts.add(
      cmd_option("output-dir", 'o', false).set_default("results")
          .set_description("Output directory"));
  opts.add(
      cmd_option("bench-op", 'b', false).set_default("append").set_description(
          "Benchmark operation (append, get, update, invalidate)"));
  opts.add(
      cmd_option("preload-records", 'r', false).set_default("0").set_description(
          "#Records to pre-load the logstore with"));
  opts.add(
      cmd_option("server", 's', false).set_default("localhost").set_description(
          "Server to connect"));
  opts.add(
      cmd_option("port", 'p', false).set_default("9090").set_description(
          "Server port"));

  cmd_parser parser(argc, argv, opts);
  if (parser.get_flag("help")) {
    fprintf(stderr, "%s\n", parser.help_msg().c_str());
    return 0;
  }

  int num_threads;
  std::string output_dir;
  std::string bench_op;
  long load_records;
  std::string server;
  int port;
  try {
    num_threads = parser.get_int("num-threads");
    output_dir = parser.get("output-dir");
    bench_op = parser.get("bench-op");
    load_records = parser.get_long("preload-records");
    server = parser.get("server");
    port = parser.get_int("port");
  } catch (std::exception& e) {
    fprintf(stderr, "could not parse cmdline args: %s\n", e.what());
    fprintf(stderr, "%s\n", parser.help_msg().c_str());
    return 0;
  }

  const char* fmt = "#threads=%d, odir=%s, bench_op=%s,"
      " #records=%ld, server=%s, port=%d\n";
  fprintf(stderr, fmt, num_threads, output_dir.c_str(), bench_op.c_str(),
          load_records, server.c_str(), port);

  ls_server_benchmark perf(output_dir, load_records, server, port);
  if (bench_op == "append") {
    perf.bench_append(num_threads);
  } else if (bench_op == "get") {
    assert_throw(load_records > 0, "Need to pre-load data for get benchmark");
    perf.bench_get(num_threads);
  } else if (bench_op == "update") {
    assert_throw(load_records > 0,
                 "Need to pre-load data for update benchmark");
    perf.bench_update(num_threads);
  } else if (bench_op == "invalidate") {
    assert_throw(load_records > 0,
                 "Need to pre-load data for invalidate benchmark");
    perf.bench_invalidate(num_threads);
  } else {
    fprintf(stderr, "Unknown benchmark op: %s\n", bench_op.c_str());
  }

  return 0;
}


package jsonbench

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._

@State(Scope.Thread)
@Fork(1)
class Bench {
  var s = "{\"id\": 123, \"login\": \"vasya\", \"email\": \"vasya@example.net\"}"
  var u = User(123, "vasya", "vasya@example.net")

  @Benchmark
  @Warmup(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
  @Measurement(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
  def playParse(): User = PlayUserCodec.decode(s)

  @Benchmark
  @Warmup(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
  @Measurement(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
  def argonautParse(): User = ArgonautUserCodec.decode(s)

  @Benchmark
  @Warmup(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
  @Measurement(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
  def sprayParse(): User = SprayUserCodec.decode(s)

  @Benchmark
  @Warmup(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
  @Measurement(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
  def jacksonParse(): User = JacksonUserCodec.decode(s)

  @Benchmark
  @Warmup(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
  @Measurement(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
  def jawnParse(): User = JawnUserCodec.decode(s)

  @Benchmark
  @Warmup(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
  @Measurement(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
  def playMarshall(): String = PlayUserCodec.encode(u)

  @Benchmark
  @Warmup(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
  @Measurement(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
  def argonautMarshall(): String = ArgonautUserCodec.encode(u)

  @Benchmark
  @Warmup(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
  @Measurement(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
  def sprayMarshall(): String = SprayUserCodec.encode(u)

  @Benchmark
  @Warmup(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
  @Measurement(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
  def jacksonMarshall(): String = JacksonUserCodec.encode(u)
}
package jsonbench

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._

@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
class ParseBench {
  var s =
    """
      |{"success":true,"users":[
      |{"email":"email1@example.net","tags":["tag1","tag2"],"fullName":"fullName1","id":1,"login":"login1"},
      |{"email":"email2@example.net","tags":["tag1","tag2"],"fullName":"fullName2","id":2,"login":"login2"},
      |{"email":"email3@example.net","tags":["tag1","tag2"],"fullName":"fullName3","id":3,"login":"login3"},
      |{"email":"email4@example.net","tags":["tag1","tag2"],"fullName":"fullName4","id":4,"login":"login4"},
      |{"email":"email5@example.net","tags":["tag1","tag2"],"fullName":"fullName5","id":5,"login":"login5"},
      |{"email":"email6@example.net","tags":["tag1","tag2"],"fullName":"fullName6","id":6,"login":"login6"},
      |{"email":"email7@example.net","tags":["tag1","tag2"],"fullName":"fullName7","id":7,"login":"login7"},
      |{"email":"email8@example.net","tags":["tag1","tag2"],"fullName":"fullName8","id":8,"login":"login8"},
      |{"email":"email9@example.net","tags":["tag1","tag2"],"fullName":"fullName9","id":9,"login":"login9"}]}
    """.stripMargin

  val playUserCodec = new PlayUserCodec()

  val argonautUserCodec = new ArgonautUserCodec()

  val sprayUserCodec: SprayUserCodec = new SprayUserCodec()

  val jacksonUserCodec = new JacksonUserCodec()

  val jawnUserCodec = new JawnUserCodec()

  @Benchmark
  def play(): UsersResponse = playUserCodec.decode(s)

  @Benchmark
  def argonaut(): UsersResponse = argonautUserCodec.decode(s)

  @Benchmark
  def spray(): UsersResponse = sprayUserCodec.decode(s)

  @Benchmark
  def jackson(): UsersResponse = jacksonUserCodec.decode(s)

  @Benchmark
  def jawn(): UsersResponse = jawnUserCodec.decode(s)
}
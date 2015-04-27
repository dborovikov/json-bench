package jsonbench

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._

@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
class MarshallBench {
  val r = UsersResponse(success = true, Seq(
    User(1, "email1@example.net", "login1", Some("fullName1"), Seq("tag1", "tag2")),
    User(2, "email2@example.net", "login2", Some("fullName2"), Seq("tag1", "tag2")),
    User(3, "email3@example.net", "login3", Some("fullName3"), Seq("tag1", "tag2")),
    User(4, "email4@example.net", "login4", Some("fullName4"), Seq("tag1", "tag2")),
    User(5, "email5@example.net", "login5", Some("fullName5"), Seq("tag1", "tag2")),
    User(6, "email6@example.net", "login6", Some("fullName6"), Seq("tag1", "tag2")),
    User(7, "email7@example.net", "login7", Some("fullName7"), Seq("tag1", "tag2")),
    User(8, "email8@example.net", "login8", Some("fullName8"), Seq("tag1", "tag2")),
    User(9, "email9@example.net", "login9", Some("fullName9"), Seq("tag1", "tag2"))
  ))

  val playUserCodec = new PlayUserCodec()

  val argonautUserCodec = new ArgonautUserCodec()

  val sprayUserCodec: SprayUserCodec = new SprayUserCodec()

  val jacksonUserCodec = new JacksonUserCodec()

  val jawnUserCodec = new JawnUserCodec()

  @Benchmark
  def play(): String = playUserCodec.encode(r)

  @Benchmark
  def argonaut(): String = argonautUserCodec.encode(r)

  @Benchmark
  def spray(): String = sprayUserCodec.encode(r)

  @Benchmark
  def jackson(): String = jacksonUserCodec.encode(r)
}
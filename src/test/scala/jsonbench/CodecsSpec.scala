package jsonbench

import org.specs2.mutable._

class CodecsSpec extends Specification {
  val r = UsersResponse(success = true, Seq(User(1, "email@example.net", "login", Some("fullName"), Seq("tag1", "tag2"))))
  val r2 = UsersResponse(success = true, Seq(
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


  "ArgonautUserCodec" should {
    "encode and decode" in {
      val codec = new ArgonautUserCodec()
      val s = codec.encode(r)
      codec.decode(s) mustEqual r
    }
  }

  "JacksonUserCodec" should {
    "encode and decode" in {
      val codec = new JacksonUserCodec()
      val s = codec.encode(r)
      codec.decode(s) mustEqual r
    }
  }

  "JawnUserCodec" should {
    "encode and decode" in {
      val codec = new JawnUserCodec()
      val s = codec.encode(r)
      codec.decode(s) mustEqual r
    }
  }

  "PlayUserCodec" should {
    "encode and decode" in {
      val codec = new PlayUserCodec()
      val s = codec.encode(r)
      codec.decode(s) mustEqual r
    }
  }

  "SprayUserCodec" should {
    "encode and decode" in {
      val codec = new SprayUserCodec()
      val s = codec.encode(r)
      codec.decode(s) mustEqual r
    }

    "test" in {
      val s = new SprayUserCodec().encode(r2)
      s mustEqual ""
    }
  }
}

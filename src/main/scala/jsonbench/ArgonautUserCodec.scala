package jsonbench

import argonaut._, Argonaut._

import scalaz._

object ArgonautUserCodec {
  implicit def PersonCodecJson =
    casecodec3(User.apply, User.unapply)("id", "email", "login")

  def decode(s: String): User = {
    s.decodeEither[User] match {
      case -\/(e) => throw new RuntimeException(e)
      case \/-(u) => u
    }
  }

  def encode(u: User): String = {
    val json = u.asJson
    json.nospaces
  }
}

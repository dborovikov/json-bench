package jsonbench

import argonaut._, Argonaut._

import scalaz._

class ArgonautUserCodec extends Codec[UsersResponse] {
  implicit def UserCodecJson =
    casecodec5(User.apply, User.unapply)("id", "email", "login", "fullName", "tags")

  implicit def UsersResponseCodecJson =
    casecodec2(UsersResponse.apply, UsersResponse.unapply)("success", "users")

  def decode(s: String): UsersResponse = {
    s.decodeEither[UsersResponse] match {
      case -\/(e) => throw new RuntimeException(e)
      case \/-(u) => u
    }
  }

  def encode(u: UsersResponse): String = {
    val json = u.asJson
    json.nospaces
  }
}

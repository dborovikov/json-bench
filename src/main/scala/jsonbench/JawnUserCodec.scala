package jsonbench

import spray.json._
import DefaultJsonProtocol._
import jawn.support.spray.Parser

class JawnUserCodec extends Codec[UsersResponse] {
  implicit val userFormat = jsonFormat(User, "id", "email", "login", "fullName", "tags")
  implicit val userResponseFormat = jsonFormat(UsersResponse, "success", "users")

  def decode(s: String): UsersResponse = {
    val json = Parser.parseFromString(s).get
    json.convertTo[UsersResponse]
  }

  def encode(u: UsersResponse): String = {
    val json = u.toJson
    json.compactPrint
  }
}
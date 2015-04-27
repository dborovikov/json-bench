package jsonbench

import spray.json._
import DefaultJsonProtocol._

class SprayUserCodec extends Codec[UsersResponse] {
  implicit val userFormat = jsonFormat(User, "id", "email", "login", "fullName", "tags")
  implicit val userResponseFormat = jsonFormat(UsersResponse, "success", "users")

  def decode(s: String): UsersResponse = {
    val json = s.parseJson
    json.convertTo[UsersResponse]
  }

  def encode(u: UsersResponse): String = {
    val json = u.toJson
    json.compactPrint
  }
}

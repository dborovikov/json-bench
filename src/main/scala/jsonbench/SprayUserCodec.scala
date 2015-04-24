package jsonbench

import spray.json._
import DefaultJsonProtocol._

object SprayUserCodec {
  implicit val userFormat = jsonFormat(User, "id", "email", "login")

  def decode(s: String): User = {
    val json = s.parseJson
    json.convertTo[User]
  }

  def encode(u: User): String = {
    val json = u.toJson
    json.compactPrint
  }
}

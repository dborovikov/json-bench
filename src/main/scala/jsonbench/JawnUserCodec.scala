package jsonbench

import spray.json._
import DefaultJsonProtocol._
import jawn.support.spray.Parser

object JawnUserCodec {
  implicit val userFormat = jsonFormat(User, "id", "email", "login")

  def decode(s: String): User = {
    val json = Parser.parseFromString(s).get
    json.convertTo[User]
  }

  def encode(u: User): String = ???
}
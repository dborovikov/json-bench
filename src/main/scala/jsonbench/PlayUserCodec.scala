package jsonbench

import play.api.libs.json._
import play.api.libs.functional.syntax._

object PlayUserCodec {
  implicit val userReads = (
    (JsPath \ "id").read[Int] and
    (JsPath \ "email").read[String] and
    (JsPath \ "login").read[String]
  )(User.apply _)

  implicit val userWrites = (
    (JsPath \ "id").write[Int] and
    (JsPath \ "email").write[String] and
    (JsPath \ "login").write[String]
  )(unlift(User.unapply))

  def decode(s: String): User = {
    val json = Json.parse(s)
    json.validate[User] match {
      case u: JsSuccess[User] => u.get
      case e: JsError => throw new RuntimeException(JsError.toFlatJson(e).toString())
    }
  }

  def encode(u: User): String = {
    val json = Json.toJson(u)
    json.toString()
  }
}

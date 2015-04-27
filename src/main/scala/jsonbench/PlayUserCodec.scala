package jsonbench

import play.api.libs.json._
import play.api.libs.functional.syntax._

class PlayUserCodec extends Codec[UsersResponse] {
  implicit val userReads = (
    (JsPath \ "id").read[Int] and
    (JsPath \ "email").read[String] and
    (JsPath \ "login").read[String] and
    (JsPath \ "fullName").readNullable[String] and
    (JsPath \ "tags").read[Seq[String]]
  )(User.apply _)

  implicit val userWrites = (
    (JsPath \ "id").write[Int] and
    (JsPath \ "email").write[String] and
    (JsPath \ "login").write[String] and
    (JsPath \ "fullName").writeNullable[String] and
    (JsPath \ "tags").write[Seq[String]]
  )(unlift(User.unapply))

  implicit val usersResponseReads = (
    (JsPath \ "success").read[Boolean] and
    (JsPath \ "users").read[Seq[User]]
    )(UsersResponse.apply _)

  implicit val usersResponseWrites = (
    (JsPath \ "success").write[Boolean] and
    (JsPath \ "users").write[Seq[User]]
    )(unlift(UsersResponse.unapply))

  def decode(s: String): UsersResponse = {
    val json = Json.parse(s)
    json.validate[UsersResponse] match {
      case u: JsSuccess[UsersResponse] => u.get
      case e: JsError => throw new RuntimeException(JsError.toFlatJson(e).toString())
    }
  }

  def encode(u: UsersResponse): String = {
    val json = Json.toJson(u)
    json.toString()
  }
}

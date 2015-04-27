package jsonbench

case class User(id: Int, email: String, login: String, fullName: Option[String], tags: Seq[String])

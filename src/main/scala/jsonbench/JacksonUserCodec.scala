package jsonbench

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

object JacksonUserCodec {
  val mapper = new ObjectMapper()
  mapper.registerModule(DefaultScalaModule)

  def decode(s: String): User = mapper.readValue(s, classOf[User])

  def encode(u: User): String = {
    mapper.writeValueAsString(u)
  }
}

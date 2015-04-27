package jsonbench

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

class JacksonUserCodec extends Codec[UsersResponse] {
  val mapper = new ObjectMapper()
  mapper.registerModule(DefaultScalaModule)

  def decode(s: String): UsersResponse = mapper.readValue(s, classOf[UsersResponse])

  def encode(u: UsersResponse): String = {
    mapper.writeValueAsString(u)
  }
}

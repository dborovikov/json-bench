package jsonbench

trait Codec[T] {
  def encode(v: T): String
  def decode(s: String): T
}

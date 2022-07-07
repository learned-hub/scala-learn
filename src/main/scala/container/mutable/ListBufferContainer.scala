package container.mutable

import scala.collection.mutable.ListBuffer

/**
 * List 对尾部的访问很慢，ListBuffer 提供快速的尾部操作
 * https://www.scala-lang.org/api/current/scala/collection/mutable/ListBuffer.html
 */
object ListBufferContainer extends App {
  val list = ListBuffer("sb","tet")
  // append
  list += "bbb"
  // prepend
  "aaa" +=: list
  println(list)
}

package container.mutable

import scala.collection.mutable.ArrayBuffer

/**
 * https://www.scala-lang.org/api/current/scala/Array.html
 * Array 不能直接 println，必须先用 mkString 转换
 *
 * Array 改变元素个数的操作都会产生新的 Array，原地修改需要使用 ArrayBuffer
 * Array 得很多操作都会隐式转换为 ArraySeq
 * Array和ArrayBuffer 都是固定连续区域，ArrayBuffer 一般会比实际内容大
 * 适合需要快速随机访问的情况
 */
object ArrayContainer extends App {
  val array = Array("Plain Donut","Strawberry Donut","Chocolate Donut")
  println(array)
  // Array 内的元素虽然可以修改，但几乎所有内置返回 Array 的方法都会产生新的 Array
  val a2 = array.reverse
  array(0) = "abc"
  println(array.mkString(","))
  println(a2.mkString(","))

  val a3 = array.map(_.length)
  println(array.mkString(","))
  println(a3.mkString(","))

  val aBuffer = ArrayBuffer("Plain Donut","Strawberry Donut","Chocolate Donut")
  // 多数操作仍然返回新的 Array
  println(aBuffer.reverse)
  println(aBuffer)

  aBuffer += "test"
  println(aBuffer)

}

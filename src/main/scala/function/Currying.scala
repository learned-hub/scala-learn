package function

object Currying extends App {
  // 柯里化 即具有多个参数列表的函数
  def sum(x: Int)(y: Int): Int = x + y
  // 第一次传参返回一个函数，第二次传参调用第一次返回的函数
  println(sum(1)(1))
  // 可以用部分函数法得到第一次传参的函数，由于这里有小括号，所以 _ 可以紧挨着
  val f = sum(1)_
  println(f(1))

  // 如下形式可以构造 DSL 中的自定义控制结构
  sum(1) {
    1
  }
}

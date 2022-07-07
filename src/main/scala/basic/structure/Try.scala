package basic.structure

import java.net.URL

// try 是表达式
object Try extends App {
  var path = "1"
//  path = "http://easysoc.com"
  val url = try {
    new URL(path)
    // 没有类似 switch 那种方式
  } catch {
    // 匹配到就返回分支结果，没有匹配到就报异常
    case _: RuntimeException =>
    case _: Exception =>
      new URL("http://easysoc.cn")
  } finally {
    println("no return")
    // finally 语句块永远会执行，但不会返回结果
    new URL("http://www.easysoc.cn")
  }
  println(url)
}

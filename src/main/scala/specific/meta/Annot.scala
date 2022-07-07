package specific.meta

import scala.annotation.StaticAnnotation

/**
 * 注解属于元编程工具，scala 只提供最小语法支持，具体注解行为由元编程工具解释
 *
 * @param arg
 */
class dep(arg: String) extends StaticAnnotation {
  println(arg)
}

object Annot extends App {

  // @ 就是 new
  @deprecated("需要编译器开启 -deprecation")
  @dep("hello")
  def test(): Unit = {}

  // 直接执行没有任何效果，可以手动或者通过 sbt 设置 scalac 开启 -deprecation 选项，才会打印 warn
  test()
}

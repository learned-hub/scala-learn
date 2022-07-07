// 包对象用于存放该包内使用的全局成员，不会作用于子包，包括子包的其它包可以通过全路径使用
package object oop {
  def helloWorld(): Unit = println("package object")
}

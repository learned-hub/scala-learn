package basic.hello

/**
 * https://www.scala-lang.org/api/current/index.html
 * 标识符区分大小写，文件名和文件内容可以没有关系，但建议和主类或对象名称一致
 * JAVA中的静态内容和需要实例化的类放到一起，太混乱，scala 将静态内容独立为 object
 *
 */
object Hello {
  // scala 将字段和方法定义之外的所有代码放入一个主构造方法，不需要手动定义构造方法
  // 单例对象的构造方法先于 main 方法执行
  println("构造函数")

  // main 入口函数的签名必须完整，必须包含 args 参数
  def main(args: Array[String]): Unit = {
    println("hello")
  }
}

// App 特质有默认的 main 方法
object Hello2 extends App {
  println("构造函数2")
}

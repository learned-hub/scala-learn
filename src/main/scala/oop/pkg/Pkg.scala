// 一个文件多个 package，默认引入
// java.lang._  https://docs.oracle.com/javase/8/docs/api/java/lang/package-summary.html
// scala._  https://www.scala-lang.org/api/current/scala/index.html
// scala.Predef._ https://www.scala-lang.org/api/current/scala/Predef$.html
// Predef 对象包含了部分容器的别名，如 scala.collection.immutable.Map，因此即使不导入也可以直接使用 Map
// 不带括号的包必须放在文件头部，其它内容都位于包内
package oop
package pkg

object Pkg {
  def hello(): Unit = {
    println("oop.pkg.Pkg")
  }
}

object Hidde {}

package oop.pkg {
  object Pkg extends App {
    // 避免包名冲突可以使用 _root_，避免类名冲突可以重命名或隐藏
    import _root_.oop.pkg.{Pkg => PPkg, Hidde => _}
    PPkg.hello()

    println("oop.pkg.oop.pkg.Pkg")
  }
}

package pkg {
  // 可以任意嵌套
  package pkg {
    object Pkg2 extends App {
      // 子包可以直接访问父包，无需 import
      Pkg.hello()
      println("oop.pkg.pkg.pkg.Pkg2")
    }
  }
}
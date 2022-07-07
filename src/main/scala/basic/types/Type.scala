package basic.types

object Type extends App {
  // https://docs.scala-lang.org/tour/unified-types.html  值类
  // 整数类型：Byte(byte)、Short(short)、Int(int)、Long(long)、Char(char)
  // 数值类型：整数类型、Float(float)、Double(double)
  // 布尔类型：Boolean(boolean)
  // 以上位于 scala 包，小括号里为对应的 JAVA 原始类型
  // 字符串：String(直接使用 java.lang.String)
  // 其它类型：Unit、Null、Nothing、Any、AnyRef

  // 只支持十和十六进制整数字面量，2.10 后不支持八进制，从来不支持二进制
  // 以 L 或 l 结尾就是 Long，否则为 Int
  val hex = 0xabc
  // 以 F 或 f 结尾就是 Float，否则为 Double
  val big = 1.23F
  // Char 必须为单引号的单个字符，否则必须用双引号的 String
  val char = 'a'
  // 返回JAVA类型 (int,float,char)
  println(hex.getClass, big.getClass, char.getClass)

  // 若无特殊声明，我们自己定义的类都是 AnyRef 的子类，以下方式可以定义自己的值类
  // 1、必须有唯一的使用 val 修饰的类参数（默认为 private val，显式使用 val 修饰变为 public val）
  // 2、继承 AnyVal 3、不能有 def 外的其它内容
  class Dollar(val amount: Int) extends AnyVal
  // 自定义值类可用于构建 DSL

}

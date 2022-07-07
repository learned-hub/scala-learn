package basic.types

/**
 * 不同于其它语言值为自动递增数字，scala 枚举默认值为变量名称
 * 值可以通过 Value() 显式定义，没有定义的仍然是其变量名
 * 枚举定义顺序可以通过 id 获取，从 0开始编号
 */
object Direction extends Enumeration {
  val North, East,South, West = Value
}
object Color extends Enumeration {
  val Red = Value("red")
  val Green = Value("green")
  val Blue = Value
}

object Enum extends App {
  for (d <- Direction.values) print(d + " ")
  for (c <- Color.values) print(c + " ")
  println(Color.Red.id)
}

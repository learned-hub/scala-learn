package specific

/**
 * 见276页 15.2 节
 * 模式种类：
 * 通配模式 _
 * 字面量或常量模式
 * 变量模式 小写字母开头，功能同通配符，只是给匹配到的内容一个名字
 * 变量绑定 变量名 @ 模式，会将匹配到的模式赋值给变量变量，类似正则表达式
 * 构造方法 通常为用例类
 * 序列模式 List、Array 等顺序容器
 * 元组
 * 类型模式，避免使用 isInstanceOf 和 asInstanceOf
 *
 * 条件模式
 */
object Match extends App {
  // 无 match 模式
  val t = (12,"abc")
  val (a,b) = t // 析构赋值

  // case 函数字面量，函数参数类型为 Option[Int]，返回值为 Int，此处我们不是定义一个函数，而是定义一组函数
  // PartialFunction
  val withDefault: Option[Int] => Int = {
    case Some(x) => x
    case None => 0
  }
  println(withDefault.getClass, withDefault(Some(10)), withDefault(None))

  /****** 类型模式 *********/
  def general(x: Any) = x match {
    case s: String => s.length
    case m: Map[_,_] => m.size  // Map 不保留类型参数的类型，不要使用具体的类型参数，
    case a: Array[String] if a.length > 2 => a.length // 数组可以匹配具体类型
    case _ => -1
  }
  /****** 可选类型 ********/
  // 可能为 null 的类型通过 Option[可能类型] 来定义，返回 Some(可能类型的值)或者 None，然后用模式匹配取出值
  val map = Map("France"->"Paris", "Japan" -> "Tokyo")
  def show(x: Option[String]): Any = x match {
    case Some(s) => s
    // 什么都不返回，返回类型为 Unit 类型的值，其值为 ()，建议不要这样做，建议返回类型和 s 相同的空值或 None
    // case None =>
    // case None => ""
    case _ => None
  }
  // map.get 可能获取 map 中没有的值
  println(show(map.get("France")) == "Paris")
  println(show(map.get("test")) == None)
}

package basic.types

object Str extends App {
  // 默认原始字符串会包含三引号内全部内容，包括第一个三引号后的换行和最后一个三引号前的换行
  val rawStr =
"""sssss
xxx
sss"""
  // 一般使用以下方式避免中间行的多余空格，但仍然需要注意是否需要第一个三引号后的换行和最后一个三引号前的换行
  val rawStr2 =
    """xxx
      |sss
      |dddd""".stripMargin

  println(rawStr)
  println(rawStr2)

  // 字符串插值
  val e = "xxo"
  // s 插值
  println(s"hello $e ${1+1}")
  // raw 插值不解析转义字符
  println(raw"hello \n")
  // f 插值类似 C 语言的 sprintf()，语法参考 java.util.Formatter（通过 String.format 静态方法调用）
  // https://www.baeldung.com/java-string-formatter https://segmentfault.com/a/1190000013654676
  println(f"${math.Pi}%.5f")

  // 拼接不可变字符串，产生新字符串
  println( e + " test")
  // String 是不可变的，对于需要构造字符串的场合，使用 StringBuilder 就地修改更高效，StringBuilder 拼接字符用 +=，拼接字符串用 ++=
  val str = new StringBuilder
  str += 'a'
  str ++= "efg"
  println(str.toString())
}

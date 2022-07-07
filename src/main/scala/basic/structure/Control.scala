package basic.structure

object Control extends App {
  var bool = true
  // if 返回语句块最后一条表达式的值，返回类型取决于分支
  val c1 = if (bool) {
    "ddd"
    2 + 1
  } else "aaa"
  println(c1)

  // while 需要配合 var 变量使用，不是表达式
  // while 和 for 没有 continue 和 break 语句，前者可以使用 if 替代，后者可以给循环加一个 var 开关，在需要的时候关闭即可
  var i = 2
  while (bool) {
    bool = i != 0
    i-=1
  }
  println(bool,i)

  // for 和 foreach 都不是表达式，for 是语言内置结构，foreach 是普通方法
  val array = Array("a","ab","abc","abcd")
  val f = for (i <- array) {
    println(i)
    i
  }
  // Unit 对应 JAVA 的 void ((),void)
  println(f, f.getClass)
  val f1 = array.foreach(arg => {
    println(arg)
    arg
  })
  // void
  println(f1.getClass)

  // for range
  for (i <- 1 to 4) println(i)
  for (i <- 1 until 4) println(i)
  // for filter
  for (
    i <- array
    // 多个条件与
    if i.length == 3
    if i == "abc"
  ) println(i)

  // for 嵌套，多一个 <- 多一层嵌套
//  for ( i <- 1 to 4; j <- 2 to 5) {
//    println(i + j)
//  }

  // yield 产生新的集合，yield 必须放在任何语句包括大括号之前
  val array2 = for (str <- array) yield { str.length }
  array2.foreach(println(_))
}

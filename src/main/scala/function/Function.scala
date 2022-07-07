package function

object Function extends App {
  // 函数的参数默认且必须是 val 类型，不需要用 val 修饰，更不可以用 var
  // 无参数也不能省略空小括号
  def outer(): Unit = {
    val field = "field"
    inner("i am inner function ")

    // 函数可以嵌套，子函数可以访问外部函数的变量，此时类似 类和方法的关系
    // 方法的参数必须带类型，无法自动推断，返回值可以，但建议显式声明
    def inner(arg: String): Unit = {
      println(arg + field)
    }
  }
  // call outer
  outer()

  /********** 字面量函数 ************/
  // val 替换 def，=> 替换 = 号的字面量函数，f 是参数为 Int，返回值为 Int 的函数
//  val f: Int => Int = (x:Int) => x + 1
  // 上述定义省略 f 的变量类型（函数），只保留函数定义实际内容
  val f = (x:Int) => x + 1
  println(f(2), f.getClass)

  val array = Array("a","ab")
  // 字面量函数简化：去掉参数类型和参数小括号
  // 函数的参数类型本来不可以推断，但当字面量用作参数传递时，由于实参具有类型，所以此时可以推断字面量函数的参数类型
  array.foreach((x) => println(x))
  // 上述字面量函数的参数括号多余，可以去掉
  array.foreach(x => println(x))

  // 字面量函数简化：占位符
  // 当函数的参数在函数体内只使用一次时，可以用 _ 替换参数同时省略形参声明，上述函数可以进一步简化为
  // 当有多个参数且每个参数只在函数体各使用一次时，可以用多个 _ 替换
  // array.foreach(_ => println(_)) 非法，必须同时省略形参
  array.foreach(println(_))
  // 具有占位符的代码一定是函数，具有多个占位符的代码一定是含多个参数的函数

  // 部分函数（partially applied function）
  def sum(a:Int,b:Int,c:Int): Int = a + b + c
  // 传入部分实参，不传的参数用 _ 代替，返回的是应用了部分参数的函数
  val two = sum(1,_,1)
  println(two(2))
  // 如果想重命名函数，不能直接 val zero = sum，可以用不加括号的 _ 替换整个参数列表
  // val zero = sum 不可以通过赋值变量重命名
  val zero = sum _
  println(zero(1,1,1))

  // 对于 array.foreach(println(_)) 中的字面量函数，可以用不加括号的 _ 替换整个参数列表，形成新的字面量函数
  array.foreach(println _)
  // 虽然不可以直接 val zero = sum，但当作为字面量函数参数，直接传递时可以通过省略 _ 来重命名函数，上述可以化简为
  array.foreach(println)

  // 上述字面量函数体中的变量都是 val，若函数体内使用了外部的 var 自由变量，则称作闭包（closure）

  /********** 函数调用 ************/
  // 可变长度参数，args 实际为所声明的类型的数组，本例即 Array[String]
  def echo(args: String*): Unit = args.foreach(println)
  echo("what","is")
  echo(array:_*)  // 不可以直接传递数组，需要加 :_*

  // 传参时，最后一个参数列表若只有一个参数，可以大括号代替小括号
  println(two {3})

  // 传参数时可以给出名字，这样参数的顺序任意
  println(sum(c=1,a=1,b=1))
  // 另外函数定义时也可以指定参数默认值
}

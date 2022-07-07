package basic.operator

object Op extends App {
  // 除了 = 号赋值操作，其它操作符即方法 a op b 即 a.op(b)
  // JAVA 的 == 对引用类型比较的是对象引用，要比较值用 equals，scala 的 == 对引用也是比较值，若要比较引用，使用 eq
  val op = 1 + 1 == 1.+(1)
  println(op)
  // 只有四个前缀操作符 + - ! ~，被解释为 unary_*，字符串的插值符号不是前缀运算符
  println(-2 == 2.unary_-)
  // 后缀操作符即没有参数的方法，调用时省略了小括号但必须带点号，数值类型后缀 L 和 F 不是后缀操作符
  println(op.getClass)

  // == 和 != 不能直接被重载，其调用 equals，因此可以通过重写 equals 实现重载 ==
}

package function

object ByName extends App {
  def empty(arg: () => Boolean): Unit = println(arg())
  empty(() => 1>2)

  // by-name 参数即参数为空的字面量函数，省掉空括号
  // 先调用函数，再参数求值
  def byNameAssert(arg: => Boolean): Unit = println(arg)
  byNameAssert(1>2)

  // 先求参数值，再调用函数
  def boolAssert(arg: Boolean): Unit = println(arg)
  boolAssert(1>2)

  // 区别在于如果先求参数值，如果求值过程发生异常，则程序崩溃
  // by-name 有机会在 assert 函数内部通过 try 结构捕获参数求值时可能产生的异常
  // 或者在求值之前有个开关，禁用断言，则不会对参数求值
}

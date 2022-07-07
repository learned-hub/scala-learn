package container.immutable

object Tuples extends App {
  // 元组的下标从 1 开始，且需要 ._N 方式访问元素，元素的类型不一样，不会统一为 Any
  val t = ("a", 10 ,"b")
  println(t._1,t._2)

  val t2 = Tuple2("b", 10)
  println(t2._1,t2._2)

  // 多个列表的元组可以通过 zipped 加 高阶函数 进行遍历操作，zipped 单独使用没有意义
  val t3 = (List(4,10,5),List(6,8)).zipped.map(_ + _)
  println(t3)
  // 新版使用 lazyZip 类型替换列表元组
  val t4 = (List(4,10,5) lazyZip List(6,8)).map(_ + _)
  println(t4)
  // 上述 zipped和lazyZip 和以下等价，看的出普通方式比较啰嗦
  println((List(4,10,5) zip List(6,8)).map(a => a._1 + a._2))

}

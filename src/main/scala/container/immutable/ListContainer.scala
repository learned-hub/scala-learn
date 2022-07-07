package container.immutable

/**
 * 不可变表示不能在原来的基础上修改，若需要修改，必须完整复制一份
 * https://www.scala-lang.org/api/current/scala/collection/immutable/List.html
 * List 只有不可变类型，虽然提供索引访问方法，但实际为链表，所有元素类型相同
 * 因为有 Any 类型存在，在显式声明列表为 Any 或合并两个不同类型列表时，实际可以插入任何值
 * 不要对 List 使用 length、last、init 和 apply索引访问，效率很低
 *
 * 基本操作：
 * head 返回第一个元素，对应 last 为最后一个元素
 * tail 除第一个元素以外的列表，对应 init 为除最后一个元素外的列表
 * reverse  反转列表
 * take(n)  返回列表的前 n 个元素组成的列表
 * drop(n)  返回移除前 n 个元素之后的列表
 * splitAt(i) 分割列表，返回前后两部分列表组成的元组
 * indices  返回由索引构建的 Range
 * flatten  将二维列表合并为一维列表
 * toArray  转换为数组
 * copyToArray  将列表元素依次复制到数组的指定位置
 * iterator 迭代器 it，通过 it.next 依次遍历列表
 * sorted/sortWith/sortBy 排序
 *
 * 对象方法：
 * range(i,j,step)  构建范围列表，不包括 i和j
 * fill(n)(e) 创建包含 n 个 e 的列表，第一个参数可以包含多个，表示多维列表
 * tabulate(n)(f(i))  创建包含 n 个元素的列表，元素由 f(i) 生成，第一个参数可以包含多个，相当于嵌套的多维列表循环遍历
 */
object ListContainer extends App {
  val list = List("Plain Donut", "Strawberry Donut", "Chocolate Donut")
  // Nil 表示空列表，和List()一样，e :: list 表示将元素 e prepend 到 list，上述对象创建法也要使用 Nil 和 :: 来构建列表
  val nums = 1 :: 2 :: 3 :: 4 :: Nil
  // list1 ::: list2 表示将 list1 prepend 到 list2，自动创建新的 Any 类型列表
  val combine = list ::: nums
  println(combine)
  /** 索引访问 */
  // JAVA 使用[] 访问下标，scala 使用 () 即 apply 方法
  println(list(1) == list.apply(1))
  /** 模式匹配 */
  // 列表模式，a 和 b 匹配前两个元素，rest 匹配其它的
  val a :: b :: rest = nums
  println(a, b, rest)
  /** zip */
  // 对偶，产生由两个列表对应元素组成的元组的列表，对不上号的被省略，unzip 将类似的结构转为两个列表构成的元组
  println(nums zip list)
  println(list.zipWithIndex.unzip)
  /** mkString */
  println(list.mkString("[", ",", "]"))

  // 高阶函数
  /** foreach */
  // foreach 仅仅遍历元素，不返回列表
  /** map */
  // map 指其他语言里也有的 map、reduce 操作，遍历元素，返回对元素进行 f 变换后的新 List
  println(nums.map(_ + 1))
  // flatMap 要求函数返回类型为 List，然后再将每个元素返回的 List 合并为一个 List
  println(list.flatMap(_.toList))
  /** filter */
  // 遍历元素，返回 f(x) 为 true 的新 List
  /** partition */
  // 遍历元素，返回 f(x) 为 true 和 false 的列表元组
  /** find */
  // 遍历元素，返回 f(x) 为 true 的第一个元素
  /** takeWhile、dropWhile */
  // 返回或者剔除列表中直到 f(x) 为 true 的新列表
  /** span */
  // 类似 splitAt(i)，返回 takeWhile、dropWhile 列表组成的元组
  /** forall */
  // 遍历元素，如果所有元素都满足 f(x) 为 true，则返回 true
  /** 左折叠/: 又折叠 :\ */
  // 结合初始值 z 对列表的每个元素进行 op 运算，(z /: list) (_ op _) 等价于 z op a op b op c

  // tabulate 多维列表
  println(List.tabulate(5,5)(_ * _))
}

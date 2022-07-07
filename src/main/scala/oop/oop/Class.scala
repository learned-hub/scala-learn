package oop.oop

/**
 * 可以包含未实现的方法的类必须声明为 abstract（不一定包含），抽象类不能直接例化
 * scala 字段和方法不可以同名，JAVA可以
 * 普通 字段和方法，只要没有 private 和 protect 修饰，就是公有的，没有 public 修饰符
 * 可以将字段以类参数的形式定义，实现在实例化类时强制初始化字段
 *
 * 类参数（不含传名参数）在传入构造方法之前求值，字段定义在父类构造方法之后求值
 * 若要在类初始化时不执行某个字段的定义，可以用 lazy 修饰
 *
 * 可以在类名之后，参数列表之前加 private 修饰，表示类的构造函数私有，这样在外部不能直接使用 new 创建对象
 * 可以添加辅助构造函数或者使用伴生对象实现类的例化
 *
 * @param arg 默认为 private val，当使用 val 修饰时变为公有，也可以定义为 var，本质就是字段
 */
abstract class Base(arg: String) {
  type T = String
  // 未实现的方法即抽象方法，本身不可以用 abstract 修饰，必须放在 abstract 类或 trait 里
  def abs():Unit
  def hi():Unit = println("i am in Base " + arg)
  // 子类可以使用但不能重写，final 还可以用来修饰类，final 类不能被继承
  final def noOverride(): T = "noOverride " + arg
}

/**
 * 类层次关系 https://docs.scala-lang.org/tour/unified-types.html
 * @param arg 私有 val 类型，可以加修饰符或重写父类字段
 * @param arg2 公有 val 类型
 */
class Class(arg: String, val arg2: String = "public") extends Base(arg) {
  println("类主构造方法 " + arg)
  //   arg = "xx"
  // 实现抽象方法加不加 override 没区别
  def abs(): Unit = println("override abs")
  // 重写基类 非抽象 字段和方法，必须加 override，这样当向基类中添加了和子类同名的成员时，子类无法编译通过，避免出现子类不小心重写！
  override def hi(): Unit = println("i am in Class " + arg)

  // 可以定义多个参数不同的 this 辅助构造方法，每个 this 构造方法的第一条语句必须调用已有的 this 或者 主构造方法
  // 辅助构造方法先于主构造方法，主构造方法是最终唯一入口
  def this() = this("this")

  // 类和对象都可以定义子类，一般放在对象中定义
  class SubClass {}
}

/**
 * 和类同名的对象为伴生对象，可以访问类的私有成员
 * 一般用来作为工厂和工具方法的集合
 */
object Class {
  // 主构造方法先于 apply
  println("对象主构造方法")
  // 调用 Class("x") 时执行
  def apply(arg: String): Class = {
    println("apply " + arg)
    new Class(arg)
  }
  class SubClass1
}

object Main extends App {

  // 调用父包的包对象内的方法
  oop.helloWorld()

  val c = new Class("c")
  // 多态
  val c1: Base = new Class("c1")
  // 工厂
  val c2 = Class("c2")
  // 辅助构造方法
  val c3 = new Class
  c.hi()
  // println(c.arg)
  println(c.arg2)
  c1.hi()
  c2.hi()
  c3.hi()
  println(c1.noOverride())
  // 访问类中子类，必须通过父类对象，一般不这样做，而是把子类放到伴生对象中以便能够直接访问
  val sub = new c.SubClass
  val sub1 = new Class.SubClass1

  // 匿名类
  new Base("匿名") {
    def abs(): Unit = ???
  }
}

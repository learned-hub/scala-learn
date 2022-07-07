package oop.oop

/**
 * 见 229 页，12.5 节
 * extends 关键字只能用一次，不可以多继承，要想分拆多个可复用的代码只能用特质
 *
 * 抽象类和类的区别：抽象类可以包括抽象方法，不能直接例化，其它行为和类相同
 *
 * 特质和抽象类区别：特质不能有类参数，super调用是动态的，其它行为和抽象类相同(不能直接例化，可以包含抽象方法)
 * 把特质混入某个类后，特质中的 super 指向其左侧的那个类或特质！
 *
 * 特质和接口的区别：接口已经可以包含静态成员和default修饰的具体方法，区别不大了
 */

class Super

trait Trait {
  // trait 可以包含抽象方法，不需要 abstract 修饰
  def abs(): Unit
}

/**
 *  with 不能单独使用，必须配合 extends 或 new 使用，如果没有单独基类，可以使用 extends 代替 with
 */
class ClassPower extends Super with Trait {
  def abs(): Unit = ???
}
class ClassSimple

abstract class Base1 {
  def hi(arg: String): Unit
}

class Base2 extends Base1 {
  def hi(arg: String): Unit = println(arg)
}

/**
 * 如果特质继承某个基类 Base，则该特质只能被混入 Base 的子类
 * 特质可以重写 Base 子类的某个方法，如果 Base 为抽象类，此时必须用 abstract override 修饰，否则 override 即可
 */
trait Trait1 extends Base1 {
  abstract override def hi(arg: String): Unit = {
    println("hi")
    // 该特质只能混入实现了 Base1.hi 方法的类，否则 super 无处可指
    super.hi("override")
  }
}

class ClassTrait extends Base2 with Trait1

object TraitApp extends App {
  val t = new ClassPower
  // 类似匿名类
  val t1 = new ClassSimple with Trait {
    def abs() = ???
  }

  val t2 = new ClassTrait
  t2.hi("")

  // 匿名类
  val t3 = new Trait {
    def abs(): Unit = ???
  }
}

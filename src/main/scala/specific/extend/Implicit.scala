package specific.extend

/**
 * 用途：
 * 1、一个类型到另一个类型的自动转换
 * 2、不改变源码的情况下，为类添加方法
 * 3、隐式参数
 *
 * implicit 可以作用于 变量、函数、类和单例对象，标记为隐式的 变量和对象 可以用作隐式参数
 * implicit 修饰的名称不重要，仅用于区别定义，建议表达出行为即可
 * 重要的是参数和返回值类型，表示从参数类型转换到返回值类型
 *
 * 隐式定义必须定义在如下范围
 * 1、调用标识符的作用域（通常全局定义在包对象中）
 * 2、类型转换的源或目的类的伴生对象内
 *
 * 若有多个隐式方法，其参数和返回类型分别相同，可以统一放在 implicit 修饰的类里，隐式方法不再用 implicit 修饰，其中
 * 1、类参数必须只有一个
 * 2、不能为样例类
 * 3、必须放在另一个类、单例对象、特质里
 * 类参数和所有方法的参数一致，方法返回类对象，即实现参数类型到类的转换
 */

case class Rect(width: Int,height:Int)
class Prompt(val per: String)

object Implicit extends App {
  implicit class RectMake(width: Int) {
    def x(height: Int): Rect = Rect(width,height)
  }
  println(3 x 4)

  /**
   * 第二个参数列表可以被 implicit 修饰
   * 参数列表和需要传的隐式变量都需要 implicit 修饰
   * implicit 作用的是整个参数列表，当有多个参数时，必须定义相同数目的隐式变量
   * 为什么不用参数默认值？
   */
  implicit val prompt: Prompt = new Prompt("relax> ")
  def greet(name: String )(implicit prompt: Prompt): Unit = {
    println("Welcome " + name)
    println(prompt.per)
  }
  greet("Joe")
}

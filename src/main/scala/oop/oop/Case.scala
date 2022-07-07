package oop.oop

/**
 * 通常用于组织数据，样例类和模式匹配一起使用，对于构造 DSL 很有用，特别是嵌套的树形结构
 *
 * 和普通类区别：
 * 1、自动实现类似伴生对象和对应的apply方法机制，不需要 new 即可创建实例
 * 2、类参数自动加 val 变为公有字段
 * 3、友好的 toString、hashCode、equals 方法
 * 4、添加 copy 方法，参数为类参数，实现仅修改某些字段后的一个拷贝数据
 *
 * 和值类区别：可以有多个类参数且自动 val，不需要继承自 AnyVal，可用于模式匹配，其它同上
 */

// 密封类用于case的父类，和其子类只能定义在同一个文件，使得模式匹配会检查所有的 case，以报告可能缺失的 case（密封类的子类）
// 有时候我们能够确定某些 case 不可能被执行，若不想严格检查所有 case，可以使用 (expr: @unchecked) 注解

sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(nub: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr


object Case extends App {
  // 模式匹配函数，现代语言的类 switch 结构，分支都不会贯穿，不需要 break
  def simplify(expr: Expr) : Expr = expr match {
    case UnOp("-", UnOp("-", e)) => e // 负负得正
    case BinOp("+", e, Number(1)) => e  // 加 0
    case BinOp("*", e, Number(1)) => e  // 乘 1
    case _ => expr  // 若什么都匹配不到会抛出异常，因此这里用通配符，若需要的返回值为 Unit，可以简写为 case _ =>
  }
  println(simplify(UnOp("-", UnOp("-", Number(2)))) == Number(2))

  // 析构解析
  val exp = BinOp("*", Number(5),Number(4))
  val BinOp(op, left, right) = exp
  println(op, left, right)
}

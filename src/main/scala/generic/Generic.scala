package generic

/**
 * 协变：S 是 T 的子类型，如果 Class[S] 是 Class[T] 的子类型，称 Class 在参数 T 上协变
 * 只有协变类型允许将 Class[S] 的变量传给 Class[T] 类型
 *
 * 默认泛型的子类型不协变，若需要协变，用 [+T]，另外还有逆变，用 [-T]
 *
 * 下界
 * [U >: T] 表示 U 的下界为 T，即 U 是 T 的父类
 * 上界
 * [T <: U] 表示 T 的上界为 U，即 T 是 U 的子类
 */
object Generic extends App {

}

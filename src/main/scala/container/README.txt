http://allaboutscala.com/
https://docs.scala-lang.org/overviews/collections-2.13/overview.html
https://docs.scala-lang.org/overviews/collections-2.13/performance-characteristics.html#

默认 Set和Map 为 immutable，其有同名的 mutable 类型，Set和Map 其实是 Trait，由同名的单例对象构建 HashSet、HashMap
#### 按 自然 排序
TreeSet 为有序的集合，其是 SortedSet Trait 的实现，两者都有同名的 mutable 类型，SortedSet 也有同名的单例对象！
TreeMap 为按 key 排序的映射类型，其是 SortedMap Trait 的实现，两者都有同名的 mutable 类型，SortedMap 也有同名的单例对象！

#### 按 插入 排序
ListSet、ListMap 按插入顺序的相反顺序排序，有同名的 mutable 类型
LinkedHashSet、LinkedHashMap  保持元素插入的顺序，只有 mutable 类型

Seq：特质，有同名的单例对象
Stack：只 mutable，不常用，List 可以代替，:: 相当于 push，head 相当于 top，tail 相当于 pop
Queue：先进先出
Vector：只 immutable，对任何元素访问都很快
Stream
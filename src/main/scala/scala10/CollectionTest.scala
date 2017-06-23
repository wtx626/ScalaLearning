package scala10

import scala.collection.mutable.ArrayBuffer

/**
  * Created by wutianxiong on 2017/4/18.
  */
object CollectionTest extends App {

  //混入类型
  val x = List(1, 2.0, 33d, 400L) //自动转为List[Double]
  x.foreach(print)
  //1.0 2.0 33.0 400.0
  val x1 = List[Number](1, 2.0, 33d, 400L)
  x1.foreach(print) //1 2.0 33.0 400

  //可变与不可变
  var sisters = Vector("Melinda")
  sisters = sisters :+ "Melinda" //返回新的Vector
  sisters = sisters :+ "lucy" //返回新的Vector
  sisters.foreach(println)

  //ZipWithIndex
  val days = Array("Sunday", "Monday", "Tuesday", "Wednesday", "Friday")
  days.zipWithIndex.foreach {
    case (day, index) => println(s"$index is $day")
  }

  //迭代器
  val it = Iterator(1, 2, 3)
  it.foreach(println)
  it.foreach(println) //迭代器已经结束，无输出

  //列表的列表扁平化
  val lol = List(List(1, 2, 3, 4), List(5, 6))
  lol.foreach(println) //List(1, 2, 3, 4) List(5, 6)
  lol.flatten.foreach(println)
  //1 2 3 4 5 6
  //社交网络 朋友的朋友
  val myFriends = List("Adam", "David", "Frank")
  val adamFriends = List("Nick", "Bill")
  val davidFriends = List("Becca", "Kenny", "Bill")
  val friendOfFriends = List(adamFriends, davidFriends)
  //无重复的朋友的朋友列表
  friendOfFriends.flatten.distinct.sorted.foreach(println)
  //Becca Bill Kenny Nick
  //应用①字符串列表转换为字符列表
  val list = List("Hello", "world")
  list.flatten.foreach(println)
  //H e l l o w o r l d
  //应用②针对option容器 ,取出Some中的值 丢掉None元素
  val opt = Vector(Some(1), None, Some(3), None)
  opt.flatten.foreach(println) //1 3

  //map flatten flatMap混合使用
  val bag = List("1", "2", "three", "4", "ont two three four")

  def toInt(str: String): Option[Int] = {
    try {
      Some(Integer.parseInt(str))
    } catch {
      case e: Exception => None
    }
  }

  println(bag.flatMap(toInt).sum) //7
  println(bag.map(toInt).flatten.sum) //7

  println("--------------")
  //提取部分元素
  val arr = Array(4, 1, 2, 5, 8, 6)
  val d1 = arr.drop(2)
  //5 8 4 6
  val d2 = arr.dropWhile(_ < 3)
  //5 8 4 6
  val d3 = arr.dropRight(3) //1 2 5

  val t1 = arr.take(2)
  //1 2
  val t2 = arr.takeWhile(_ > 3) //循环遍历，遇到第一个为false就停止
  d2.foreach(println)

  //序列分割
  val array = Array(1, 2, 58, 8, 6, 40, 12)
  val g1 = array.groupBy(_ < 10)
  g1(true).foreach(println)

  //reduce fold
  val a = array.reduceLeft(_ + _) //127
  println(array.reduceLeft(_ min (_)))
  // foldLeft 基本上和reduceLeft一样，但会加上一个初始值
  println(array.foldLeft(10)(_ + _)) //137
  //scanLeft 遍历序列的方式和reduceLeft一样，但返回的是序列
  array.scanLeft(10)(_ * _).foreach(println) //10 10 20 1160 9280 55680 2227200 26726400

  //去掉序列中相同的元素
  val repeat = Vector(1, 1, 2, 2, 3, 5)
  repeat.distinct.foreach(println)
  //自定义distinct
  val dale1 = Person10("dale", "coop")
  val dale2 = Person10("dale", "coop")
  val dale3 = Person10("dale3", "coop3")
  val lstPerson = List(dale1, dale2, dale3)
  for (elem <- lstPerson.distinct) {
    println(elem)
  }

  //合并两个序列
  val one = ArrayBuffer(1, 2, 3)
  val two = Array(2, 3, 4, 5, 6)
  //共有的元素
  one.intersect(two).foreach(println)
  //合并
  one.union(two).foreach(println)
  //找出不同的
  one.diff(two).foreach(println)
  two.diff(one).foreach(println)

  //用zip将两个序列集合合并为一对
  val women = List("wilma", "betty")
  val men = List("fred", "barney")
  val couple = women.zip(men)
  couple.foreach(println)

  //集合排序
  println("----------sorted------------")
  val toSort = List(10, 5, 6, 7, 1, 9)
  toSort.sorted.foreach(print(_, "\t"))
  println()
  toSort.sortWith(_ > _).foreach(print(_, "\t"))
  //混入Ordered特质
  println("\n------sorted ordered---------")
  val person1 = new Person11("david")
  val person2 = new Person11("lucy")
  val person3 = new Person11("bob")
  List(person1, person2, person3).sorted.foreach(println)
  if (person1 > person2) println(person1.name) else println(person2.name)

  //将集合转换成字符串
  println("---------mkString---------")
  val arrMkString = Vector("apple", "banana", "cherry")
  println(arrMkString.mkString) //applebananacherry
  println(arrMkString.mkString(" ")) //apple banana cherry
  println(arrMkString.mkString(",")) //apple,banana,cherry
  println(arrMkString.mkString("[", ",", "]")) //[apple,banana,cherry]
  println(arrMkString.toString) //Vector(apple, banana, cherry)
}

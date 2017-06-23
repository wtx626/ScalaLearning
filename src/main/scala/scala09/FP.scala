package scala09

import scala.reflect.ClassTag

/**
  * Created by wutianxiong on 2017/4/4.
  */
object FP extends App{

  val lst=List(2,4,6,8,11)
  val evens=lst.filter((i:Int)=>i%2==0)
  println(evens)
  for{
    i <- 0 to lst.length-1
    if lst(i)%2==0
  }
    println(lst(i))
  lst.foreach((i:Int)=>println(i))
  lst.foreach(i=>println(i))
  lst.foreach(println(_))
  lst.foreach(println)

  //将函数字面量赋值给一个变量
  val f0=(i:Int)=>{i * 2}
  val f1:(Int)=>Boolean = i=>{i%2==0}
  val f2:Int=>Boolean = i=>{i%2==0}
  val f3:Int=>Boolean = i=>i%2==0
  val f4:Int=>Boolean = _%2==0

  def modMethod(i:Int)=i%2==0
  println(lst.filter(modMethod))

  //定义接收简单函数作为参数的方法
  def executeFunction(callBack:()=>Unit): Unit ={
    callBack()
  }

  def executeFunction(f:String=>Int): Unit ={
    f
  }
  def executeFunction(f:(Int,Int)=>Boolean): Unit ={
    f
  }
//  def map[U: ClassTag](f: T => U): RDD[U] = withScope {
//    val cleanF = sc.clean(f)
//    new MapPartitionsRDD[U, T](this, (context, pid, iter) => iter.map(cleanF))
//  }

  def executeFunction(f:(Int,Int)=>Int,x:Int,y:Int): Unit ={
    val result=f(x,y)
    println(result)
  }
  val sum=(x:Int,y:Int)=>x+y
  executeFunction(sum,3,6)
  val sayHello1=()=>println("Hello")
  executeFunction(sayHello1)

  //闭包
  private val hello="sayHello"
  def sayHello(name:String): Unit ={
    println(s"$hello $name")
  }

  val foo=new Foo
  foo.exec(sayHello,"AL")

  //部分应用函数
  val sumThree=(a:Int,b:Int,c:Int)=>a+b+c
  val f=sumThree(1,2,_:Int)
  println(f(3))

  //定义返回函数的函数
  def saySomething(prefix:String)={
    (s:String)=>{prefix+" "+s}
  }
  val sayFun=saySomething("Fun")
  println(sayFun("I am ok"))

  //创建部分应用函数
  val divide:PartialFunction[Int,Int]={
    case d:Int if d!=0=>42/d
  }

  println(List(0,1,2).collect(divide))
}

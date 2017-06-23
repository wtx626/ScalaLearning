package scala09

/**
  * Created by wutianxiong on 2017/4/4.
  */
class Foo {

  def exec(f:(String)=>Unit,name:String): Unit ={
//    println(FP.hello)//编译出错
    f(name)
  }
}

object Foo{
  val foo=new Foo
  foo.exec(FP.sayHello,"lala")
}


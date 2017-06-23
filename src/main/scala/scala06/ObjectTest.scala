package scala06

/**
  * Created by wutianxiong on 2017/3/28.
  */
object ObjectTest extends App{
  def printClass(c:Any): Unit ={
    println(c.getClass)
  }

  printClass(1)
}

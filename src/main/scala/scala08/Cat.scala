package scala08

/**
  * Created by wutianxiong on 2017/3/29.
  */
class Cat extends Pet{
  override def comeToMaster: Unit = {
    println("I'm a cat")
  }

  override def speak: Unit = {
    this.comeToMaster
  }
}

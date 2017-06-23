package scala10

/**
  * Created by wutianxiong on 2017/4/21.
  */
class Person11(var name: String) extends Ordered[Person11] {
  override def compare(that: Person11): Int = {
    if (this.name == that.name) 0
    else if (this.name > that.name) 1
    else -1
  }

  override def toString: String = this.name
}

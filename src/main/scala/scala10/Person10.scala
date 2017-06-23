package scala10

/**
  * Created by wutianxiong on 2017/4/21.
  */
class Person10(firstName: String, lastName: String) {
  override def toString: String = s"$firstName $lastName"

  def canEqual(a: Any) = a.isInstanceOf[Person10]

  override def equals(obj: scala.Any): Boolean = obj match {
    case one:Person10=>one.canEqual(this)&&this.hashCode()==obj.hashCode()
    case _=>false
  }

  override def hashCode(): Int = {
    val prime=31
    var result=1
    result=prime*result+lastName.hashCode
    result=prime*result+(if (firstName==null)0 else firstName.hashCode)
    result
  }
}

object Person10{
  def apply(firstName: String, lastName: String)={
    new Person10(firstName,lastName)
  }
}

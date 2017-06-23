package scala03
import scala.util.control.Breaks
/**
  * Created by wutianxiong on 2017/3/30.
  */
object TestContru extends App{

  for (i<-1 to 10 if i<4)print(i)

  val majors= Map("zhangsan"->"cs","lisi"->"se")
  for ((k,v)<-majors)println(s"key:$k , value:$v")
  def echoWhatYouGaveMe(x:Any):String=x match {
    case 1| 2| 3=>"numbers"
    case true=>"true"
    case "hello"=>"say Hello"
    case Nil => "an empty list"

    case List(0,_,_)=>"a three elements list 0 as the first element"
    case list @ List(0,_)=>s"$list"

    case (a,b)=>s"got$a and $b"

    case Dog("wawa")=>"found a dog"

    case s:String if(s!="lala")=>s"the type is type $s"

    case _=>"default"
  }

  println(echoWhatYouGaveMe("lala1"))
  val s="Foo"
  def toInt(s:String)={
    val lal=try{
      s
    }catch {
      case _:Throwable=>println("exception ignored")
    }finally {
      "over"
    }
  }

}

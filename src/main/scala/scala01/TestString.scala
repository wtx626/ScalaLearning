package scala01
import com.google.common.hash.Hashing;

/**
  * Created by wutianxiong on 2017/3/30.
  */
object TestString extends App{

  val numPattern="[0-9]+".r
  val address ="num 24,Main Street 101"
  val match1=numPattern.findFirstIn(address)
  val matchs=numPattern.findAllIn(address).toList

  val result1=numPattern.replaceFirstIn(address,"x")
  val result2=address.replaceFirst("[0-9]+","x")

//  println(Hashing.murmur3_32().hashString("counter".hashCode.toString).asInt()&63)

  println("shuffle_0_0_0.index".hashCode+" "+"structured".hashCode+" "+"project".hashCode)

}

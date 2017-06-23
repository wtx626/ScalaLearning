package scala08

/**
  * Created by wutianxiong on 2017/3/29.
  */


class StartfleetCompont

trait StartfleetWarpCore extends StartfleetCompont

class StarShip extends StartfleetCompont with StartfleetWarpCore

class RomulanStuff extends StartfleetCompont

class Warbird extends RomulanStuff with StartfleetWarpCore

object TestTrait extends App with BaseSoundPlayer with Pizza{
  override def play: Unit = {

  }

  override def close: Unit = {

  }

  override def pause: Unit = {

  }

  override def stop: Unit = {

  }

  override def resume: Unit = {

  }

  var numToppings: Int = 0
  override val maxNumToppings=1
  (new Dog1).comeToMaster
  (new Cat).speak
}

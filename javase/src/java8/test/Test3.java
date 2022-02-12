package java8.test;

interface Doable{
  default void doIt(){
    System.out.println("Do it now");
  }
}
@FunctionalInterface
interface Sayable extends Doable{
  void say(String msg);   // abstract method
}
public class Test3 implements Sayable{
  public void say(String msg){
    System.out.println(msg);
  }
  public static void main(String[] args) {
    Test3 fie = new Test3();
    fie.say("Hello there");
    fie.doIt();
  }
}
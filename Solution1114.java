/*1114. 按序打印
我们提供了一个类：

public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}
三个不同的线程 A、B、C 将会共用一个 Foo 实例。

一个将会调用 first() 方法
一个将会调用 second() 方法
还有一个将会调用 third() 方法
请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。

 

示例 1:

输入: [1,2,3]
输出: "firstsecondthird"
解释: 
有三个线程会被异步启动。
输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。
正确的输出是 "firstsecondthird"。
示例 2:

输入: [1,3,2]
输出: "firstsecondthird"
解释: 
输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。
正确的输出是 "firstsecondthird"。
 */
public class Solution1114 {
    class Foo {

        volatile int count=1;
        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            count++;
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (count!=2);
            printSecond.run();
            count++;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (count!=3);
            printThird.run();
        }
    }}
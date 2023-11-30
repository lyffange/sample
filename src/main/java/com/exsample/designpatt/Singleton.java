package com.exsample.designpatt;

/**
 * 饿汉式：构造方法私有化，外部无法产生新的实例化对象，只能通过static方法取得实例化对象
 */
public class Singleton  {
  public static void main(String[] args) {
    Singleton instance = getInstance();
    System.out.println("instance = " + instance);
  }
  //在类的内部可以访问私有结构，所以可以在类的内部产生实例化对象
  private static Singleton instance = new Singleton();
  //private 声明构造
    private Singleton() {
    }
    //返回对象实例
    public static Singleton getInstance() {
        return instance;
    }

    public void print() {
        System.out.println("Hello Singleton...");
    }
}
/**
 *   懒汉式：当第一次去使用Singleton对象的时候才会为其产生实例化对象的操作
 */
//class Singleton2 {
//
//  /**
//   * 声明变量
//   */
//  private static volatile Singleton singleton = null;
//
//  /**
//   * 私有构造方法
//   */
//  private Singleton2() {
//
//  }
//
//  /**
//   * 提供对外方法
//   * @return
//   */
//  public static Singleton getInstance() {
//    // 还未实例化
//    if (singleton == null) {
//      synchronized (Singleton.class) {
//        if (singleton == null) {
//          singleton = new Singleton();
//        }
//      }
//    }
//    return singleton;
//  }
//  public void print() {
//    System.out.println("Hello World");
//  }
//}
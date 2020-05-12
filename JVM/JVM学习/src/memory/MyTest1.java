package memory;

/*
    线程私有：
        虚拟机栈：栈帧 [局部变量表可以存放8个基本类型 和引用类型(并不是引用对象)]
                  一般出现栈溢出的错误
        程序计数器 PC  程序执行到哪里
        本地方法栈：主要处理本地方法

    线程公有：
        堆 Heap：   [引用在栈帧里面，指向的对象在堆上]
            1.分为新生代[eden from to](比例一般是8:1:1)和老年代

        方法区 ： 存储元信息[类信息]。 1.7之前也叫永久代，1.8之后废弃。变成元空间
            class卸载时 会回收方法区
        运行时常量池： 方法区的一部分。

        直接内存：堆外内存 与Java NIO密切相关 JVM通过DirectByteBuffer来操作直接内存
 */

/*
  一个对象有两部分数据：
     1.实例本身        一个实例对应一份
     2.元数据 [类信息] 多个实例也只有一份
 */

/*
    1.通过句柄访问对象  [即引用指向对象指针，指针再指向对象] 每次垃圾回收 对象的指针都会变化 但引用的值不会变
                                                        所以HOTSPOT用第二种
    2.通过直接指针访问对象 [即引用直接指向对象本身，指针指向方法区的元数据] 而元数据一般不会被回收
                                                         垃圾回收整理内存时，引用的值会发生变化 但还是可以
                                                         通过引用访问这个对象
 */

import java.util.ArrayList;
import java.util.List;

/*
    关于Java对象创建的过程：

    new关键字创建对象的3个步骤：

    1.在堆内存中创建出对象的实例
    2.为对象的实例成员变量[静态变量在加载时就被赋值]赋初始值
    3.将对象的引用返回

    对象存储的两种方式：
        指针碰撞： 前提是堆中的空间通过一个指针分割，一侧是被占用的，另一侧是未被占用 分配空间直接移动指针

        空闲列表：而实际上内存是断断续续的 jvm会用一个列表记录哪些内存是空闲

     对象在内存中的布局：

        1.对象头
        2.实例数据
        3.对齐填充
 */
public class MyTest1 {

    public static void main(String[] args) {

        /*
            OUT OF MEMORY 错误
            增加三个参数
            -Xms5m  堆最小内存 5M
            -Xmx5m  堆最大内存 5M
            -XX:+HeapDumpOnOutOfMemoryError 把错误打印到磁盘上

            使用JDK自带的jvisualvm分析 C:\Program Files\Java\jdk1.8.0_201\bin
            文件位置D:\文档\牛客算法java代码实现

            可以查看概要 类 实例数
         */
        List<MyTest1> list = new ArrayList<>();

        while(true) {
            list.add(new MyTest1());

            //显式调用gc后 不会出现OOM错误  可以使用jvisualvm连接进程实时监控 双击进程

            //可以看出gc活动特别频繁  堆空间大小一直维持在2M
            //把堆内存最大改成1M 还是会出现OOM

            //应该是System.gc();降低了创建对象的速度
            //System.gc();
        }

    }
}

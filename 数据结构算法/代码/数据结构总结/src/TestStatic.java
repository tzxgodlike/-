public class TestStatic extends Father {

    //public static int tmp;
    static  ThreadLocal f = new ThreadLocal();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{

            TestStatic testStatic = new TestStatic();

            f.set(testStatic);
            TestStatic t =(TestStatic) f.get();
            t.age=222;
            System.out.println(testStatic.age);
        });


        Thread t2 = new Thread(()->{
            //TestStatic testStatic = new TestStatic();
            //Father f = new Father();
            Father fa = (Father )f.get();
            System.out.println(fa);
        });
        t1.start();
        t1.join();
        t2.start();

    }
}

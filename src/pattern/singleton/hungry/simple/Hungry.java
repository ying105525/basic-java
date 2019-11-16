package pattern.singleton.hungry.simple;

public class Hungry {

    private Hungry() {
    }


//    先静态、后静态
//    先属性、后方法
//    先上后下

    private static final Hungry instance = new Hungry();


    public static Hungry getInstance() {
        System.out.println(System.currentTimeMillis() + ":" + instance);
        return instance;
    }

}

package reflect;

public class ShowTime {
    public static void main(String[] args) {
//        首先介绍Class类的几个反射方法。
//        用类.class生成对应的类对象。
        Class chineseManClz = ChineseMan.class;
        System.out.println(chineseManClz);
//        通过反射,Class类的forName方法生成类对象
        Class chineseManClzByForName = null;
        try {
            chineseManClzByForName = Class.forName("reflect.ChineseMan");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(chineseManClzByForName);
//        通过反射获取类的全限定名和不带路径的类名
        String fullClzName= chineseManClz.getName();
        String simpleClzName = chineseManClz.getSimpleName();
        System.out.println("全类目："+fullClzName+"---无路径类目: "+simpleClzName);
        Class<?>[] classes =  chineseManClz.getInterfaces();
        for(int i=0;i<classes.length;i++){
            System.out.println(classes[i]);
        }
    }
}
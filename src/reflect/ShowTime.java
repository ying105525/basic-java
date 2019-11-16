package reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ShowTime {
    public static void main(String[] args) {
//--------------------------获取类-------------------
//        首先介绍Class类的几个反射方法。
//        用类.class生成对应的类对象。注意：Class类是个泛型类Class<T>
        Class<ChineseMan> chineseManClz = ChineseMan.class;
        System.out.println(chineseManClz);
        System.out.println("-----------------\n");
//        通过反射,Class类的forName方法生成类对象
        Class chineseManClzByForName = null;
        try {
            chineseManClzByForName = Class.forName("reflect.ChineseMan");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(chineseManClzByForName);
        System.out.println("-----------------\n");
//        通过反射获取类的全限定名和不带路径的类名

        String fullClzName = chineseManClz.getName();
        String simpleClzName = chineseManClz.getSimpleName();
        System.out.println("全类目：" + fullClzName + "---无路径类目: " + simpleClzName);
        System.out.println("-----------------\n");

        Class<?>[] classes = chineseManClz.getInterfaces();
        System.out.println("输出所有的实现的接口：");
        for (int i = 0; i < classes.length; i++) {
            System.out.println(classes[i]);
        }
        System.out.println("-----------------\n");

        //       获取该类中的所有类和接口类的对象
        final Class[] declaredClasses = chineseManClz.getDeclaredClasses();
        System.out.println("输出所有的实现的类和接口：");
        for (int i = 0; i < declaredClasses.length; i++) {
            System.out.println(declaredClasses[i]);
        }
        System.out.println("-----------------\n");

        //        获取该类中的所有类属性
        final Field[] declaredFields = chineseManClz.getDeclaredFields();
        System.out.println("输出所有的属性：");
        for (int i = 0; i < declaredFields.length; i++) {
            System.out.println(declaredFields[i]);
        }
        System.out.println("-----------------\n");

        Object man = new ChineseMan(1,"chineseMan");
        ChineseMan chineseMan = chineseManClz.cast(man);
        System.out.println("由于前面泛型类指定了类型，所以这里可以成功转换，如果不指定，则chineseMan应该是Object类型" + chineseMan);


//      ---------------------获取类中属性-----------------
        Field[] fields = chineseManClz.getFields();
        System.out.println("获取所有公有属性对象");
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("-----------------\n");

        try {
            Field filed = chineseManClz.getField("name");
            System.out.println("获取公有属性对象name： " + filed);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {
            chineseManClz.getField("age");
        } catch (NoSuchFieldException e) {
            System.out.println("未找到公有属性age");
        }
        System.out.println("-----------------\n");

        System.out.println("获取所有属性对象： ");
        Field[] dFields = chineseManClz.getDeclaredFields();
        for(Field field :dFields){
            System.out.println(field);
        }
        System.out.println("-----------------\n");

        //--------------------获取类中注解相关的方法--------------------------------
        Annotation[]  annotations = chineseManClz.getAnnotations();

        System.out.println("获取【修饰该类】的所有公有的注解对象： ");
        for(Annotation annotation:annotations){
            System.out.println(annotation);
        }
        System.out.println("-----------------\n");

        //--------------------获取类中构造器相关的方法--------------------------------
        Constructor<?>[] constructors = chineseManClz.getConstructors();

        System.out.println("获取类的所有公有构造方法： ");
        for(Constructor constructor:constructors){
            System.out.println(constructor);
        }
        System.out.println("-----------------\n");

        try {
            Constructor<ChineseMan> constructor =  chineseManClz.getConstructor(int.class, String.class);
            System.out.println("获取与指定类型参数匹配的构造方法："+constructor);
        } catch (NoSuchMethodException e) {
            System.out.println("未找到与指定类型参数匹配的构造方法");
        }
        System.out.println("-----------------\n");

//        --------------------------------------------------------------------------------------------------------------
        //--------------------Field类：获取成员变量相关信息--------------------------------

        try {
            Field filed = chineseManClz.getField("name");
            System.out.println(filed);
            Field ss= chineseManClz.getField("name");
            System.out.println(filed.equals(ss));
            System.out.println(filed.get(man));
        } catch (Exception e) {
            e.printStackTrace();
        }

//        --------------------------------------------------------------------------------------------------------------
//--------------------Method类：获取成员变量相关信息--------------------------------

        try {
            Method method = chineseManClz.getMethod("shoeMethod",String.class);
            System.out.println("获取到时候shoeMethod方法： "+method);
            method.invoke(chineseMan,"这里是获取成员变量相关信息");
        } catch (Exception e) {
            e.printStackTrace();
        }


//        --------------------------------------------------------------------------------------------------------------
//--------------------Constructor类：获取构造方法相关信息--------------------------------

        try {
            Constructor<?> constructor = chineseManClz.getConstructors()[0];
            System.out.println("获取到构造方法方法： "+constructor);
            ChineseMan cm = (ChineseMan) constructor.newInstance(11,"反射构造函数创建的对象");
            System.out.println(cm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

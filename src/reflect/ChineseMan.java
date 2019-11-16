package reflect;

@Hero
public class ChineseMan extends Man implements Comparable {
    public ChineseMan(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private int age = 30;
    @People
    public String name = "YSL";

    interface face {
    }

    public void  shoeMethod(String s){
        System.out.println(s);
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void saySomething() {
        System.out.println("这里是子类ChineseMan的saySomething方法");
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "ChineseMan{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

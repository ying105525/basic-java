package reflect;

public class ChineseMan extends Man implements Comparable{
    private int age = 30;
    public String name = "YSL";

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
}

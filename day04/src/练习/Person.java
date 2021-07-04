package 练习;

/**
 * @author lichuang
 * @create 2021-07-04 19:28
 */
public class Person implements Comparable{

    private String name;
    private int age;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
       if(o instanceof Person){
           Person p = (Person) o;
           return this.name.compareTo(p.name);
       }else{
           throw new RuntimeException("数据类型错误! ");
       }
    }
}

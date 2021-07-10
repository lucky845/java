package 练习三;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 请把学生名与考试分数录入到集合中，并按分数显示前三名
 * 成绩学员的名字。
 * TreeSet(Student(name,score,id));
 *
 * @author lichuang
 * @create 2021-07-10 15:33
 */
public class Test2 {

    public static void main(String[] args) {
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Student && o2 instanceof Student){
                    Student s1 = (Student) o1;
                    Student s2 = (Student) o2;
                    return -Double.compare(s1.score,s2.score); // 分数从大到小排序
                }else{
                    throw new RuntimeException("输入的数据类型不匹配！");
                }
            }
        };

        TreeSet set = new TreeSet(com);
        set.add(new Student("Tom",80,1001));
        set.add(new Student("Jack",90,1002));
        set.add(new Student("Jerry",88,1003));
        set.add(new Student("Laude",92,1004));
        set.add(new Student("Make",21,1005));
        set.add(new Student("Lucy",56,1006));

        int count = 0;
        for (Object o : set) {
            count++;
            if (count <= 3) {
                System.out.println(o);
            }
        }


    }


    public static class Student{
        private String name;
        private double score;
        private int id;

        public Student() {
        }

        public Student(String name, double score, int id) {
            this.name = name;
            this.score = score;
            this.id = id;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    ", id=" + id +
                    '}';
        }
    }
}

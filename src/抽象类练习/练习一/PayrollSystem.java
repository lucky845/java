package 抽象类练习.练习一;

import java.util.Calendar;

/*
（5）定义PayrollSystem类，创建Employee变量数组并初始化，该数组存放各
类雇员对象的引用。利用循环结构遍历数组元素，输出各个对象的类
型,name,number,birthday,以及该对象生日。当键盘输入本月月份值时，如果本
月是某个Employee对象的生日，还要输出增加工资信息。
 */
public class PayrollSystem {
    public static void main(String[] args) {
        // 方式一:
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入当前月份");
//        int month = sc.nextInt();

        // 方式二:
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH); // 获取当前月份
        // System.out.println(month);  // 从0开始

        Employee[] e = new Employee[2];

        e[0] = new SalariedEmployee("jack",1001,new MyDate(2000,1,1),10000);
        e[1] = new HourlyEmployee("marry",1002,new MyDate(2000,2,2),60,240);


        for (int i = 0; i < e.length; i++) {
            System.out.println(e[i]);
            double salary = e[i].earnings();
            System.out.println(salary);

            if((month + 1) == e[i].getBirthday().getMonth()){
                System.out.println("生日快乐!奖励100元");
                salary += 100;
            }

        }


    }
}

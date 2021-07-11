package 枚举练习;

/**
 *
 * 创建星期枚举类，有7个枚举值，包含计划属性plan，使用构造器为此属性赋值。
 *
 *
 * @author lichuang
 * @create 2021-07-11 19:54
 */
public enum WeekTest2 {

    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期天");

    private String name;
    private String plan;

    private WeekTest2(String name) {
        this.name = name;
        plan = "睡觉";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }
}

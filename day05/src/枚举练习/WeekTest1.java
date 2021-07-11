package 枚举练习;

/**
 *
 * 创建星期枚举类，有7个枚举值，包含计划属性plan，为此属性赋值（使用构造器）。
 *
 *
 * @author lichuang
 * @create 2021-07-11 19:48
 */
public enum WeekTest1 {

    MONDAY("星期一","打球"),
    TUESDAY("星期二","打球"),
    WEDNESDAY("星期三","打游戏"),
    THURSDAY("星期四","睡觉"),
    FRIDAY("星期五","睡觉"),
    SATURDAY("星期六","学习"),
    SUNDAY("星期天","追番");

    private String name;
    private String plan;

    private WeekTest1(String name, String plan) {
        this.name = name;
        this.plan = plan;
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

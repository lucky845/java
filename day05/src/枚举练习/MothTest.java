package 枚举练习;

/**
 *
 * 创建月份枚举类，枚举值包含十二个月份，月份要求用英文单词
 *
 *
 * @author lichuang
 * @create 2021-07-11 19:41
 */
public enum MothTest {

    JANUARY("一月"),
    FEBRUARY("二月"),
    MARCH("三月"),
    APRIL("四月"),
    MAY("五月"),
    JUNE("六月"),
    JULY("七月"),
    AUGUST("八月"),
    SEPTEMBER("九月"),
    OCTOBER("十月"),
    NOVEMBER("十一月"),
    DECEMBER("十二月");

    private String name;

    MothTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

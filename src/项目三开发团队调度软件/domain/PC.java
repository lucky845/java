package 项目三开发团队调度软件.domain;

public class PC implements Equipment{

    private String model; // 机器的型号
    private String display; // 显示器的名称

    public PC() {
        super();
    }

    public PC(String model, String display) {
        super();
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }
}

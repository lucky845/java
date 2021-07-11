package 枚举练习;

/**
 *
 * 创建一个Color枚举类，
 * 1)有 RED,BLUE,BLACK,YELLOW,GREEN这个五个枚举值；
 * 2)Color有三个属性redValue，greenValue，blueValue，
 * 3)创建构造方法，参数包括这三个属性，
 * 4)每个枚举值都要给这三个属性赋值，三个属性对应的值分别是red：255,0,0  	blue:0,0,255
 * black:0,0,0  yellow:255,255,0  green:0,255,0
 * 5)重写toString方法显示三属性的值
 * 6)在Color中添加抽象方法meaning，不同的枚举类的meaning代表的意思各不相同
 *
 *
 * @author lichuang
 * @create 2021-07-11 19:57
 */
public enum ColorTest implements Color,ReflectColor {

    RED(255,0,0){
        @Override
        public void show() {
            System.out.println("红色");
        }

        @Override
        public void meaning() {
            System.out.println("2");
        }
    },
    BLUE(0,0,255){
        @Override
        public void show() {
            System.out.println("蓝色");
        }

        @Override
        public void meaning() {
            System.out.println("3");
        }
    },
    BLACK(0,0,0){
        @Override
        public void show() {
            System.out.println("黑色");
        }

        @Override
        public void meaning() {
            System.out.println("4");
        }
    },
    YELLOW(255,255,0){
        @Override
        public void show() {
            System.out.println("黄色");
        }

        @Override
        public void meaning() {
            System.out.println("5");
        }
    },
    GREEN(0,255,0){
        @Override
        public void show() {
            System.out.println("绿色");
        }

        @Override
        public void meaning() {
            System.out.println("6");
        }
    };

    private int redValue;
    private int greenValue;
    private int blueValue;


    private ColorTest(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public String toString() {
        return "ColorTest{" +
                "redValue=" + redValue +
                ", greenValue=" + greenValue +
                ", blueValue=" + blueValue +
                '}';
    }



}

interface Color{
    void meaning();
}

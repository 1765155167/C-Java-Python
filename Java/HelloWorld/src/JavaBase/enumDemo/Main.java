package JavaBase.enumDemo;

public class Main {
    public static void main(String[] args) {
        Weekday day = Weekday.MON;
        switch (day) {
            case MON:
            case TUE:
            case WED:
            case THU:
            case FRI:
                System.out.println(day.toString() + " is 工作日");
                break;
            case SAT:
            case SUN:
                System.out.println(day.toString() + " is 休息日");
                break;
            default:
                throw new RuntimeException("cannot process " + day);
        }
    }
}

/**
 * 构造方法要设置成私有private
 * 字段为final修饰
 */
enum Weekday {
    SUN("星期日"), MON("星期一"), TUE("星期二"),
    WED("星期三"), THU("星期四"), FRI("星期五"),
    SAT("星期六");
    private final String dayValue;

    private Weekday(String dayValue) {
        this.dayValue = dayValue;
    }
    @Override
    public String toString() {
        return this.dayValue;
    }
}

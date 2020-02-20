# Integer
```java
System.out.println(Integer.toHexString(255));//ff
System.out.println(Integer.toBinaryString(255));//1111 1111
```
# Random 伪随机数 需要指定随机种子（默认系统时间戳）
# SecureRandom 真随机数（安全随机数）不需要指定随机种子
# BigInteger 大整数
# BigDecimal 精准浮点数
# var 相当于C++ auto var b = new Person();
# menu 枚举
```java
enum Weekday {
    SUN, MON, TUE,WED, THU, FRI,SAT;
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
```
# 字符串相关
## String 值不可更改
## StringBuilder 可以添加(append)插入(insert)和删除(delete)
## StringJoiner 以某字符串进行分割符号 内部实现 StringBuilder
```java
StringBuilder stringBuilder = new StringBuilder("Home ")
// 分隔符 开头 结尾
String[] fields = {"name","age","address"}
StringJoiner joiner = new StringJoiner(", ", stringBuilder.toString(), "!!!");
for (var str : fields) {
    joiner.add(str);
}
joiner.toString();//="Home name, age, address!!!";
```
# Inteface 接口
```java
interface Interface {
    void cat();
    void run();
    //定义一个默认方法，可以不必重写这个方法
    default void abs(int a) {
        System.out.println("Interface Hello");
    }
}
```
# Java具有多态性，
```java
Person p = new Student();//其中Student继承Person并重写了Person的print方法
p.print();//执行的是Student的print方法 
/*在C++中要想实现多态需要生命函数为virtual（虚函数）*/
```


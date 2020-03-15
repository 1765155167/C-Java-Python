package JavaBase.Stream;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.LongSupplier;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        LongStream stream = LongStream.generate(new Long());
//        stream.limit(10).map(n -> n + 1).forEach(System.out::println);
        LongStream stream1 = stream.limit(10).filter(n -> n % 2 != 0);
//        stream1.forEach(System.out::println);
        long sum = stream1.reduce(0, (acc, n) -> acc + n);
        System.out.println(sum);
        // 按行读取配置文件:
        List<String> props = List.of("profile=native", "debug=true", "logging=warn", "interval=500");
        Map<String, String> map = props.stream()
                // 把k=v转换为Map[k]=v:
                .map(kv -> {
                    String[] ss = kv.split("\\=", 2);
                    return Map.of(ss[0], ss[1]);
                })
                // 把所有Map聚合到一个Map:
                .reduce(new HashMap<String, String>(), (m, kv) -> {
                    m.putAll(kv);
                    return m;
                });
        // 打印结果:
        map.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });

        Stream<String> stream3 = Stream.of("Apple", "", null, "Pear", "  ", "Orange");
        var a =  stream3.filter(n->n!=null&&!n.isBlank()).collect(Collectors.toList());
        System.out.println(a);
        System.out.println(LocalDateFactory.fromInt(20200315));
    }
}

class Long implements LongSupplier {
    int num1 = 0;
    int num2 = 0;

    @Override
    public long getAsLong() {
        if (num1 == 0 && num2 == 0) {
            num2 = 1;
            return 1;
        }
        int ret = num1 + num2;
        num1 = num2;
        num2 = ret;
        return ret;
    }
}
class LocalDateFactory {
    public static LocalDate fromInt(int yyyyMMdd) {
        int year = yyyyMMdd / 10000;
        int day = yyyyMMdd%100;
        int mouth = (yyyyMMdd - year*10000) / 100;
        LocalDate localDate = LocalDate.of(year,mouth,day);//指定日期
        return localDate;
    }
}
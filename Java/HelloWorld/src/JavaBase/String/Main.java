package JavaBase.String;

import java.beans.IntrospectionException;
import java.util.Arrays;
import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) throws IntrospectionException {
        System.out.println(Integer.toHexString(255));//ff
        System.out.println(Integer.toBinaryString(255));//1111 1111
    }
    public static int maxDemo(int a, int b) {
        return  a > b ? a:b;
    }
    static void StringBuilderTest() {
        String[] fields = {"name", "position", "salary"};
        String table = "employee";
        String insert = buildInsertSql(table, fields);
        System.out.println(insert);
        String s = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";
        System.out.println(s.equals(insert) ? "测试成功" : "测试失败");
    }

    static String buildInsertSql(String table, String[] fields) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO ")
                .append(table)
                .append(" (");
//        for (var str : fields) {
//            stringBuilder.append(str).append(", ");
//        }
//        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        // 分隔符 开头 结尾
        StringJoiner joiner = new StringJoiner(", ", stringBuilder.toString(), ") VALUES (?, ?, ?)");
        for (var str : fields) {
            joiner.add(str);
        }
        return joiner.toString();
    }
}

class Score {
    private int[] scores;

    public Score(int[] scores) {
        this.scores = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            this.scores[i] = scores[i];
        }
    }

    public void printScores() {
        System.out.println(Arrays.toString(scores));
    }
}
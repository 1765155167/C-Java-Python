package 测试;

public class Factorial {
    public static long fact(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("n < 0");
        }
        if (n > 20) {
            throw new ArithmeticException("n > 20");
        }
        long r = 1;
        for (long i = 1; i <= n; i++) {
            r = r * i;
        }
        return r;
    }
}

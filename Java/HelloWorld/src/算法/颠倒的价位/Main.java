package 算法.颠倒的价位;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Price> list1 = new ArrayList<>();
        List<Price> list2 = new ArrayList<>();
        //枚举四位数
        for (int i = 1000; i < 10000; i++) {
            //颠倒求职
            if (isNo(i)) {
                continue;
            }
            int i1 = reverse(i);
            int plus = i1 - i;//差值
//            System.out.println(i1 + ":" + i);
            if (plus > -300 && plus < -200) {
                //赔钱200多
                list1.add(new Price(i, plus));
            }
            if (plus > 800 && plus < 900) {
                //转800多
                list2.add(new Price(i, plus));
            }
        }
        for (Price p1 : list1) {
            for (Price p2 : list2) {
                if (p1.plus + p2.plus == 558) {
                    System.out.println(p1.toString() + p2.toString());
                }
            }
        }
    }

    private static boolean isNo(int i) {
        String num = "" + i;
        if (num.contains("3")||num.contains("4")||num.contains("7")) {
            return true;
        }
        return false;
    }

    private static int reverse(int i) {
        String s = "" + i;
        String res = reverse(s);
        return Integer.parseInt(res);
    }

    //字符串反转180°
    private static String reverse(String s) {
        char[] ans = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = s.length() - i - 1;
            if (c == '6') ans[index] = '9';
            else if (c == '9') ans[index] = '6';
            else ans[index] = c;
        }
        return new String(ans);
    }

    private static class Price {
        int p;//原价
        int plus;//差值

        public Price(int p, int plus) {
            this.p = p;
            this.plus = plus;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Price{");
            sb.append("p=").append(p);
            sb.append(", plus=").append(plus);
            sb.append('}');
            return sb.toString();
        }
    }
}

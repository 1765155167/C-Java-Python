package 算法.动态规划.最大公共子序列;

/**
 * string1 string2
 * dp[i][j]代表string1[0-i] 与string2[0-j]的最大公共子序列
 * dp[i][0]最大长度为1，当string1[i]==string2[0]时dp[i~][0]=1
 * dp[0][j]最大长度为1，当string2[j]==string1[0]时dp[0][j~]=1
 * dp[i][j] = max{dp[i-1][j], dp[i][j-1], dp[i-1][j-1] + 1};
 */
public class Main {
    private static void dp(String s1, String s2, int[][] dp) {
        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1] + 1));
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
    }

    public static void main(String[] args) {
        String s1 = "1A2B3C4D";
        String s2 = "0A0B0C04D";
        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            dp[i][0] = 0;
            if (s2.charAt(0) == s1.charAt(i)) {
                for (int j = i; j < s1.length(); j++) {
                    dp[j][0] = 1;
                }
                break;
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            dp[0][i] = 0;
            if (s1.charAt(0) == s2.charAt(i)) {
                for (int j = i; j < s2.length(); j++) {
                    dp[0][j] = 1;
                }
                break;
            }
        }
        dp(s1, s2, dp);
        System.out.println(dp[s1.length() - 1][s2.length() - 1]);
    }
}

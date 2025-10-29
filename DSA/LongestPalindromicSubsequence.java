public class LongestPalindromicSubsequence {

    static class Solution {
        public int longestPalindromeSubseq(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            int n = s.length();
            int[][] dp = new int[n][n];

            for (int i = 0; i < n; i++) {
                dp[i][i] = 1;
            }

            for (int len = 2; len <= n; len++) {
                for (int i = 0; i <= n - len; i++) {
                    int j = i + len - 1;

                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[0][n - 1];
        }
    }

    /**
     * Main method to test the solution.
     */
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "bbbab";
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Output: " + sol.longestPalindromeSubseq(s1)); // Expected: 4

        String s2 = "cbbd";
        System.out.println("\nInput: \"" + s2 + "\"");
        System.out.println("Output: " + sol.longestPalindromeSubseq(s2)); // Expected: 2

        String s3 = "a";
        System.out.println("\nInput: \"" + s3 + "\"");
        System.out.println("Output: " + sol.longestPalindromeSubseq(s3)); // Expected: 1

        String s4 = "agbdba";
        System.out.println("\nInput: \"" + s4 + "\"");
        System.out.println("Output: " + sol.longestPalindromeSubseq(s4)); // Expected: 5

        String s5 = "aaaaa";
        System.out.println("\nInput: \"" + s5 + "\"");
        System.out.println("Output: " + sol.longestPalindromeSubseq(s5)); // Expected: 5
    }
}


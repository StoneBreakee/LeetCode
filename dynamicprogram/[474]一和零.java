// 背包问题的演化
        // dp[i][j] 表示i个0，j个1的最大子集个数
        // eles 中的每个元素只能使用一次
        int[][] dp = new int[m + 1][n + 1];
        int x = 0, zero, one;
        for (String str : strs) {
            zero = 0;
            one = 0;
            for (int i = 0; i < str.length(); i++) {
                x = str.charAt(i) == '0' ? zero++ : one++;
            }
            // 倒序遍历，如果正序赋值会造成结果的包含重复的情况
            // “01” 在超过i=1,j=1之后，dp[i][j]的结果相当于重复利用了“01”
            for (int i = m; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    if (i >= zero && j >= one) {
                        int tmp = dp[i - zero][j - one] + 1;
                        dp[i][j] = dp[i][j] > tmp ? dp[i][j] : tmp;
                    }
                }
            }
        }
        return dp[m][n];

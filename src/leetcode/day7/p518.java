package leetcode.day7;

public class p518 {
    public static void main(String[] args) {
        Solution567567 solution567567 = new Solution567567();
        int coins[] = {1, 2, 5};
        int coins2[] = {2};
        int change = solution567567.change(5, coins);
        System.out.println("change:" + change);
    }
}

class Solution567567 {
    int count = 0;
    int coins[];
    int amount;

    public int change(int amount, int[] coins) {
        this.coins = coins;
        this.amount = amount;
        dfs(0, 0);
        return count;
    }

    public void dfs(int curSum, int idx) {
        if (curSum > amount) return;
        if (curSum == amount) {
            //System.out.println("curSum==amount=>" + (curSum == amount));
            count++;
            return;
        }
        for (int i = idx; i < coins.length; i++) {
            //System.out.println("递归前curSum:" + curSum);
            if (curSum + coins[i] > amount) continue;
            dfs(curSum + coins[i], i);
            //System.out.println("递归后curSum:" + curSum);
        }
    }

    public int change2(int amount, int[] coins) {
        int dp[] = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[i] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
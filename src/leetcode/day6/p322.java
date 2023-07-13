package leetcode.day6;

import java.util.Arrays;

public class p322 {
    public static void main(String[] args) {

    }
}

class Solution76868 {
    int amount;
    int[] coins;
    int usedNum = 0;
    int minNum = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        this.amount = amount;
        this.coins = coins;
        dfs(0, 0, 0);
        return minNum;
    }

    public void dfs(int startIdx, int curAmount, int usedNum) {
        if (curAmount > amount) return;
        if (curAmount == amount) {
            minNum = Math.min(minNum, usedNum);
            System.out.println("minNum==>" + minNum);
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            curAmount += coins[i];
            System.out.println("curAmount==>" + curAmount);
            usedNum++;
            dfs(i, curAmount, usedNum);
        }

    }
}

class solu {
    int note[];

    public int coinChange(int[] coins, int amount) {
        note = new int[amount + 1];//当前额度最小使用币数
        return dfs(coins, amount);
    }

    public int dfs(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (note[amount] != 0) return note[amount];
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = dfs(coins, amount - coin);
            if (count == -1) continue;//不需要当前这种面额的币
            res = Math.min(res, count + 1);
        }
        note[amount] = res != Integer.MAX_VALUE ? res : -1;
        return note[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        int dp[] = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            //每次循环找出凑齐i面额所能使用的最小数量币
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    if (dp[i - coins[j]] < min) {
                        //减去所遍历到的那个币的面额放入金额的最小使用币数，
                        //加上1就代表使用了当前币
                        //min代表凑齐当前面额所能使用的最小数量币
                        min = dp[i - coins[j]] + 1;
                    }
                }
            }
            dp[i] = min;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public int coinChange3(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    //使用当前币dp[i-coins[j]]+1 不是用当前币dp[i]
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] >= (amount + 1) ? -1 : dp[amount];
    }
}

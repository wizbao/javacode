package dynamic_programming;

/**
 * @author hey
 * @description 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * @create 2020-05-14-19:33
 */
public class RobDemo {
    public int rub(int[] nums) {
        int len = nums.length;
        if (len==0)return 0;
        int[] dp = new int[len + 1];
        dp[0]=0;
        dp[1]=nums[0];
        for (int i = 2; i < len+1; i++) {
            dp[i]=Math.max(dp[i-1],nums[i-1]+dp[i-2]);
        }
        return dp[len];
    }
}

package Programmers;

class Solution {
    static int []dp;
    public int solution(int n) {
        int answer = 0;
        dp = new int[n+1];
        for(int i = 3;i<n+1;i++){
            tiles(i);
        }
        answer = dp[n];
        return answer;
    }

    static int tiles(int n){
        if(n==1) return 1;
        else if(n==2) return 2;

        if(dp[n]!=0) return dp[n];
        else{
            return dp[n] = (tiles(n-1)+tiles(n-2))%1000000007;
        }
    }
}

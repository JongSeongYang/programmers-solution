class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {

        dfs(0,numbers,target,0);
        return answer;
    }

    static void dfs(int a, int[] arr, int t, int r){

        if(a==arr.length){
            if(t==r)
                answer++;
        }
        else{
            dfs(a+1,arr,t,r+arr[a]);
            dfs(a+1,arr,t,r-arr[a]);
        }
    }
}
class Solution {
    static int[] arr;
    static int answer = 0;
    public int solution(int n, int[] lost, int[] reserve) {

        arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = 1;
        }
        for(int i = 0;i<reserve.length;i++){
            arr[reserve[i]-1]++;
        }
        for(int i = 0;i<lost.length;i++){
            arr[lost[i]-1]--;
        }
        solve(0);

        return answer;
    }

    static void solve(int a){
        if(a==arr.length){
            int num = 0;
            for(int i = 0;i<arr.length;i++)
                if(arr[i]>=1)
                    num++;

            answer = Math.max(answer, num);
        }
        else{
            if(arr[a] ==2){
                if(a==0){
                    if(arr[a+1]==0){
                        arr[a]--;
                        arr[a+1]++;
                        solve(a+1);
                        arr[a]++;
                        arr[a+1]--;
                    }
                }
                else if(a==arr.length-1){
                    if(arr[a-1]==0){
                        arr[a]--;
                        arr[a-1]++;
                        solve(a+1);
                        arr[a]++;
                        arr[a-1]--;
                    }
                }
                else{
                    if(arr[a+1]==0){
                        arr[a]--;
                        arr[a+1]++;
                        solve(a+1);
                        arr[a]++;
                        arr[a+1]--;
                    }
                    if(arr[a-1]==0){
                        arr[a]--;
                        arr[a-1]++;
                        solve(a+1);
                        arr[a]++;
                        arr[a-1]--;
                    }
                }
            }
            solve(a+1);
        }
    }
}
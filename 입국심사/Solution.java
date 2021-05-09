import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long min=1;
        long max=(long)times[times.length-1]*n;
        long mid=0;
        long sum;
        long answer = max;
        while(min<=max){
            sum=0;
            mid=(min+max)/2;
            for(int time:times){
                sum+=mid/time;
            }
            System.out.print(mid+ " " + sum+" answer : ");
            if(sum>=n){
                if(mid<answer){
                    answer=mid;
                }
                max=mid-1;
                System.out.println(answer+" min,max : "+min+" "+max);
            }
            else{
                min=mid+1;
                System.out.println(answer+" min,max : "+min+" "+max);
            }
        }
        return answer;
    }
}
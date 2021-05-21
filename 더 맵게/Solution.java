import java.util.*;
class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int solution(int[] scoville, int K) {
        int answer = 0;
        for(int i = 0;i<scoville.length;i++)
            pq.offer(scoville[i]);

        while(true){
            if(pq.peek() >= K) break;
            if(pq.size() < 2) return -1;
            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a+2*b);
            answer++;
        }
        return answer;
    }
}
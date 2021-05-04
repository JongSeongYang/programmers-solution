class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int a = 3;
        int b = 3;

        while(true){
            if(a*b>brown+yellow) break;
            for(int i = b;i<=(brown+yellow)/b;i++){
                if((i-2)*(b-2)==yellow && (i+b == (brown+4)/2)){
                    answer[0] = i;
                    answer[1] = b;
                    break;
                }
            }
            if(answer[0]!=0) break;
            b++;
            a++;
        }
        return answer;
    }
}
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int same = 0;
        int zero = 0;
        for(int lotto : lottos){
            if(lotto == 0){
                zero ++;
            }
            else{
                for(int num : win_nums){
                    if(lotto == num){
                        same++;
                        break;
                    }
                }
            }
        }
        int high = 7-(same+zero);
        int low = 7-same;
        if(low==7) low = 6;
        if(high==7) high = 6;
        int[] answer = {high, low};
        return answer;
    }
}
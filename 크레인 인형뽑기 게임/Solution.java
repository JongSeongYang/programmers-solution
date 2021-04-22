package Programmers;

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> result = new Stack<>();

        for(int i=0;i<moves.length;i++){
            int pop = pick(board,moves[i]-1);
            if( pop != 0) {
                if(result.empty())
                    result.push(pop);
                else if(!result.empty() && result.peek() != pop)
                    result.push(pop);
                else if(!result.empty() && result.peek() == pop){
                    result.pop();
                    answer++;
                }
                System.out.println(result.size());
            }
        }
        return 2*answer;
    }

    static int pick(int[][] board, int move){
        for(int i=0;i<board.length;i++){
            if(board[i][move]!=0){
                int picked = board[i][move];
                board[i][move] = 0;
                return picked;
            }
        }
        return 0;
    }
}

package programmers;

// N-Queen

public class Pg12952 {
    public static void main(String[] args) {
        Solution12952 solution12952 = new Solution12952();
        System.out.println(solution12952.solution(5));
    }
}

class Solution12952 {

    static int[] col;
    static int answer;
    static int N;

    public int solution(int n) {
        answer = 0;
        N = n;
        for(int i = 0 ; i < n ; ++i) {
            col = new int[n];
            col[0] = i;
            backtracking(1);
        }

        return answer;
    }

    private void backtracking(int row){
        if(row == N){
            answer++;
            col[row - 1] = 0;
            return;
        }

        for(int i = 0 ; i < N ; ++i){
            col[row] = i;
            if(checkDiagonal(row)){
                backtracking(row + 1);
            } else {
                col[row] = 0;
            }
        }
        col[row] = 0;
    }

    private boolean checkDiagonal(int row){
        for(int i = 0 ; i < row ; ++i){
            if(col[i] == col[row]) return false;
            if(Math.abs(row - i) == Math.abs(col[row] - col[i])) return false;
        }

        return true;
    }

}

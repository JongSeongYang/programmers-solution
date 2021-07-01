import java.util.*;
class Solution {

    static boolean[][] check;
    static int m;
    static int n;
    static int[] answer;

    public int[] solution(int m, int n, int[][] picture) {
        this.m = m;
        this.n = n;
        check = new boolean[m][n];
        answer = new int[2];
        bfs(picture);

        return answer;
    }

    private void bfs(int[][] arr) {
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                int cnt = 0;
                if(arr[i][j] !=0 && !check[i][j]){
                    int[] tmp = {i,j};
                    q.offer(tmp);
                    check[i][j] = true;
                    cnt++;
                    answer[0]++;
                }
                while(!q.isEmpty()){
                    int[] v = q.poll();
                    int x = v[1];
                    int y = v[0];
                    if(y>0 && arr[y-1][x] == arr[y][x] && !check[y-1][x]){
                        int[] tmp = {y-1,x};
                        q.offer(tmp);
                        check[y-1][x]=true;
                        cnt++;
                    }
                    if(y<m-1 && arr[y+1][x] == arr[y][x] && !check[y+1][x]){
                        int[] tmp = {y+1,x};
                        q.offer(tmp);
                        check[y+1][x]=true;
                        cnt++;
                    }
                    if(x>0 && arr[y][x-1] == arr[y][x] && !check[y][x-1]){
                        int[] tmp = {y,x-1};
                        q.offer(tmp);
                        check[y][x-1]=true;
                        cnt++;
                    }
                    if(x<n-1 && arr[y][x+1] == arr[y][x] && !check[y][x+1]){
                        int[] tmp = {y,x+1};
                        q.offer(tmp);
                        check[y][x+1]=true;
                        cnt++;
                    }
                }
                answer[1] = Math.max(cnt,answer[1]);
            }
        }
    }
}
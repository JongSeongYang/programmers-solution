import java.util.*;
class Solution {
    static char[] n;
    static boolean[] used;
    static ArrayList<Integer> list = new ArrayList<>();

    public int solution(String numbers) {
        int answer = 0;
        n = numbers.toCharArray();
        for(int i = 1 ;i<numbers.length()+1;i++){
            char[] tmp = new char[i];
            used = new boolean[numbers.length()];
            makeNum(0,i,tmp);
        }

        answer = list.size();
        return answer;
    }

    static void makeNum(int a, int length, char[] b){
        if(a == length){
            int t = Integer.parseInt(String.valueOf(b));
            if(t==0) return;
            if(!list.contains(t) && isPrime(t))
                list.add(t);
        }
        else{
            for(int i = 0;i<n.length;i++){
                if(!used[i]){
                    used[i] = true;
                    b[a] = n[i];
                    makeNum(a+1, length, b);
                    b[a] = 0;
                    used[i] = false;
                }
            }
        }
        return;
    }

    static boolean isPrime(int num){
        if(num==1) return false;
        else{
            boolean check = false;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    check = true;
                    break;
                }
            }
            if(check) return false;
            else return true;
        }
    }
}
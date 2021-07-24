import java.util.*;
class Solution {
    static int length;
    public int solution(String s) {
        int answer = 0;
        length = s.length();
        String new_s = s;
        for(int i = 0;i<length;i++){
            if(check(new_s)) answer++;
            new_s = new_s.substring(1, s.length()) + new_s.charAt(0);
        }

        return answer;
    }

    static boolean check(String s){
        Stack <Character> tmp = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='[')
                tmp.add('[');
            else if(s.charAt(i)==']'){
                if(tmp.isEmpty() || tmp.peek() != '[')
                    return false;
                tmp.pop();
            }
            else if(s.charAt(i)=='{')
                tmp.add('{');
            else if(s.charAt(i)=='}'){
                if(tmp.isEmpty() || tmp.peek() != '{')
                    return false;
                tmp.pop();
            }
            else if(s.charAt(i)=='(')
                tmp.add('(');
            else if(s.charAt(i)==')'){
                if(tmp.isEmpty() || tmp.peek() != '(')
                    return false;
                tmp.pop();
            }
        }
        if(tmp.isEmpty()) return true;
        else return false;
    }
}
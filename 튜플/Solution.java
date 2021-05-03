import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};

        String tmp = s.substring(2,s.length()-2);
        tmp = tmp.replace("},{"," ");
        String[] str = tmp.split(" ");
        answer = new int[str.length];
        Arrays.sort(str, (o1, o2) -> o1.length() - o2.length());
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(Integer.parseInt(str[0]));
        answer[0] = Integer.parseInt(str[0]);
        for(String a : str){
            String[] str2 = a.split(",");
            for(int i = 0;i<str2.length;i++){
                Integer b = Integer.parseInt(str2[i]);
                if(!arr.contains(b)){
                    arr.add(b);
                    answer[str2.length-1] = b.intValue();
                }
            }
        }

        //answer = arr.stream().mapToInt(i->i).toArray();
        return answer;
    }
}
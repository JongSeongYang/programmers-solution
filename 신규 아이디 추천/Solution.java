class Solution {
    public String solution(String new_id) {
        String answer = "";
        String id = new_id;
        id = id.toLowerCase();

        byte[] bt = id.getBytes();
        for(int i = 0; i<id.length();i++){
            String tmp = id.substring(i,i+1);
            if(tmp.equals("-") || tmp.equals("_") || tmp.equals(".") || (bt[i]>=97 && bt[i]<=122) || (bt[i] >=48 && bt[i]<=57))
                continue;
            id = id.replace(tmp," ");
        }

        answer = removeSpace(id);
        answer = removeHeadTail(answer);
        answer = removeDuplicate(answer);
        if(answer.length()>=16 || answer.length() <=2){
            answer = makeLength(answer);
        }
        return answer;
    }
    static String removeDuplicate(String id){
        String result = id;
        while(result.contains("..")){
            result = result.replace("..",".");
        }
        return result;
    }

    static String makeLength(String id){
        String result = "";
        if(id.length()>=16)
            result = id.substring(0,15);
        if(id.length()<=2){
            result = id;
            for(int i = 0;i<3-id.length();i++)
                result+=id.substring(id.length()-1, id.length());
        }
        result = removeHeadTail(result);
        return result;
    }

    static String removeSpace(String id){
        String result="";
        String[] a = id.split(" ");
        for(int i = 0;i<a.length;i++){
            result+=a[i].trim();
        }
        return result;
    }

    static String removeHeadTail(String id){
        char[] a = id.toCharArray();
        String result = id;
        while(true){
            if(!result.startsWith(".") && !result.endsWith(".")) break;
            if(result.startsWith(".")) a[0] = ' ';
            if(result.endsWith(".")) a[a.length-1] = ' ';

            result = String.valueOf(a);
            result = result.trim();
            a = result.toCharArray();
        }
        if(result.length()==0) return "a";
        return result = String.valueOf(a);
    }
}
import java.util.*;
public class Prob_03 {
    public static void main(String[] args) {
        String s = "Great people";

        HashMap<String,Integer> map=new HashMap<>();
        StringBuilder s1 = new  StringBuilder();

        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch==' ' && s1.length()>0)
            {
                 map.put(s1.toString(),map.getOrDefault(s1.toString(),0)+1);
                s1.setLength(0);
            }
            else if(ch!=' ') {
                s1.append(ch);
            }
        }
        if(s1.length()>0){
            map.put(s1.toString(),map.getOrDefault(s1.toString(),0)+1);
        }
        int cnt=0;
        for(Map.Entry<String,Integer> m:map.entrySet())
        {
            cnt+=m.getValue();
        }
        System.out.println("Total words in string : "+cnt);
        }
}

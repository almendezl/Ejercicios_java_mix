package pesPal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;


public class PesPal {

    public static boolean isPalindrome (String s) {
        int length=s.length();
        for (int i=0;i<length/2;i++) {
            if (s.charAt(i)!=s.charAt(length-1-i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s=br.readLine())!=null) {
            TreeMap<String,Boolean> map=new TreeMap();
            int length=s.length();
            for (int min=0;min<length;min++) {
                for (int max=min+1;max<=length;max++) {
                    String curr=s.substring(min,max);
                    if (isPalindrome(curr) && !map.containsKey(curr)) {
                        map.put(curr,true);
                    }
                }
            }
            
            StringBuilder sb=new StringBuilder("The string '");
            sb.append(s);
            sb.append("' contains ");
            sb.append(map.size());
            sb.append(" palindromes.");
            System.out.println(sb);
        }
    }
    
}

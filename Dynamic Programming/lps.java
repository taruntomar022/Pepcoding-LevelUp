import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(lps(str));
    }
    
    public static int lps(String str){
        int dp[][] = new int[str.length()][str.length()];

        for(int diag=0;diag<str.length();diag++){
            int sp = 0;
            int ep = diag;
            while(ep < str.length()){
                if(diag == 0){
                    dp[sp][ep] = 1;
                }
                else{
                    if(str.charAt(sp) == str.charAt(ep)){
                        dp[sp][ep] = 2 + dp[sp+1][ep-1]; 
                    }else{
                        dp[sp][ep] = Math.max(dp[sp+1][ep],dp[sp][ep-1]);
                    }
                }
                sp++;
                ep++;
            }
        }
        return dp[0][str.length()-1];
    }

}import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(lps(str));
    }
    
    public static int lps(String str){
        int dp[][] = new int[str.length()][str.length()];

        for(int diag=0;diag<str.length();diag++){
            int sp = 0;
            int ep = diag;
            while(ep < str.length()){
                if(diag == 0){
                    dp[sp][ep] = 1;
                }
                else{
                    if(str.charAt(sp) == str.charAt(ep)){
                        dp[sp][ep] = 2 + dp[sp+1][ep-1]; 
                    }else{
                        dp[sp][ep] = Math.max(dp[sp+1][ep],dp[sp][ep-1]);
                    }
                }
                sp++;
                ep++;
            }
        }
        return dp[0][str.length()-1];
    }

}

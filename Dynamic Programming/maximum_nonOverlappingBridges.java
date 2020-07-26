import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Pair arr[] = new Pair[n];
        for(int i=0;i<n;i++){
            Pair pb = new Pair();
            pb.sp = scn.nextInt();
            pb.ep = scn.nextInt();
            arr[i] = pb;
        }
        System.out.println(mnob(arr));
    }
    
    public static class Pair implements Comparable<Pair>{
        int sp;
        int ep;
        
        public int compareTo(Pair other){
            if(this.sp != other.sp){
                return this.sp - other.sp;
            }else{
                return this.ep - other.ep;
            }
        }
    }
    
    public static int mnob(Pair[] arr){
        Arrays.sort(arr);
        // reducible to LIS
        int dp[] = new int[arr.length];
        dp[0] = 1;
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[i].ep > arr[j].ep && (dp[j] > dp[i])){
                    dp[i] = dp[j];
                }
            }
            dp[i] += 1;
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(dp[i]>max){
                max = dp[i];
            }
        }
        return max;
    }

}

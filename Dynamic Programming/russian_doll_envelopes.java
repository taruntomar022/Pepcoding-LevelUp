import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Pair[] arr = new Pair[n];
        for(int i=0;i<n;i++){
            Pair pb = new Pair();
            pb.wd = scn.nextInt();
            pb.ht = scn.nextInt();
            arr[i] = pb;
        }
        System.out.println(rde(arr));
    }

    public static class Pair implements Comparable<Pair>{
        int wd;
        int ht;
        public int compareTo(Pair other){
            if(this.wd != other.wd){
                return this.wd - other.wd;
            }
            else{
                return this.ht - other.wd;
            }
        }
    }

    public static int rde(Pair arr[]){
        Arrays.sort(arr);
        int dp[] = new int[arr.length];
        dp[0] = 1;
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[i].ht > arr[j].ht && (dp[j]>dp[i])){
                    dp[i] = dp[j];
                }
            }
            dp[i] += 1;
        }
        int max = dp[0];
        for(int i=1;i<arr.length;i++){
            if(dp[i]>max){
                max = dp[i];
            }
        }
        return max;
    }
}

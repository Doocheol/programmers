import java.util.*;
import java.io.*;

public class Main {
    
    private static int n, k;
    private static int[][] dp;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[n+1][n+1];
        
        for (int i = 0; i <= n; i++) {
            dp[i][1] = i;
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
            }
        }
        
        System.out.println(dp[n][k]);
        
    }
    
}
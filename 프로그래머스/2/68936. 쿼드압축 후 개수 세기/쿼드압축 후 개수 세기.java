class Solution {
    public int[] solution(int[][] arr) {
        int[][] rev = new int[arr.length][arr.length];
        for (int i = 0; i < rev.length; i++) {
            rev[i] = arr[i].clone();
            for (int j = 0; j < rev.length; j++) {
                rev[i][j] ^= 1;
            }
        }
        
        Compression(arr);
        int one = sum(arr);
        Compression(rev);
        int zero = sum(rev);
        
        return new int[]{zero, one};
        
    }
    
    private static void Compression(int[][] arr) {
        for (int p = 0; Math.pow(2, p) < arr.length; p++) {
            int pow = (int) Math.pow(2, p);
            int quad = (int) Math.pow(4, p + 1);
            for (int i = (pow * 2) - 1; i < arr.length; i += (pow * 2)) {
                for (int j = (pow * 2) - 1; j < arr.length; j += (pow * 2)) {
                    if (arr[i][j] + arr[i - pow][j] + arr[i][j - pow] + arr[i - pow][j - pow] == quad) {
                        arr[i - pow][j] = arr[i][j- pow] = arr[i - pow][j - pow] = 0;
                        arr[i][j] = quad;
                    }
                }
            }
        }
    }
    private static int sum(int[][] arr) {
        int sum = 0;
        for (int[] a : arr) {
            for (int x : a) {
                if (x > 0) sum++;
            }
        }
        return sum;
    }
}
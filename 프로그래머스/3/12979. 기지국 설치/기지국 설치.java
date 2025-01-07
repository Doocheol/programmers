class Solution {
    public int solution(int n, int[] stations, int w) {
        
        int answer = 0;
        int location = 1;
        int idx = 0;
        
        while (location <= n) {
            if (idx < stations.length && stations[idx] - w <= location) {
                location = stations[idx] + w + 1;
                idx++;
            }
            else {
                location += w * 2 + 1;
                answer++;
            }
        }
        
        return answer;
        
    }
}
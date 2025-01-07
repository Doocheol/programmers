class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        // 시작 위치
        int currentX = x;
        int currentY = y;
        StringBuilder path = new StringBuilder();
        
        // 사전 순으로 이동 방향 설정: 'd', 'l', 'r', 'u'
        char[] directions = {'d', 'l', 'r', 'u'};
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};
        
        for(int step = 0; step < k; step++) {
            boolean moved = false;
            for(int i = 0; i < directions.length; i++) {
                char dir = directions[i];
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                
                // 미로 범위 내인지 확인
                if(nextX < 1 || nextX > n || nextY < 1 || nextY > m) continue;
                
                // 다음 위치에서 목표까지의 맨해튼 거리
                int distance = Math.abs(nextX - r) + Math.abs(nextY - c);
                int nextRemaining = k - (step + 1);
                
                // 이동 가능성 판단
                if(distance > nextRemaining) continue;
                if((nextRemaining - distance) % 2 != 0) continue;
                
                // 이동 가능하면 방향 추가하고 현재 위치 업데이트
                path.append(dir);
                currentX = nextX;
                currentY = nextY;
                moved = true;
                break;
            }
            // 모든 방향을 시도했으나 이동할 수 없는 경우
            if(!moved) {
                return "impossible";
            }
        }
        
        // 최종 위치가 목표 지점인지 확인
        if(currentX == r && currentY == c) {
            return path.toString();
        }
        else {
            return "impossible";
        }
    }
}

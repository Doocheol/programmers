import java.util.*;
import java.io.*;

public class Main {
    
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static boolean[][] visited;
    private static int[][] map;
    private static int n, m;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        bfs(0, 0);
        System.out.println(map[n-1][m-1]);
        
    }
    
    private static void bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int nx = current[0] + dx[d];
                int ny = current[1] + dy[d];
                if (check(nx, ny)) {
                    if (map[nx][ny] != 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        map[nx][ny] = map[current[0]][current[1]] + 1;
                        queue.add(new int[] {nx, ny});
                    }
                }
            }
        }
    }
    
    private static boolean check(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
    
}
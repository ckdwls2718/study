// 미로 탈출

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class EscapeMaze {
    static int[][] graph;
    static int n, m;

    //네가지 방향 정의 (상,하,좌,우)
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static int bfs(int x, int y){
        // bfs 를 위한 큐 생성
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        // 큐가 빌때까지 반복
        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            // 현위치에서 4방향으로 확인
            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                // 범위를 벗어나면 스킵
                if (nx < 0 || nx >=n || ny < 0 || ny >= m ) continue;

                // 시작 지점이라면 스킵
                if (nx ==0 && ny ==0) continue;

                // 벽이라면 스킵
                if (graph[nx][ny] == 0) continue;
                // 길이라면 이 전 값의 +1을 큐에 저장
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Node(nx,ny));
                }
            }
        }
        return graph[n-1][m-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int result = 0;

        // 입력 버퍼 비우기 - 엔터값
        sc.nextLine();
        graph = new int[n][m];

        //미로값 입력받기
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0));

        // 이해를 위해 지나간 발자취 출력력
        for (int i = 0 ;i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
    }
}

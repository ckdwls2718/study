//음료수 얼려 먹기

import java.util.Scanner;

public class IceDrink {
    static int[][] graph;
    static int n , m;

    public static boolean dfs(int i, int j) {

        //범위를 벗어나면 false 반환
        if(i >= n || i<=-1 || j >= m || j <= -1) return false;

        //상하좌우도 재귀함수를 이용해 모두 호출
        if (graph[i][j] == 0) {
            // 노드 방문처리
            graph[i][j] = 1;

            dfs(i-1,j);
            dfs(i+1,j);
            dfs(i,j-1);
            dfs(i,j+1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int result = 0;

        // 입력 버퍼 비우기 - 엔터값
        sc.nextLine();
        graph = new int[n][m];

        //음료수값 입력 받기
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // 음료수 채우기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i,j))
                    result++;
            }
        }

        System.out.println("result = " + result);
    }
}

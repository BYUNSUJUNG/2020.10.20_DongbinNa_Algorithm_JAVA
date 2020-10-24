package Step03_BFS_DFS;

import java.util.*;


// (1,1)���� �����ؼ� (n,m)�� ����
// �̵��� �� �ִ� ��: 1

// �Է� ����
// 5 6
// 101010
// 111111
// 000001
// 111111
// 111111

// ��� ����
// 10
class Node {
	private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }
    
    public int getDistance() {
        return this.distance;
    }
}

public class BFS_EscapeTheMaze {

    public static int n, m;
    public static int[][] graph = new int[201][201];

    // �̵��� �� ���� ���� ���� (��, ��, ��, ��) 
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static int bfs(int x, int y) {
        // ť(Queue) ������ ���� queue ���̺귯�� ��� 
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        // ť�� �� ������ �ݺ��ϱ� 
        while(!q.isEmpty()) {
            Node node = q.poll();
            x = node.getIndex();
            y = node.getDistance();
            // ���� ��ġ���� 4���� ���������� ��ġ Ȯ��
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // �̷� ã�� ������ ��� ��� ����
                if (nx <= 0 || nx > n || ny <= 0 || ny > m) continue;
                // ���� ��� ����
                if (graph[nx][ny] == 0) continue;
                // �ش� ��带 ó�� �湮�ϴ� ��쿡�� �ִ� �Ÿ� ���
                if (graph[nx][ny] == 1) {
                    //System.out.println(x+""+y);
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Node(nx, ny));
                } 
            } 
        }
        // ���� ������ �Ʒ������� �ִ� �Ÿ� ��ȯ
        return graph[n][m];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M�� ������ �������� �����Ͽ� �Է� �ޱ�
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // ���� �����

        // 2���� ����Ʈ�� �� ���� �Է� �ޱ�
        for (int i = 1; i <= n; i++) {
            String str = sc.nextLine();
            for (int j = 1; j <= m; j++) {
                graph[i][j] = str.charAt(j-1) - '0';
            }
        }

        // BFS�� ������ ��� ���
        System.out.println(bfs(1, 1));
    }
}
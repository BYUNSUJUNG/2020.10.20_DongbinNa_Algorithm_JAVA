# 1. 구현 & 그리디 유형
## (1) 구현 - 시뮬레이션, 완전 탐색과 유사
풀이를 떠올리기는 쉽지만 소스코드로 옮기기 어려운 문제

  ### 1) 상하좌우 ([코드](https://github.com/BYUNSUJUNG/2020.10.20_DongbinNa_Algorithm_JAVA/blob/master/src/Step02_Implementaion/UpDownLeftRight.java))
  **문제**  
  여행가 A는 N x N 크기의 정사각형 공간 위에 서 있습니다.  
  가장 왼쪽 위 좌표는 (1,1)이며, 가장 오른쪽 아래 좌표는 (N,N)에 해당합니다.  
  여행가는 상(U), 하(D), 좌(L), 우(R) 방향으로 이동할 수 있으며, 시작 좌표는 항상 (1,1) 
  
  **이때, N x N 크기의 정사각형 공간을 벗어나는 움직임은 무시됩니다.**
  ```java
  // 이동 후 좌표 
  int nx = 0, ny = 0;
  if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
  ```
  **Point. 2차원 공간, 방향 백터 활용**
  ```java
  // L, R, U, D에 따른 이동 방향 
  int[] dx = {0, 0, -1, 1};
  int[] dy = {-1, 1, 0, 0};
  char[] moveTypes = {'L', 'R', 'U', 'D'};
  ```

  ### 2) 시각 ([코드](https://github.com/BYUNSUJUNG/2020.10.20_DongbinNa_Algorithm_JAVA/blob/master/src/Step02_Implementaion/Time.java)) - 완전 탐색 유형
  **문제**  
  정수 N이 입력되면 00시 00분 00초부터 N시 59분 59초까지 3이 포함되는 모든 경우의 수(Cnt)를 출력합니다.  
  
  **Point. 3이 포함되는지 확인**
  ```java
  // % 10 : 1의 자리에 3이 포함되어 있는지
  // / 10 : 10의 자리에 3이 포함되어 있는지
    if (h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3)
        return true; // 포함될 경우 true 리턴
    return false; // 포함되지 않았을 경우 false 리턴
  ```
  
  ### 3) 왕실의 나이트([코드](https://github.com/BYUNSUJUNG/2020.10.20_DongbinNa_Algorithm_JAVA/blob/master/src/Step02_Implementaion/RoyalHousehold.java))
  **문제**    
  첫째 줄에 8 x 8 좌표 평면상에서 현재 나이트가 위치한 곳의 좌표를 나타내는 두 문자로 구성된 문자열이 입력된다.  
  입력 문자는 a1처럼 열과 행으로 이뤄진다.  
  첫째 줄에 나이트가 이동할 수 있는 경우의 수를 출력하시오.   
  
  **나이트는 특정 위치에서 다음과 같은 2가지 경우로 이동할 수 있습니다.**
  * 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동하기
  * 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기
  
  **Point. 나이트가 이동할 수 있는 8가지 방향 정의**
  ```java
  int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
  int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
  ```
## (2) 그리디  
현재 상황에서 지금 당장 좋은 것만 고르는 방법

 ### 1) 거스름 돈([코드](https://github.com/BYUNSUJUNG/2020.10.20_DongbinNa_Algorithm_JAVA/blob/master/src/Step02_Greedy/Change.java))
 **문제**    
 카운터에는 거스름돈으로 사용할 500원, 100원, 50원, 10원짜리 동전이 무한히 존재한다고 가정합니다.  
 손님에게 거슬러 주어야 할 돈이 N원일 때 거슬러 주어야 할 동전의 최소 개수를 구하세요.  
 
 **Point. 가장 큰 화폐 단위부터**  
 ```java
  int[] coinTypes = {500, 100, 50, 10};
  // 큰 화폐부터 차근 차근
  for (int i = 0; i < 4; i++) {
      int coin = coinTypes[i];
      cnt += n / coin;
      n %= coin; // 몫을 다시 n값으로
  }
 ```
 ### 2) 곱셈과 덧셈([코드](https://github.com/BYUNSUJUNG/2020.10.20_DongbinNa_Algorithm_JAVA/blob/master/src/Step02_Greedy/MultiplicationOrAddition.java))
 **문제**  
 각 자리가 숫자로만 이루어진 문자열이 주어졌을 때,  
 왼쪽부터 오른쪽으로 하나씩 모든 숫자를 확인하며  
 숫자 사이에 'x' 또는 '+' 연산자를 넣어  
 결과적으로 만들어질 수 있는 가장 큰 수를 구하는 프로그램을 작성하시오.

 **단, +보다 x를 먼저 계산하는 일반적인 방식과 달리, 모든 연산은 왼쪽부터 순서대로 이루어진다고 가정합니다.**  
 
 **Point. 0 또는 1인 경우에는 덧셈을**  
 ```java
 // 첫번째 숫자인 result도 0 또는 1인 경우를 놓치면 안된다.
 if (num<=1||result<=1) {
    result += num;
  }
  else {
    result *= num;
  }
 ```
 
# 2. DFS & BFS
그래프 탐색 

## (1) 스택([코드](https://github.com/BYUNSUJUNG/2020.10.20_DongbinNa_Algorithm_JAVA/blob/master/src/Step03/StackEx.java))
## (2) 큐([코드](https://github.com/BYUNSUJUNG/2020.10.20_DongbinNa_Algorithm_JAVA/blob/master/src/Step03/QueueEx.java))
## (3) 인접행렬([코드](https://github.com/BYUNSUJUNG/2020.10.20_DongbinNa_Algorithm_JAVA/blob/master/src/Step03/AdjacencyMatrixEx.java))
## (4) 재귀함수
  ### 1) Ex1 - 종료 조건 X (무한)([코드](https://github.com/BYUNSUJUNG/2020.10.20_DongbinNa_Algorithm_JAVA/blob/master/src/Step03/RecursiveFunctionEx1.java))
  ### 2) Ex2 - 종료 조건 O ([코드](https://github.com/BYUNSUJUNG/2020.10.20_DongbinNa_Algorithm_JAVA/blob/master/src/Step03/RecursiveFunctionEx2.java))
## (5) 팩토리얼[코드](https://github.com/BYUNSUJUNG/2020.10.20_DongbinNa_Algorithm_JAVA/blob/master/src/Step03/FactorialEx.java)
## (6) DFS(깊이 우선 탐색) / 스택 또는 재귀 함수 사용
  ### 1) Ex([코드](https://github.com/BYUNSUJUNG/2020.10.20_DongbinNa_Algorithm_JAVA/blob/master/src/Step03/DFS_Ex.java))
  
  **Point. 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출**
  ```java
  // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!visited[y]) dfs(y);
        }
  ```
   
  ### 2) 음료수 얼려먹기([코드](https://github.com/BYUNSUJUNG/2020.10.20_DongbinNa_Algorithm_JAVA/blob/master/src/Step03/DFS_Drink.java)) - 재귀 함수 사용
  
  **Point. 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출**
  ```java
  dfs(x - 1, y);
  dfs(x, y - 1);
  dfs(x + 1, y);
  dfs(x, y + 1);
  ```
  
## (7) BFS(너비 우선 탐색) / 큐 사용
  ### 1) Ex([코드](https://github.com/BYUNSUJUNG/2020.10.20_DongbinNa_Algorithm_JAVA/blob/master/src/Step03/BFS_Ex.java))
  
  **Point. 연결된, 아직 방문하지 않은 원소들을 방문, 큐 삽입**
  ```java
   // 큐가 빌 때까지 반복
  while(!q.isEmpty()) {
      // 큐에서 하나의 원소를 뽑아 출력
      int x = q.poll();
      System.out.print(x + " ");
      // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
      for(int i = 0; i < graph.get(x).size(); i++) {
          int y = graph.get(x).get(i);
          if(!visited[y]) {
              q.offer(y);
              visited[y] = true;
          }
      } // end of for
   }
   ```
  
  ### 2) 미로탈출([코드](https://github.com/BYUNSUJUNG/2020.10.20_DongbinNa_Algorithm_JAVA/blob/master/src/Step03/BFS_EscapeTheMaze.java))
  
  **Point. 해당 노드를 처음 방문하는 경우에만 최단 거리 기록**
  ```java
  if (graph[nx][ny] == 1) {
      graph[nx][ny] = graph[x][y] + 1;
      q.offer(new Node(nx, ny));
  }
   ```
  
# 3. 정렬 알고리즘
## (1) 선택 정렬([코드](https://github.com/BYUNSUJUNG/2020.10.20_DongbinNa_Algorithm_JAVA/blob/master/src/Step04/SelectionSort.java))
## (2) 삽입 정렬([코드](https://github.com/BYUNSUJUNG/2020.10.20_DongbinNa_Algorithm_JAVA/blob/master/src/Step04/InsertSort.java))
## (3) 퀵 정렬([코드](https://github.com/BYUNSUJUNG/2020.10.20_DongbinNa_Algorithm_JAVA/blob/master/src/Step04/QuickSort.java))
## (4) 계수 정렬([코드](https://github.com/BYUNSUJUNG/2020.10.20_DongbinNa_Algorithm_JAVA/blob/master/src/Step04_Sort/CountingSort.java))
## (5) 표준 라이브러리([오름차순 코드](https://github.com/BYUNSUJUNG/2020.10.20_DongbinNa_Algorithm_JAVA/blob/master/src/Step04_Sort/StandardLibrary.java))([내림차순 코드](https://github.com/BYUNSUJUNG/2020.10.20_DongbinNa_Algorithm_JAVA/blob/master/src/Step04_Sort/StandardLibrary_ReverseOrder.java))
## (6) 두 배열의 원소 값 바꾸기([코드](https://github.com/BYUNSUJUNG/2020.10.20_DongbinNa_Algorithm_JAVA/blob/master/src/Step04_Sort/Replace_two_array_elements.java))



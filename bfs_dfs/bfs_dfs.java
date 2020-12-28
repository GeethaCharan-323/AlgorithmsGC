import java.util.*;

public class bfs_dfs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of vertices in the graph");
        int n = input.nextInt();
        int[][] matrix = new int[n][n];
        System.out.println("Enter the adjacency matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        System.out.println("Enter the source vertex");
        int source = input.nextInt();
        bfs(matrix,source);
        dfs(matrix,source);
    }
    static void bfs(int[][] matrix, int source){
        boolean[] visited = new boolean[matrix.length];
        visited[source-1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        System.out.println("The breadth first order is:");
        while(!queue.isEmpty()){
            System.out.print(queue.peek()+" ");
            int x = queue.poll();
            int i;
            for(i=0; i<matrix.length;i++){
                if(matrix[x-1][i] == 1 && visited[i] == false){
                    queue.add(i+1);
                    visited[i] = true;
                }
            }
        }
    }
    static void dfs(int[][] matrix, int source){
        boolean[] visited = new boolean[matrix.length];
        visited[source-1] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        int i,x;
        System.out.println("The depth first order is:");
        System.out.println(source);
        while(!stack.isEmpty()){
            x = stack.pop();
            for(i=0; i<matrix.length; i++){
                if(matrix[x-1][i] == 1 && visited[i] == false){
                    stack.push(x);
                    visited[i] = true;
                    System.out.print(" "+(i+1));
                    x = i+1;
                    i = -1;
                }
            }
        }
    }
}
import java.util.Scanner; //Scanner Function to take in the Input Values

public class Dijkstra {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int n = input.nextInt();
        int[] preD = new int[n];
        int min = 999, nextNode = 0; // min holds the minimum value, nextNode holds the value for the next node.
        int[] distance = new int[n]; // the distance matrix
        int[][] matrix = new int[n][n]; // the actual matrix
        int[] visited = new int[n]; // the visited array
        System.out.println("Enter the cost matrix");
        for(int i = 0; i < distance.length; i++){
            visited[i] = 0; //initialize visited array to zeros
            preD[i] = 0;
            for(int j = 0; j < distance.length; j++){
                matrix[i][j] = input.nextInt(); //fill the matrix
                if(matrix[i][j]==0){
                    matrix[i][j] = 999; // make the zeros as 999
                }
            }
        }
        distance = matrix[0]; //initialize the distance array
        visited[0] = 1; //set the source node as visited
        distance[0] = 0; //set the distance from source to source to zero which is the starting point
        for(int counter = 0; counter < n; counter++){
            min = 999;
            for(int i = 0; i < n; i++){
                if(min > distance[i] && visited[i]!=1){
                    min = distance[i];
                    nextNode = i;
                }
            }
            visited[nextNode] = 1;
            for(int i = 0; i < n; i++){
                if(visited[i]!=1){
                    if(min+matrix[nextNode][i] < distance[i]){
                        distance[i] = min+matrix[nextNode][i];
                        preD[i] = nextNode;
                    }
                }
            }
        }
        int j;
        System.out.println("Shortest Paths to ");
        for(int i = 0; i < n; i++){
            if(i!=0){
                System.out.print(i+" = " + i);
                j = i;
                do{
                    j=preD[j];
                    System.out.print(" <- " + j);
                }while(j!=0);
            }
            if(i!=0)
                System.out.println("  Distance :"+distance[i]);
        }
    }
}
/* OUTPUT
Enter the number of vertices: 
4
Enter the adjacency matrix
0 4 5 7
4 0 0 1
5 0 0 2
7 1 2 0
Shortest Paths to 
1 = 1 <- 0  Distance :4
2 = 2 <- 0  Distance :5
3 = 3 <- 1 <- 0  Distance :5
*/

import java.util.Scanner;

public class OptimalBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No.of Nodes:");
        int n = sc.nextInt();
        int []keys = new int[n];
        int []freq = new int[n];
        System.out.println("Enter Keys:");
        for (int i = 0; i < n; i++) {
            keys[i]=sc.nextInt();
        }
        System.out.println("Enter Frequency of keys:");
        for (int i = 0; i < n; i++) {
            freq[i]=sc.nextInt();
        }
        System.out.println("Cost of Optimal BST is " + optimalSearchTree(keys, freq, n));
    }
    static int optimalSearchTree(int[] keys, int[] freq, int n) {
        return optCost(freq, 0, n-1);
    }
    static int optCost(int[] freq, int i, int j) {
        if (j < i)  return 0;
        if (j == i)  return freq[i];

        int fsum = sum(freq, i, j);
        int min = Integer.MAX_VALUE;

        for (int r = i; r <= j; ++r) {
            int cost = optCost(freq, i, r-1) + optCost(freq, r+1, j);
            if (cost < min)
                min = cost;
        }
        return min + fsum;
    }
    static int sum(int[] freq, int i, int j) {
        int s = 0;
        for (int k = i; k <=j; k++)
            s = s + freq[k];
        return s;
    }
}

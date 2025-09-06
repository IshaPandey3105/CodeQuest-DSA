import java.util.Scanner;

public class J9_MulOfMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input dimensions
        System.out.print("Enter rows and columns of first matrix (n m): ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.print("Enter rows and columns of second matrix (p q): ");
        int p = sc.nextInt();
        int q = sc.nextInt();

        // Check if multiplication is possible
        if (m != p) {
            System.out.println("Matrix multiplication not possible! (m != p)");
            sc.close();
            return;
        }

        // Declare matrices
        int[][] a = new int[n][m];
        int[][] b = new int[p][q];
        int[][] result = new int[n][q];

        // Input for first matrix
        System.out.println("Enter elements of first matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        // Input for second matrix
        System.out.println("Enter elements of second matrix:");
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        // Matrix multiplication using 3 loops
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < q; j++) {
                for (int k = 0; k < m; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        // Print result matrix
        System.out.println("Resultant Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < q; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}


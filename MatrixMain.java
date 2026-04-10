import java.util.Scanner;

class Matrix {
    private int rows, cols;
    private int[][] data;

    public Matrix(int r, int c) {
        rows = r;
        cols = c;
        data = new int[r][c];
    }

    public void readData(Scanner sc) {
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                data[i][j] = sc.nextInt();
    }

    public Matrix transpose() {
        Matrix t = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                t.data[j][i] = data[i][j];
        return t;
    }

    public Matrix multiply(Matrix m) {
        Matrix result = new Matrix(this.rows, m.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < m.cols; j++) {
                result.data[i][j] = 0;
                for (int k = 0; k < this.cols; k++) {
                    result.data[i][j] += this.data[i][k] * m.data[k][j];
                }
            }
        }
        return result;
    }

    public void print() {
        for (int[] row : data) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}

public class MatrixMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns for Matrix A: ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        Matrix A = new Matrix(r1, c1);
        A.readData(sc);

        System.out.print("Enter rows and columns for Matrix B: ");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        Matrix B = new Matrix(r2, c2);
        B.readData(sc);

        System.out.println("\nTranspose of Matrix A:");
        A.transpose().print();

        System.out.println("\nTranspose of Matrix B:");
        B.transpose().print();

        System.out.println("\nProduct of Matrix A and Matrix B:");
        Matrix product = A.multiply(B);
        product.print();

        sc.close();
    }
}


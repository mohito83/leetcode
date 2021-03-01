package matrix;

public class RotateMatrix {
    void rotateMatrix(int N, int[][] arr) {
        for (int x =0; x < N/2; x++) {
            for (int y=x; y<N-1-x; y++) {
                int temp = arr[x][y];
                arr[x][y] = arr[y][N-1-x];
                arr[y][N-1-x] = arr[N-1-x][N-1-y];
                arr[N-1-x][N-1-y] = arr[N-1-y][x];
                arr[N-1-y][x] = temp;
            }
        }
    }

    void printMatrix(int N, int[][] arr) {
        for (int i=0;i<N; i++) {
            for (int j=0; j<N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        RotateMatrix rm = new RotateMatrix();

        System.out.println("Original Matrix");
        rm.printMatrix(4,arr);

        rm.rotateMatrix(4, arr);
        System.out.println("After rotating matrix:");
        rm.printMatrix(4, arr);
    }
}

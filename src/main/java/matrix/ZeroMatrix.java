package src.main.java.matrix;

public class ZeroMatrix {

    void printMatrix(int N, int[][] arr) {
        for (int i=0;i<N; i++) {
            for (int j=0; j<N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,0,3,4},
                {5,6,7,8},
                {9,10,0,12},
                {13,14,15,16}};
        ZeroMatrix zm = new ZeroMatrix();

        System.out.println("Original Matrix");
        zm.printMatrix(4,arr);

        zm.zerofyMatrix(arr);
        System.out.println("After rotating src.main.java.matrix:");
        zm.printMatrix(4, arr);
    }

    private void zerofyMatrix(int[][] arr) {
        int noOfRows = arr.length;
        int noOfCols = arr[0].length;

        boolean[] rowArr = new boolean[noOfRows];
        boolean[] colArr = new boolean[noOfCols];

        for (int i=0; i<noOfRows; i++) {
            for(int j=0;j<noOfCols; j++) {
                if(arr[i][j] ==0) {
                    rowArr[i]=true;
                    colArr[j] = true;
                }
            }
        }

        for (int i=0; i<noOfRows; i++) {
            if (rowArr[i]) {
                for (int j=0;j<noOfCols; j++) {
                    arr[i][j] = 0;
                }
            }
        }

        for (int i=0; i<noOfCols; i++) {
            if (colArr[i]) {
                for (int j=0;j<noOfRows; j++) {
                    arr[j][i] = 0;
                }
            }
        }
    }
}

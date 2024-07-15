//73. Set Matrix Zeroes
class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] findZeroes = new boolean[row][col];
        //track the index where zeroes exist
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(matrix[i][j]==0) {
                    findZeroes[i][j]=true;
                }
            }
        }
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(findZeroes[i][j]) {
                    //entire row set to 0
                    for(int c=0; c<col; c++) {
                        matrix[i][c]=0;
                    }
                    //entire col set to 0
                    for(int r=0; r<row; r++) {
                        matrix[r][j]=0;
                    }
                }
            }
        }
        
    }
}

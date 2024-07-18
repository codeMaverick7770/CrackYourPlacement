// 54. Spiral Matrix
// Time: O(mxn) Space: O(mxn)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        
        int rowStart = 0; // Should start from 0
        int colStart = 0; // Should start from 0
        int rowStop = matrix.length - 1;
        int colStop = matrix[0].length - 1;

        while (rowStart <= rowStop && colStart <= colStop) {
            // Row Right
            for (int i = colStart; i <= colStop; i++) {
                list.add(matrix[rowStart][i]);
            }
            rowStart++; // Move down to the next row

            // Col Down
            for (int i = rowStart; i <= rowStop; i++) {
                list.add(matrix[i][colStop]);
            }
            colStop--; // Move left to the previous column

            // Row Left (check if still valid)
            if (rowStart <= rowStop) {
                for (int i = colStop; i >= colStart; i--) {
                    list.add(matrix[rowStop][i]);
                }
                rowStop--; // Move up to the previous row
            }

            // Col Up (check if still valid)
            if (colStart <= colStop) {
                for (int i = rowStop; i >= rowStart; i--) {
                    list.add(matrix[i][colStart]);
                }
                colStart++; // Move right to the next column
            }
        }

        return list;
    }
}

class Solution {
    public void setZeroes(int[][] matrix) {
        /*
        157 / 157 test cases passed.
Status: Accepted
Runtime: 1 ms
84.21%
        // fr = first row
    // fc = first col
    
    // Use first row and first column as markers. 
    // if matrix[i][j] = 0, mark respected row and col marker = 0; indicating
       that later this respective row and col must be marked 0;
    // And because you are altering first row and collumn, 
       you need to  have two variables to track their own status. 
    // So, for ex, if any one of the first row is 0, fr = 0, 
       and at the end set all first row to 0;
       
       time: O(m*n)
       space: O(1)
        */
        
        if (matrix == null) 
            return;
        
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int rowZero = 0;
        int colZero = 0;
        
      
        
        for (int row = 0; row < rowSize; row++) {
            if (matrix[row][0] == 0)
                rowZero = 1;
        }
        for (int col = 0; col < colSize; col++) {
            if (matrix[0][col] == 0)
                colZero = 1;
        }
        
        for (int row = 0; row < rowSize; row++)
            for (int col = 0; col < colSize; col++)
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
        
        for (int row = 1; row < rowSize; row++) { /* start from row 1*/
            if (matrix[row][0] == 0)
                for (int col = 0; col < colSize; col++)
                    matrix[row][col] = 0;
        }
        for (int col = 1; col < colSize; col++) { /* start from col 1*/
            if (matrix[0][col] == 0)
                for (int row = 0; row < rowSize; row++)
                    matrix[row][col] = 0;
        }
        
        if (rowZero == 1) {
            for (int row = 0; row < rowSize; row++)
                matrix[row][0] = 0;
        }
        if (colZero == 1) {
            for (int col = 0; col < colSize; col++)
                matrix[0][col] = 0;    
        }
    }
}

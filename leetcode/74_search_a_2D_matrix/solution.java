class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
        binary search:
        pick the right-top elment as mid
        target > mid, row ++
        target < mid, col --
        time:O(m+n)
        space: O(1)
        */
        if (matrix == null)
            return false;
        if (matrix.length == 0)
            return false;
        if (matrix[0].length == 0)
            return false;
        
        int row = 0;
        int col = matrix[0].length-1;
        
        
        
        while (col >= 0 && row <= matrix.length-1) {
            if (target == matrix[row][col]) return true;
            else if (target > matrix[row][col])
                row ++;
            else
                col --;
            
        }
        return false;
    }
    
}

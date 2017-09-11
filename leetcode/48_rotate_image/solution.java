

class Solution {
    public void rotate(int[][] matrix) {
        /*
        21 / 21 test cases passed.
Status: Accepted
Runtime: 5 ms
2.31%

use matrix swap
advice: draw a matrix
        */
        int size = matrix.length;
        int tmp;
        for (int i = 0; i < (size+1)/2; i++) {
            for (int j = 0; j < (size)/2; j++){
                tmp = matrix[i][j];
                matrix[i][j] = matrix[size-j-1][i];
                matrix[size-j-1][i] = matrix[size-i-1][size-j-1];
                matrix[size-i-1][size-j-1] = matrix[j][size-i-1];
                matrix[j][size-i-1] = tmp;
            }
            
        }
        return;
    }
}
//size = 3
//tmp = m[0][1]
//m[0][1] = m[1][2]
/*
123
456
789

721
654
983
*/

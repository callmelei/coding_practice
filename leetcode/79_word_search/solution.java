class Solution {
    public boolean exist(char[][] board, String word) {
        /*
        DFS, avoid duplicated cell, it cannot go back to the same letter
        hashmap needs to be clear and remove
        87 / 87 test cases passed.
Status: Accepted
Runtime: 109 ms
4%
        */
        int m = board.length;
        int n;
        //System.out.println("====");
        HashMap<String, Integer> hash = new HashMap<>();
        if (m == 0) return false;
        if (word.length() == 0) return true;
        n = board[0].length;
        for (int row = 0 ; row < m; row++) {
            for (int col = 0; col < n; col ++) {
                if (dfs(board, row, col, word, 0, hash))
                    return true;
                hash.clear();
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, int row, int col, String word, int match_count, HashMap<String, Integer> hash) {
        
        //System.out.println(row + ","+ col + "," + match_count);

        if (match_count == word.length())
            return true;
        if (row >= board.length || row < 0) return false;
        if (col >= board[0].length || col < 0) return false;
        if (board[row][col] == word.charAt(match_count)) {
            //System.out.println("->" + row + ","+ col + "," + (match_count+1));

            String str = String.valueOf(row) + "," + String.valueOf(col);
            if (hash.get(str) == null) {
                hash.put(str, 1);
                if (dfs(board, row+1, col, word, match_count+1, hash)||
                    dfs(board, row-1, col, word, match_count+1, hash) ||
                    dfs(board, row, col+1, word, match_count+1, hash) ||
                    dfs(board, row, col-1, word, match_count+1, hash) )
                    return true;
                else {
                    hash.remove(str); /*remove the key, in order to be picked again*/
                    return false;
                }
            } else {
                //System.out.println("has:" + str);
                return false;
            }
        } else
            return false;
    }
}
/*
[
"CAA",
"AAA",
"BCD"
]
"AAB"

[
"ABCE",
"SFES",
"ADEE"
]
"ABCESEEEFS"
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        /*
        DFS, avoid duplicated cell, it cannot go back to the same letter
        we can use hasmap, but hashmap needs to be clear and remove
        we can also use XOR to mask the value temporarily
	no additional space
        87 / 87 test cases passed.
Status: Accepted
Runtime: 109 ms
12.79%
        */
        int m = board.length;
        int n;
        //System.out.println("====");

        if (m == 0) return false;
        if (word.length() == 0) return true;
        n = board[0].length;
        for (int row = 0 ; row < m; row++) {
            for (int col = 0; col < n; col ++) {
                if (dfs(board, row, col, word, 0))
                    return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, int row, int col, String word, int match_count) {
        

        if (match_count == word.length())
            return true;
        if (row >= board.length || row < 0) return false;
        if (col >= board[0].length || col < 0) return false;
        if (board[row][col] == word.charAt(match_count)) {
            //System.out.println("->" + row + ","+ col + "," + (match_count+1));

            String str = String.valueOf(row) + "," + String.valueOf(col);
     
                board[row][col] ^= 256; //pick this slot
                if (dfs(board, row+1, col, word, match_count+1)||
                    dfs(board, row-1, col, word, match_count+1) ||
                    dfs(board, row, col+1, word, match_count+1) ||
                    dfs(board, row, col-1, word, match_count+1) )
                    return true;
                else {
                    board[row][col] ^= 256; //remove the pickup
                    return false;
                }

        } else
            return false;
    }
}

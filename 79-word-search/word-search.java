class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;


        // Early exit
        if (board == null || board.length == 0 || word.length() == 0) return false;
        if (word.length() > board.length * board[0].length) return false;


        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == word.charAt(0) && helper(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }


    private boolean helper(char[][] board, String word, int i, int j, int index){

        // Base Case
        if(index == word.length()){
            return true;
        }

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)){
            return false;
        }

        // Temporary mark cell as visited
        char temp = board[i][j];
        board[i][j] = '*' ;

        // Explore 4 directions
        boolean found = helper(board, word, i+1, j, index+1) ||
                        helper(board, word, i-1, j, index+1) ||
                        helper(board, word, i, j+1, index+1) ||
                        helper(board, word, i, j-1, index+1);


        board[i][j] = temp;

        return found;
    }
}
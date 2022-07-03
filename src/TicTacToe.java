public class TicTacToe {
    private final int[][] board;
    private final int n;
    private final int[] rowSum;
    private final int[] colSum;
    private int diagSum, antiDiagSum;
    private int winner;

    public TicTacToe(final int n) {
        this.n = n;
        board = new int[n][n];
        rowSum = new int[n];
        colSum = new int[n];
    }

    /**
     * Makes a move on board and returns the winner if move
     * is a winning move.
     * 
     * @param player is either 1 or 2
     * @param row    is the move's row index
     * @param col    is the move's column index
     * @return +1 if first player wins,
     *         -1 if second player wins,
     *         0 if no one wins,
     * @throw IllegalArgumentException if the move is illegal
     */

    // display move on board
    public void displayBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((board[i][j] == 1) ? "O" + " " : "X" + " ");
            }
            System.out.println();
        }
    }

    public void move(int player, int row, int col) throws IllegalArgumentException {

        // Check if the move is legal
        if (row < 0 || col < 0 || row >= board.length || col >= board.length) {
            throw new IllegalArgumentException("Move out of boundary");
        } else if (board[row][col] != 0) {
            throw new IllegalArgumentException("Move already made");
        } else if (player != 1 && player != 2) {
            throw new IllegalArgumentException("Player must be 0 or 1");
        } else {
            player = player == 1 ? 1 : -1;
            board[row][col] = player;
            rowSum[row] += player;
            colSum[col] += player;
            if (row == col) {
                diagSum += player;
            }
            if (row == n - col - 1) {
                antiDiagSum += player;
            }
            if (rowSum[row] == Math.abs(n) || colSum[col] == Math.abs(n) || diagSum == Math.abs(n)
                    || antiDiagSum == Math.abs(n)) {
                winner = player == 1 ? 1 : 2;
            }
        }
    }

    public int getWinner() {
        return winner;
    }

    public int[][] getBoard() {
        return board;
    }

    public static void main(String[] args) {
        System.out.println("Player 1: O");
        System.out.println("Player 2: X");
        TicTacToe ticTacToe = new TicTacToe(3);
        ticTacToe.move(1, 0, 0);
        ticTacToe.move(2, 0, 1);
        ticTacToe.move(1, 0, 2);
        ticTacToe.move(2, 1, 0);
        ticTacToe.move(1, 1, 1);
        ticTacToe.move(2, 1, 2);
        ticTacToe.move(1, 2, 0);
        ticTacToe.move(2, 2, 1);
        ticTacToe.move(1, 2, 2);
        ticTacToe.displayBoard();
        System.out.println("Winner is Player : " + ticTacToe.getWinner());
    }
}

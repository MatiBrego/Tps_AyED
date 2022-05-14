import java.util.Arrays;
public class SudokuSolver {

    public static int[][] sudoku = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}


    };

    // look for blank space
    public static int[] searchBlankSpace() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) {
                    int[] coordinates = {i, j};
                    return coordinates;
                }
            }
        }
        int[] coordinates = {-1};
        return coordinates;
    }

    public static boolean checkRow(int n, int rowNum) {
        for (int j = 0; j < 9; j++) {
            if (sudoku[rowNum][j] == n) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkColumn(int n, int columnNum) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][columnNum] == n) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkSquare(int[] coordinates, int n) {
        // Declaro un max y un min para la row y la column
        int minRow = 0;
        int maxRow = 0;
        int minCol = 0;
        int maxCol = 0;

        // Busco entre qué valores del cuadrado está la coordinate
        if (coordinates[0] < 3) {
            minRow = 0;
            maxRow = 2;
        } else if (coordinates[0] >= 3 && coordinates[0] < 6) {
            minRow = 3;
            maxRow = 5;
        } else if (coordinates[0] >= 6 && coordinates[0] < 9) {
            minRow = 6;
            maxRow = 8;

        }

        if (coordinates[1] < 3) {
            minCol = 0;
            maxCol = 2;
        } else if (coordinates[1] >= 3 && coordinates[1] < 6) {
            minCol = 3;
            maxCol = 5;
        } else if (coordinates[1] >= 6 && coordinates[1] < 9) {
            minCol = 6;
            maxCol = 8;
        }

        //
        for (int i = minRow; i <= maxRow; i++) {
            for (int j = minCol; j <= maxCol; j++) {
                if (sudoku[i][j] == n) {
                    return false;
                }
            }
        }
        return true;
    }

    // check if valid ( row , column n cell)
    public static boolean isValid(int[] coordinates, int n) {
        if(checkRow(n, coordinates[0])){
            if(checkColumn(n, coordinates[1])){
                return checkSquare(coordinates, n);
            }}
                return false;

    }

    // solve recursive backtracking
    public static boolean solve() {
        int[] currPos = searchBlankSpace();
        if(currPos[0]==-1){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(sudoku[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        }
        for (int i = 1; i <= 9; i++) {
            if (isValid(currPos, i)) {
                sudoku[currPos[0]][currPos[1]] = i;
                if (solve()) {
                    return true;
                }
            }
        }
        sudoku[currPos[0]][currPos[1]] = 0;
        return false;
    }
}

public class GFG {
    // Rows and columns in the given grid
    static int R, C;

    // For searching in all 8 direction
    static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

    // This function searches in all
    // 8-direction from point
    // (row, col) in grid[][]
    static boolean search2D(char[][] grid, int row,
                            int col, String word)
    {
        // If first character of word
        // doesn't match with
        // given starting point in grid.
        if (grid[row][col] != word.charAt(0))
            return false;

        int len = word.length();

        // Search word in all 8 directions
        // starting from (row, col)
        for (int dir = 0; dir < 8; dir++) {
            // Initialize starting point
            // for current direction
            int k, rd = row + x[dir], cd = col + y[dir];

            // First character is already checked,
            // match remaining characters
            for (k = 1; k < len; k++) {
                // If out of bound break
                if (rd >= R || rd < 0 || cd >= C || cd < 0)
                    break;

                // If not matched, break
                if (grid[rd][cd] != word.charAt(k))
                    break;

                // Moving in particular direction
                rd += x[dir];
                cd += y[dir];
            }

            // If all character matched,
            // then value of must
            // be equal to length of word
            if (k == len)
                return true;
        }
        return false;
    }

    // Searches given word in a given
    // matrix in all 8 directions
    static void patternSearch(
            char[][] grid,
            String word)
    {
        // Consider every point as starting
        // point and search given word
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (grid[row][col]==word.charAt(0)  &&
                        search2D(grid, row, col, word))
                    System.out.println(
                            "pattern found at " + row + ", " + col);
            }
        }
    }

    // Driver code
    public static void main(String args[])
    {
        R = 45;
        C = 45;
        char[][] grid = {
                {'A', 'D', 'M', 'I', 'R', 'E', 'D', 'F', 'G', 'N', 'I', 'L', 'L', 'O', 'R', 'Z', 'R', 'Q', 'E', 'A', 'C', 'A', 'S', 'U', 'O', 'V', 'R', 'E', 'N', 'J', 'L', 'W', 'F', 'S', 'E', 'V', 'E', 'R', 'A', 'L', 'Y', 'Y', 'N', 'V', 'R'},
                {'G', 'Y', 'D', 'O', 'T', 'S', 'U', 'C', 'O', 'R', 'P', 'F', 'Y', 'L', 'H', 'T', 'O', 'O', 'M', 'S', 'V', 'C', 'C', 'Y', 'L', 'F', 'R', 'E', 'T', 'T', 'U', 'B', 'P', 'U', 'W', 'T', 'W', 'E', 'L', 'C', 'O', 'M', 'E', 'M', 'I'},
                {'E', 'E', 'V', 'E', 'N', 'I', 'N', 'G', 'C', 'S', 'U', 'Z', 'N', 'L', 'E', 'R', 'U', 'T', 'X', 'I', 'M', 'C', 'V', 'I', 'J', 'H', 'N', 'X', 'U', 'S', 'U', 'R', 'P', 'A', 'T', 'E', 'D', 'G', 'N', 'I', 'L', 'L', 'I', 'H', 'S'},
                {'N', 'C', 'L', 'A', 'P', 'P', 'E', 'D', 'C', 'E', 'F', 'T', 'X', 'W', 'U', 'E', 'C', 'N', 'A', 'T', 'P', 'E', 'R', 'A', 'P', 'P', 'R', 'O', 'A', 'C', 'H', 'R', 'U', 'E', 'I', 'R', 'E', 'D', 'O', 'P', 'H', 'P', 'H', 'Y', 'M'},
                {'T', 'M', 'D', 'K', 'W', 'Y', 'O', 'R', 'A', 'S', 'F', 'M', 'R', 'E', 'L', 'L', 'A', 'M', 'S', 'Y', 'H', 'B', 'U', 'Z', 'G', 'G', 'H', 'G', 'V', 'V', 'I', 'E', 'F', 'Z', 'O', 'R', 'R', 'N', 'L', 'C', 'B', 'T' ,'J', 'L', 'S'},
                {'L', 'Y', 'A', 'M', 'F', 'M', 'O', 'E', 'S', 'C', 'I', 'P', 'Y', 'R', 'E', 'T', 'C', 'A', 'R', 'A', 'H', 'C', 'E', 'A', 'N', 'N', 'G', 'D', 'B', 'B', 'N', 'T', 'C', 'W', 'N', 'I', 'E', 'T', 'X', 'U', 'B', 'U', 'C', 'G', 'Q'},
                {'E', 'P', 'H', 'Z', 'O', 'J', 'O', 'M', 'I', 'A', 'N', 'X', 'A', 'G', 'N', 'I', 'R', 'A', 'L', 'G', 'E', 'D', 'R', 'S', 'I', 'I', 'N', 'Z', 'X', 'B', 'G', 'S', 'Q', 'M', 'D', 'B', 'E', 'I', 'Z', 'R', 'O', 'I', 'O', 'N', 'U'},
                {'M', 'A', 'G', 'P', 'O', 'A', 'P', 'A', 'O', 'R', 'G', 'T', 'R', 'A', 'V', 'E', 'L', 'E', 'D', 'O', 'E', 'W', 'L', 'C', 'T', 'L', 'W', 'J', 'E', 'E', 'I', 'O', 'L', 'V', 'H', 'L', 'H', 'G', 'O', 'I', 'C', 'D', 'U', 'I', 'C'},
                {'A', 'D', 'N', 'W', 'A', 'O', 'Z', 'I', 'N', 'C', 'E', 'V', 'O', 'R', 'P', 'M', 'I', 'D', 'B', 'S', 'S', 'Q', 'R', 'Y', 'R', 'L', 'D', 'T', 'D', 'L', 'C', 'O', 'R', 'W', 'Q', 'E', 'C', 'I', 'N', 'O', 'O', 'E', 'N', 'S', 'Q'},
                {'N', 'O', 'I', 'N', 'X', 'R', 'I', 'N', 'A', 'E', 'O', 'I', 'R', 'A', 'O', 'R', 'P', 'U', 'R', 'U', 'I', 'H', 'E', 'F', 'A', 'I', 'F', 'W', 'E', 'E', 'B', 'R', 'E', 'L', 'B', 'M', 'U', 'R', 'G', 'U', 'O', 'R', 'T', 'S', 'G'},
                {'K', 'O', 'L', 'I', 'D', 'S', 'G', 'S', 'L', 'L', 'U', 'E', 'K', 'A', 'T', 'S', 'I', 'M', 'E', 'O', 'R', 'L', 'H', 'M', 'T', 'K', 'G', 'R', 'N', 'L', 'V', 'I', 'F', 'Z', 'F', 'B', 'B', 'P', 'T', 'S', 'K', 'U', 'R', 'A', 'N'},
                {'J', 'R', 'I', 'A', 'E', 'O', 'K', 'O', 'J', 'Y', 'S', 'H', 'E', 'L', 'P', 'L', 'E', 'S', 'V', 'I', 'P', 'S', 'T', 'E', 'S', 'J', 'P', 'N', 'E', 'N', 'T', 'E', 'S', 'U', 'Z', 'V', 'A', 'R', 'M', 'E', 'I', 'S', 'Y', 'R', 'I'},
                {'N', 'W', 'M', 'T', 'S', 'M', 'K', 'X', 'E', 'L', 'L', 'S', 'A', 'J', 'Z', 'C', 'A', 'S', 'O', 'R', 'R', 'Z', 'O', 'D', 'W', 'S', 'B', 'L', 'I', 'W', 'G', 'S', 'I', 'I', 'C', 'F', 'R', 'O', 'I', 'L', 'N', 'A', 'C', 'R', 'N'},
                {'C', 'A', 'S', 'R', 'E', 'E', 'T', 'J', 'Z', 'G', 'Y', 'L', 'A', 'F', 'M', 'S', 'N', 'L', 'R', 'E', 'U', 'T', 'R', 'I', 'H', 'T', 'Y', 'U', 'A', 'H', 'U', 'N', 'I', 'L', 'V', 'G', 'K', 'C', 'L', 'B', 'G', 'E', 'L', 'A', 'W'},
                {'R', 'Y', 'F', 'U', 'R', 'B', 'S', 'P', 'E', 'N', 'J', 'O', 'Y', 'M', 'E', 'N', 'T', 'Y', 'P', 'S', 'S', 'E', 'B', 'C', 'T', 'W', 'F', 'L', 'T', 'D', 'S', 'Q', 'I', 'H', 'E', 'G', 'I', 'E', 'I', 'A', 'T', 'M', 'S', 'B', 'O'},
                {'D', 'A', 'W', 'C', 'V', 'O', 'N', 'R', 'T', 'R', 'U', 'M', 'P', 'E', 'T', 'E', 'W', 'J', 'Y', 'Q', 'Z', 'N', 'W', 'I', 'E', 'L', 'A', 'L', 'E', 'E', 'G', 'A', 'D', 'S', 'T', 'R', 'N', 'E', 'T', 'N', 'H', 'M', 'N', 'M', 'R'},
                {'F', 'X', 'I', 'J', 'E', 'D', 'I', 'I', 'Y', 'I', 'G', 'N', 'I', 'D', 'L', 'O', 'H', 'E', 'S', 'I', 'S', 'D', 'O', 'N', 'I', 'K', 'S', 'A', 'M', 'N', 'N', 'P', 'R', 'I', 'O', 'O', 'G', 'D', 'A', 'O', 'G', 'K', 'F', 'E', 'F'},
                {'L', 'A', 'T', 'L', 'D', 'Y', 'A', 'S', 'L', 'T', 'S', 'A', 'C', 'N', 'W', 'O', 'D', 'X', 'T', 'N', 'R', 'E', 'H', 'E', 'T', 'R', 'H', 'B', 'O', 'R', 'I', 'I', 'H', 'H', 'S', 'O', 'C', 'A', 'R', 'S', 'I', 'C', 'A', 'B', 'Y'},
                {'O', 'N', 'N', 'V', 'W', 'N', 'G', 'O', 'T', 'O', 'L', 'A', 'T', 'I', 'P', 'S', 'O', 'H', 'R', 'C', 'E', 'R', 'E', 'D', 'N', 'U', 'I', 'Y', 'S', 'U', 'G', 'N', 'F', 'U', 'T', 'T', 'H', 'L', 'Y', 'A', 'N', 'I', 'R', 'G', 'Y'},
                {'A', 'G', 'E', 'P', 'R', 'A', 'A', 'N', 'H', 'Y', 'O', 'B', 'E', 'D', 'I', 'E', 'N', 'T', 'O', 'O', 'T', 'L', 'M', 'R', 'E', 'N', 'O', 'S', 'E', 'T', 'G', 'E', 'W', 'N', 'P', 'J', 'A', 'C', 'P', 'E', 'R', 'W', 'E', 'A', 'L'},
                {'T', 'R', 'L', 'O', 'G', 'P', 'Y', 'E', 'G', 'F', 'S', 'C', 'O', 'N', 'S', 'I', 'D', 'E', 'K', 'U', 'R', 'Y', 'O', 'E', 'W', 'A', 'N', 'Y', 'R', 'E', 'A', 'A', 'A', 'C', 'G', 'U', 'L', 'N', 'M', 'R', 'E', 'P', 'W', 'I', 'B'},
                {'I', 'I', 'O', 'R', 'B', 'Q', 'A', 'R', 'I', 'S', 'I', 'L', 'B', 'T', 'A', 'U', 'S', 'R', 'I', 'N', 'A', 'N', 'S', 'A', 'T', 'W', 'P', 'L', 'I', 'R', 'R', 'P', 'S', 'O', 'K', 'S', 'C', 'K', 'C', 'M', 'V', 'M', 'E', 'N', 'I'},
                {'N', 'L', 'I', 'P', 'F', 'F', 'K', 'C', 'R', 'W', 'D', 'J', 'N', 'A', 'T', 'Y', 'P', 'E', 'N', 'T', 'U', 'T', 'N', 'D', 'K', 'A', 'T', 'R', 'T', 'Y', 'B', 'P', 'H', 'M', 'U', 'S', 'C', 'E', 'Y', 'E', 'O', 'A', 'L', 'I', 'S'},
                {'G', 'Y', 'V', 'O', 'D', 'M', 'K', 'O', 'R', 'F', 'U', 'R', 'I', 'O', 'U', 'S', 'N', 'D', 'G', 'I', 'Q', 'S', 'M', 'F', 'F', 'Y', 'N', 'A', 'E', 'L', 'D', 'L', 'I', 'F', 'N', 'E', 'G', 'X', 'A', 'E', 'I', 'L', 'L', 'N', 'N'},
                {'D', 'E', 'D', 'I', 'R', 'Q', 'U', 'A', 'R', 'R', 'E', 'L', 'B', 'L', 'E', 'S', 'S', 'E', 'D', 'N', 'B', 'O', 'G', 'U', 'L', 'A', 'O', 'I', 'T', 'T', 'N', 'E', 'N', 'O', 'D', 'L', 'S', 'P', 'E', 'R', 'I', 'N', 'G', 'G', 'E'},
                {'S', 'P', 'E', 'S', 'I', 'L', 'K', 'B', 'T', 'J', 'E', 'N', 'O', 'R', 'M', 'O', 'U', 'S', 'Z', 'G', 'O', 'M', 'A', 'L', 'E', 'M', 'N', 'L', 'E', 'H', 'A', 'X', 'G', 'R', 'E', 'D', 'I', 'T', 'R', 'E', 'M', 'E', 'N', 'D', 'S'},
                {'B', 'B', 'T', 'E', 'B', 'U', 'S', 'U', 'D', 'D', 'E', 'N', 'L', 'Y', 'S', 'W', 'A', 'L', 'L', 'O', 'W', 'N', 'C', 'L', 'S', 'M', 'S', 'I', 'R', 'G', 'T', 'U', 'U', 'T', 'R', 'E', 'H', 'P', 'S', 'R', 'Y', 'R', 'O', 'O', 'T'},
                {'S', 'N', 'S', 'T', 'K', 'F', 'O', 'Q', 'H', 'N', 'D', 'I', 'N', 'T', 'E', 'R', 'R', 'U', 'P', 'T', 'I', 'N', 'G', 'Y', 'R', 'N', 'E', 'M', 'N', 'I', 'S', 'Y', 'M', 'A', 'S', 'E', 'W', 'D', 'R', 'S', 'L', 'X', 'B', 'U', 'H'},
                {'H', 'S', 'E', 'V', 'C', 'D', 'A', 'B', 'A', 'N', 'D', 'O', 'N', 'E', 'D', 'R', 'E', 'M', 'E', 'M', 'B', 'E', 'R', 'E', 'E', 'V', 'N', 'A', 'A', 'L', 'H', 'F', 'U', 'B', 'T', 'H', 'S', 'E', 'E', 'C', 'T', 'P', 'E', 'S', 'R'},
                {'A', 'Q', 'G', 'A', 'A', 'A', 'S', 'A', 'T', 'R', 'O', 'F', 'M', 'O', 'C', 'T', 'G', 'M', 'U', 'P', 'B', 'M', 'Y', 'S', 'H', 'X', 'S', 'F', 'L', 'S', 'T', 'P', 'K', 'L', 'O', 'T', 'I', 'R', 'S', 'P', 'N', 'P', 'R', 'V', 'O'},
                {'R', 'U', 'I', 'D', 'L', 'E', 'S', 'B', 'B', 'H', 'A', 'D', 'V', 'I', 'S', 'A', 'B', 'L', 'E', 'A', 'K', 'H', 'O', 'D', 'T', 'R', 'E', 'P', 'Y', 'E', 'I', 'O', 'H', 'Y', 'O', 'M', 'L', 'E', 'O', 'E', 'A', 'S', 'U', 'Z', 'W'},
                {'P', 'I', 'D', 'H', 'B', 'R', 'E', 'L', 'M', 'E', 'C', 'N', 'E', 'U', 'L', 'F', 'N', 'I', 'P', 'T', 'E', 'T', 'C', 'C', 'H', 'A', 'S', 'I', 'N', 'G', 'W', 'U', 'G', 'E', 'D', 'F', 'E', 'T', 'U', 'R', 'H', 'T', 'T', 'F', 'I'},
                {'L', 'R', 'E', 'H', 'T', 'D', 'L', 'E', 'R', 'S', 'Y', 'L', 'L', 'U', 'F', 'I', 'T', 'I', 'P', 'R', 'D', 'G', 'S', 'T', 'B', 'V', 'O', 'C', 'J', 'S', 'D', 'R', 'I', 'N', 'N', 'O', 'N', 'T', 'R', 'F', 'P', 'U', 'N', 'P', 'N'},
                {'Y', 'R', 'U', 'S', 'A', 'T', 'E', 'H', 'T', 'R', 'E', 'V', 'E', 'N', 'V', 'F', 'D', 'C', 'N', 'I', 'R', 'E', 'A', 'H', 'E', 'Q', 'Y', 'O', 'N', 'H', 'E', 'I', 'F', 'D', 'I', 'Y', 'C', 'U', 'C', 'E', 'M', 'B', 'E', 'C', 'G'},
                {'I', 'E', 'X', 'W', 'O', 'U', 'K', 'N', 'O', 'B', 'I', 'R', 'E', 'D', 'N', 'E', 'L', 'S', 'U', 'O', 'W', 'E', 'S', 'R', 'A', 'R', 'H', 'I', 'P', 'I', 'D', 'N', 'E', 'G', 'G', 'R', 'E', 'B', 'E', 'C', 'U', 'B', 'V', 'O', 'Z'},
                {'M', 'L', 'Y', 'I', 'C', 'O', 'H', 'X', 'Z', 'P', 'O', 'V', 'E', 'R', 'T', 'Y', 'Z', 'B', 'H', 'T', 'Y', 'A', 'T', 'C', 'U', 'K', 'T', 'E', 'G', 'F', 'L', 'G', 'A', 'Z', 'U', 'T', 'E', 'I', 'E', 'T', 'I', 'O', 'E', 'N', 'M'},
                {'P', 'K', 'L', 'M', 'T', 'K', 'Y', 'S', 'U', 'O', 'U', 'T', 'P', 'M', 'E', 'T', 'N', 'O', 'C', 'I', 'R', 'L', 'Z', 'R', 'R', 'O', 'I', 'S', 'N', 'T', 'O', 'B', 'T', 'S', 'E', 'E', 'B', 'D', 'Q', 'M', 'R', 'R', 'Z', 'F', 'Z'},
                {'U', 'G', 'E', 'M', 'S', 'O', 'L', 'C', 'U', 'T', 'X', 'O', 'E', 'R', 'K', 'A', 'V', 'A', 'Q', 'C', 'B', 'U', 'D', 'H', 'A', 'I', 'C', 'N', 'M', 'I', 'F', 'V', 'H', 'S', 'U', 'R', 'K', 'L', 'N', 'X', 'T', 'N', 'E', 'U', 'G'},
                {'D', 'N', 'M', 'I', 'I', 'O', 'E', 'Q', 'G', 'W', 'L', 'C', 'R', 'T', 'R', 'E', 'M', 'U', 'L', 'O', 'U', 'S', 'B', 'E', 'K', 'U', 'B', 'T', 'G', 'N', 'N', 'F', 'E', 'U', 'X', 'O', 'U', 'H', 'O', 'O', 'U', 'W', 'E', 'S', 'N'},
                {'E', 'I', 'O', 'N', 'A', 'L', 'T', 'E', 'L', 'P', 'M', 'O', 'C', 'D', 'Z', 'E', 'X', 'E', 'C', 'U', 'T', 'I', 'O', 'B', 'X', 'Q', 'Q', 'E', 'K', 'G', 'U', 'O', 'R', 'S', 'D', 'E', 'E', 'N', 'U', 'W', 'W', 'G', 'U', 'I', 'I'},
                {'N', 'R', 'S', 'G', 'W', 'R', 'E', 'K', 'C', 'I', 'P', 'G', 'A', 'R', 'E', 'R', 'A', 'M', 'M', 'A', 'R', 'G', 'N', 'E', 'I', 'I', 'C', 'L', 'I', 'Z', 'A', 'T', 'I', 'O', 'N', 'P', 'O', 'T', 'N', 'N', 'I', 'G', 'Q', 'O', 'P'},
                {'C', 'A', 'D', 'R', 'E', 'R', 'E', 'F', 'F', 'U', 'S', 'K', 'B', 'V', 'Q', 'R', 'U', 'B', 'K', 'S', 'M', 'O', 'E', 'J', 'N', 'N', 'F', 'I', 'V', 'D', 'E', 'H', 'S', 'I', 'N', 'R', 'U', 'F', 'I', 'I', 'D', 'N', 'S', 'N', 'P'},
                {'E', 'E', 'N', 'M', 'H', 'X', 'F', 'G', 'N', 'I', 'M', 'O', 'C', 'E', 'B', 'J', 'E', 'V', 'S', 'U', 'B', 'H', 'R', 'P', 'X', 'Z', 'G', 'V', 'R', 'T', 'D', 'G', 'N', 'I', 'H', 'S', 'I', 'W', 'G', 'P', 'N', 'R', 'G', 'U', 'I'},
                {'Z', 'T', 'A', 'J', 'I', 'D', 'E', 'R', 'E', 'W', 'O', 'L', 'F', 'C', 'W', 'B', 'Q', 'D', 'A', 'R', 'F', 'I', 'F', 'T', 'E', 'E', 'N', 'I', 'Z', 'H', 'E', 'A', 'R', 'T', 'H', 'R', 'U', 'G', 'Y', 'M', 'M', 'G', 'E', 'K', 'R'},
                {'N', 'L', 'H', 'S', 'D', 'C', 'H', 'Y', 'Z', 'X', 'E', 'T', 'A', 'M', 'S', 'S', 'A', 'L', 'C', 'R', 'O', 'U', 'N', 'D', 'E', 'D', 'S', 'C', 'A', 'P', 'P', 'L', 'A', 'U', 'S', 'E', 'T', 'W', 'E', 'L', 'F', 'T', 'H', 'D', 'D'}

        };
        patternSearch(grid, "CIVILIZATION");
        System.out.println();
        patternSearch(grid, "INTERRUPTING");
    }
}

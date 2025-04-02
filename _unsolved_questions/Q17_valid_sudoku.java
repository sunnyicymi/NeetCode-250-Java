import java.util.HashSet;

class Q17_valid_sudoku {

  public static void main(String[] args) {}

  static boolean s1_solution(char[][] board) {
    int N = 9;

    HashSet<Character>[] rows = new HashSet[N];
    HashSet<Character>[] cols = new HashSet[N];
    HashSet<Character>[] boxes = new HashSet[N];

    // Initialize HashSets
    for (int i = 0; i < N; i++) {
      rows[i] = new HashSet<>();
      cols[i] = new HashSet<>();
      boxes[i] = new HashSet<>();
    }

    // Iterate through the board
    for (int r = 0; r < N; r++) {
      for (int c = 0; c < N; c++) {
        char val = board[r][c];

        // Ignore empty cells (should be '.')
        if (val == '.') continue;

        // Check if the value is already in the row
        if (rows[r].contains(val)) return false;
        rows[r].add(val);

        // Check if the value is already in the column
        if (cols[c].contains(val)) return false;
        cols[c].add(val);

        // Calculate correct 3x3 box index
        int boxIndex = (r / 3) * 3 + (c / 3);
        if (boxes[boxIndex].contains(val)) return false;
        boxes[boxIndex].add(val);
      }
    }

    return true;
  }
}
/*
 * [MEDIUM] 36. Valid Sudoku, determine if 9X9 sudoku is valid, only filled
 * cells need to be validated with rules as
 * 1. each row must contain 1 - 9 without repeatation
 * 2. each col must contain 1 - 9 without repeatation
 * 3. each of 9, 3x3 sub-boxes of grid must contain digit 1 - 9
 *
 * -> we do not have to solve the sudoku we just have to validate the already
 * filled values;
 *
 * solution 1 = first check row then col then tricky is 3x3 box check for any duplication
 * we can use HashSet with 9 cell for value and occurance. if value present then return false else add the value in the set.
 *
 * 9 column = 9 hashSet for different process but core concept is same
 *
 * for box is like matrix the logic is same no duplicate, to select the appropriate box 1/3 = 0 as flooor value, so 0/3 or 1/3 or 2/3 = 0 th first box
 * correct element box number = row/3 + 3 + col/3 is the hashSet number to check
 * total = 27 hashSet.
 * TC = N^2 for row and col
 * SC = 3N = N = box number which is equal to 1 constant so we are good.
 *
 *
 *
 *
 */

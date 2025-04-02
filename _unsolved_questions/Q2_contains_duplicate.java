import java.util.HashMap;
import java.util.HashSet;

class Q2_contains_duplicate {

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4, 5 };

    // boolean ans = s1_solution(nums);
    // System.out.println(ans);

    boolean ans2 = s2_solution(nums);
    System.out.println(ans2);
  }

  static boolean s1_solution(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (nums[i] == nums[j]) {
          return true;
        }
      }
    }
    return false;
  }

  static boolean s2_solution(int[] nums) {
    HashSet<Integer> seenNums = new HashSet<>();

    for (int num : nums) {
      if (seenNums.contains(num)) {
        return true;
      }
      seenNums.add(num);
    }
    return false;
  }
}
/*
[EASY] 127. question: given an array return true if any value appear twice else return false
example nums = [1, 2, 3, 5]; here noelement appears twice return false;
example2 nums = [1, 2, 3, 4, 3]; here 3 appears twice return true then. simple

1. Take first value check all the next values using 2 for loops.
TC = O(N^2) -> s1_solution

2. sort the values and then we just have to check the advacent values,
- but even sorting takes O(nLogn) TC for bubbleSort

3. Using HashSet, which only store the unique values, if value in set means duplicate else add value in set
TC = O(n)+O(1) = O(n) 
SC = O(n) for new hashSet

 * 
 */

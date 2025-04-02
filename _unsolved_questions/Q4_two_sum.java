import java.util.Arrays;
import java.util.HashMap;

class Q4_two_sum {

  public static void main(String[] args) {
    int[] nums = { 11, 7, 15, 2 };
    int target = 9;
    // int[] ans = s1_solution(nums, target);
    // System.out.println(Arrays.toString(ans));

    // int[] ans2 = s2_solution(nums, target);
    // System.out.println(Arrays.toString(ans2));

    int[] ans3 = s3_solution(nums, target);
    System.out.println(Arrays.toString(ans3));
  }

  static int[] s1_solution(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) return new int[] { i, j };
      }
    }

    return new int[] { -1, -1 };
  }

  static int[] s2_solution(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      int compliment = target - nums[i];

      // now check if matching
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] == compliment) return new int[] { i, j };
      }
    }

    return new int[] { -1, -1 };
  }

  static int[] s3_solution(int[] nums, int target) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int compliment = target - nums[i];
      // if key count with complement return indices
      if (hashMap.containsKey(compliment)) {
        return new int[] { hashMap.get(compliment), i };
      }

      // otherwise put current number to map
      hashMap.put(nums[i], i);
    }

    return new int[] { -1, -1 };
  }
}
/*
 * [EASY] Q1: Two Sum, in given array nums a target is given, return indices of the values which the sum equal to target else return [-1, -1]
 * example nums = [2,7,11,15], target = 9, Output: [0,1]
 * nums = [3,2,4], target = 6, Output: [1,2]
 *
 * 1. do for loop first loop from 0 and 2nd loop from i + 1 and add both if equal to target return i and j else return -1, -1 TC = O(N^2);
 *
 * 2. do sorting which makes solution better than first
 * example after sorting, 2 7 11 13 target = 9 so 9 - 2 = 7 also we do not have to go beyond the target. which makes solution but not in worst case sceneroo TC = O(N^2)
 *
 * 3. making searching better on sorted array we can use binary search with better TC = O(nlogN) n for for loop and N for numbers
 *
 *
 * 4. better solution, we have to keep track of reminder is available? use HashMap
 * - here iterate and store all the reminder in first for loop
 * - on second time if reminded found means answer found
 * - key = value, and value = index
 * - TC = O(n) for loop SC = O(n)
 */

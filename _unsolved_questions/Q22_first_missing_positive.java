import java.util.Arrays;
import java.util.HashSet;

class Q22_first_missing_positive {

  public static void main(String[] args) {
    int[] nums = { 3, 4, -1, 1 };

    // int ans1 = s1_solution(nums);
    // System.out.println(ans1);
    // int ans2 = s2_solution(nums);
    // System.out.println(ans2);
    int ans3 = s3_solution(nums);
    System.out.println(ans3);
  }

  static int s1_solution(int[] nums) {
    Arrays.sort(nums);
    int smallest = 1;

    System.out.println(Arrays.toString(nums));

    for (int num : nums) {
      if (num == smallest) {
        smallest++;
      }
    }

    return smallest;
  }

  static int s2_solution(int[] nums) {
    HashSet<Integer> hashSet = new HashSet<>();

    // store all +ve number in hashSet
    for (int num : nums) {
      if (num > 0) {
        hashSet.add(num);
      }
    }

    // find first missing +ve number
    int smallest = 1;
    while (hashSet.contains(smallest)) {
      smallest++;
    }

    return smallest;
  }

  static int s3_solution(int[] nums) {
    int N = nums.length;

    // place number in their correct position index based
    for (int i = 0; i < N; i++) {
        while (nums[i] > 0 && nums[i] <= N && nums[i] != nums[nums[i] - 1]) {
            // swap
            int temp = nums[i];
            nums[i] = nums[temp - 1];
            nums[temp - 1] = temp;
        }
    }

    System.out.println(Arrays.toString(nums));
    
    for (int i = 0; i < N; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }

    // If all numbers are in place, return n + 1
    return N + 1;
  }
}
/*
 * [HARD] Q41. given an unsorted integer array nums, return the smallest positive integer that is "not" present in nums
 *
 * nums= [1,2,0]
 * ans = 3 which makes 0, 1, 2, 3
 * nums = [3,4,-1,1]
 * ans = 2 smallest +ve = 1 which is there then 2, it is not there hence ans = 2
 * nums = [7,8,9,11,12]
 * ans = 1 smallest +ve number
 *
 * 1. sort the array, assume smallest if 1, and check if the sorted element equals to smallest, if equals then count++ else skip
 * TC = nLogn because of sorting.
 *
 * 2. better then sorting we can use hashSet, to store all +ve numbers, then iterate from start and find first missing positive number.
 *
 */

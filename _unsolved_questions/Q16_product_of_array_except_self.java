import java.util.Arrays;

class Q16_product_of_array_except_self {

  public static void main(String[] args) {
    int[] nums = { 1, 2, 4, 5 };

    // int[] ans1 = s1_solution(nums);
    // System.out.println(Arrays.toString(ans1));

    int[] ans2 = s2_solution(nums);
    System.out.println(Arrays.toString(ans2));

    int[] ans3 = s3_solution(nums);
    System.out.println(Arrays.toString(ans3));
  }

  static int[] s1_solution(int[] nums) {
    int n = nums.length;

    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      int product = 1;

      for (int j = 0; j < n; j++) {
        if (i != j) {
          product = product * nums[j];
        }
      }
      result[i] = product;
    }

    return result;
  }

  static int[] s2_solution(int[] nums) {
    int n = nums.length;

    int[] result = new int[n];
    int[] prefix = new int[n];
    int[] postfix = new int[n];

    prefix[0] = 1;
    for (int i = 1; i < n; i++) {
      prefix[i] = prefix[i - 1] * nums[i - 1];
    }

    postfix[n - 1] = 1;
    for (int i = n - 2; i >= 0; i--) {
      postfix[i] = postfix[i + 1] * nums[i + 1];
    }

    for (int i = 0; i < n; i++) {
      result[i] = prefix[i] * postfix[i];
    }

    return result;
  }

  static int[] s3_solution(int[] nums) {
    int[] result = new int[nums.length];
    Arrays.fill(result, 1);

    int pre = 1, post = 1;

    for (int i = 0; i < nums.length; i++) {
      result[i] = pre;
      pre = nums[i] * pre;
    }

    for (int i = nums.length - 1; i >= 0; i--) {
      result[i] = result[i] * post;
      post = nums[i] * post;
    }

    return result;
  }
}
/*
 * [MEDIUM] Q238. Product of Array Except Self means given an array nums return new array which is product of all the elements expect self without division operator
 * nums = [1,2,4,5]
 * ans = [2x4x5, 1x4x5, 1x2x5, 1x2x4] = [40, 20, 10, 8];
 *
 * 1. for all the elements in array, inside the for loop create product and multiply it with the other element only when i != j then update result[i] with the product
 * TC = O(N^2);
 *
 * 2. take product of i to all the left elements and right element
 * prefix = product from all left elements
 * postfix = product from all right elements
 * at the end we do product of prefix and postfix and got the result
 * for the edge case use 1 as product with 1 does nothing.
 *
 * catch = left part multiply by 1 that is ok, instead of that use the before prefix values
 * ex = [1, 2, 3, 4]
 *
 * prefix = [1, 1, 1, 1]
 * postfix = [1, 1, 1, 1] // both are of same size as nums value filled with 1
 *
 * first, 1 before 1 is nothing prefix = 1
 * second, 2 before 2 is 1 hence prefix = 1
 * third, 3 beofre 3 is 2 and 1 hence prefix = 2x1 = 2
 * forth, 4 before 4 is 1, 2, 3 ence prefix = 1x2x3 = 6 but here instead of multiplying from start just multipley with the previous prefix ie 2x3 = 6 simple
 * do same for postfix
 *
 * for postfix we will start from last
 *
 * TC = O(3N) = O(N); SC = (3N) = O(N)
 *
 * 3. instead of two postfix and prefix array we can store the ans in ans array for better SC
 * TC = (2N) SC = 1 no additional space used
 */

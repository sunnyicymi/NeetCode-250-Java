/**
 * Question: 1929. Concatenation of Array
 * Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

Specifically, ans is the concatenation of two nums arrays.

Return the array ans.

    [EASY]
 * 
 * In simple words: ->
 * given array arr1 of size n
 * create another arrray arr2 of size 2*n
 * where arr2[i] = arr1[i]
 * and when i > n, arr2[i + n] = arr1[i]
 * 
 * 
 * 
-> The first n elements of ans are just nums itself → ans[i] = nums[i].
-> The next n elements of ans are also nums but starting from index n → ans[i + n] = nums[i].
For i = 0:
ans[0] = nums[0] = 1
ans[0 + 3] = nums[0] = 1 → ans[3] = 1 ✅

For i = 1:
ans[1] = nums[1] = 2
ans[1 + 3] = nums[1] = 2 → ans[4] = 2 ✅

For i = 2:
ans[2] = nums[2] = 3
ans[2 + 3] = nums[2] = 3 → ans[5] = 3 ✅

Final ans = [1, 2, 3, 1, 2, 3].
 * 
 * Input: nums = [1,2,1], nums = [1,3,2,1]
 * 
 * 
 * Output: ans = [1,2,1,1,2,1], ans = [1,3,2,1,1,3,2,1]
 * 
 */


/**
 * Solution Discussion: All should include TC and SC
 * --------------------------------------------------
 * 
 * first loop from 0 then ans[0] = nums[0] at the same time in loop ans[i + n] ie ans[0 + 3] = ans[3] = nums[i] ie nums[0] = 1
 * 
 *
 * 1. Simple Brute Force
 * - simple loop and update the value at the same time for ans[i] and ans[i + n] both = nums[i]
 * 
 * 2. Optimized Brute Force
 * - use an inbuild method called System.arraycopy()
 * 
 * 4. Best Solution
 * It is solution one
 * 
 * TC = O(n) ans SC = O(n) not 2n because 2 is already there
 */

import java.util.Arrays;

class Q1_concatenation_of_array{
    public static void main(String[] args){
        System.out.println("Que: Q1_concatenation_of_array");

        // Inputs
        int arr[] = {1,3,2,1};

        // call solution 1
        int ans[] = s1_print_my_name(arr);
        System.out.println("ans = " + Arrays.toString(ans));

        // call solution 2
        // int ans[] = s2_print_my_name(arr);
        // System.out.println("ans = " + Arrays.toString(ans));

    }

    
    // build solution 1 : Simple Brute Force
    static int[] s1_print_my_name(int[] nums) {
        
        int n = nums.length;
        int ans[] = new int[2*n];

        for(int i = 0; i < n; i++){
            
            // first half
            ans[i] = nums[i];

            // second half 
            ans[i + n] = nums[i];
        }
        
        return ans;
    }

    // build solution 2 : Optimized Brute Force
    static int[] s2_print_my_name(int[] nums) {
        
        int n = nums.length;
        int ans[] = new int[2*n];

        // System.arraycopy(sourceArray, sourceStartIndex, destinationArray, destinationStartIndex, length);
        // Faster Execution: System.arraycopy() is implemented in native code (C/C++), making it much faster than a manual loop.

        System.arraycopy(nums, 0, ans, 0, n);
        System.arraycopy(nums, 0, ans, n, n);
        
        return ans;
    }

    // build solution 4 : Best Solution is s1
   
}

/**
 * Question: Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * 
 * 
 * In simple words: -> simple
 * 
 * 
 * Input: nums = [1,2,3,1] [1,2,3,4] [1,1,1,3,3,4,3,2,4,2]
 * 
 * 
 * Output: true, false, true
 * 
 */


/**
 * Solution Discussion: All should include TC and SC
 * --------------------------------------------------
 * 1. Simple Brute Force
 * - run 2 times for loop and check if the number repeats
 * TC = O(n^2) but given constrains of the array length being up to 10^5 and not be efficient enough for large input sizes
 * 
 * 2. Optimized Brute Force
 * - sorting and linear scan
 * sorting makes the duplicate items adjustend -> bubble sort TC = O(n^2) hence not ideal for 10^5 data
 * linear scan measn just check the adjestand item.
 * 
 * 3. Unconvensional Solution
 * - it is unconvensional but TC wise best solution as TC = O(nlogn) which is better thatn O(n)
 * - using In-Place sorting + scan ie using QuickSort of MergeSort + adjacent Scan
 * 
 * 
 * 4. Best Solution
 * Using HashSet, if value exisist return true else add the value to hashset
 * TC = O(n)
 */

import java.util.HashSet;

class Q2_contains_duplicate{
    public static void main(String[] args){
        // Inputs
        int nums[] = {1,2,3,4};

        // call solution 1
        // boolean ans = s1_solution(nums);
        // System.out.println(ans);

        // call solution 2
        // boolean ans = s2_solution(nums);
        // System.out.println(ans);

        // call solution 3
        boolean ans = s4_solution(nums);
        System.out.println(ans);

        // call solution 4
        // boolean ans = s4_solution(nums);
        // System.out.println(ans);

    }

    
    // build solution 1 : Simple Brute Force
    static boolean s1_solution(int[] nums) {
        // 1,2,3,4
        int n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                // always move one step ahead of i that is why i + 1 for j
                System.out.println(nums[i] + " " + nums[j]);
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    // build solution 2 : Optimized Brute Force
    static boolean s2_solution(int[] nums){
        int n = nums.length;

        // first sorting [bubble-sort]
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - 1; j++){
                if(nums[j] > nums[j + 1]){
                    // Swap elements if they're in the wrong order
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        // second searching
        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i - 1]){
                return true;
            }
        }
        return false;
    }

    // build solution 3 : Unconvensional
    static boolean s3_solution(int[] nums){
        int n = nums.length;

        // Step 1: Sort the array (in-place)
        quickSort(nums, 0, n - 1);

        // Step 2: Check for adjacent duplicates
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;  // Found a duplicate
            }
        }

        return false;
    }

    static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    // Helper function to swap elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // build solution 4 : Best Solution
    static boolean s4_solution(int[] nums){
        // iterate array with index store the value in hashSet
        // on iterate if value exists tehn duplicate found
        // else add the value to hashSet for next iterate

        HashSet<Integer> hashSet = new HashSet<>();

        for(int num : nums){
            // if num exist already return true
            if(hashSet.contains(num)){
                return true;
            }
            // else add to the hashSet 
            hashSet.add(num);
        }
        return false;

    }
}

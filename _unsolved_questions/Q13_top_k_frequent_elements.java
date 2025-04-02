import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Q13_top_k_frequent_elements {

  public static void main(String[] args) {
    int[] nums = { 1, 1, 1, 2, 2, 3 };
    int k = 2;

    int[] ans1 = s3_solution(nums, k);
    System.out.println(Arrays.toString(ans1));
    // int[] ans2 = s3_solution(nums, k);
    // System.out.println(Arrays.toString(ans2));
  }

  static int[] s1_solution(int[] nums, int k) {
    List<int[]> freqList = new ArrayList<>();
    boolean[] visited = new boolean[nums.length];

    // iterate to all elements
    for (int i = 0; i < nums.length; i++) {
      if (visited[i]) continue; // if alread visited skip

      int count = 1; // default count for each element in nums
      // check if the element is visited or not, if not visited then increase the count and mark visited for that particular element
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] == nums[j]) {
          count++;
          visited[j] = true; // mark duplicate
        }
      }
      // add all element and its count to the freq list and continue
      freqList.add(new int[] { nums[i], count });
    }

    // now sort list by max freq
    freqList.sort((a, b) -> Integer.compare(b[1], a[1]));

    // lastly extract k times max occurance elements
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = freqList.get(i)[0];
    }

    return result;
  }

  static int[] s3_solution(int[] nums, int k) {
    if (k == nums.length) return nums; // it if only one item then return that simple

    HashMap<Integer, Integer> freqMap = new HashMap<>();

    // put values to hashMap with occurances
    for (int n : nums) {
      freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
    }

    // now pq
    Queue<Integer> heap = new PriorityQueue<>(
      // insertion based on number of occurances
      (a, b) -> freqMap.get(a) - freqMap.get(b)
    );

    // now iterate over keys, and for all key add to head, and whenever the pq full then pop the least occuring element;
    for (int n : freqMap.keySet()) {
      heap.add(n);
      if (heap.size() > k) {
        heap.poll();
      }
    }

    int[] ans = new int[k];

    for (int i = 0; i < k; i++) {
      ans[i] = heap.poll();
    }

    return ans;
  }
}
/*
 * [Medium] Q357. Top K frequent elements
 * given an integer array nums and a value k, return k most frequent elements, ie return top K element in array
 * example nums = [1,1,1,2,2,3] k = 2;
 * solution = k = 2 means return top 2 element who are most frequent in nums array
 * 1 = 3 times, 2 = 2 times, 3 = 1 time hence top 2 most freuqnet elements are 1 and 2
 * ans = [1, 2]
 *
 * 1. solution use hashMap and return the items in the requested times + heap (Priority Queue)
 * - iterate for entire array and then store in the list
 * - iterate in the list and return the values
 * - to find top key elements we can sort array of given array, the values in decendent order
 * - TC = O(nlogn) for sorting and hashMap this may be good but the catch is, suppose we have 1M distinct characters and k = 3 then we have to do 1M X log1M work for nothing as all are distinct
 *
 * -> here comes the priority queue(inside the priority queue we do add/ remove values like any other queue, but it have some meaning behind them. lets suppose we have pq with different weight now we want to add element of higher weight then we have to get rid fo element only who are lower in weight),
 * so instead of sorting array, create pq of k size and enter the value based on the occurance and retain only the maxiumum number value
 * ex nums = 1, 3, 4, 3, 4, 2, 3, 4, 2, 5, 4, 5, 5 and k = 4
 * in hashmap we have 1 = 1x, 2 = 2x, 3 = 3x, 4 = 4x, 5 = 3x
 * k = 3, pd of size 3
 * first pq = 1. 2. 3 for 1,2 and 3
 * 2nd pq = 4. 3. 2 removed 1x for one ad added 4x of 4
 * 3rd pq = 3, 4, 3 for 3, 4 and 5 this is our answer [we maintaining order]
 * here TC = O(NlogK) k = k items not n items SC = O(N)
 *
 * Golden Solution: for any top K questions, use sgolden key approach
 *
 * 3. count freq of each element using nested for loop N^2, then sort the element based on freq NlogN and then pic the top K frequent elements;
 *
 * -> so here we basically did iterate all the elements in nums, then ccreatea a freqLsit whcih count the occurance of numer, then if the element visited before then skip if not then count freq ++ later sort it lastely get the max occurannce k times value right
 * TC = O(N^2+NlogN+K)≈O(N^2);
 *
 *
 *
 *
 */

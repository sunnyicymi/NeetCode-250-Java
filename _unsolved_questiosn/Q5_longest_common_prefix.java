/**
 * Question: Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string ""
 * 
 * 
 * In simple words: ->
 * 
 * 
 * Input: strs = ["flower","flow","flight"] and strs = ["dog","racecar","car"]
 * 
 * 
 * Output: "fl" and ""
 * 
 */

/**
 * Solution Discussion: All should include TC and SC
 * --------------------------------------------------
 * 1. Simple Brute Force
 *
 *
 * 2. Optimized Brute Force
 *
 *
 * 3. Unconvensional Solution
 *
 *
 * 4. Best Solution
 *
 */

class Q5_longest_common_prefix {

  public static void main(String[] args) {
    System.out.println("Que: Q5_longest_common_prefix");

    // Inputs
    String[] strs = { "flower", "flow", "flight" };

    // shadow coding and solution discussion

    // call solution 1
    // String ans = s1_solution(strs);
    // System.out.println(ans);

    // call solution 2

    // call solution 3

    // call solution 4
    String ans = s4_solution(strs);
    System.out.println(ans);
  }

  // build solution 1 : Simple Brute Force
  static String s1_solution(String[] strs) {
    String prefix = strs[0]; // assume first whole letter is prefix

    for (int i = 1; i < strs.length; i++) {
      // Compare the prefix with each string in the array
      while (strs[i].indexOf(prefix) != 0) {
        // Reduce the prefix by one character at a time from the end.
        prefix = prefix.substring(0, prefix.length() - 1);
        System.out.println(prefix);
        // If prefix becomes empty, return "" immediately
        if (prefix.isEmpty()) {
          return "";
        }
      }
    }
    return prefix;
  }

  // build solution 2 : Optimized Brute Force
  static String s2_solution(String[] strs) {
    return "";
  }

  // build solution 3 : Unconvensional Solution
  static String s3_solution(String[] strs) {
    return "";
  }

  // build solution 4 : Best Solution
  static String s4_solution(String[] strs) {
    // divide and conquor
    // ie divide in half compare, recursively
    return findLCP(strs, 0, strs.length - 1);
  }

  static String findLCP(String[] strs, int left, int right) {
    if (left == right) {
      return strs[left];
    }

    int mid = (left + right) / 2;

    String leftLCP = findLCP(strs, left, mid);
    String rightLCP = findLCP(strs, mid + 1, right);

    return commonPrefix(leftLCP, rightLCP);
  }

  static String commonPrefix(String str1, String str2) {
    int minLength = Math.min(str1.length(), str2.length());

    for (int i = 0; i < minLength; i++) {
      if (str1.charAt(i) != str2.charAt(i)) {
        return str1.substring(0, i);
      }
    }
    return str1.substring(0, minLength);
  }
}

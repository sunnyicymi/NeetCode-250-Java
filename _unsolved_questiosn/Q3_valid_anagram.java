/**
 * Question: Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * [anagram] = An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.
 *
 * In simple words: -> simple
 *
 *
 * Input: s = "anagram", t = "nagaram" and s = "rat", t = "car"
 *
 *
 * Output: true, false
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
 *  
        Step-by-Step Execution Example (s = "abc", t = "bca")

        i   sChar (received)   tChar (sold)   countMap.getOrDefault(sChar, 0) + 1   countMap.getOrDefault(tChar, 0) - 1   countMap After
        --------------------------------------------------------------------------------------------------------------
        0   'a'               'b'            1 (new)                              -1 (new)                              {'a': 1, 'b': -1}
        1   'b'               'c'            -1 + 1 = 0                           -1 (new)                              {'a': 1, 'b': 0, 'c': -1}
        2   'c'               'a'            -1 + 1 = 0                           1 - 1 = 0                             {'a': 0, 'b': 0, 'c': 0}
        
        At the end, if all values in countMap are 0, s and t are anagrams.
     // explaination:
    // 1. Get character at index i from string s , s.charAt(i)
    // 2. if item available in map return 0, .getOrDefault(s.charAt(i), 0) part
    // 3. + 1 like add to cart and -1 is like remove from cart
    // lastly, for all values if value in for loop not equal to zero means characters are not anagram.


   

 */

import java.util.HashMap;

class Q3_valid_anagram {

  public static void main(String[] args) {
    System.out.println("Que: Q3_valid_anagram");

    // Inputs
    String s = "anagram";
    String t = "nagaram";

    // call solution 1
    // boolean ans = s1_solution(s, t);
    // System.out.println(ans);

    // call solution 2
    // boolean ans = s2_solution(s, t);
    // System.out.println(ans);

    // call solution 3
    boolean ans = s3_solution(s, t);
    System.out.println(ans);
    // call solution 4
    // boolean ans = s4_solution(s, t);
    // System.out.println(ans);
  }

  // build solution 1 : Simple Brute Force
  static boolean s1_solution(String s, String t) {
    // first length should be equal,
    if (s.length() != t.length()) {
      return false;
    }

    // convert string to character to compare and sorting
    char[] sArray = s.toCharArray();
    char[] tArray = t.toCharArray();

    // bubbleSort both
    bubbleSort(sArray);
    bubbleSort(tArray);

    // compare sorted chareacters
    for (int i = 0; i < sArray.length; i++) {
      if (sArray[i] != tArray[i]) {
        return false;
      }
    }
    return true;
  }

  // build solution 2 : Optimized Brute Force
  // why it is not best solution ?
  // -> it uses two hashMaps means double memory, .equals is slower as it compare key,value one-by-one,
  // SC = O(2n) TC = O(1)
  static boolean s2_solution(String s, String t) {
    HashMap<Character, Integer> s1 = new HashMap<>();
    HashMap<Character, Integer> t1 = new HashMap<>();

    if (s.length() != t.length()) {
      return false;
    }

    for (int i = 0; i < s.length(); i++) {
      s1.put(s.charAt(i), s1.getOrDefault(s.charAt(i), 0) + 1);
      t1.put(t.charAt(i), t1.getOrDefault(t.charAt(i), 0) + 1);
    }
    return s1.equals(t1);
  }

  // build solution 3 : Unconvensional Solution
  static boolean s3_solution(String s, String t) {
    // 1. create integer array of 26 for 26 alphabets
    // 2. count freq of char in s by increasing count
    // 3. count freq of char in t by decreasing count
    // 4. if all values in freq are 0, s and t are anagram

    int[] count = new int[26];

    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a']++; // inc count
      count[t.charAt(i) - 'a']--; // dec count
      // why a? a's ASCII=97, char - a = 97 -97 = 0 index, for b index = 1 for c index = 2 and so on.
    }

    for (int value : count) {
      if (value != 0) return false;
    }

    return true;
  }

  // build solution 4 : Best Solution
  static boolean s4_solution(String s, String t) {
    if (s.length() != t.length()) return false;

    HashMap<Character, Integer> countMap = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
      countMap.put(t.charAt(i), countMap.getOrDefault(t.charAt(i), 0) - 1);
      // get at i, else return 0 it what getOrDefault is
    }

    for (int value : countMap.values()) {
      if (value != 0) return false;
    }

    return true;
  }

  // bubbleSort
  static void bubbleSort(char[] arr) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          // swap
          char temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }
}

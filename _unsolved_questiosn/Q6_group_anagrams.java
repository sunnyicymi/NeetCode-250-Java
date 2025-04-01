/**
 * Question: Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 *
 * In simple words: -> group the anagrams together in an array if not anagram then leave them single in the array
 *
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"] [""]
 *
 *
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]] [[""]]
 *
 */

/**
 * Solution Discussion: All should include TC and SC
 * --------------------------------------------------
 * 1. Simple Brute Force
 * first check for anagram, if anagram and group is matching add them in the existing group if not create a new group and add there.
 *
 * TC = O(N² K) N = words K = word length
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Q6_group_anagrams {

  public static void main(String[] args) {
    System.out.println("Que: Name_here");

    // Inputs
    String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
    // shadow coding and solution discussion

    // call solution 1
    // List<List<String>> ans = s1_solution(strs);
    // System.out.println(ans);

    // call solution 2
    List<List<String>> ans = s1_solution(strs);
    System.out.println(ans);
    
    // call solution 3

    // call solution 4

  }

  // build solution 1 : Simple Brute Force
  static List<List<String>> s1_solution(String[] strs) {
    List<List<String>> result = new ArrayList<>();

    for (String word : strs) {
      boolean foundGroup = false;

      // compare with existing group
      for (List<String> group : result) {
        if (checkAnagram(group.get(0), word)) {
          group.add(word);
          foundGroup = true;
          break;
        }
      }

      // if no group was found, create a new group
      if (!foundGroup) {
        List<String> newGroup = new ArrayList<>();
        newGroup.add(word);
        result.add(newGroup);
      }
    }

    return result;
  }

  // build solution 2 : Optimized Brute Force
  static List<List<String>> s2_solution(String[] strs) {
    HashMap<String, List<String>> anagramGroups = new HashMap<>();

    for (String word : strs) {
      char[] chars = word.toCharArray();
      Arrays.sort(chars);

      String sortedWord = new String(chars);

      anagramGroups.putIfAbsent(sortedWord, new ArrayList<>());
      anagramGroups.get(sortedWord).add(word);
    }
    return new ArrayList<>(anagramGroups.values());
  }

  // build solution 3 : Unconvensional Solution
  //   static List<List<String>> s3_solution(String[] strs) {
  //   }

  // build solution 4 : Best Solution
  //   static List<List<String>> s4_solution(String[] strs) {
  //   }

  static boolean checkAnagram(String s, String t) {
    if (s.length() != t.length()) return false;

    HashMap<Character, Integer> countMap = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
      countMap.put(t.charAt(i), countMap.getOrDefault(t.charAt(i), 0) - 1);
    }

    for (int value : countMap.values()) {
      if (value != 0) return false;
    }

    return true;
  }
}

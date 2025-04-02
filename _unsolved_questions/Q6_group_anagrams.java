import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Q6_group_anagrams {

  public static void main(String[] args) {
    String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

    // List<List<String>> ans1 = s1_solution(strs);
    // System.out.println(ans1);

    // List<List<String>> ans2 = s2_solution(strs);
    // System.out.println(ans2);

    List<List<String>> ans3 = s3_solution(strs);
    System.out.println(ans3);
  }

  static List<List<String>> s1_solution(String[] strs) {
    List<List<String>> result = new ArrayList<>();

    // iterate through each word
    for (String word : strs) {
      boolean foundGroup = false;

      // check if word in anagram in prev group
      for (List<String> group : result) {
        if (isAnagram(group.get(0), word)) {
          group.add(word);
          foundGroup = true;
          break;
        }
      }

      // if no group then create one
      if (!foundGroup) {
        List<String> newGroup = new ArrayList<>();
        newGroup.add(word);
        result.add(newGroup);
      }
    }
    return result;
  }

  static List<List<String>> s2_solution(String[] strs) {
    HashMap<String, List<String>> hashMap = new HashMap<>();

    for (String word : strs) {
      // sort the words to create a unique key
      char[] chars = word.toCharArray();
      Arrays.sort(chars);
      String sortedWord = new String(chars);

      // if key exists add to list, otherwise create new list
      hashMap.putIfAbsent(sortedWord, new ArrayList<>());
      // here we are sure we have list so just add value [order] is important here
      hashMap.get(sortedWord).add(word);
    }
    return new ArrayList<>(hashMap.values());
  }

  static List<List<String>> s3_solution(String[] strs) {
    HashMap<String, List<String>> hashMap = new HashMap<>();

    for (String word : strs) {
      // gen freq count key
      int[] charCount = new int[26];

      for (char c : word.toCharArray()) {
        charCount[c - 'a']++;
      }

      // convert freq array to a string key
      StringBuilder keyBuilder = new StringBuilder();
      for (int count : charCount) {
        keyBuilder.append(count).append("#"); // # for delimiter
      }

      String key = keyBuilder.toString(); // "1#0#0#1#0#..."

      // store in hashMap
      hashMap.putIfAbsent(key, new ArrayList<>());
      hashMap.get(key).add(word);
    }

    return new ArrayList<>(hashMap.values());
  }

  static boolean isAnagram(String s1, String s2) {
    if (s1.length() != s2.length()) return false;

    char[] arr1 = s1.toCharArray();
    char[] arr2 = s2.toCharArray();

    Arrays.sort(arr1);
    Arrays.sort(arr2);

    return Arrays.equals(arr1, arr2);
  }
}
/*
 * [MEDIUM] Q49. given the array of different string, group the anagrams togehter/
 * for example = strs = ["eat", "tea", "tan","ate","nat", "bat"]
 * solution = [["eat", "tea","ate"], ["tan", "nat"], ["bat"]];
 *
 * -> check anagram, then group them together.
 * 
 * 
 -> 1. my intution is like create a function to check if two string are anagram or not
 If yes, then group them together else add them to a separate group.
 TC = n for outer loop, n for inner loop and anagram check is MlogN m = max word length
 total TC = O(N^2 & M log M); M = longest word

 -> 2nd intution, we can use hashMap for the group thing. it is like first we can do like we will check the hashSet for the anagram if not available then add, if available then increate add the new str to hashMap value of the same key.
 TC = O(N * M log M). M = longest word
 * 
 * 3. sort the element based on alaphabetically and just check for grouping
 * example = aet, aet, aet, ant, ant, bat where all words sorted alphabetically and now we can group same word together not sorted one but the index of this from original array, TC = O(nlogn) * K biggest lenght of str
 * 
 * 4. use array of 26 for alphabets and check count of characters for anagram check then we will use the hashing. inside the hashMap we will string value of abc and store the original words it our group. TC = O(n*k) SC = O(n*j)
 * 
 * 5. using character frequencey count;  TC = O(N * M) same as above 4th number but clear message
 * first, create freq count for all 26 letters from a-z
 * then, increment count for each character as placeholder in the array
 * then, convert freq count to a string key
 * then, store each words in hashMap based on the freq key
 *
 */

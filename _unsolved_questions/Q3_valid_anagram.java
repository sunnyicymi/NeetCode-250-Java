import java.util.HashMap;

class Q3_valid_anagram {

  public static void main(String[] args) {
    // boolean ans = s1_solution("sat", "sat");
    // System.out.println(ans);

    // boolean ans2 = s2_solution("sat", "sam");
    // System.out.println(ans2);

    boolean ans3 = s3_solution("sat", "tas");
    System.out.println(ans3);
  }

  static boolean s1_solution(String s, String t) {
    if (s.length() != t.length()) return false;
    // run until not empty
    while (!s.isEmpty() && !t.isEmpty()) {
      char firstChar = s.charAt(0);
      // if exists then remove the item from both s and t
      if (t.indexOf(firstChar) != -1) {
        s = s.substring(1); // update s hence first character as well
        t =
          t.substring(0, t.indexOf(firstChar)) +
          t.substring(t.indexOf(firstChar) + 1); // update t
      } else {
        // not match so return false;
        return false;
      }
    }

    // If both strings become empty, it means all characters from s have been matched and removed from t, indicating they are anagrams.
    return s.isEmpty() && t.isEmpty();
  }

  static boolean s2_solution(String s, String t) {
    if (s.length() != t.length()) return false;

    int[] charCount = new int[26];

    for (int i = 0; i < s.length(); i++) {
      charCount[s.charAt(i) - 'a']++; // -a for convertion ASCII 97 = 0 for a
      charCount[t.charAt(i) - 'a']--;
    }

    for (int value : charCount) {
      if (value != 0) return false;
    }
    return true;
  }

  static boolean s3_solution(String s, String t) {
    if (s.length() != t.length()) return false;

    HashMap<Character, Integer> charCountS = new HashMap<>();
    HashMap<Character, Integer> charCountT = new HashMap<>();

    // count s char
    for (char c : s.toCharArray()) {
      charCountS.put(c, charCountS.getOrDefault(c, 0) + 1);
    }

    // count t char
    for (char c : t.toCharArray()) {
      charCountT.put(c, charCountT.getOrDefault(c, 0) + 1);
    }

    return charCountS.equals(charCountT);
  }
}
/*
 * anagram = words which can be achieved using suffling ex = tea can be ate, eta.
 * [EASY] Q242. vaid anagram, two strings s and t return true if they are anagram else return false.
 * s = cat , t = tac => they are anagram
 * s = sat, t = sam => not anagram
 *
 *
 * 1. take first char from s and check if present in t if yes then remove that char from both side and do repeat until there is no character left. TC = O(N^2);
 *
 * 2. sort and check if they are equal TC = O(nLogn); not gonna implement here
 *
 * 3. using hashMap TC = O(N) SC = O(2n);
 *
 *
 *
 * 4. using simple array of 26 as total letters are only 26 in english hence better solution then hashMap as hashMap increases the SC by 2 times TC = O(n) SC = O(26)
 *
 * -> character and frequencey matching, at last if freq match done else false
 * -> increment counter if freq found in s
 * -> decrement counter if freq found in t
 * example = cart and ract
 * a c r t
 * first run c = 1, r = -1 1 for s and -1 for t
 * second run a = 1, a = -1 ie a = 0;
 * third run r = 1 and c = -1 here r = 0 and c = 0
 * forth run t = 1 and t = -1 here t = 0
 * -> since all becore 0 and freq = 0 for whole for loop, hence ans = true it is anagram.
 * at last we will check freq is 0 or not
 *
 *
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Q14_encode_and_decode_strings {

  public static void main(String[] args) {}

  static String encode(List<String> strs) {
    if (strs.size() == 0) return Character.toString((char) 258);

    // check if character is 257 as till 256 is ASCII character, measn 257 is a break

    String separate = Character.toString((char) 257);
    StringBuilder sb = new StringBuilder();

    for (String str : strs) {
      sb.append(str);
      sb.append(separate);
    }

    sb.deleteCharAt(sb.length() - 1); // deleted last extra separator
    return sb.toString();
  }

  static List<String> decode(String s) {
    if (s.equals(Character.toString((char) 258))) {
      return new ArrayList<>();
    }

    String separate = Character.toString((char) 257);

    return Arrays.asList(s.split(separate, -1));
  }
}
/*
 * [Medium] Q271 premium, given a list of string, desing an algorithm to encode a list of strings to a sting, it sent to netwrokn and after it have to be decoded to original list of strings
 * machine 1 encode
 * machine 2 decode
 *
 * 1. add any character like # in between the two string while encoding, on decoding side we just have to remove the extra character which we added
 *
 * 2. use 4-bit strategy
 * assing 4bits to mention the length of the upcoming string
 *  example = 0011abc0010ab0010bc
 * measn 3 char next ie abc, 2 char next ie ab, 2 char next ie bc
 *
 *
 */

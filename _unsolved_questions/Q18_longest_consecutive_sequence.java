class Q18_longest_consecutive_sequence {

  public static void main(String[] args) {}
}
/*
 * [MEDIUM] Q128 given an unsorted array of integers nums, return the longest consecutive elements seqeunce
 * exampls [100, 4, 200, 1, 3, 2]
 * ans = 4
 * explaination = longest consecutive elements in sequence is 1, 2, 3, 4 hance ans = 4
 *
 * 1. LCS = suppose it is empty means 0 lcs, if 1 item then 1 lcs present
 *
 * min lcs = 1 atleast
 *
 * so if 101 exists then lcs becomre 2 for our example
 * now lets Current Consecutive Subsequence, CCS = 1 default
 *
 * first run 101 do not exists lcs = 1, ccs =1
 * for 1, 2 exists lcs = 2 and css = 2
 * for 2 and 3 same and for 4 alseo lcs = 4 and ccs = 4
 *
 * tc = n^3 very bad
 */

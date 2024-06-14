
/*Given two strings str1 and *tr2 of length M and N
respectively and below operations that can be performed on str1
Find the minimum number of edits (operations) to convert str1 into str2.

- **Operation 1 (INSERT)**: Insert any character before or after any index of **str1**
- **Operation 2 (REMOVE):** Remove a character of **str1**
- **Operation 3 (Replace):** Replace a character at any index of **str1** with some other character.

***Input:str1 = “cat”, str2 = “cut”

***Output: 1

***Explanation:** We can convert str1 into str2 by replacing ‘a’ with ‘u’.

***Input:str1 = “sunday”, str2 = “saturday”

***Output:3

***Explanation: Last three and first characters are same. We basically need to convert “un” to “atur”.
This can be done using below three operations. Replace ‘n’ with ‘r’, insert t, insert a
* */
public class Solution {
    public static void main(String[] args) {
        String str1 = "cat";
        String str2 = "cut";

        String str3 = "sunday";
        String str4 = "saturday";

        System.out.println(minimumOperations(str1, str2));
        System.out.println(minimumOperations(str3, str4));
    }

    public static int minimumOperations(String str1, String str2) {

        int M = str1.length();
        int N = str2.length();

        int[][] table = new int[M + 1][N + 1];

        // DP table
        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0) {
                    table[i][j] = j; // If str1 is empty, insert all characters of str2
                } else if (j == 0) {
                    table[i][j] = i; // If str2 is empty, remove all characters of str1
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1]; // If characters match, no new operation needed
                } else {
                    table[i][j] = 1 + Math.min(table[i][j - 1],    // Insert
                            Math.min(table[i - 1][j],    // Remove
                                    table[i - 1][j - 1])); // Replace
                }
            }
        }
        return table[M][N];
    }
}

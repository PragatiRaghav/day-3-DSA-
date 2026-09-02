class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        String[] phone = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(digits, 0, "", result, phone);

        return result;
    }

    private void backtrack(
        String digits,
        int index,
        String current,
        List<String> result,
        String[] phone
    ) {

        // All digits have been processed
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        // Get letters corresponding to current digit
        String letters = phone[digits.charAt(index) - '0'];

        // Try every possible letter
        for (char ch : letters.toCharArray()) {
            backtrack(
                digits,
                index + 1,
                current + ch,
                result,
                phone
            );
        }
    }
}

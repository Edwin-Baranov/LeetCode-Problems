class Solution {
     public int[] plusOne(int[] digits) {
        int[] result = null;
        for (int i = 0; i < digits.length; ++i) {
            if (digits[i] != 9) {
                result = new int[digits.length];
                break;
            }
        }

        if (result == null) {
            result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        } else {
            boolean hasIncremented = false;
            for (int i = digits.length - 1; i >= 0; --i) {
                if (!hasIncremented) {
                    if (digits[i] == 9) {
                        result[i] = 0;
                        continue;
                    }
                    result[i] = digits[i] + 1;
                    hasIncremented = true;
                } else {
                    result[i] = digits[i];
                }
            }
        }
        return result;
    }
}
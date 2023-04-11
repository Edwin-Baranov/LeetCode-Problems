class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int total = 0;
        for (int i = 0; i < bank.length; ++i) {
            int count = 0;
            int charCount = bank[i].length();
            for (int j = 0; j < charCount; ++j) {
                char c = bank[i].charAt(j);
                if (c == '1')
                    ++count;
            }
            
            if (count > 0) {
                total += count * prev;
                prev = count;
            }
        }
        return total;
    }
}
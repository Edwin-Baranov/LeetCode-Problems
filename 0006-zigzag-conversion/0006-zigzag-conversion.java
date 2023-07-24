class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        StringBuilder[] rows = new StringBuilder[numRows];
        
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        
        int n = s.length();
        boolean goingDown = true;
        int currentRow = 0;
        
        for (int i = 0; i < n; i++) {
            if (goingDown) {
                rows[currentRow++].append(s.charAt(i));
                if (currentRow == numRows) {
                    goingDown = false;
                    currentRow -= 2;
                }
            } else {
                rows[currentRow--].append(s.charAt(i));
                if (currentRow < 0) {
                    goingDown = true;
                    currentRow += 2;
                }
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < numRows; i++) {
            result.append(rows[i].toString());
        }
        
        return result.toString();
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        fillPixels(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    
    private void fillPixels(int[][] image, int sr, int sc, int color, int selected) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] == color)
            return;
        
        if (image[sr][sc] == selected) {
            image[sr][sc] = color;
            
            fillPixels(image, sr + 1, sc, color, selected);
            fillPixels(image, sr - 1, sc, color, selected);
            fillPixels(image, sr, sc + 1, color, selected);
            fillPixels(image, sr, sc - 1, color, selected);
        }
    }
}
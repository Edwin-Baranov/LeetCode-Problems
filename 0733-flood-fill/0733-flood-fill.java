class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) fillPixels(image, sr, sc, color, newColor);
        return image;
    }
    public void fillPixels(int[][] image, int r, int c, int color, int newColor) {
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length) {
          return;
        }
      
        if (image[r][c] == color) {
            image[r][c] = newColor;
            fillPixels(image, r-1, c, color, newColor);
            fillPixels(image, r, c-1, color, newColor);
            fillPixels(image, r+1, c, color, newColor);
            fillPixels(image, r, c+1, color, newColor);
        }
    }
}
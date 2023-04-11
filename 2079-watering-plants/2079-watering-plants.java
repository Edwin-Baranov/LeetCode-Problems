class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int water = capacity;
        int extraSteps = 0;
        for (int i = 0; i < plants.length; ++i) {
            if (water < plants[i]) {
                extraSteps += i * 2;
                water = capacity;
            }
            water -= plants[i];
        }
        return extraSteps + plants.length;
    }
}
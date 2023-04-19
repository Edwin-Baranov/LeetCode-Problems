class Solution {
    Map<Integer, Integer> points = new HashMap<>();
    
    public int deleteAndEarn(int[] nums) {
        
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
        }
        
        List<Integer> elements = new ArrayList<Integer>(points.keySet());
        Collections.sort(elements);
        
        int twoBack = 0;
        int oneBack = points.get(elements.get(0));
        
        for (int i = 1; i < elements.size(); ++i) {
            int currentElement = elements.get(i);
            int newMax;
            
            if(currentElement == elements.get(i - 1) + 1) {
                newMax = Math.max(oneBack, twoBack + points.get(currentElement));
            } else {
                newMax = oneBack + points.get(currentElement);
            }
            
            twoBack = oneBack;
            oneBack = newMax;
        }
        
        return oneBack;
    }
}
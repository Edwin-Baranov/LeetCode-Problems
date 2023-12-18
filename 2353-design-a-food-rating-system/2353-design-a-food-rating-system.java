class FoodRatings {
    
    private Map<String, Integer> ratingMap;
    private Map<String, String> cuisineMap;
    private Map<String, PriorityQueue<FoodItem>> cuisineFoodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        ratingMap = new HashMap();
        cuisineMap = new HashMap();
        cuisineFoodMap = new HashMap();
        
        for (int i = 0; i < foods.length; i++) {
            ratingMap.put(foods[i], ratings[i]);
            cuisineMap.put(foods[i], cuisines[i]);
            cuisineFoodMap.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>()).add(new FoodItem(foods[i], ratings[i]));
        }
    }
    
    public void changeRating(String food, int newRating) {
        ratingMap.put(food, newRating);
        
        String cuisineName = cuisineMap.get(food);
        cuisineFoodMap.get(cuisineName).add(new FoodItem(food, newRating));
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<FoodItem> list = cuisineFoodMap.get(cuisine);
        FoodItem top = list.peek();
        
        while (top.rating != ratingMap.get(top.name)) {
            list.poll();
            top = list.peek();
        }
        
        return top.name;
    }
    
    private class FoodItem implements Comparable<FoodItem> {
        String name;
        int rating;
        
        public FoodItem(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
        
        @Override
        public int compareTo(FoodItem other) {
            if (rating == other.rating) {
                return name.compareTo(other.name);
            }
            
            return -1 * Integer.compare(rating, other.rating);
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
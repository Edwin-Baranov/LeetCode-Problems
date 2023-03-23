class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        std::unordered_map<int, int> basket;
        int left = 0, right;
    
        for (right = 0; right < fruits.size(); ++right) {
            basket[fruits[right]]++;
        
            if (basket.size() > 2) {
                basket[fruits[left]]--;
                if (basket[fruits[left]] == 0)
                    basket.erase(fruits[left]);
                left++;
            }
        }
    
        return right - left;
    }
};
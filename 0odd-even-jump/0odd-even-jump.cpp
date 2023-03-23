class Solution {
public:
    int oddEvenJumps(vector<int>& arr) {
        int count = 1;
        std::vector<bool> highJump(arr.size()), lowJump(arr.size());
        highJump[arr.size() - 1] = lowJump[arr.size() - 1] = true;

        std::map<int, int> passedIndexes;
        passedIndexes[arr[arr.size() - 1]] = arr.size() - 1;

        for (int i = arr.size() - 2; i >= 0; i--) {
            auto nextLargest = passedIndexes.lower_bound(arr[i]);
            auto nextSmallest = passedIndexes.upper_bound(arr[i]);

            if (nextLargest != passedIndexes.end()) {
                highJump[i] = lowJump[nextLargest->second];
            } else {
                highJump[i] = false;
            }

            if (nextSmallest != passedIndexes.begin()) {
                lowJump[i] = highJump[(--nextSmallest)->second];
            } else {
                lowJump[i] = false;
            }

            if (highJump[i]) {
                count++;
            }
            passedIndexes[arr[i]] = i;
        }
        return count;
    }
};
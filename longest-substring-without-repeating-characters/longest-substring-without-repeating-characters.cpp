class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        std::unordered_set<char> charSet;

        int leftPointer = 0, rightPointer;
        int result = 0;

        for (rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            char rightChar = s[rightPointer];

            while (charSet.find(rightChar) != charSet.end()) {
                char leftChar = s[leftPointer];
                charSet.erase(leftChar);
                leftPointer++;
            }

            charSet.insert(rightChar);

            result = std::max(result, static_cast<int>(charSet.size()));
        }

        return result;
    }
};
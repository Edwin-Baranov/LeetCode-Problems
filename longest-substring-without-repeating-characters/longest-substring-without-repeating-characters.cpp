class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> charIndex;

        int answer = 0;
        int left = -1;
        for(int right = 0; right < s.length(); right++) {
            if(charIndex.find(s[right]) != charIndex.end() && charIndex[s[right]] > left) {
               left = charIndex[s[right]];
            }
            answer = max(answer, right - left);
            charIndex[s[right]] = right;
        }

        return answer;
    }
};
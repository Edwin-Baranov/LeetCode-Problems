class Solution {
public:
    string licenseKeyFormatting(string s, int k) {
        int count = k;
        std::string result;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s[i] == '-') {
                continue;
            }
        
            if (count <= 0) {
                result += '-';
                count = k;
            }
        
            result += std::toupper(s[i]);
            count--;
        }
    
        std::reverse(result.begin(), result.end());
        return result;
    }
};
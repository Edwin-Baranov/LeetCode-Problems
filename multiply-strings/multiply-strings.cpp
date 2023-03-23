class Solution {
public:
    string multiply(string num1, string num2) {
         if (num1 == "0" || num2 == "0") {
            return "0";
        }

        int n1Length = num1.length();
        int n2Length = num2.length();
        vector<int> result(n1Length + n2Length);

        for (int i = n1Length - 1; i >= 0; i--) {
            int digit1 = num1[i] - '0';
            for (int j = n2Length - 1; j >= 0; j--) {
                int digit2 = num2[j] - '0';
                int product = digit1 * digit2;
                int pos1 = i + j;
                int pos2 = i + j + 1;
                int sum = product + result[pos2];
                result[pos2] = sum % 10;
                result[pos1] += sum / 10;
            }
        }

        string res;
        for (int i = 0; i < result.size(); i++) {
            if (i == 0 && result[i] == 0) {
                continue;
            }
            res += to_string(result[i]);
        }
        return res;
    }
};
class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        std::unordered_set<std::string> emailSet;

        for (auto& email : emails) {
            std::string filteredEmail;
         bool charIgnore = false;
            bool isLocalName = true;

            for (char c : email) {
                if (c == '+' && isLocalName) {
                    charIgnore = true;
                }

                if (c == '@') {
                    charIgnore = false;
                    isLocalName = false;
                }

                if (charIgnore) {
                    continue;
                }

                if (c != '.' || !isLocalName) {
                    filteredEmail += c;
                }
            }

            emailSet.insert(filteredEmail);
        }

        return emailSet.size();
    }
};
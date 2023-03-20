class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<String>();
        
        for (String email : emails) {
            StringBuilder filteredEmail = new StringBuilder();
            
            boolean charIgnore = false;
            boolean isLocalName = true;
            
            for(char c : email.toCharArray()) {
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
                    filteredEmail.append(c);
                }
            }
            
            emailSet.add(filteredEmail.toString());
        }
        
        return emailSet.size();
    }
}
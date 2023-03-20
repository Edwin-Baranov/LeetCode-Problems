class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<String>();
        
        for (String email : emails) {
            String[] emailParts = email.split("@", 2);
            
            int plusIndex = emailParts[0].indexOf("+");
            if (plusIndex > 0) {
                emailParts[0] = emailParts[0].substring(0, plusIndex);
            }
            
            emailParts[0] = emailParts[0].replace(".", "");
            
            emailSet.add(emailParts[0] + '@' + emailParts[1]);
        }
        
        return emailSet.size();
    }
}
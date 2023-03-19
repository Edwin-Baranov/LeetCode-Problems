class WordNode {
    Map<Character, WordNode> children = new HashMap();
    boolean isWord = false;
    public WordNode() {}
}

class WordDictionary {
    WordNode storage;

    public WordDictionary() {
        storage = new WordNode();
    }
    
    public void addWord(String word) {
        WordNode pointer = storage;
        
        for (char ch : word.toCharArray()) {
            if (!pointer.children.containsKey(ch)) {
                pointer.children.put(ch, new WordNode());
            }
            pointer = pointer.children.get(ch);
        }
        pointer.isWord = true;
    }
     
    
    public boolean search(String word) {
        return searchInNode(word, storage);
        
    }
    
    private boolean searchInNode(String word, WordNode node) {
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (char x : node.children.keySet()) {
                    WordNode child = node.children.get(x);
                    if (searchInNode(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            }
            if (!node.children.containsKey(ch)) {
                return false;
            }
            node = node.children.get(ch);
        }
        return node.isWord;
    }
}
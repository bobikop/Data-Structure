public class Trie {
   TrieNode root;

   // Construct an empty Trie Object
    public Trie() {
        root= new TrieNode();
    }

   // Insert a new word into trie
    public void insert(String word) {
        TrieNode curNode=root;
        char[] arr=word.toCharArray();
        for (char c : arr) {
            if(!curNode.children.containsKey(c)){
                curNode.children.put(c, new TrieNode());
            }
            curNode=curNode.children.get(c);// Move to next node
        }
        curNode.isWord=true;
    }


    public boolean search(String word) {
        TrieNode curNode=root;
        char[] arr=word.toCharArray();
        for (char c : arr) {
            if(!curNode.children.containsKey(c)) return false;

            curNode=curNode.children.get(c); // Move to next node
        }
        return curNode.isWord;
    }


    public boolean startsWith(String prefix) {
        TrieNode curNode=root;
        char[] arr=prefix.toCharArray();
        for (char c : arr) {
            if(!curNode.children.containsKey(c)) return false;

            curNode=curNode.children.get(c); // Move to next node/child
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

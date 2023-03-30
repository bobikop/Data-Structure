import java.util.Arrays;
import java.util.List;

public class TrieMainApp {
    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.insert("apple") ;
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        trie.insert("app") ;
        System.out.println(trie.search("app") + "  =>After insertion");
        List<String> dict= Arrays.asList("apple","pen");


        System.out.println(wordBreak2("applepenapple", dict));
    }

    public static boolean wordBreak2(String s, List<String> wordDict) {
        Trie trie=new Trie();
        for (String str:wordDict){
            trie.insert(str);
        }
        TrieNode curNode =trie.root;
        char[] arr = s.toCharArray();
        int prevWordIndex=-1;
        for (int i = 0; i < arr.length; i++) {
            if (!curNode.children.containsKey(arr[i])) return false;
            curNode = curNode.children.get(arr[i]);
            if (curNode.isWord) prevWordIndex=i;
            if(i== arr.length-1 && !curNode.isWord && prevWordIndex>-1) {
                i=prevWordIndex;
                curNode=trie.root;
            }
            if (curNode.isWord && curNode.children.isEmpty() ) {
                if(i== arr.length-1 && !curNode.isWord && prevWordIndex>-1) {
                    i=prevWordIndex+1;
                    curNode=trie.root;
                }
                if(i== arr.length-1 && curNode.isWord) return true;
                else curNode=trie.root;}

        }

        return curNode.isWord;
    }
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */



}
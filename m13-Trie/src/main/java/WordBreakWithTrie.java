import java.util.*;

public class WordBreakWithTrie {
    public static void main(String[] args) {
        //List<String> dict = Arrays.asList("a","b","bbb","bbbb");
       // System.out.println(wordBreak("bb", dict));
        List<String> dict = Arrays.asList("aa","aaa" );
        System.out.println(wordBreak("aaaaaaa", dict));
    }
    public static boolean wordBreak(String str, List<String> wordDict) {
 // create a Trie
        Trie trie=new Trie();
        TrieNode curNode= trie.root;
        // Create a stack nd a hashset
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        Set<Integer> visited=new HashSet<>();
        // Fill in the dict
        for (String s : wordDict) {
            trie.insert(s);
        }
        // START WORD BREAK
        char[] arr=str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            //if no word contains current char and stack is empty return false
            if (!curNode.children.containsKey(arr[i]) && stack.isEmpty()) return false;
            else if(!curNode.children.containsKey(arr[i]) && !stack.isEmpty()){
                i=stack.pop();
                curNode= trie.root;
                continue;
            }
            curNode=curNode.children.get(arr[i]);
            if(curNode!=null && curNode.isWord){
                if(visited.add(i)) stack.push(i);
                if(curNode.children.size()==0) curNode= trie.root;
            }
            if (!stack.isEmpty() && !curNode.isWord && i== arr.length-1) {
                i=stack.pop();
                curNode= trie.root;
            }
        }
       return curNode.isWord|| curNode== trie.root;

    }


}
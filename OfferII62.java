package 剑指offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer II 062. 实现前缀树
 Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。

 请你实现 Trie 类：

 Trie() 初始化前缀树对象。
 void insert(String word) 向前缀树中插入字符串 word 。
 boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。


 示例：

 输入
 inputs = ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 inputs = [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 输出
 [null, null, true, false, true, null, true]

 解释
 Trie trie = new Trie();
 trie.insert("apple");
 trie.search("apple");   // 返回 True
 trie.search("app");     // 返回 False
 trie.startsWith("app"); // 返回 True
 trie.insert("app");
 trie.search("app");     // 返回 True
 */
public class OfferII62 {
    class Trie {

        class TreeNode{
            TreeNode [] treeNodes = new TreeNode[26];
            Character ch;
        }
        TreeNode[] tree ;

        /** Initialize your data structure here. */
        public Trie() {
            tree = new TreeNode[26];
        }

        Set<String> set = new HashSet<>();

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TreeNode []node = tree;
            for(int i = 0;i<word.length();i++){
                    if(node[word.charAt(i)-'a']!=null){
                        node = node[word.charAt(i)-'a'].treeNodes;
                    }else {
                        node[word.charAt(i)-'a'] = new TreeNode();
                        node[word.charAt(i)-'a'].ch = word.charAt(i);
                        node[word.charAt(i)-'a'].treeNodes = new TreeNode[26];
                        node = node[word.charAt(i)-'a'].treeNodes;
                    }
                }
            set.add(word);

            }


        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            return set.contains(word);
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie.TreeNode[]node = tree;

            for(int i=0;i<prefix.length();i++){
                if(node[prefix.charAt(i)-'a']!=null){
                    node = node[prefix.charAt(i)-'a'].treeNodes;
                }else return false;
            }
            return true;
        }
    }
}
/**
 * res
 *
 * class Trie {
 private Trie[] children;
 private boolean isEnd;

 public Trie() {
 children = new Trie[26];
 isEnd = false;
 }

 public void insert(String word) {
 Trie node = this;
 for (int i = 0; i < word.length(); i++) {
 char ch = word.charAt(i);
 int index = ch - 'a';
 if (node.children[index] == null) {
 node.children[index] = new Trie();
 }
 node = node.children[index];
 }
 node.isEnd = true;
 }

 public boolean search(String word) {
 Trie node = searchPrefix(word);
 return node != null && node.isEnd;
 }

 public boolean startsWith(String prefix) {
 return searchPrefix(prefix) != null;
 }

 private Trie searchPrefix(String prefix) {
 Trie node = this;
 for (int i = 0; i < prefix.length(); i++) {
 char ch = prefix.charAt(i);
 int index = ch - 'a';
 if (node.children[index] == null) {
 return null;
 }
 node = node.children[index];
 }
 return node;
 }
 }

 */
package tree;

import java.util.Arrays;

/**
 * @description: 单词的压缩编码
 * @create: 2020-11-15-21:37
 * @author: Hey
 */
public class MinimumLengthEncoding {

    public static void main(String[] args) {
        MinimumLengthEncoding m = new MinimumLengthEncoding();
        String[] words = {"me","time","e"};
        int len = m.minimumLengthEncoding(words);
        System.out.println(len);
    }

    public int minimumLengthEncoding(String[] words) {
        int len = 0;
        Trie trie = new Trie();
        // 先对单词列表根据单词长度由长到短排序
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        // 单词插入trie，返回该单词增加的编码长度
        for (String word: words) {
            len += trie.insert(word);
        }
        return len;
    }

}

// 定义tire
class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public int insert(String word) {
        TrieNode cur = root;
        boolean isNew = false;
        // 倒着插入单词
        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i) ;
            if (cur.children[c-'a'] == null) {
                isNew = true; // 是新单词
                cur.children[c-'a'] = new TrieNode();
            }
            cur = cur.children[c-'a'];
        }
        // 如果是新单词的话编码长度增加新单词的长度+1，否则不变。
        return isNew? word.length() + 1: 0;
    }
}

class TrieNode {
    char val;
    TrieNode[] children = new TrieNode[26];

    public TrieNode() {}
}


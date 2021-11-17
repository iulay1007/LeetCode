import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 318. 最大单词长度乘积
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 *
 *
 *
 * 示例 1:
 *
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * 示例 2:
 *
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 *
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 * */
public class Solution318 {
    public int maxProduct(String[] words) {
        int max = 0;
        int []wordNum = new int[words.length];
        for(int i = 0 ;i< wordNum.length;i++){
            for(int j = 0;j<words[i].length();j++){
             wordNum[i]|=1<<(words[i].charAt(j)-'a');
            }
        }

        for(int i =0;i< wordNum.length-1;i++){
            for(int j = i+1;j< wordNum.length;j++){
                if((wordNum[i] & wordNum[j]) == 0)
                    max = Math.max(words[i].length()*words[j].length(),max);
            }
        }
        return max;

    }
}


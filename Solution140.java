/*
140. 单词拆分 II
给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。

说明：

分隔时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
输出:
[
  "cats and dog",
  "cat sand dog"
]
示例 2：

输入:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
输出:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
解释: 注意你可以重复使用字典中的单词。
示例 3：

输入:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
输出:
[]
*/
import java.util.ArrayList;
import java.util.List;

public class Solution140 {
    List<String> result=new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        char ch[]=s.toCharArray();
        backtrack(s,wordDict,ch,"","",0);
        return result;
    }
    void backtrack(String s,List<String> wordDict,char ch[],String path,String track,int start)
    {

        String temp_out="";
        if (wordDict.contains(track))
        {
            temp_out=path+" "+track;
            String this_temp=path;
            path=temp_out;
            if(start<ch.length)
                backtrack(s,wordDict,ch,new String(this_temp),track+ch[start],start+1);
            track="";
        }
        if(temp_out.replace(" ", "").equals(s))
        {
            path=path.trim();
            System.out.println(path);
            result.add(path);
            path="";
        }

        for(int i=start;i<ch.length;i++)
        {
            String temp=track+ch[i];
            String temp_path=path;
            backtrack(s,wordDict,ch,temp_path,temp,i+1);
        }

    }

}

import java.util.ArrayList;
import java.util.List;

/*
131. 分割回文串
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

返回 s 所有可能的分割方案。

示例:

输入: "aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]
*/
public class Solution131 {
    class Solution {
        public List<List<String>> result=new ArrayList<List<String>>();
        public List<List<String>> partition(String s) {
            List<String> track=new ArrayList<>();
            backtrack(s,track,0);
            return result;

        }
        private void backtrack(String str,List<String> track,int s) {
            if(s>=str.length())
            {
                result.add(new ArrayList<>(track));
                return;

            }

            for(int i=s;i<str.length();i++){
                if(!checkPalindrome(str,s,i))
                    continue;

                track.add(str.substring(s,i+1));

                backtrack(str,track,i+1);

                track.remove(track.size()-1);

            }

        }

        private boolean checkPalindrome(String str, int left, int right) {
            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

    }}
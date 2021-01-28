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
    public List<List<String>> result=new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
    // char ch[]=s.toCharArray();
     List<String> track=new ArrayList<>();
     int count=0;
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
            backtrack(str,track,s+1);
            track.remove(track.size()-1);
            //if(track.size()>0)
            //track.remove(track.size()-1);
           //count-= track.get(track.size()-1).length();

        }

    }

    private boolean checkPalindrome(String str, int left, int right) {
        // 严格小于即可
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }



}
/*public List<List<String>> result=new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
     char ch[]=s.toCharArray();
     List<String> track=new ArrayList<>();
     int count=0;
     backtrack(ch,track,0,count);
        return result;

    }

    private void backtrack(char ch[],List<String> track,int s,int count) {
        if(s==ch.length&&count==ch.length)
        {
            result.add(new ArrayList<>(track));
            return;

        }
        String temp="";
        for(int i=s;i<ch.length;i++){
            if(ch[s]==ch[i])
            {
                temp+=ch[i];
                track.add(temp);
                count++;
                 backtrack(ch,track,s+1,count);
            }
            else if(i+1<ch.length&&ch[s]==ch[i+1])
            {
                 temp=temp+ch[i]+ch[i+1];
                track.add(temp);
                count+=2;
                backtrack(ch,track,s+2,count);
            }

            if(track.size()>0)
          {

             count-= track.get(track.size()-1).length();
            track.remove(track.size()-1);

        }}

    }
}
*/
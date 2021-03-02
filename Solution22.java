import java.util.ArrayList;
import java.util.List;

public class Solution22 {
   
        public List<String> generateParenthesis(int n)  {
            if(n==0)
                return null;
            List<String> result=new ArrayList<>();
            String track="";
            backtrack(n,n,track,result);
            return result;
        }

        private void backtrack(int left ,int right,String track,List<String> result) {
            if(right<left||left<0||right<0)
                return;
            else if(left==0&&right==0)
            {
                result.add(track);
                return;
            }
            backtrack(left-1,right,track+"(",result);
            backtrack(left,right-1,track+")",result);
        }
    }
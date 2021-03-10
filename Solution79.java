class Solution {
     public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        if(h==1&&w==1)
        {
           for(int i=0;i<word.length();i++)
           {
               if(word.charAt(i)==board[0][0])
                   continue;
               else return false;
           }
           return true;
        }
        boolean visited[][]=new boolean[h][w];
        String find="";
        visited[0][0]=true;
      return   backtrack(board,visited,word,0,0,find,0,h,w);
    }

    private boolean backtrack(char[][] board,boolean[][] visited, String word,int sr,int sc,String find,int findWordPosition,int h,int w) {
         if(sr>h||sr<0||sc>w||sc<0)
           return false;
        if(find.equals(word))
            return true;
        for(int i=sr;i<h;i++)

            for(int j=sc;j<w;j++)
            {
                if(board[i][j]==word.charAt(findWordPosition))
                {
                    visited[i][j]=true;
                    String temp=find;
                    temp+=board[i][j];
                    findWordPosition++;
                    if(j+1<w&&visited[i][j+1]==false)
                    {   visited[i][j+1]=true;
                  if(  backtrack(board,visited,word,sr,sc+1,temp,findWordPosition,h,w))
                      return true;
                    visited[i][j+1]=false;
                    }

                    if(j-1>=0&&visited[i][j-1]==false)
                    {   visited[i][j-1]=true;
                        if(  backtrack(board,visited,word,sr,sc-1,temp,findWordPosition,h,w))
                            return true;
                        visited[i][j-1]=false;
                    }


                    if(i+1<h&& visited[i+1][j]==false){
                    visited[i+1][j]=true;
                  if(  backtrack(board,visited,word,sr+1,sc,temp,findWordPosition,h,w))
                      return true;
                    visited[i+1][j]=false;
                    }

                    if(i-1>=0&&visited[i-1][j]==false){
                        visited[i-1][j]=true;
                        if(  backtrack(board,visited,word,sr-1,sc,temp,findWordPosition,h,w))
                            return true;
                        visited[i-1][j]=false;
                    }
                    findWordPosition--;


                }

            }
        return false;
    }
}
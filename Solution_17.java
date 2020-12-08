import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_17 {

    List list=new ArrayList<char []>();
    List result=new ArrayList<String>();
    char ch1[]= {'a','b','c'};
    char ch2[]={'d','e','f'};
    char ch3[]={'g','h','i'};
    char ch4[]={'l','j','k'};
    char ch5[]={'m','n','o'};
    char ch6[]={'p','q','r','s'};
    char ch7[]={'t','u','v'};
    char ch8[]={'w','x','y','z'};


    public List<String> letterCombinations(String digits) {
        list.add(ch1);
        list.add(ch2);
        list.add(ch3);
        list.add(ch4);
        list.add(ch5);
        list.add(ch6);
        list.add(ch7);
        list.add(ch8);
        char ch[]=new char[digits.length()];
        ch=digits.toCharArray();
        int num[]=new int[digits.length()];
        for(int i=0;i<digits.length();i++)
            num[i]=ch[i]-'0'-1;


}

    char dfs(int num[],int pos,String temp){
        if(pos> num.length)
            list.add(temp);
       else if(pos<= num.length)
        {

       char ch[]= (char[]) list.get(num[pos]);
       for(int i=0;i<ch.length;i++)
           temp+=dfs(num,pos+1,temp);
    }
        //return ;

}
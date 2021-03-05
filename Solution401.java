import java.util.ArrayList;
import java.util.List;
/*
输入: n = 1
返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-watch
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class Solution401 {
    List<String> list=new ArrayList<>();
    public List<String> readBinaryWatch(int num) {

        if(num==0) {
            list.add("0:00");
            return list;
        }
        backtrackone(num,0,0,0,0);
        return list;
    }

    void backtrackone(int num,int min,int sec,int s,int in){
        String temp="";
        int numb=num;
        if(num<0)
            return;
     /*  if(num==0&&min<=11&&s<=59) {
            temp=min+":"+sec;
            list.add(temp);
            return;
        }*/
        int nums[]={0,1,2,4,8,1,2,4,8,16,32};
        for(int i=s;i<=4;i++,in++)
        {
            if(s<=4)
                min=min+nums[in];

            if(i!=0)
                num--;
            if(num==0&&min<=11&&sec<=59) {
                temp=min+":"+sec;
                if(list.contains(temp)==false)
                    list.add(temp);
                num=numb;
                //min=0;
            }

            if(num<0)
                return;
            if(i!=0&&s<=4)
                backtrackone(num,min,0,s+1,in);
            min=min-nums[in];
            num++;
            //  backtracktwo(num,min,sec);

        }


    }
   /* void backtracktwo(int num,int min,int sec){
        String temp="";
        if(num<0)
        return;
        if(num==0) {
            temp=min+":"+sec;
            list.add(temp);
            return;
        }
        for(int i=0;i<=6;i++)
        {
            if(num<=0)
            return;
            if(num!=0)
            sec+= i;
            if(i!=0)
            num--;
            if(num<=0)
            return;
            backtracktwo(num,min,sec);
           
        }

    }*/
}
package 剑指offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution506 {
    public String[] findRelativeRanks(int[] score) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<score.length;i++){
            map.put(score[i],i);
        }
        Arrays.sort(score);
        String[] res = new String[score.length];
        for(int i = score.length-1 ;i>=0;i--){
           if(i == score.length-1){
            res[map.get(score[i])] ="Gold Medal";
           }
           else if( i == score.length-2){
               res[map.get(score[i])] ="Silver Medal";
           }

            else if( i == score.length-3){
                res[map.get(score[i])] ="Bronze Medal";
            }
            else {
               res[map.get(score[i])] = score.length-i+"";
           }


        }
        return res;
    }
}

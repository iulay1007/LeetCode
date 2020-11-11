/*242. 有效的字母异位词
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？*/ 
#include<stdio.h>
void px(char *str,int length){
  
    for(int i=0;i<length-1;i++)
    for(int j=0;j<length-i-1;j++)
    {
        if(str[j]>str[j+1])
        {
         	char ch=str[j];
            str[j]=str[j+1];
            str[j+1]=ch;

        }
    }

    
    
    

}
//冒泡排序超时！ 
bool isAnagram(char * s, char * t){
    int i=0;
    int size1=0;
    int size2=0;
    while(s[i]!='\0')
    {
        i++;
    }
    size1=i;
    i=0;
     while(t[i]!='\0')
    {
        i++;
    }
    size2=i;
    if(size1!=size2)
    return false;
    px(s,size1);
    px(t,size2);
    for(int i=0;i<size1;i++){
        if(s[i]==t[i])
        continue;
        else
        return false;

    }
    return true;

}

//桶排序可以的 
bool isAnagram2(char * s, char * t){
char sh[26]={0};
char th[26]={0};
int i=0;
while(s[i]!='\0') {
	sh[s[i]-97]++;
	i++;
}
i=0;
while(t[i]!='\0') {
	th[t[i]-97]++;
	i++;
}
for(int i=0;i<26;i++)
if(sh[i]==th[i])
continue;
else return false;


return true;
}
int main(){
	

	char s[]="anagram";
	char t[]="nagaram";

	isAnagram(s,t);
	printf("%s\n",s);
	printf("%s",t);
//	if(isAnagram(s,t)==true)
//	printf("true");
//	else printf("false");
	
}
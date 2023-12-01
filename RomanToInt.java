class Solution {
    public int romanToInt(String s) {
        int ans=0;
        char[] cs=s.toCharArray();
        char c1,c2;
        c1= cs[0];
        for(int i=0,end =cs.length;i<end;i++){
            if(i==end-1){
                c2=' ';
            }else{
                c2=cs[i+1];
            }
            switch(c1){
                case 'I':{
                    ans+=(c2=='V' || c2=='X')?-1:1;
                    break;
                }
                case 'V':{
                    ans+=5;
                    break;
                }
                case 'X':{
                    ans+=(c2=='L' || c2=='C')?-10:10;
                    break;
                }
                case 'L':{
                    ans+=50;
                    break;
                }
                case 'C':{
                    ans+=(c2=='D' || c2=='M')?-100:100;
                    break;
                }
                case 'D':{
                    ans+=500;
                    break;
                }
                case 'M':{
                    ans+=1000;
                    break;
                }
                case 'A':
                    break;
            }
            c1=c2;
        }
        return ans;
    }
}
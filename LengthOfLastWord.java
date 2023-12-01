class Solution {
	//更快的是从末尾开始统计
    public int lengthOfLastWord(String s) {
        char[] cs = s.toCharArray();
        int size=0;
        int i=0;
        int n=cs.length;
        while(i<n){
            if(cs[i]!=' '){
                size=1;
                i++;
                while(i<n && cs[i]!=' '){
                    size++;
                    i++;
                }
            }
            i++;
        }
        return size;
    }
}
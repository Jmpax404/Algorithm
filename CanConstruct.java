class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] hb=new int[128];
        char[] rs = ransomNote.toCharArray();
        char[] ms = magazine.toCharArray();
        for(char c:ms){
            hb[c]++;
        }
        for(char c:rs){
            int m = hb[c];
            if(m==0){
                return false;
            }
            hb[c]--;
        }
        return true;
    }
}
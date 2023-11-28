public class Main {

    public int candy1(int[] ratings) {
        int n = ratings.length;
        int ret = 1;    //用于记录答案
        //pre用于记录前一个同学分得的糖果数量
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if(ratings[i] >= ratings[i-1]){
                //处于递增序列中
                dec = 0;    //递减序列长度在递增序列中始终为0
                pre = ratings[i] == ratings[i- 1] ? 1 : pre+1;  //当前同学和上一个同学分数相等时，直接分配1个就行，这样满足最小
                ret += pre;
                inc = pre;      //inc用于记录上一个递增序列的长度

            }else {
                //处于递减序列中
                dec++;
                if(dec == inc){
                    //当递减序列长度和递增序列长度相等时，把递增序列的最后一个同学分配到递减序列中
                    dec++;
                }
                ret += dec; //这里加的dec相当于把递减序列翻转后加的每个同学的糖果数量
                pre = 1;    //pre在递减序列中没有意义，因为我肯定比前一个同学少；

            }
        }
        return ret;

    }

    public int candy(int[] ratings) {
        int n =ratings.length;
        int[] candies=new int[n];
        candies[0]=1;
        for (int i = 1; i < n; i++) {
            if(ratings[i]>ratings[i-1]){
                candies[i]=candies[i-1]+1;
            }else {
                candies[i]=1;
            }
        }
        int sum=candies[n-1];
        for(int i =n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1] && candies[i]<=candies[i+1]){
                candies[i]=candies[i+1]+1;
            }
            sum+=candies[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        new Main().candy(new int[]{1,2,3,3,3,2});
    }
}
public class Main_FullPermutation {

    static int n;
    static int[] table;

    static int[] arr;

    static void generate(int index){
        for (int i=0;i<n;i++){
            if(table[i]==0){
                table[i]=1;
                arr[index]=i+1;
                if(index<n-1){
                    generate(index+1);
                }else {
                    for(int j =0;j<n;j++){
                        System.out.print(arr[j]);
                    }
                    System.out.println();
                }
                table[i]=0;
                arr[index]=0;
            }
        }
    }

    public static void main(String[] args) {
        n=3;
        table=new int[n];
        arr=new int[n];
        generate(0);
    }
}
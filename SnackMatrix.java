import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int colNum = 1;
        for (int i = 0; i < n; i++) {
            int rowNum = colNum;
            System.out.print(rowNum);
            rowNum += i + 2;
            for (int j = 3, end = n - i + 1; j <= end; j++) {
                System.out.print( " " + rowNum );
                rowNum += i + j;
            }
            colNum += i + 1;
            System.out.println();
        }
    }
}
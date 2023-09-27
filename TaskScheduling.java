import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            Pattern pattern = Pattern.compile("Task.*?[(,)]");
            ArrayList<HashSet<Integer>> matrix = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                Matcher matcher = pattern.matcher(s);
                HashSet<Integer> list = new HashSet<>();
                matcher.find();
                while (matcher.find()) {
                    list.add(Integer.parseInt(s.substring(matcher.start() + 4, matcher.end() - 1)));
                }
                matrix.add(list);
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> matrix.get(n1).contains(n2) ? 1 : (n1 - n2));
            for (int i = 0; i < n; i++) {
                pq.add(i);
            }
            System.out.print("Task" + pq.poll());
            while (!pq.isEmpty()) {
                System.out.print(" Task" + pq.poll());
            }
            System.out.println();
        }
    }

}
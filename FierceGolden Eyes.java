import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {//multiple use cases
            int n = sc.nextInt();
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int id = sc.nextInt();
                Set<Integer> set = map.get(id);
                if (set == null) {//different rows can have the same problem
                    set = new HashSet<>();
                }
                int m = sc.nextInt();
                for (int j = 0; j < m; j++) {
                    int ansId = sc.nextInt();
                    if (ansId != id) {//it can answer own question
                        set.add(ansId);
                    }
                }
                map.put(id, set);
            }
            Set<Integer> frauds = new HashSet<>();
            for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                Integer key = entry.getKey();
                Set<Integer> set = entry.getValue();
                for (Integer t : set) {
                    Set<Integer> answers = map.get(t);
                    //some people could not make its question
                    if (answers != null && answers.contains(key)) {
                        frauds.add(key);
                        frauds.add(t);
                    }
                }
            }
            for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                Integer key = entry.getKey();
                Set<Integer> set = entry.getValue();
                if (!frauds.contains(key)) {
                    int c = 0;
                    for (Integer t : set) {
                        if (frauds.contains(t)) {
                            c++;
                        }
                        if (c == 2) {
                            frauds.add(key);
                            break;
                        }
                    }
                }
            }
            System.out.println(frauds.size());
            //should not output the blank line when the size is 0
            if (!frauds.isEmpty()) {
                Iterator<Integer> it = frauds.iterator();
                if (it.hasNext()) {
                    System.out.print(it.next());
                }
                while (it.hasNext()) {
                    System.out.print(" " + it.next());
                }
                System.out.println();
            }
        }
    }

}
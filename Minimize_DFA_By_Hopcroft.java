import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DFA {

    private Set<Integer> states;
    private Set<Character> alphabet;
    private int initialState;
    private Set<Integer> finalStates;
    private Map<Integer, Map<Character, Integer>> transitions;

    public DFA(Set<Integer> states, Set<Character> alphabet, int initialState, Set<Integer> finalStates, Map<Integer, Map<Character, Integer>> transitions) {
        this.states = states;
        this.alphabet = alphabet;
        this.initialState = initialState;
        this.finalStates = finalStates;
        this.transitions = transitions;
    }

    public DFA minimize() {
        Set<Set<Integer>> partition = hopcroft();
        Set<Integer> newStates = new HashSet<>();
        Set<Character> newAlphabet = new HashSet<>(alphabet);
        int newInitialState = initialState;
        Set<Integer> newFinalStates = new HashSet<>();
        Map<Integer, Map<Character, Integer>> newTransitions = new HashMap<>();
        Map<Integer, Integer> mapping = new HashMap<>();
        int i = 0;
        for (Set<Integer> set : partition) {
            for (Integer state : set) {
                mapping.put(state, i);
                if (finalStates.contains(state)) {
                    newFinalStates.add(i);
                }
            }
            newTransitions.put(i, new HashMap<>());
            newStates.add(i);
            i++;
        }
        for (Map.Entry<Integer, Map<Character, Integer>> entry : transitions.entrySet()) {
            Map<Character, Integer> newMap = newTransitions.get(mapping.get(entry.getKey()));
            for (Map.Entry<Character, Integer> valueEntry : entry.getValue().entrySet()) {
                newMap.put(valueEntry.getKey(), mapping.get(valueEntry.getValue()));
            }
        }
        return new DFA(newStates, newAlphabet, newInitialState, newFinalStates, newTransitions);
    }

    private Set<Set<Integer>> hopcroft() {
        Set<Set<Integer>> partition = new HashSet<>();
        Set<Integer> nonFinalStates = new HashSet<>(states);
        nonFinalStates.removeAll(finalStates);
        partition.add(finalStates);
        partition.add(nonFinalStates);
        Set<Set<Integer>> nextP = new HashSet<>(partition);
        Queue<Set<Integer>> workList = new LinkedList<>(partition);
        while (!workList.isEmpty()) {
            Set<Integer> s = workList.poll();
            for (char c : alphabet) {
                Set<Integer> image = new HashSet<>();
                for (Integer x : states) {
                    Map<Character, Integer> map = transitions.get(x);
                    if (map != null) {
                        Integer xc = map.get(c);
                        if (xc != null && s.contains(xc)) {
                            image.add(x);
                        }
                    }
                }
                Set<Set<Integer>> partitionTemp = new HashSet<>();
                for (Set<Integer> q : partition) {
                    Set<Integer> q1 = new HashSet<>(q);
                    q1.retainAll(image);
                    Set<Integer> q2 = new HashSet<>(q);
                    q2.removeAll(q1);
                    if (!q1.isEmpty() && !q2.isEmpty()) {
                        nextP.remove(q);
                        nextP.add(q1);
                        nextP.add(q2);
                        if (workList.contains(q)) {
                            workList.remove(q);
                            workList.add(q1);
                            workList.add(q2);
                        } else if (q1.size() <= q2.size()) {
                            workList.add(q1);
                        } else {
                            workList.add(q2);
                        }
                        if (s.equals(q)) {
                            break;
                        }
                    } else {
                        partitionTemp.add(q);
                    }
                }
                partition = new HashSet<>(partitionTemp);
            }
            partition = new HashSet<>(nextP);
        }
        return partition;
    }

    public static DFA inputDFA() {
        Set<Integer> states = new HashSet<>();
        Set<Character> alphabet = new HashSet<>();
        int initialState = 0;
        Set<Integer> finalStates = new HashSet<>();
        Map<Integer, Map<Character, Integer>> transitions = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        Pattern pattern0 = Pattern.compile("q.*?,");
        Pattern pattern2 = Pattern.compile("q.*?[a-z]");
        String s0 = sc.nextLine() + ",";
        Matcher matcher0 = pattern0.matcher(s0);
        while (matcher0.find()) {
            int value = Integer.parseInt(s0.substring(matcher0.start() + 1, matcher0.end() - 1));
            states.add(value);
            transitions.put(value, new HashMap<>());
        }
        String s1 = sc.nextLine() + ",";
        matcher0 = pattern0.matcher(s1);
        while (matcher0.find()) {
            int value = Integer.parseInt(s1.substring(matcher0.start() + 1, matcher0.end() - 1));
            states.add(value);
            finalStates.add(value);
            transitions.put(value, new HashMap<>());
        }
        while (sc.hasNextLine()) {
            String s2 = sc.nextLine() + "x";
            Matcher matcher2 = pattern2.matcher(s2);
            matcher2.find();
            int startState = Integer.parseInt(s2.substring(matcher2.start() + 1, matcher2.end() - 1));
            String s3 = s2.substring(matcher2.end() - 1, s2.indexOf('-') - 1);
            String[] s3s = s3.split("\\|");
            matcher2.find();
            int endState = Integer.parseInt(s2.substring(matcher2.start() + 1, matcher2.end() - 1));
            for (String symbol : s3s) {
                alphabet.add(symbol.charAt(0));
                Map<Character, Integer> map = transitions.get(startState);
                map.put(symbol.charAt(0), endState);
            }
        }
        return new DFA(states, alphabet, initialState, finalStates, transitions);
    }

    public void outputDFA() {
        Set<Integer> nonFinalStates = new HashSet<>(states);
        nonFinalStates.removeAll(finalStates);
        System.out.print("NonAccept: ");
        Iterator<Integer> it = nonFinalStates.iterator();
        if (it.hasNext()) {
            System.out.print("q" + it.next());
        }
        while (it.hasNext()) {
            System.out.print(",q" + it.next());
        }
        System.out.println();
        System.out.print("Accept: ");
        it = finalStates.iterator();
        if (it.hasNext()) {
            System.out.print("q" + it.next());
        }
        while (it.hasNext()) {
            System.out.print(",q" + it.next());
        }
        System.out.println();
        for (Map.Entry<Integer, Map<Character, Integer>> entry : transitions.entrySet()) {
            Map<Integer, List<Character>> output = new HashMap<>();
            for (Map.Entry<Character, Integer> valueEntry : entry.getValue().entrySet()) {
                List<Character> list = output.get(valueEntry.getValue());
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(valueEntry.getKey());
                output.put(valueEntry.getValue(), list);
            }
            for (Map.Entry<Integer, List<Character>> outputEntry : output.entrySet()) {
                System.out.print("q" + entry.getKey());
                List<Character> list = outputEntry.getValue();
                Iterator<Character> charIt = list.iterator();
                if (charIt.hasNext()) {
                    System.out.print(charIt.next());
                }
                while (charIt.hasNext()) {
                    System.out.print("|" + charIt.next());
                }
                System.out.print(" -> q" + outputEntry.getKey());
                System.out.println();
            }
        }
    }

}

public class Main2 {

    public static void main(String[] args) {
        DFA dfa = DFA.inputDFA();
        DFA dfaMin = dfa.minimize();
        dfaMin.outputDFA();
    }

}
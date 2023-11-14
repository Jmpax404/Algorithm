import java.util.*;

class TuringMachine {
    final static Character BLANK_SYMBOL = '␣';
    public final static String ROTOR_1 = "entoyhwlrbdqvzigucsafkjmxp";
    public final static String ROTOR_2 = "kuqzhrwoecfsibgxdanmjytvlp";
    public final static String ROTOR_3 = "vnykhwemaxcpotzlrgjdiufqsb";
    public final static String REFLACTOR = "badcfehgjilknmporqtsvuxwzy";

    class MappingResult {
        String state;
        boolean isRight;
        char value;

        public MappingResult(String state, char value, boolean isRight) {
            this.state = state;
            this.isRight = isRight;
            this.value = value;
        }
    }

    Set<Integer> states;
    Set<Character> alphabet;
    String initialState;
    String acceptState;
    String rejectState;
    Map<String, Map<Character, MappingResult>> transitions;

    public boolean run(String str) {
        str = TuringMachine.BLANK_SYMBOL + str + TuringMachine.BLANK_SYMBOL;
        char[] cs = str.toCharArray();
        int currentPosition = 1;
        String currentState = initialState;
        while (true) {// can be an infinite loop
            if (currentState.equals(acceptState)) {
                StringBuilder sb = new StringBuilder();
                for (char c : cs) {
                    if (c != TuringMachine.BLANK_SYMBOL) {
                        sb.append(c);
                    }
                }
                System.out.println(sb);
                return true;
            } else if (currentState.equals(rejectState)) {
                return false;
            }
            Map<Character, MappingResult> characterStateWithDirectionMap = transitions.get(currentState);
            {// extra work
                if (characterStateWithDirectionMap == null && currentState.endsWith("e2")) {
                    int hour = cs[0] - 'a';
                    int minute = cs[1] - 'a';
                    int second = cs[2] - 'a';
                    char currentHandle = cs[new String(cs).lastIndexOf('#') - 1];
                    char currentHandle1 = ROTOR_1.charAt((currentHandle - 'a' + second) % 26);
                    char currentHandle2 = ROTOR_2.charAt((currentHandle1 - 'a' + minute) % 26);
                    char currentHandle3 = ROTOR_3.charAt((currentHandle2 - 'a' + hour) % 26);
                    char currentHandle4 = REFLACTOR.charAt((currentHandle3 - 'a'));
                    char currentHandle5 = (char) ((ROTOR_3.indexOf(currentHandle4) + 26 - hour) % 26 + 'a');
                    char currentHandle6 = (char) ((ROTOR_2.indexOf(currentHandle5) + 26 - minute) % 26 + 'a');
                    char currentHandle7 = (char) ((ROTOR_1.indexOf(currentHandle6) + 26 - second) % 26 + 'a');
                    System.out.printf("0:%c 1:%c 2:%c 3:%c 4:%c 5:%c 6:%c 7:%c\n", currentHandle, currentHandle1,
                            currentHandle2, currentHandle3, currentHandle4,
                            currentHandle5, currentHandle6, currentHandle7);
                    second++;
                    if (second >= 26) {
                        second = 0;
                        minute++;
                    }
                    cs[2] = (char) (second + 'a');
                    if (minute >= 26) {
                        minute = 0;
                        hour++;
                    }
                    cs[1] = (char) (minute + 'a');
                    if (hour >= 26) {
                        hour = 0;
                    }
                    cs[0] = (char) (hour + 'a');
                    System.out.println(new String(cs));
                    cs[new String(cs).lastIndexOf('#') - 1] = currentHandle7;
                    System.out.println(new String(cs));
                    currentPosition = new String(cs).lastIndexOf('#');
                    characterStateWithDirectionMap = new HashMap<Character, MappingResult>() {{
                        put('#', new MappingResult("10", '#', true));
                    }};
                }
            }
            MappingResult mappingResult = characterStateWithDirectionMap.get(cs[currentPosition]);
            cs[currentPosition] = mappingResult.value;
            int tempPosition = currentPosition + (mappingResult.isRight ? 1 : -1);
            if (tempPosition < 0) {
                cs = (TuringMachine.BLANK_SYMBOL + String.valueOf(cs)).toCharArray();
                tempPosition = 0;
            } else if (tempPosition >= cs.length) {
                cs = (String.valueOf(cs) + TuringMachine.BLANK_SYMBOL).toCharArray();
                tempPosition = cs.length - 1;
            }
            {//output TM state
                for (int i = 0; i < tempPosition; i++) {
                    System.out.print(cs[i]);
                }
                System.out.print("[q" + currentState + "]");
                for (int i = tempPosition; i < cs.length; i++) {
                    System.out.print(cs[i]);
                }
                System.out.format("\t\tq%s -%c-> q%s\n",
                        currentState, mappingResult.isRight ? 'R' : 'L', mappingResult.state);
            }
            currentState = mappingResult.state;
            currentPosition = tempPosition;
        }
    }
}


class EnigmaTuringMachine extends TuringMachine {

    public EnigmaTuringMachine() {
        super();
        states = new HashSet<>();
        String alphabetStr = "abcdefghijklmnopqrstuvwxyz";
        alphabet = new HashSet<>();
        for (char c : alphabetStr.toCharArray()) {
            alphabet.add(c);
        }
        initialState = "0";
        acceptState = "33";
        rejectState = "-1";
        transitions = new HashMap<String, Map<Character, MappingResult>>() {{
            put("0", new HashMap<Character, MappingResult>() {{
                for (char c : alphabet) {
                    put(c, new MappingResult("1", c, false));
                }
            }});
            put("1", new HashMap<Character, MappingResult>() {{
                put(TuringMachine.BLANK_SYMBOL, new MappingResult("2", '#', false));
            }});
            put("2", new HashMap<Character, MappingResult>() {{
                put(TuringMachine.BLANK_SYMBOL, new MappingResult("3", '#', false));
            }});
            put("3", new HashMap<Character, MappingResult>() {{
                put(TuringMachine.BLANK_SYMBOL, new MappingResult("4", 'a', false));
            }});
            put("4", new HashMap<Character, MappingResult>() {{
                put(TuringMachine.BLANK_SYMBOL, new MappingResult("5", 'a', false));
            }});
            put("5", new HashMap<Character, MappingResult>() {{
                put(TuringMachine.BLANK_SYMBOL, new MappingResult("6", 'a', true));
            }});//
            put("6", new HashMap<Character, MappingResult>() {{
                put('a', new MappingResult("7", 'a', true));
            }});
            put("7", new HashMap<Character, MappingResult>() {{
                put('a', new MappingResult("8", 'a', true));
            }});
            put("8", new HashMap<Character, MappingResult>() {{
                put('#', new MappingResult("9", '#', true));
            }});
            put("9", new HashMap<Character, MappingResult>() {{
                put('#', new MappingResult("10", '#', true));
            }});
            put("10", new HashMap<Character, MappingResult>() {{
                int i = 0;
                for (char c : alphabet) {
                    final int fi = i;
                    put(c, new MappingResult("a" + fi, '#', false));
                    i++;
                }
                put(TuringMachine.BLANK_SYMBOL, new MappingResult("30", TuringMachine.BLANK_SYMBOL, false));
            }});
            int i = 0;
            for (char c : alphabet) {
                final int fi = i;
                put("a" + i, new HashMap<Character, MappingResult>() {{
                    put('#', new MappingResult("11", c, true));
                }});
                i++;
            }
            put("11", new HashMap<Character, MappingResult>() {{
                put('#', new MappingResult("12", '#', false));
            }});
            // aaa#[q]a#bcde. start handling
            put("12", new HashMap<Character, MappingResult>() {{
                for (char c : alphabet) {
                    put(c, new MappingResult("12", c, false));
                }
                put('#', new MappingResult("14", '#', false));
            }});
            put("14", new HashMap<Character, MappingResult>() {{
                int i = 0;
                for (char c : alphabet) {
                    final int fi = i;
                    put(c, new MappingResult("b" + fi, c, false));
                    i++;
                }
            }});
            List<Character> alphabetList = new ArrayList<>(alphabet);
            for (int ki = 0; ki < alphabetList.size(); ki++) {
                final int fki = ki;
                put("b" + ki, new HashMap<Character, MappingResult>() {{
                    int j = 0;
                    for (char c2 : alphabet) {
                        final int fj = j;
                        put(c2, new MappingResult("b" + fki + "c" + fj, c2, false));
                        j++;
                    }
                }});
                for (int kj = 0; kj < alphabetList.size(); kj++) {
                    final int fkj = kj;
                    put("b" + ki + "c" + kj, new HashMap<Character, MappingResult>() {{
                        int k = 0;
                        for (char c3 : alphabet) {
                            put(c3, new MappingResult("b" + fki + "c" + fkj + "d" + k + "e0", c3, true));
                            k++;
                        }
                    }});
                    for (int kk = 0; kk < alphabetList.size(); kk++) {
                        final int fkk = kk;
                        put("b" + ki + "c" + kj + "d" + kk + "e0", new HashMap<Character, MappingResult>() {{
                            put(alphabetList.get(fkj), new MappingResult("b" + fki + "c" + fkj + "d" + fkk + "e" + 1,
                                    alphabetList.get(fkj), true));
                        }});
                        put("b" + ki + "c" + kj + "d" + kk + "e" + 1, new HashMap<Character, MappingResult>() {{
                            put(alphabetList.get(fki), new MappingResult("b" + fki + "c" + fkj + "d" + fkk + "e" + 2,
                                    alphabetList.get(fki), true));
                        }});
                    }
                }
            }
            put("30", new HashMap<Character, MappingResult>() {{
                put('#', new MappingResult("31", TuringMachine.BLANK_SYMBOL, false));
            }});
            put("31", new HashMap<Character, MappingResult>() {{
                put(TuringMachine.BLANK_SYMBOL, new MappingResult("32", TuringMachine.BLANK_SYMBOL, false));
                for (char c : alphabet) {
                    put(c, new MappingResult("31", c, false));
                }
                put('#', new MappingResult("32", TuringMachine.BLANK_SYMBOL, false));
            }});
            put("32", new HashMap<Character, MappingResult>() {{
                for (char c : alphabet) {
                    put(c, new MappingResult("32", TuringMachine.BLANK_SYMBOL, false));
                }
                put(TuringMachine.BLANK_SYMBOL, new MappingResult("33", TuringMachine.BLANK_SYMBOL, false));
            }});
        }};
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a paragraph:");
        String str = sc.nextLine();
        EnigmaTuringMachine tm = new EnigmaTuringMachine();
        boolean state = tm.run(str);
    }
}
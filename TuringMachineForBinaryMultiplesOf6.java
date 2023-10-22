import java.util.*;

class TuringMachine {
    final static Character BLANK_SYMBOL = '␣';

    class StateWithDirection {
        int state;
        boolean isRight;

        public StateWithDirection(int state, boolean isRight) {
            this.state = state;
            this.isRight = isRight;
        }
    }

    Set<Integer> states;
    Set<Character> alphabet;
    int initialState;
    int acceptState;
    int rejectState;
    Map<Integer, Map<Character, StateWithDirection>> transitions;

    public boolean run(String str) {
        str = TuringMachine.BLANK_SYMBOL + str + TuringMachine.BLANK_SYMBOL;
        char[] cs = str.toCharArray();
        int currentPosition = 1;
        int currentState = initialState;
        while (true) {//can be an infinite loop
            if (currentState == acceptState) {
                return true;
            } else if (currentState == rejectState) {
                return false;
            }
            Map<Character, StateWithDirection> characterStateWithDirectionMap = transitions.get(currentState);
            StateWithDirection stateWithDirection = characterStateWithDirectionMap.get(cs[currentPosition]);
            int tempPosition = currentPosition + (stateWithDirection.isRight ? 1 : -1);
            if (tempPosition < 0) {
                tempPosition = 0;
            } else if (tempPosition >= cs.length) {
                tempPosition = cs.length - 1;
            }
            {//output TM state
                for (int i = 0; i < tempPosition - 1; i++) {
                    System.out.print(cs[i]);
                }
                System.out.print("[q" + currentState + "]");
                for (int i = tempPosition - 1; i < cs.length; i++) {
                    System.out.print(cs[i]);
                }
                System.out.format("\t\tq%d -%c-> q%d\n",
                        currentState, stateWithDirection.isRight ? 'R' : 'L', stateWithDirection.state);
            }
            currentState = stateWithDirection.state;
            currentPosition = tempPosition;
        }
    }

}


class TuringMachineForBinaryMultiplesOf6 extends TuringMachine {

    public TuringMachineForBinaryMultiplesOf6() {
        super();
        this.states = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        this.alphabet = new HashSet<>(Arrays.asList('0', '1', TuringMachine.BLANK_SYMBOL));
        this.initialState = 0;
        this.acceptState = 4;
        this.rejectState = 5;
        this.transitions = new HashMap<Integer, Map<Character, StateWithDirection>>() {{
            put(0, new HashMap<Character, StateWithDirection>() {{
                put('0', new StateWithDirection(0, true));
                put('1', new StateWithDirection(1, true));
                put(TuringMachine.BLANK_SYMBOL, new StateWithDirection(3, false));
            }});
            put(1, new HashMap<Character, StateWithDirection>() {{
                put('0', new StateWithDirection(2, true));
                put('1', new StateWithDirection(0, true));
                put(TuringMachine.BLANK_SYMBOL, new StateWithDirection(rejectState, true));
            }});
            put(2, new HashMap<Character, StateWithDirection>() {{
                put('0', new StateWithDirection(1, true));
                put('1', new StateWithDirection(2, true));
                put(TuringMachine.BLANK_SYMBOL, new StateWithDirection(rejectState, true));
            }});
            put(3, new HashMap<Character, StateWithDirection>() {{
                put('0', new StateWithDirection(acceptState, true));
                put('1', new StateWithDirection(rejectState, true));
                put(TuringMachine.BLANK_SYMBOL, new StateWithDirection(rejectState, true));
            }});
        }};
    }

}


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a binary string: ");
        String str = sc.nextLine();
        TuringMachineForBinaryMultiplesOf6 tm = new TuringMachineForBinaryMultiplesOf6();
        boolean state = tm.run(str);
        System.out.println("Can be divided by 6? " + state);
        System.out.println("----------------Validation----------------");
        int ans = 0;
        int step = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            ans += step * (str.charAt(i) - '0');
            step *= 2;
        }
        System.out.format("%d %% 6 = %d\n", ans, ans % 6);
    }

}
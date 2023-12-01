class Solution {
    public String intToRoman(int num) {
        int t0, t1, t2, t3;
        t0 = num % 10;
        num /= 10;
        t1 = num % 10;
        num /= 10;
        t2 = num % 10;
        num /= 10;
        t3 = num % 10;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t3; i++) {
            sb.append('M');
        }
        if (t2 == 9) {
            sb.append("CM");
        } else if (t2 == 4) {
            sb.append("CD");
        } else {
            if (t2 >= 5) {
                sb.append('D');
                t2 -= 5;
            }
            for (int i = 0; i < t2; i++) {
                sb.append('C');
            }
        }
        if (t1 == 9) {
            sb.append("XC");
        } else if (t1 == 4) {
            sb.append("XL");
        } else {
            if (t1 >= 5) {
                sb.append('L');
                t1 -= 5;
            }
            for (int i = 0; i < t1; i++) {
                sb.append('X');
            }
        }
        if (t0 == 9) {
            sb.append("IX");
        } else if (t0 == 4) {
            sb.append("IV");
        } else {
            if (t0 >= 5) {
                sb.append('V');
                t0 -= 5;
            }
            for (int i = 0; i < t0; i++) {
                sb.append('I');
            }
        }
        return sb.toString();
    }

    /* 两个数组，贪心啪一下，很快啊 谢谢大家 */
    public String intToRomanOthers(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] rom = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(rom[i]);
                num -= values[i];
            }
        }

        return sb.toString();
    }
}
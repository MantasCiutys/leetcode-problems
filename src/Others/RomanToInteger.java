package Others;

import LinkedList.Node;

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.
*/
public class RomanToInteger {
    private static int romanToInt(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i <= s.length() - 2) {
                if (areSymbolsSpecial(s.substring(i, i+2))) {
                    answer += getIntegerForTwoSymbols(s.substring(i, i+2));
                    i++;
                } else {
                    answer += getIntegerForSymbol(s.charAt(i));
                }
            } else {
                answer += getIntegerForSymbol(s.charAt(i));
            }
        }

        return answer;
    }

    private static int getIntegerForSymbol(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        // should never be executed
        return 0;
    }

    private static boolean areSymbolsSpecial(String s) {
        return "IV".equals(s) || "IX".equals(s) || "XL".equals(s)  || "XC".equals(s)  || "CD".equals(s)
        || "CM".equals(s);
    }

    private static int getIntegerForTwoSymbols(String s) {
        switch (s) {
            case "IV": return 4;
            case "IX": return 9;
            case "XL": return 40;
            case "XC": return 90;
            case "CD": return 400;
            case "CM": return 900;
        }
        // should never be executed
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(RomanToInteger.romanToInt("MCMXCIV"));
    }
}

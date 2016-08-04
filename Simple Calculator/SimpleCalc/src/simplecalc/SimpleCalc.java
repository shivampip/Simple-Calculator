/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalc;

public class SimpleCalc {

    static boolean error = false;
    static String eq;
    static int num[]=new int[100];

    static boolean isInt(char a) {
        String aa = "" + a;
        try {
            int aaa = Integer.parseInt(aa);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static int cal(String eq) {
        int ans = 0;
        char equa[] = new char[eq.length()];
        eq.getChars(0, eq.length(), equa, 0);

        try {
            int k = 0;
            for (int i = 0; i < eq.length(); i++) {
                if (isInt(equa[i])) {
                    num[k] = Integer.parseInt("" + equa[i]);
                    try {
                        if (isInt(equa[i + 1])) {
                            num[k] = num[k] * 10 + Integer.parseInt("" + equa[i + 1]);
                            i++;
                            try {
                                if (isInt(equa[i + 1])) {
                                    num[k] = num[k] * 10 + Integer.parseInt("" + equa[i + 1]);
                                    i++;
                                }
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e) {
                    }
                    k++;
                }
            }

            char oper[] = new char[10];
            int op = 0;
            for (char a : equa) {
                if (a == '+') {
                    oper[op] = '+';
                    op++;
                } else if (a == '-') {
                    oper[op] = '-';
                    op++;
                } else if (a == '*') {
                    oper[op] = '*';
                    op++;
                } else if (a == '/') {
                    oper[op] = '/';
                    op++;
                }

            }

            for (int pp = 0; pp < 10; pp++) {
                if (oper[pp] == '+') {
                    ans = num[0] + num[1];
                } else if (oper[pp] == '-') {
                    ans = num[0] - num[1];
                } else if (oper[pp] == '*') {
                    ans = num[0] * num[1];
                } else if (oper[pp] == '/') {
                    ans = num[0] / num[1];
                }

                num[0] = ans;
                for (int h = 1; h < 10; h++) {
                    num[h] = num[h + 1];
                }
            }
        } catch (Exception e) {
            error = true;
        }

        return ans;
    }

    public static void main(String[] args) {
        new SimpleCalcGUI().setVisible(true);
    }

}

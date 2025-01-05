package org.faye.bc.bc147;

public class P1 {
    public boolean hasMatch(String s, String p) {
        if (p.length() == 1) {
            return true;
        }

        char[] pp = p.toCharArray();

        if (pp[0] == '*') {
            String ppp = p.substring(1);
            return s.contains(ppp);
        } else if (pp[pp.length - 1] == '*') {
            String ppp = p.substring(0, p.length() - 1);
            return s.contains(ppp);
        } else {
            int index = p.indexOf('*');
            String aaa = p.substring(0, index);
            String bbb = p.substring(index + 1);
            int aaaIndex = s.indexOf(aaa);
            int bbbIndex = s.lastIndexOf(bbb);

            if (aaaIndex == -1 || bbbIndex == -1) {
                return false;
            }

            return aaaIndex + aaa.length() <= bbbIndex;
        }
    }

    public static void main(String[] args) {
        System.out.println(new P1().hasMatch("car", "c*v"));
    }
}

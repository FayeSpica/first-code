package org.faye.c.c414;

public class P1 {
    public String convertDateToBinary(String date) {
        StringBuilder sb = new StringBuilder();
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        // System.out.println("year: " + year + " month: " + month + " day: " + day);

        sb.append(Integer.toBinaryString(year));
        sb.append("-");
        sb.append(Integer.toBinaryString(month));
        sb.append("-");
        sb.append(Integer.toBinaryString(day));

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new P1().convertDateToBinary("2019-09-18"));
    }
}

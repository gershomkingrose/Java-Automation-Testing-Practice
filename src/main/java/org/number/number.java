package org.number;

public class number {

    public static String check(String n) {
        if (n.length() != 10) {
            return "notvalid";
        }

        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);

            if (c==0||c==1 || c==2||c==3||c==4||c==5||c==6||c==7||c==8||c==9) {
                return "notvalid";
            }
        }

        return "valid";
    }

    public static void main(String[] args) {
        System.out.println(check("1234567890")); // Example test case
    }
}

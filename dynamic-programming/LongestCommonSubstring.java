import java.io.*;
import java.util.*;

public class Main {

    public static int solution(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0)
            return 0;


        return lcsHelper(s1, s2, 0, 0);
    }

    private static int lcsHelper(String s1, String s2, int firstIndex, int secondIndex) {
        if (firstIndex >= s1.length() || secondIndex >= s2.length())
            return 0;

        if (s1.charAt(firstIndex) == s2.charAt(secondIndex))
            return 1 + lcsHelper(s1, s2, firstIndex + 1, secondIndex + 1);

        return Math.max(lcsHelper(s1, s2, firstIndex, secondIndex + 1),
                lcsHelper(s1, s2, firstIndex + 1, secondIndex)
        );


    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1, s2));
    }

}
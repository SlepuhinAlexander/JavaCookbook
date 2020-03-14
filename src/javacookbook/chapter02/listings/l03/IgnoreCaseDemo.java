package javacookbook.chapter02.listings.l03;

public class IgnoreCaseDemo {
    public static void main(String[] args) {
        String s = "This is a TEST.";
        System.out.println("Ignore case in search. \n" +
                "Searching for \"test\" in: " + s);
        if (s.matches("(?i).*test.*")) {
            System.out.println("\"test\" contains in the string.");
        }
        System.out.println();
        s = "alpha beta, Alpha beta, alPHa beta, ALPHA beta";
        System.out.println("Ignore case in find-and-replace.\n" +
                "Replace any \"alpha\" to \"zeta\" in: \n" +
                "  " + s);
        String result = s.replaceAll("(?i)alpha","zeta");
        System.out.println("After replacement: \n" +
                "  " + result);
    }
}
/*
* output:
* Ignore case in search.
* Searching for "test" in: This is a TEST.
* "test" contains in the string.
*
* Ignore case in find-and-replace.
* Replace any "alpha" to "zeta" in:
*   alpha beta, Alpha beta, alPHa beta, ALPHA beta
* After replacement:
*   zeta beta, zeta beta, zeta beta, zeta beta
* */

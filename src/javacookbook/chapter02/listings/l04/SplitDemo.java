package javacookbook.chapter02.listings.l04;

public class SplitDemo {
    public static void main(String[] args) {
        String[] result;
        String testSting = "This is a test.";
        System.out.println("Original string: " + testSting);
        result = testSting.split("\\s+");
        System.out.print("Splitting by whitespaces: ");
        printArray(result);

        testSting = "One, Two, and Three.";
        System.out.println("Original string: " + testSting);
        result = testSting.split("\\W+");
        System.out.print("Splitting by non-words: ");
        printArray(result);

        System.out.println("Original string: " + testSting);
        result = testSting.split(",\\s+");
        System.out.print("Splitting by commas and whitespaces: ");
        printArray(result);

        testSting = "Jerry Jerry@HerbSchildt.com";
        System.out.println("Original string: " + testSting);
        result = testSting.split("[\\W&&[^.@]]+");
        System.out.print("Splitting by whitespaces. Allowing to use '.' and '@' in words: ");
        printArray(result);

        testSting = "This, is. a!:; test?";
        System.out.println("Original string: " + testSting);
        result = testSting.split("[.,!?:;]+\\s*");
        System.out.print("Splitting by punctuation marks: ");
        printArray(result);
    }

    static void printArray(String[] strings) {
        for (String s : strings) {
            System.out.print(s + "|");
        }
        System.out.println("\n");
    }
}
/*
* output:
* Original string: This is a test.
* Splitting by whitespaces: This|is|a|test.|
*
* Original string: One, Two, and Three.
* Splitting by non-words: One|Two|and|Three|
*
* Original string: One, Two, and Three.
* Splitting by commas and whitespaces: One|Two|and Three.|
*
* Original string: Jerry Jerry@HerbSchildt.com
* Splitting by whitespaces. Allowing to use '.' and '@' in words: Jerry|Jerry@HerbSchildt.com|
*
* Original string: This, is. a!:; test?
* Splitting by punctuation marks: This|is|a|test|
* */

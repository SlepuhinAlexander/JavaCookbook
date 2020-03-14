package javacookbook.chapter02.listings.l05;

import java.util.regex.PatternSyntaxException;

public class KeyValuePairsDemo {
    public static void main(String[] args) {
        String testString = "Name = Tom, Age = 27, IDNum = 1432, Wage = 37.25";
        System.out.println("Original string of key-value pairs: " + testString);
        KeyValuePair[] keyValuePairs;
        try {
            keyValuePairs = KeyValueSplitter.getKeyValuePairs(testString, "\\s*,\\s*", "\\s*=\\s*");
        } catch (KeyValueSplitException e) {
            System.out.println("Error while getting a key-value pair.");
            return;
        } catch (PatternSyntaxException e) {
            System.out.println("Incorrect regex syntax in splitter.");
            return;
        }
        for (KeyValuePair keyValuePair : keyValuePairs) {
            System.out.println("Key: " + keyValuePair.key + "\t\tValue: " + keyValuePair.value);
        }
    }
}

class KeyValuePair {
    String key;
    String value;

    public KeyValuePair(String k, String v) {
        key = k;
        value = v;
    }
}

class KeyValueSplitException extends Exception {

}

class KeyValueSplitter {
    public static KeyValuePair[] getKeyValuePairs(String s, String pairSeparator, String keyValueSeparator)
            throws PatternSyntaxException, KeyValueSplitException {
        s = s.trim();
        String[] keyValueStrings = s.split(pairSeparator);
        KeyValuePair[] keyValuePairs = new KeyValuePair[keyValueStrings.length];
        String[] tmp;
        for (int i = 0; i < keyValueStrings.length; i++) {
            tmp = keyValueStrings[i].split(keyValueSeparator);
            if (tmp.length != 2) {
                throw new KeyValueSplitException();
            }
            keyValuePairs[i] = new KeyValuePair(tmp[0], tmp[1]);
        }
        return keyValuePairs;
    }
}

/*
* output:
* Original string of key-value pairs: Name = Tom, Age = 27, IDNum = 1432, Wage = 37.25
* Key: Name     Value: Tom
* Key: Age      Value: 27
* Key: IDNum    Value: 1432
* Key: Wage	    Value: 37.25
* */
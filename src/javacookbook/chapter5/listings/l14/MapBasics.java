package javacookbook.chapter5.listings.l14;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MapBasics {
    public static void main(String[] args) {
        TreeMap<String, Integer> atoms = new TreeMap<>();
        atoms.put("Hydrogen", 1);
        atoms.put("Oxygen", 8);
        atoms.put("Iron", 26);
        atoms.put("Copper", 29);
        atoms.put("Silver", 47);
        atoms.put("Gold", 79);
        System.out.println("The first map contains the following " + atoms.size() + " entries:");
        System.out.println(atomsToString(atoms));
        System.out.println();

        TreeMap<String, Integer> atoms2 = new TreeMap<>();
        atoms2.put("Zinc", 30);
        atoms2.put("Lead", 82);
        System.out.println("The second map contains the following " + atoms2.size() + " entries:");
        System.out.println(atomsToString(atoms2));
        System.out.println();

        System.out.println("Adding the second map to the first map");
        atoms.putAll(atoms2);
        System.out.println("Now the first map contains the following " + atoms.size() + " entries:");
        System.out.println(atomsToString(atoms));
        System.out.println();

        if (atoms.containsKey("Gold")) {
            System.out.println("Gold has the atomic number " + atoms.get("Gold"));
        }

        if (atoms.containsValue(82)) {
            System.out.println("Atomic number 82 has been found");
        }
        System.out.println();

        System.out.println("Trying to remove atom \"Gold\"");
        if (atoms.remove("Gold") != null) {
            System.out.println("Atom \"Gold\" has been removed");
        } else {
            System.out.println("Atom \"Gold\" not found");
        }
        System.out.println("After removing \"Gold\" atom, the first map contains: ");
        System.out.println("Key set: " + atoms.keySet());
        System.out.println("Values collection: " + atoms.values());
        System.out.println();

        System.out.println("Clearing the first map");
        atoms.clear();
        if (atoms.isEmpty()) {
            System.out.println("The fist map is empty");
        }
    }

    public static <K, V> String mapToString(Map<K, V> map, String keyPrefix, String valPrefix, String separator) {
        StringBuilder builder = new StringBuilder();
        Iterator<Map.Entry<K, V>> iterator = map.entrySet().iterator();
        Map.Entry<K, V> entry;
        while (iterator.hasNext()) {
            entry = iterator.next();
            builder.append(keyPrefix).append(entry.getKey());
            builder.append(valPrefix).append(entry.getValue());
            if (iterator.hasNext()) {
                builder.append(separator);
            }
        }
        return builder.toString();
    }

    public static <K, V> String atomsToString(Map<K, V> map) {
        return mapToString(map, "\tatom: ", ", atomic number: ", "\n");
    }
}
/*
 * output:
 * The first map contains the following 6 entries:
 *     atom: Copper, atomic number: 29
 *     atom: Gold, atomic number: 79
 *     atom: Hydrogen, atomic number: 1
 *     atom: Iron, atomic number: 26
 *     atom: Oxygen, atomic number: 8
 *     atom: Silver, atomic number: 47
 *
 * The second map contains the following 2 entries:
 *     atom: Lead, atomic number: 82
 *     atom: Zinc, atomic number: 30
 *
 * Adding the second map to the first map
 * Now the first map contains the following 8 entries:
 *     atom: Copper, atomic number: 29
 *     atom: Gold, atomic number: 79
 *     atom: Hydrogen, atomic number: 1
 *     atom: Iron, atomic number: 26
 *     atom: Lead, atomic number: 82
 *     atom: Oxygen, atomic number: 8
 *     atom: Silver, atomic number: 47
 *     atom: Zinc, atomic number: 30
 *
 * Gold has the atomic number 79
 * Atomic number 82 has been found
 *
 * Trying to remove atom "Gold"
 * Atom "Gold" has been removed
 * After removing "Gold" atom, the first map contains:
 * Key set: [Copper, Hydrogen, Iron, Lead, Oxygen, Silver, Zinc]
 * Values collection: [29, 1, 26, 82, 8, 47, 30]
 *
 * Clearing the first map
 * The fist map is empty
 * */

package javacookbook.chapter5.listings.l15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class PropertiesToMapDemo {
    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.setProperty("Tom", "tom@hschildt.com");
        prop.setProperty("Ken", "ken@hschildt.com");
        prop.setProperty("Ralph", "Ralph@hschildt.com");
        prop.setProperty("Steve", "Steve@hschildt.com");
        HashMap<String, String> propMap = new HashMap<>(((Map) prop));
        System.out.println("Map contents: ");
        System.out.println(mapToString(propMap, "\t", ": ", "\n"));
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
}
/*
 * output:
 * Map contents:
 *     Tom: tom@hschildt.com
 *     Ralph: Ralph@hschildt.com
 *     Steve: Steve@hschildt.com
 *     Ken: ken@hschildt.com
 * */

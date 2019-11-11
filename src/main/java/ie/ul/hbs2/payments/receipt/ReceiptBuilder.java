package ie.ul.hbs2.payments.receipt;

import javax.swing.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReceiptBuilder {

    private Map<String, String> components = new HashMap<>();

    public void addComponent(String key, String value) {
        components.put(key, value);
    }

    public String build() {
        String receipt = "Receipt from Shambles Hotel Group";

        Iterator<Map.Entry<String, String>> it = components.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> pair = it.next();
            receipt += "\n" + pair.getKey() + ": " + pair.getValue();
        }
        return receipt;
    }
}

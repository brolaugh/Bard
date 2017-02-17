package com.brolaugh.bard.datahandler;

import java.util.LinkedList;

public class RollBreakDown {
    private LinkedList<String> entries = new LinkedList<>();

    public void addEntry(String entry) {
        entries.add(entry);

    }

    public String getStringBreakdown() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < entries.size(); i++) {
            if (i > 0) {
                builder.append("\n");
                builder.append(entries.get(i));
            } else {
                builder.append(entries.get(i));
            }
        }
        return builder.toString();
    }
}

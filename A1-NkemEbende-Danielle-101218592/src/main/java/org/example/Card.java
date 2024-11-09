package org.example;

public class Card {
    // COMMIT 1 - RESP 1
    public String type;    // Adventure Event
    public String name;    // F W Q D... Plague..
    public int value;      // #'s

    public Card(String t, String n, int v) {
        this.type = t;
        this.name = n;
        this.value = v;
    }

    // getters - REFACTOR 1
    public String getType() { return type; }
    public String getName() { return name; }
    public int getValue() { return value; }

}

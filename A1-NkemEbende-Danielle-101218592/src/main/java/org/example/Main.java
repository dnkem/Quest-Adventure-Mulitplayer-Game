package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("COMP 4004 - A1");
    }

    static class Card {
        String type;    // Adventure Event
        String name;    // F W Q D... Plague..
        int value;      // #'s

        Card (String t, String n, int v){
            this.type = t;
            this.name = n;
            this.value = v;
        }
    }

    ArrayList<Card> advDeck = new ArrayList<Card>();
    ArrayList<Card> eventDeck = new ArrayList<Card>();

    public ArrayList<Card> getAdvDeck(){
        return advDeck;
    }

    public ArrayList<Card> getEventDeck(){
        return eventDeck;
    }

    public void initAdvDeck(){
        advDeck = new ArrayList<Card>();
        // add in foes
        // F5s
        Card cardF5 = new Card("Adventure","F", 5);
        for (int i=0; i<8; i++){ advDeck.add(cardF5);}
        // F10s
        Card cardF10 = new Card("Adventure","F", 10);
        for (int i=8; i<15; i++){ advDeck.add(cardF10);}
        // F15s
        Card cardF15 = new Card("Adventure","F", 15);
        for (int i=15; i<23; i++){ advDeck.add(cardF15);}
        // F20s
        Card cardF20 = new Card("Adventure","F", 20);
        for (int i=23; i<30; i++){ advDeck.add(cardF20);}
        // F25s
        Card cardF25 = new Card("Adventure","F", 25);
        for (int i=30; i<37; i++){ advDeck.add(cardF25);}
        // F30s
        Card cardF30 = new Card("Adventure","F", 30);
        for (int i=37; i<41; i++){ advDeck.add(cardF30);}
        // F35s
        Card cardF35 = new Card("Adventure","F", 35);
        for (int i=41; i<45; i++){ advDeck.add(cardF35);}
        // F40s
        Card cardF40 = new Card("Adventure","F", 40);
        for (int i=45; i<47; i++){ advDeck.add(cardF40);}
        // F50s
        Card cardF50 = new Card("Adventure","F", 50);
        for (int i=47; i<49; i++){ advDeck.add(cardF50);}
        // F70
        Card cardF70 = new Card("Adventure","F", 70);
        advDeck.add(cardF70);

        // add in weapons
        // D5s
        Card cardD5 = new Card("Adventure","D", 5);
        for (int i=50; i<56; i++){ advDeck.add(cardD5);}
        // H10s
        Card cardH10 = new Card("Adventure","H", 10);
        for (int i=56; i<68; i++){ advDeck.add(cardH10);}
        // S10s
        Card cardS10 = new Card("Adventure","S", 10);
        for (int i=68; i<84; i++){ advDeck.add(cardS10);}
        // B15s
        Card cardB15 = new Card("Adventure","B", 15);
        for (int i=84; i<92; i++){ advDeck.add(cardB15);}
        // L20s
        Card cardL20 = new Card("Adventure","L", 20);
        for (int i=92; i<98; i++){ advDeck.add(cardL20);}
        // E30s
        Card cardE30 = new Card("Adventure","E", 30);
        for (int i=98; i<100; i++){ advDeck.add(cardE30);}
    }

    public void initEventDeck(){
        eventDeck = new ArrayList<Card>();
        // add in quests
        // Q2s
        Card cardQ2 = new Card("Event","Q", 2);
        for (int i=0; i<3; i++){ eventDeck.add(cardQ2);}
        // Q3s
        Card cardQ3 = new Card("Event","Q", 3);
        for (int i=3; i<7; i++){ eventDeck.add(cardQ3);}
        // Q4s
        Card cardQ4 = new Card("Event","Q", 4);
        for (int i=7; i<10; i++){ eventDeck.add(cardQ4);}
        // Q5s
        Card cardQ5 = new Card("Event","Q", 5);
        for (int i=10; i<12; i++){ eventDeck.add(cardQ5);}

        // add in events
        // Plagues
        Card cardPlague = new Card("Event","Plague", 2);
        eventDeck.add(cardPlague);
        // Queens favor
        Card cardFavor = new Card("Event","Queen’s favor", 2);
        eventDeck.add(cardFavor);
        eventDeck.add(cardFavor);
        // Prosperity
        Card cardProsperity = new Card("Event","Prosperity", 2);
        eventDeck.add(cardProsperity);
        eventDeck.add(cardProsperity);
    }

    public int getEventDeckSize(){
        return eventDeck.size();
    }
    public int getAdvDeckSize(){
        return advDeck.size();
    }

}
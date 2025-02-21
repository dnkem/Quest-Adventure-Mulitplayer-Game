package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    public List<Card> cards;

    // ctors
    public Deck() {
        this.cards = new ArrayList<Card>(); // Properly initialized
    }
    public Deck(List<Card> c) {
        this.cards = new ArrayList<Card>();
        for (int i=0; i<c.size(); i++){
            this.cards.add(c.get(i));
        }
    }

    // getters & setters
    public List<Card> getDeck() { return cards;}
    public int getDeckSize() { return cards.size();}
    public int size() {return cards.size();}
    public Card get(int i) { return cards.get(i); }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public Card remove(int i){
        return cards.remove(i);
    }

    public Card removeLast(){
        return cards.removeLast();
    }

    public Card removeFirst(){
        return cards.removeFirst();
    }

    public void add(Card c){
        cards.add(c);
    }

    public void initEventDeck() {
        // add in quests
        // Q2s
        for (int i = 0; i < 3; i++) {
            Card cardQ2 = new Card("Event", "Q", 2);
            this.add(cardQ2);
        }
        // Q3s
        for (int i = 3; i < 7; i++) {
            Card cardQ3 = new Card("Event", "Q", 3);
            this.add(cardQ3);
        }
        // Q4s
        for (int i = 7; i < 10; i++) {
            Card cardQ4 = new Card("Event", "Q", 4);
            this.add(cardQ4);
        }
        // Q5s
        for (int i = 10; i < 12; i++) {
            Card cardQ5 = new Card("Event", "Q", 5);
            this.add(cardQ5);
        }

        // add in events
        // Plagues
        Card cardPlague = new Card("Event", "Plague", 2);
        this.add(cardPlague);
        // Queens favor
        Card cardFavor = new Card("Event", "Queen’s favor", 2);
        this.add(cardFavor);
        Card cardFavor2 = new Card("Event", "Queen’s favor", 2);
        this.add(cardFavor2);
        // Prosperity
        Card cardProsperity = new Card("Event", "Prosperity", 2);
        this.add(cardProsperity);
        Card cardProsperity2 = new Card("Event", "Prosperity", 2);
        this.add(cardProsperity2);
    }

    public void initAdvDeck() {
        // add in foes
        // F5s
        for (int i = 0; i < 8; i++) {
            Card cardF5 = new Card("Adventure", "F", 5);
            this.add(cardF5);
        }
        // F10s
        for (int i = 8; i < 15; i++) {
            Card cardF10 = new Card("Adventure", "F", 10);
            this.add(cardF10);
        }
        // F15s
        for (int i = 15; i < 23; i++) {
            Card cardF15 = new Card("Adventure", "F", 15);
            this.add(cardF15);
        }
        // F20s
        for (int i = 23; i < 30; i++) {
            Card cardF20 = new Card("Adventure", "F", 20);
            this.add(cardF20);
        }
        // F25s
        for (int i = 30; i < 37; i++) {
            Card cardF25 = new Card("Adventure", "F", 25);
            this.add(cardF25);
        }
        // F30s
        for (int i = 37; i < 41; i++) {
            Card cardF30 = new Card("Adventure", "F", 30);
            this.add(cardF30);
        }
        // F35s
        for (int i = 41; i < 45; i++) {
            Card cardF35 = new Card("Adventure", "F", 35);
            this.add(cardF35);
        }
        // F40s
        for (int i = 45; i < 47; i++) {
            Card cardF40 = new Card("Adventure", "F", 40);
            this.add(cardF40);
        }
        // F50s
        for (int i = 47; i < 49; i++) {
            Card cardF50 = new Card("Adventure", "F", 50);
            this.add(cardF50);
        }
        // F70
        Card cardF70 = new Card("Adventure", "F", 70);
        this.add(cardF70);

        // add in weapons
        // D5s
        for (int i = 50; i < 56; i++) {
            Card cardD5 = new Card("Adventure", "D", 5);
            this.add(cardD5);
        }
        // H10s
        for (int i = 56; i < 68; i++) {
            Card cardH10 = new Card("Adventure", "H", 10);
            this.add(cardH10);
        }
        // S10s
        for (int i = 68; i < 84; i++) {
            Card cardS10 = new Card("Adventure", "S", 10);
            this.add(cardS10);
        }
        // B15s
        for (int i = 84; i < 92; i++) {
            Card cardB15 = new Card("Adventure", "B", 15);
            this.add(cardB15);
        }
        // L20s
        for (int i = 92; i < 98; i++) {
            Card cardL20 = new Card("Adventure", "L", 20);
            this.add(cardL20);
        }
        // E30s
        for (int i = 98; i < 100; i++) {
            Card cardE30 = new Card("Adventure", "E", 30);
            this.add(cardE30);
        }
    }
}

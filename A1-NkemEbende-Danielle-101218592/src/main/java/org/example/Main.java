package org.example;

import org.w3c.dom.ls.LSOutput;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("COMP 4004 - A1");
        // note that the printed items don't need to actually print when test but should when the corresponding function runs in main
    }

    // COMMIT 1 - RESP 1
    class Card {
        String type;    // Adventure Event
        String name;    // F W Q D... Plague..
        int value;      // #'s

        Card (String t, String n, int v){
            this.type = t;
            this.name = n;
            this.value = v;
        }

        // getters - REFACTOR 1
        public String getType(){ return type; }
        public String getName(){ return  name; }
        public int getValue() { return value; }
    }

    ArrayList<Card> advDeck = new ArrayList<Card>();
    ArrayList<Card> eventDeck = new ArrayList<Card>();
    ArrayList<Card> discardAdvDeck = new ArrayList<Card>();
    ArrayList<Card> discardEventDeck = new ArrayList<Card>();

    public ArrayList<Card> getAdvDeck(){
        return advDeck;
    }

    public ArrayList<Card> getEventDeck(){
        return eventDeck;
    }

    public ArrayList<Card> getDiscardAdvDeck(){
        return discardAdvDeck;
    }
    public ArrayList<Card> getDiscardEventDeck(){
        return discardEventDeck;
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
    public int getDiscardAdvDeckSize(){
        return discardAdvDeck.size();
    }
    public int getDiscardEventDeckSize(){
        return discardEventDeck.size();
    }

    // COMMIT 2 - RESP 2
    public void shuffleDecks(){
        Collections.shuffle(eventDeck);
        Collections.shuffle(advDeck);
    }

    // - REFACTOR 1
    class Player{
        String id;          // P1, P2, P3, P4
        int numShields = 0;
        ArrayList<Card> cards = new ArrayList<Card>();

        Player(String ID){
            this.id = ID;
        }

        // getters and setters
        public String getID(){ return id; }
        public int getNumShields(){ return numShields; }
        public void setId(String i){this.id = i; }
        public void setNumShields(int s){ this.numShields = s; }
        public int getCardsSize(){ return cards.size(); }
        public Card getCard(int i){ return cards.get(i); }

        // Commit 7
        public String cardsToString(){
            String cards = "";
            for (int i=0; i<getCardsSize(); i++){
                cards += getCard(i).getName() + getCard(i).getValue() + " ";
            }
            return cards;
        }

        public void add(Card c){
            cards.add(c);
        }

        // COMMIT 4 - RESP 4 - REFACTOR 1
        public void printPlayersCards(PrintWriter printWriter){
            // collect player card info into a string
            String cards = "";
            for (int i=0; i<getCardsSize(); i++){
                cards += getCard(i).getName() + getCard(i).getValue() + "   ";
            }
            printWriter.println("Checks there's items in card: " + cards);

            // print into the terminal
            printWriter.println("Printing " + getID() + " Cards:");
            printWriter.printf("%s", cards);
            printWriter.flush();
            printWriter.close();
        }

        // COMMIT 5 - RESP 5
        public void drawAdvCard(){
            cards.add(advDeck.removeLast());
        }

        public void drawEventCard(){
            currentDrawnEventCard = eventDeck.removeLast();
            if (currentDrawnEventCard.getName().equals("Queen’s favor")){
                playQueenEventCard(currentPlayer);
            } else if (currentDrawnEventCard.getName().equals("Prosperity")){
                playProsperityCard(currentPlayer);
            } else if (currentDrawnEventCard.getName().equals("Plague")){
                playPlagueCard(currentPlayer);
            }

            // deal with used event card
            discardEventCard(currentDrawnEventCard);
        }

        // COMMIT 13
        public void drawQuestCard(Scanner input, PrintWriter output){
            currentDrawnEventCard = eventDeck.removeLast();
            if (currentDrawnEventCard.getName().equals("Q")){
                currentPlayer.promptSponsor(input, output, currentDrawnEventCard);
            }
            // discardEventCard(currentDrawnEventCard);
        }

        public void playQueenEventCard(Player p){
            if (currentPlayer.getID().equals(p.id) && currentDrawnEventCard.getName().equals("Queen’s favor")){
                p.drawAdvCard();
                p.drawAdvCard();
            } else {
                System.out.println("Can't draw adv cards for Queens favor event");
            }
        }

        public void playProsperityCard(Player p){
            if (currentPlayer.getID().equals(p.id) && currentDrawnEventCard.getName().equals("Prosperity")){
                p1.drawAdvCard(); p1.drawAdvCard();
                p2.drawAdvCard(); p2.drawAdvCard();
                p3.drawAdvCard(); p3.drawAdvCard();
                p4.drawAdvCard(); p4.drawAdvCard();
            } else {
                System.out.println("Can't draw adv cards for Prosperity event");
            }
        }

        // Commit 11
        public void playPlagueCard(Player p){
            if (currentPlayer.getID().equals(p.id) && currentDrawnEventCard.getName().equals("Plague")){
                if (p.getNumShields() == 0 || p.getNumShields() == 1){
                    p.numShields = 0;
                } else {
                    p.numShields -= 2;
                }
            } else {
                System.out.println("Can't do Plague  event");
            }
        }

        // Commit 13
        public void promptSponsor(Scanner input, PrintWriter output, Card c){
            System.out.println(this.getID() + " do you want to sponsor " + c.getName() + c.getValue() + " Y/N: ");
            output.println(this.getID() + " do you want to sponsor " + c.getName() + c.getValue() + " Y/N: "); output.flush();
            String inputStr = input.nextLine();

            try{
                if (inputStr.equals("Y") || inputStr.equals("N")){
                    output.println("input is valid"); output.flush();
                } else{
                    throw new Exception("wrong item");
                }
            } catch(Exception e) {
                output.println("input is not valid"); output.flush();
            }
        }

        // COMMIT 7
        public void promptPosition(Scanner input, PrintWriter output){
            output.println("Enter a Position from 1 to " + this.getCardsSize() + ": "); output.flush();
            String inputStr = input.nextLine();
            int inputNum = -1;

            try{
                inputNum = Integer.parseInt(inputStr);
                output.println("input is valid"); output.flush();
            } catch(NumberFormatException e) {
                output.println("input is not valid"); output.flush();
                return;
            }

            // delete at index
            trimCard(inputNum);
        }

        public void trimCard(int index){
            // print
            System.out.println("Cards Before Deletion:      " + cardsToString());

            // delete at index
            if (index > 0 && index <= this.getCardsSize()){
                this.discardAdvCard(cards.remove(index - 1));
                System.out.println("Deleted card at position: " + index);
            }

            // re print correctly
            System.out.println("Cards After deletion:       " + cardsToString());
        }

        public void trimToTwelve(Scanner input, PrintWriter output){
            if (getCardsSize() <= 12) return;
            int extraCards = this.getCardsSize() - 12;
            for (int i=0; i<extraCards; i++){
                promptPosition(input, output);
            }
            System.out.println(cardsToString());
        }

        public void discardAdvCard(Card c) {
            discardAdvDeck.add(c);
        }

        public void discardEventCard(Card c){
            discardEventDeck.add(c);
        }
    }

    Player p1 = new Player("P1");
    Player p2 = new Player("P2");
    Player p3 = new Player("P3");
    Player p4 = new Player("P4");


    public void distributeCards(){
        for (int j=0; j<12; j++){
            p1.drawAdvCard();
        }
        for (int j=0; j<12; j++){
            p2.drawAdvCard();
        }
        for (int j=0; j<12; j++){
            p3.drawAdvCard();
        }
        for (int j=0; j<12; j++){
            p4.drawAdvCard();
        }
    }

    // COMMIT 3 - RESP 3
    Player currentPlayer = p1;      // shallow copy
    public void nextPlayer(){
        switch (currentPlayer.id){
            case "P1":
                currentPlayer = p2;
                break;
            case "P2":
                currentPlayer = p3;
                break;
            case "P3":
                currentPlayer = p4;
                break;
            case "P4":
                currentPlayer = p1;
                break;
        }
    }

    // COMMIT 5 - RESP 5
    Card currentDrawnEventCard;

    // Commit 10
    public void clearScreen(PrintWriter printWriter){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        printWriter.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        printWriter.flush();
        printWriter.close();
    }

}
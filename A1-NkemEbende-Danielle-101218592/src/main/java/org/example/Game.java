package org.example;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Game {
    public Deck advDeck;
    public Deck eventDeck;

    // ctor1 for std deck
    public Game(){
        advDeck = new Deck();
        eventDeck = new Deck();
    }
    // ctor2 for test deck
    public Game(Deck adv, Deck event){
        this.advDeck = adv;
        this.eventDeck = event;
    }

    Deck discardAdvDeck = new Deck();
    Deck discardEventDeck = new Deck();

    public Player p1 = new Player("P1", this);
    public Player p2 = new Player("P2", this);
    public Player p3 = new Player("P3", this);
    public Player p4 = new Player("P4", this);

    public ArrayList<Player> eligiblePlayers = new ArrayList<Player>();
    public ArrayList<Player> gameWinners = new ArrayList<Player>();


    public Card currentDrawnEventCard;

    public Player sponsoringPlayer; // shallow copy of sponsoring player

    public void concludeQuest(PrintWriter output) {
        // distribute shields
        if (!eligiblePlayers.isEmpty()) {
            for (int i = 0; i < eligiblePlayers.size(); i++) {
                eligiblePlayers.get(i).setNumShields(eligiblePlayers.get(i).getNumShields() + currentDrawnEventCard.getValue());
            }
        }

        System.out.println("END OF " + currentPlayer.getID() + "'s TURN\n");
        clearScreen(output);

        // empty eligible players attack
        discardAllEligibleAttackCards();
        // empty eligible players list
        eligiblePlayers.clear();
        // discard current event drawn
        sponsoringPlayer.discardEventCard(currentDrawnEventCard);
    }

    public boolean checkForWinners() {
        ArrayList<Player> winners = new ArrayList<Player>();
        if (p1.getNumShields() >= 7) {
            winners.add(p1);
        }
        if (p2.getNumShields() >= 7) {
            winners.add(p2);
        }
        if (p3.getNumShields() >= 7) {
            winners.add(p3);
        }
        if (p4.getNumShields() >= 7) {
            winners.add(p4);
        }

        if (winners.isEmpty()) return false;
        gameWinners = winners;
        return true;
    }

    public void printWinners() {
        String w = "";
        for (int i = 0; i < gameWinners.size(); i++) {
            w += gameWinners.get(i).getID();
        }
        System.out.println("WINNER(S) of the game: " + w);
    }

    public void allEligiblePlayersAttackStage(ArrayList<Card> stage, String stageName) {
        int num = eligiblePlayers.size();
        System.out.println("STAGE: " + arrayToString(stage) + "\n");
        for (int i = num - 1; i >= 0; i--) {
            System.out.println(eligiblePlayers.get(i).getID());
            eligiblePlayers.get(i).attackStage(stage, stageName);
            System.out.println();
        }
    }

    public void discardAllEligibleAttackCards() {
        int num = eligiblePlayers.size() - 1;
        while (num >= 0) {
            eligiblePlayers.get(num).discardAttackCards();
            num--;
        }
    }

    public void participantsSetUpAttack(Scanner input, PrintWriter output) {
        clearScreen(output);
        Collections.reverse(eligiblePlayers);
        for (int i = 0; i < eligiblePlayers.size(); i++) {
            eligiblePlayers.get(i).setUpAttack(input);
            clearScreen(output);
        }
    }

    public int getValues(ArrayList<Card> array) {
        int value = 0;
        for (int i = 0; i < array.size(); i++) {
            value += array.get(i).getValue();
        }
        return value;
    }

    public String arrayToString(ArrayList<Card> array) {
        String s1 = "";
        for (int j = 0; j < array.size(); j++) {
            s1 += array.get(j).getName() + array.get(j).getValue() + " ";
        }
        return s1;
    }

    public void printEligiblePlayers() {
        System.out.println("Eligible Players for this Quest:");
        for (int i = 0; i < eligiblePlayers.size(); i++) {
            System.out.println(eligiblePlayers.get(i).getID());
        }
    }

    public void getEligiblePlayers() {
        if (sponsoringPlayer.getID().equals("P1")) {
            eligiblePlayers.add(p2);
            eligiblePlayers.add(p3);
            eligiblePlayers.add(p4);
        } else if (sponsoringPlayer.getID().equals("P2")) {
            eligiblePlayers.add(p1);
            eligiblePlayers.add(p3);
            eligiblePlayers.add(p4);
        } else if (sponsoringPlayer.getID().equals("P3")) {
            eligiblePlayers.add(p1);
            eligiblePlayers.add(p2);
            eligiblePlayers.add(p4);
        } else if (sponsoringPlayer.getID().equals("P4")) {
            eligiblePlayers.add(p1);
            eligiblePlayers.add(p2);
            eligiblePlayers.add(p3);
        }
    }

    public void askEligiblePlayers(Scanner input, PrintWriter output) {
        Collections.reverse(eligiblePlayers);
        String item = "";
        for (int i = eligiblePlayers.size() - 1; i >= 0; i--) {
            item = eligiblePlayers.get(i).promptJoin(input, output);
            if (item.equals("N")) {
                updateEligiblePlayers(eligiblePlayers.get(i));
            }
        }
    }

    public void updateEligiblePlayers(Player removed) {
        if (removed.getID().equals("P1")) {
            eligiblePlayers.remove(p1);
        } else if (removed.getID().equals("P2")) {
            eligiblePlayers.remove(p2);
        } else if (removed.getID().equals("P3")) {
            eligiblePlayers.remove(p3);
        } else if (removed.getID().equals("P4")) {
            eligiblePlayers.remove(p4);
        }
    }

    // PLAYER CONTENT *** BEGINS

    // PLAYER CONTENT *** ENDS

    public ArrayList<Card> stage1 = new ArrayList<>();
    int stage1Value = 0;
    public ArrayList<Card> stage2 = new ArrayList<>();
    int stage2Value = 0;
    public ArrayList<Card> stage3 = new ArrayList<>();
    int stage3Value = 0;
    public ArrayList<Card> stage4 = new ArrayList<>();
    int stage4Value = 0;
    public ArrayList<Card> stage5 = new ArrayList<>();
    int stage5Value = 0;

    public void distributeCards() {
        for (int j = 0; j < 12; j++) {
            p1.drawAdvCard();
        }
        for (int j = 0; j < 12; j++) {
            p2.drawAdvCard();
        }
        for (int j = 0; j < 12; j++) {
            p3.drawAdvCard();
        }
        for (int j = 0; j < 12; j++) {
            p4.drawAdvCard();
        }
    }

    // COMMIT 3 - RESP 3
    public Player currentPlayer = p1;      // shallow copy

    public void nextPlayer() {
        switch (currentPlayer.id) {
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

    // Commit 10
    public void clearScreen(PrintWriter printWriter) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        printWriter.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        printWriter.flush();
        printWriter.close();
    }

    // Commit #14
    public void playersSponsorPrompt(Scanner input, PrintWriter output) {
        String responseP2 = "";
        String responseP3 = "";
        String responseP4 = "";
        String responseP1 = "";

        if (currentDrawnEventCard.getName().equals("Q")) {
            String response = currentPlayer.promptSponsor(input, output, currentDrawnEventCard);
            int count = 0;
            String id = currentPlayer.getID();
            if (response.equals("N")) {
                while (count < 3) {
                    if (id.equals("P1")) {
                        responseP2 = p2.promptSponsor(input, output, currentDrawnEventCard);
                        if (responseP2.equals("Y")) {
                            System.out.println("Player 2 Sponsored Quest");
                            sponsoringPlayer = p2;
                            break;
                        } else {
                            id = "P2";
                        }
                    } else if (id.equals("P2")) {
                        responseP3 = p3.promptSponsor(input, output, currentDrawnEventCard);
                        if (responseP3.equals("Y")) {
                            System.out.println("Player 3 Sponsored Quest");
                            sponsoringPlayer = p3;
                            break;
                        } else {
                            id = "P3";
                        }
                    } else if (id.equals("P3")) {
                        responseP4 = p4.promptSponsor(input, output, currentDrawnEventCard);
                        if (responseP4.equals("Y")) {
                            System.out.println("Player 4 Sponsored Quest");
                            sponsoringPlayer = p4;
                            break;
                        } else {
                            id = "P4";
                        }
                    } else if (id.equals("P4")) {
                        responseP1 = p1.promptSponsor(input, output, currentDrawnEventCard);
                        if (responseP1.equals("Y")) {
                            System.out.println("Player 1 Sponsored Quest");
                            sponsoringPlayer = p1;
                            break;
                        } else {
                            id = "P1";
                        }
                    }
                    count++;
                }
                if (count == 4 && (responseP1.equals("N") && responseP2.equals("N") && responseP3.equals("N")) || (responseP4.equals("N") && responseP1.equals("N") && responseP2.equals("N")) || (responseP2.equals("N") && responseP3.equals("N") && responseP4.equals("N"))) {
                    // no one sponsored it end turn next player
                    System.out.println("No sponsored this quest, next player's turn");
                    nextPlayer();
                }
            } else if (response.equals("Y")) {
                System.out.println("Current Player " + currentPlayer.getID() + " Sponsored Quest");
                sponsoringPlayer = currentPlayer;
            }
        }
    }

    public void overwriteCard(List<Card> cards, int index, String type, String name, int value) {
        cards.get(index).name = name;
        cards.get(index).type = type;
        cards.get(index).value = value;
    }
    public void overwriteCard(Deck cards, int index, String type, String name, int value) {
        cards.get(index).name = name;
        cards.get(index).type = type;
        cards.get(index).value = value;
    }

}
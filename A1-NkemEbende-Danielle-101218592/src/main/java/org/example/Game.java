package org.example;

import io.cucumber.java.ja.前提;

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
    public ArrayList<Player> noLongerEligible = new ArrayList<Player>();
    public ArrayList<Player> gameWinners = new ArrayList<Player>();


    public Card currentDrawnEventCard;

    public ArrayList<Player> promptedPlayers = new ArrayList<Player>();

    public void initPromptedPlayers(){
        promptedPlayers.clear();
        // add in order of players depending on current player
        if (currentPlayer.getID().equals("P1")){
            promptedPlayers.add(p1);
            promptedPlayers.add(p2);
            promptedPlayers.add(p3);
            promptedPlayers.add(p4);
        } else if (currentPlayer.getID().equals("P2")) {
            promptedPlayers.add(p2);
            promptedPlayers.add(p3);
            promptedPlayers.add(p4);
            promptedPlayers.add(p1);
        } else if (currentPlayer.getID().equals("P3")) {
            promptedPlayers.add(p3);
            promptedPlayers.add(p4);
            promptedPlayers.add(p1);
            promptedPlayers.add(p2);
        } else if (currentPlayer.getID().equals("P4")) {
            promptedPlayers.add(p4);
            promptedPlayers.add(p1);
            promptedPlayers.add(p2);
            promptedPlayers.add(p3);
        }
    }

    public String updatePromptedPlayers(){
        if (promptedPlayers.isEmpty() || promptedPlayers.size() == 0) {
            return "No players available to be prompted";
        }
        String p = promptedPlayers.get(0).getID();
        promptedPlayers.remove(0);
        System.out.println("Prompted Player List Size: " +  promptedPlayers.size());
        return p + " was removed from prompted players list.";

    }

    public ArrayList<ArrayList> promptedStage = new ArrayList<ArrayList>();
    int currentStage = 1;

    public void initPromptedStages(){
        promptedStage.clear();
        if (currentDrawnEventCard.getValue() == 2){
            promptedStage.add(stage1);
            promptedStage.add(stage2);
        } else if (currentDrawnEventCard.getValue() == 3){
            promptedStage.add(stage1);
            promptedStage.add(stage2);
            promptedStage.add(stage3);
        } else if (currentDrawnEventCard.getValue() == 4){
            promptedStage.add(stage1);
            promptedStage.add(stage2);
            promptedStage.add(stage3);
            promptedStage.add(stage4);
        } else if (currentDrawnEventCard.getValue() == 5) {
            promptedStage.add(stage1);
            promptedStage.add(stage2);
            promptedStage.add(stage3);
            promptedStage.add(stage4);
            promptedStage.add(stage4);
        }
    }

    public String updatePromptedStages(){
        if (promptedStage.isEmpty() || promptedStage.size() == 0) {
            return "No Stages are available to be prompted";
        }
        promptedStage.remove(0);
        currentStage = currentDrawnEventCard.getValue() - promptedStage.size() + 1;
        System.out.println("Prompted Stages List Size: " +  promptedStage.size());
        return "Stage was removed from prompted Stage list.";
    }
    public ArrayList<Player> promptedEligiPlayers;

    public void initPromptedEligiPlayers(){
        promptedEligiPlayers = new ArrayList<>(eligiblePlayers);
    }
    // this function is different form the others as it is a copy of eligible players which is already being
    // updated so we use this list to make sure we're cycling through correctly
    public String updatePromptedEligiPlayers(){
        if (promptedEligiPlayers.isEmpty() || promptedEligiPlayers.size() == 0) {
            return "No eligible players available to be prompted";
        }
        promptedEligiPlayers.remove(0);
        return "";
    }

    public ArrayList<Player> trimmingPlayers = new ArrayList<>();

    public void initTrimmingPlayers(String group){
        if (group.equals("everyone")){
            trimmingPlayers = new ArrayList<>();
            if (p1.getCardsSize() > 12){
                trimmingPlayers.add(p1);
            }
            if (p2.getCardsSize() > 12){
                trimmingPlayers.add(p2);
            }
            if (p3.getCardsSize() > 12){
                trimmingPlayers.add(p3);
            }
            if (p4.getCardsSize() > 12){
                trimmingPlayers.add(p4);
            }
        } else if (group.equals("eligible")){
            for (int i=0; i< eligiblePlayers.size(); i++){
                if (eligiblePlayers.get(i).getCardsSize()>12) {
                    trimmingPlayers.add(eligiblePlayers.get(i));
                }
            }
        }
    }

    public void updateTrimmingPlayers(){
        if (trimmingPlayers.get(0).getCardsSize() <= 12){
            trimmingPlayers.remove(0);
        }
    }

    public Player sponsoringPlayer; // shallow copy of sponsoring player

    public void concludeQuest(PrintWriter output) {
        clearScreen(output);
        // distribute shields
        if (!eligiblePlayers.isEmpty()) {
            for (int i = 0; i < eligiblePlayers.size(); i++) {
                eligiblePlayers.get(i).setNumShields(eligiblePlayers.get(i).getNumShields() + currentDrawnEventCard.getValue());
            }
        }

        // print winners
        if (!eligiblePlayers.isEmpty()){
            System.out.println("The winner(s) of this quest: ");
            for (int i=0; i<eligiblePlayers.size(); i++){
                System.out.println(eligiblePlayers.get(i).getID());
            }
        } else { // if sponsor wins
            System.out.println("No winners for this quest.");

        }

        System.out.println("END OF " + currentPlayer.getID() + "'s TURN\n");
        clearScreen(output);

        // empty eligible players attack
        discardAllEligibleAttackCards();
        // empty eligible players list
        eligiblePlayers.clear();
        noLongerEligible.clear();
        // discard current event drawn and stage cards
        sponsoringPlayer.discardEventCard(currentDrawnEventCard);
        sponsoringPlayer.discardStageCards();
        sponsoringPlayer = null;

        // check for winners of the entire game
        checkForWinners();
        if (!gameWinners.isEmpty()){
            printWinners();
            return;
        }

        // no winner, next player
        nextPlayer();
    }

    public void checkForWinners() {
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
        gameWinners = winners;
    }

    public void cycleInDeck(Deck org, Deck discarded){
        // shuffle discarded first
        discarded.shuffleDeck();
        // add discarded into org deck
        for (int i=0; i<discarded.size(); i++){
            org.add(discarded.get(i));
        }
        // clear discarded deck
        discarded.cards.clear();
    }

    public boolean checkIfWinner(String num){
        for (int i=0; i< gameWinners.size(); i++){
            if (gameWinners.get(i).getID().contains(num)){
                return true;
            }
        }
        return false;
    }

    public void sponsorDrawsAdvCards(){
        // get no. of cards used in all stages
        int cardNum = stage1.size() + stage2.size() + stage3.size() + stage4.size() + stage5.size();

        // get no. of stages
        int stageNum = 0;
        if (!stage1.isEmpty()){
           stageNum++;
        }
        if (!stage2.isEmpty()) {
            stageNum++;
        }
        if (!stage3.isEmpty()) {
            stageNum++;
        }
        if (!stage4.isEmpty()) {
            stageNum++;
        }
        if (!stage5.isEmpty()) {
            stageNum++;
        }


        // sponsor draws adv card (cardNum + stageNum) times
        int total = stageNum + cardNum;
        for (int i=0; i<total; i++){
            sponsoringPlayer.drawAdvCard();

        }
        sponsoringPlayer.sortCards();
    }

    public void printWinners() {
        String w = "";
        for (int i = 0; i < gameWinners.size(); i++) {
            w += gameWinners.get(i).getID() + " ";
        }
        System.out.println("WINNER(S) of the game: " + w);
        if (gameWinners.isEmpty()) System.out.println("No Winners");
    }

    public void eligiblePlayersDrawAdvCard(){
        for (int i=0; i<eligiblePlayers.size(); i++){
            eligiblePlayers.get(i).drawAdvCard();
            eligiblePlayers.get(i).sortCards();
            // make sure to call trim to 12
        }
    }

    public void allEligiblePlayersAttackStage(ArrayList<Card> stage, String stageName) {
        if (stage.isEmpty()) {
            System.out.println("Can't attack an empty stage");
            return;
        }

        System.out.println("STAGE: " + arrayToString(stage) + "\n");
        for (int i=0; i<eligiblePlayers.size(); i++) {
            System.out.println(eligiblePlayers.get(i).getID());
            eligiblePlayers.get(i).attackStage(stage, stageName);
            System.out.println();
        }
        removeIneligiblePlayersFromList();
    }

    public void removeIneligiblePlayersFromList(){
        List<Integer> indices = new ArrayList<>();

        // remove the players that are no longer eligible
        // find indices of no longer eligible players
        int count = eligiblePlayers.size();
        for (int i=0; i<count; i++){
            for (int j=0; j<noLongerEligible.size(); j++){
                if (noLongerEligible.get(j).getID().equals(eligiblePlayers.get(i).getID())){
                    indices.add(i);
                }
            }
        }

        // remove those indices
        for (int i=indices.size()-1; i>=0; i--){
            updateEligiblePlayers(eligiblePlayers.get(indices.get(i)));
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

    public void printIleligiblePlayers() {
        System.out.println("Ileligible Players for this Quest:");
        for (int i = 0; i < noLongerEligible.size(); i++) {
            System.out.println(noLongerEligible.get(i).getID());
        }
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
        String item = "";
        for (int i=0; i<eligiblePlayers.size(); i++){
            item = eligiblePlayers.get(i).promptJoin(input, output);
            if (item.equals("N")) {
                noLongerEligible.add(eligiblePlayers.get(i));
            }
        }
        removeIneligiblePlayersFromList();
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
            p1.sortCards();
        }
        for (int j = 0; j < 12; j++) {
            p2.drawAdvCard();
            p2.sortCards();
        }
        for (int j = 0; j < 12; j++) {
            p3.drawAdvCard();
            p3.sortCards();
        }
        for (int j = 0; j < 12; j++) {
            p4.drawAdvCard();
            p4.sortCards();
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
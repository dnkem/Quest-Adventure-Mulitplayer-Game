package org.example;


import java.io.PrintWriter;
import java.io.StringWriter;
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

        for (int i=0; i<8; i++){
            Card cardF5 = new Card("Adventure","F", 5);
            advDeck.add(cardF5);
        }
        // F10s
        for (int i=8; i<15; i++){
            Card cardF10 = new Card("Adventure","F", 10);
            advDeck.add(cardF10);
        }
        // F15s
        for (int i=15; i<23; i++){
            Card cardF15 = new Card("Adventure","F", 15);
            advDeck.add(cardF15);
        }
        // F20s
        for (int i=23; i<30; i++){
            Card cardF20 = new Card("Adventure","F", 20);
            advDeck.add(cardF20);
        }
        // F25s
        for (int i=30; i<37; i++){
            Card cardF25 = new Card("Adventure","F", 25);
            advDeck.add(cardF25);
        }
        // F30s
        for (int i=37; i<41; i++){
            Card cardF30 = new Card("Adventure","F", 30);
            advDeck.add(cardF30);
        }
        // F35s
        for (int i=41; i<45; i++){
            Card cardF35 = new Card("Adventure","F", 35);
            advDeck.add(cardF35);
        }
        // F40s
        for (int i=45; i<47; i++){
            Card cardF40 = new Card("Adventure","F", 40);
            advDeck.add(cardF40);
        }
        // F50s
        for (int i=47; i<49; i++){
            Card cardF50 = new Card("Adventure","F", 50);
            advDeck.add(cardF50);
        }
        // F70
        Card cardF70 = new Card("Adventure","F", 70);
        advDeck.add(cardF70);

        // add in weapons
        // D5s
        for (int i=50; i<56; i++){
            Card cardD5 = new Card("Adventure","D", 5);
            advDeck.add(cardD5);
        }
        // H10s
        for (int i=56; i<68; i++){
            Card cardH10 = new Card("Adventure","H", 10);
            advDeck.add(cardH10);
        }
        // S10s
        for (int i=68; i<84; i++){
            Card cardS10 = new Card("Adventure","S", 10);
            advDeck.add(cardS10);
        }
        // B15s
        for (int i=84; i<92; i++){
            Card cardB15 = new Card("Adventure","B", 15);
            advDeck.add(cardB15);
        }
        // L20s
        for (int i=92; i<98; i++){
            Card cardL20 = new Card("Adventure","L", 20);
            advDeck.add(cardL20);
        }
        // E30s
        for (int i=98; i<100; i++){
            Card cardE30 = new Card("Adventure","E", 30);
            advDeck.add(cardE30);
        }
    }

    public void initEventDeck(){
        eventDeck = new ArrayList<Card>();
        // add in quests
        // Q2s
        for (int i=0; i<3; i++){
            Card cardQ2 = new Card("Event","Q", 2);
            eventDeck.add(cardQ2);
        }
        // Q3s
        for (int i=3; i<7; i++){
            Card cardQ3 = new Card("Event","Q", 3);
            eventDeck.add(cardQ3);
        }
        // Q4s
        for (int i=7; i<10; i++){
            Card cardQ4 = new Card("Event","Q", 4);
            eventDeck.add(cardQ4);
        }
        // Q5s
        for (int i=10; i<12; i++){
            Card cardQ5 = new Card("Event","Q", 5);
            eventDeck.add(cardQ5);
        }

        // add in events
        // Plagues
        Card cardPlague = new Card("Event","Plague", 2);
        eventDeck.add(cardPlague);
        // Queens favor
        Card cardFavor = new Card("Event","Queen’s favor", 2);
        eventDeck.add(cardFavor);
        Card cardFavor2 = new Card("Event","Queen’s favor", 2);
        eventDeck.add(cardFavor2);
        // Prosperity
        Card cardProsperity = new Card("Event","Prosperity", 2);
        eventDeck.add(cardProsperity);
        Card cardProsperity2 = new Card("Event","Prosperity", 2);
        eventDeck.add(cardProsperity2);
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
        ArrayList<Card> attack = new ArrayList<Card>();

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
            System.out.println(cards);

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
            System.out.println("    " + currentDrawnEventCard.type +": " + currentDrawnEventCard.getName() + currentDrawnEventCard.getValue());
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
                // replace w/ playersSponsorPrompt(input, output);
                System.out.println("    " + currentDrawnEventCard.type +": " + currentDrawnEventCard.getName() + currentDrawnEventCard.getValue());
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
        public String promptSponsor(Scanner input, PrintWriter output, Card c){
            System.out.println(this.getID() + " do you want to sponsor " + c.getName() + c.getValue() + " Y/N: ");
            output.println(this.getID() + " do you want to sponsor " + c.getName() + c.getValue() + " Y/N: "); output.flush();
            String inputStr = input.nextLine();

            try{
                if (inputStr.equals("Y") || inputStr.equals("N")){
                    output.println("input is valid"); output.flush();
                    if (inputStr.equals("Y")){
                        output.println("Y");output.flush();
                        System.out.println(inputStr);
                        return inputStr;
                    } else {
                        output.println("N");output.flush();
                        System.out.println(inputStr);
                        return inputStr;
                    }
                } else{
                    throw new Exception("wrong item");
                }
            } catch(Exception e) {
                output.println("input is not valid"); output.flush();
                return "input is not valid";
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
                System.out.println(inputNum);
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

        public String promptJoin(Scanner input, PrintWriter output){
            System.out.println(this.getID() + " do you want to join the quest (Y/N): ");
            output.println(this.getID() + " do you want to join the quest (Y/N): "); output.flush();
            String inputStr = input.nextLine();

            try{
                if (inputStr.equals("Y") || inputStr.equals("N")){
                    output.println("input is valid"); output.flush();
                    if (inputStr.equals("Y")){
                        output.println("Y");output.flush();
                        System.out.println(inputStr);
                        return inputStr;
                    } else {
                        output.println("N");output.flush();
                        System.out.println(inputStr);
                        return inputStr;
                    }
                } else{
                    throw new Exception("wrong item");
                }
            } catch(Exception e) {
                output.println("input is not valid"); output.flush();
                return "input is not valid";
            }
        }

        public boolean eligibleStage(ArrayList<Card> array){
            boolean eligible = false;
            for (int i=0; i<array.size(); i++){
                if (array.get(i).getName().equals("F")){
                    eligible = true;
                }
            }
            for (int i=0; i<array.size(); i++){
                for (int j=1; j<array.size()-1; j++){
                    if (array.get(i).getName().equals(array.get(j).getName())){
                        eligible = false;
                        cards.add(array.remove(j));
                    }
                }
            }
            return eligible;
        }

        public void buildStages(Scanner input){
            for (int i=0; i<currentDrawnEventCard.getValue(); i++){
                boolean go = true;
                while(go) {
                    System.out.println(getID() + " Cards: " + cardsToString());
                    System.out.println("Stage " + (i + 1) + ": Select what position (1-" + getCardsSize() + ") should be used in this stage (enter 'Q' to quit): ");
                    String inputStr = input.nextLine();

                    int inputNum = -1;
                    try {
                        inputNum = Integer.parseInt(inputStr);
                        System.out.println(inputNum);
                        if (getCardsSize() == 0){
                            System.out.println("*The player's hand of cards is empty");
                            break;
                        } else if (inputNum > getCardsSize() || inputNum < 1) {
                            System.out.println("*This number, " + inputNum + ", is an invalid position");
                        } else {
                            switch (i) {
                                case 0: stage1.add(cards.remove(inputNum-1)); break;
                                case 1: stage2.add(cards.remove(inputNum-1)); break;
                                case 2: stage3.add(cards.remove(inputNum-1)); break;
                                case 3: stage4.add(cards.remove(inputNum-1)); break;
                                case 4: stage5.add(cards.remove(inputNum-1)); break;
                            }
                        }
                    } catch (NumberFormatException e) {
                        if (i == 0 && stage1.isEmpty()){
                            System.out.println("*This stage has no cards, A stage cannot be empty"); continue;
                        } else if (i == 1 && stage2.isEmpty()) {
                            System.out.println("*This stage has no cards, A stage cannot be empty"); continue;
                        } else if (i == 2 && stage3.isEmpty()) {
                            System.out.println("*This stage has no cards, A stage cannot be empty"); continue;
                        } else if (i == 3 && stage4.isEmpty()) {
                            System.out.println("*This stage has no cards, A stage cannot be empty"); continue;
                        } else if (i == 4 && stage5.isEmpty()) {
                            System.out.println("*This stage has no cards, A stage cannot be empty"); continue;
                        } else {
                            System.out.println("Q");
                            go = false;
                            break;
                        }
                    }
                }
                boolean eligible = true;
                // assign the stages values and check if valid
                switch (i) {
                    case 0: stage1Value = getValues(stage1); break;
                    case 1:
                        if (getValues(stage2) > stage1Value) {
                            stage2Value = getValues(stage2);
                            eligible = true;
                        } else {
                            System.out.println("*Insufficient value for this stage");
                            eligible = false;
                            i -= 1;
                        }
                        break;
                    case 2:
                        if (getValues(stage3) > stage2Value) {
                            stage3Value = getValues(stage3);
                            eligible = true;
                        } else {
                            System.out.println("*Insufficient value for this stage");
                            eligible = false;
                            i -= 1;
                        }
                        break;
                    case 3:
                        if (getValues(stage4) > stage3Value) {
                            stage4Value = getValues(stage4);
                            eligible = true;
                        } else {
                            System.out.println("*Insufficient value for this stage");
                            eligible = false;
                            i -= 1;
                        }
                        break;
                    case 4:
                        if (getValues(stage5) > stage4Value) {
                            stage5Value = getValues(stage5);
                            eligible = true;
                        } else {
                            System.out.println("*Insufficient value for this stage");
                            eligible = false;
                            i -= 1;
                        }
                        break;
                }

                // print stages
                if (eligible) {
                    switch (i) {
                        case 0:
                            String s1 = arrayToString(stage1);
                            System.out.println("    Stage 1: " + s1);
                            break;
                        case 1:
                            String s2 = arrayToString(stage2);
                            System.out.println("    Stage 2: " + s2);
                            break;
                        case 2:
                            String s3 = arrayToString(stage3);
                            System.out.println("    Stage 3: " + s3);
                            break;
                        case 3:
                            String s4 = arrayToString(stage4);
                            System.out.println("    Stage 4: " + s4);
                            break;
                        case 4:
                            String s5 = arrayToString(stage5);
                            System.out.println("    Stage 5: " + s5);
                            break;
                    }
                }
            }
        }
        public void discardStageCards(){
            int num = stage1.size();
            for (int i=0; i<num; i++){
                discardAdvCard(stage1.removeFirst());
            }
            num = stage2.size();
            for (int i=0; i<num; i++){
                discardAdvCard(stage2.removeLast());
            }
            num = stage3.size();
            for (int i=0; i<num; i++){
                discardAdvCard(stage3.removeLast());
            }
            num = stage4.size();
            for (int i=0; i<num; i++){
                discardAdvCard(stage4.removeLast());
            }
            num = stage5.size();
            for (int i=0; i<num; i++){
                discardAdvCard(stage5.removeLast());
            }
        }

        public void discardAttackCards(){
            int num = attack.size();
            for (int i=0; i<num; i++){
                discardAdvCard(attack.removeFirst());
            }
        }

        public void drawAdvCardsTo12(){
            int num = 12 - this.getCardsSize();
            for (int j=0; j<num; j++){
                drawAdvCard();
            }
        }

        public String promptAttack(Scanner input){
            System.out.println(getID() + " Cards: " + cardsToString());
            System.out.println(getID() + " select what position (1-" + getCardsSize() + ") should be used in the attach (enter 'Q' to quit): ");
            String inputStr = input.nextLine();
            int inputNum = -1;

            try{
                inputNum = Integer.parseInt(inputStr);
                attack.add(cards.remove(inputNum - 1));
                System.out.println(inputNum);
                return inputStr;
            } catch(NumberFormatException e) {
                System.out.println("Q");
                return inputStr;
            }
        }

        public void setUpAttack(Scanner input){
            boolean go = true;
            while (go){
                String item = promptAttack(input);
                if (item.equals("Q")) {
                    go = false;
                    break;
                }
            }
        }

        public void attackStage(ArrayList<Card> stage, String stageStr){
            int attackValue = 0;
            for (int i=0; i<attack.size(); i++){
                attackValue += attack.get(i).getValue();
            }

            if (stageStr.equals("stage1")){
                System.out.println("Attack Value:" + attackValue);
                if (attackValue < stage1Value) {
                    discardAttackCards();
                    updateEligiblePlayers(this); // remove this player from eligibility list of players
                    System.out.println("Didn't clear stage, removed from eligible players");
                } else{
                    System.out.println("Stage is cleared successful");
                }
            } else if (stageStr.equals("stage2")){
                System.out.println("Attack Value:" + attackValue);
                if (attackValue < stage2Value) {
                    discardAttackCards();
                    updateEligiblePlayers(this);
                    System.out.println("Didn't clear stage, removed from eligible players");
                }else{
                    System.out.println("Stage is cleared successful");
                }
            } else if (stageStr.equals("stage3")){
                System.out.println("Attack Value:" + attackValue);
                if (attackValue < stage3Value) {
                    discardAttackCards();
                    updateEligiblePlayers(this);
                    System.out.println("Didn't clear stage, removed from eligible players");
                }else{
                    System.out.println("Stage is cleared successfully");
                }
            } else if (stageStr.equals("stage4")){
                System.out.println("Attack Value:" + attackValue);
                if (attackValue < stage4Value) {
                    discardAttackCards();
                    updateEligiblePlayers(this);
                    System.out.println("Didn't clear stage, removed from eligible players");
                }else{
                    System.out.println("Stage is cleared successfully");
                }
            } else if (stageStr.equals("stage5")){
                System.out.println("Attack Value:" + attackValue);
                if (attackValue < stage5Value) {
                    discardAttackCards();
                    updateEligiblePlayers(this);
                    System.out.println("Didn't clear stage, removed from eligible players");
                }else{
                    System.out.println("Stage is cleared successfully");
                }
            }
        }

        public void sortCards(){
        }
    }

    public void concludeQuest(PrintWriter output){
        // distribute shields
        if(!eligiblePlayers.isEmpty()) {
            for (int i=0; i<eligiblePlayers.size(); i++) {
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

    public boolean checkForWinners(){
        ArrayList<Player> winners = new ArrayList<Player>();
        if (p1.getNumShields() >= 7){
            winners.add(p1);
        }
        if (p2.getNumShields() >= 7){
            winners.add(p2);
        }
        if (p3.getNumShields() >= 7){
            winners.add(p3);
        }
        if (p4.getNumShields() >= 7){
            winners.add(p4);
        }

        if (winners.isEmpty()) return false;
        gameWinners = winners;
        return true;
    }

    public void printWinners(){
        String w ="";
        for (int i=0; i<gameWinners.size(); i++){
            w += gameWinners.get(i).getID();
        }
        System.out.println("WINNER(S) of the game: " + w);
    }

    public void allEligiblePlayersAttackStage(ArrayList<Card> stage, String stageName){
        int num = eligiblePlayers.size();
        System.out.println("STAGE: " + arrayToString(stage) + "\n");
        for (int i=num-1; i>=0; i--){
            System.out.println(eligiblePlayers.get(i).getID());
            eligiblePlayers.get(i).attackStage(stage, stageName);
            System.out.println();
        }
    }

    public void discardAllEligibleAttackCards(){
        int num = eligiblePlayers.size() - 1;
        while (num >= 0) {
            eligiblePlayers.get(num).discardAttackCards();
            num--;
        }
    }

    public void participantsSetUpAttack(Scanner input, PrintWriter output){
        clearScreen(output);
        //Collections.reverse(eligiblePlayers);
        for (int i=0; i<eligiblePlayers.size(); i++){
            eligiblePlayers.get(i).setUpAttack(input);
            clearScreen(output);
        }
    }

    public int getValues(ArrayList<Card> array){
        int value = 0;
        for (int i=0; i< array.size(); i++){
            value += array.get(i).getValue();
        }
        return value;
    }

    public String arrayToString(ArrayList<Card> array){
        String s1 = "";
        for (int j = 0; j < array.size(); j++) {
            s1 += array.get(j).getName() + array.get(j).getValue() + " ";
        }
        return s1;
    }
    public void printEligiblePlayers(){
        System.out.println("Eligible Players for this Quest:");
        for (int i=0; i<eligiblePlayers.size(); i++){
            System.out.println(eligiblePlayers.get(i).getID());
        }
    }

    public void getEligiblePlayers(){
        if (sponsoringPlayer.getID().equals("P1")){
            eligiblePlayers.add(p2); eligiblePlayers.add(p3); eligiblePlayers.add(p4);
        } else if (sponsoringPlayer.getID().equals("P2")){
            eligiblePlayers.add(p1); eligiblePlayers.add(p3); eligiblePlayers.add(p4);
        }else if (sponsoringPlayer.getID().equals("P3")){
            eligiblePlayers.add(p1); eligiblePlayers.add(p2); eligiblePlayers.add(p4);
        }else if (sponsoringPlayer.getID().equals("P4")){
            eligiblePlayers.add(p1); eligiblePlayers.add(p2); eligiblePlayers.add(p3);
        }
    }

    public void askEligiblePlayers(Scanner input, PrintWriter output){
        Collections.reverse(eligiblePlayers);
        String item = "";
        for (int i=eligiblePlayers.size() - 1; i>=0; i--){
            item = eligiblePlayers.get(i).promptJoin(input, output);
            if (item.equals("N")){
                updateEligiblePlayers(eligiblePlayers.get(i));
            }
        }
    }

    public void updateEligiblePlayers(Player removed){
        if (removed.getID().equals("P1")){
            eligiblePlayers.remove(p1);
        } else if (removed.getID().equals("P2")){
            eligiblePlayers.remove(p2);
        }else if (removed.getID().equals("P3")){
            eligiblePlayers.remove(p3);
        }else if (removed.getID().equals("P4")){
            eligiblePlayers.remove(p4);
        }
    }

    Player p1 = new Player("P1");
    Player p2 = new Player("P2");
    Player p3 = new Player("P3");
    Player p4 = new Player("P4");

    ArrayList<Player> eligiblePlayers = new ArrayList<Player>();
    ArrayList<Player> gameWinners = new ArrayList<Player>();

    Player sponsoringPlayer; // shallow copy of sponsoring player

    ArrayList<Card> stage1 = new ArrayList<>();
    int stage1Value = 0;
    ArrayList<Card> stage2 = new ArrayList<>();
    int stage2Value = 0;
    ArrayList<Card> stage3 = new ArrayList<>();
    int stage3Value = 0;
    ArrayList<Card> stage4 = new ArrayList<>();
    int stage4Value = 0;
    ArrayList<Card> stage5 = new ArrayList<>();
    int stage5Value = 0;

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

    // Commit #14
    public void playersSponsorPrompt(Scanner input, PrintWriter output){
        String responseP2 = "";
        String responseP3 = "";
        String responseP4 = "";
        String responseP1 = "";

        if (currentDrawnEventCard.getName().equals("Q")){
            String response = currentPlayer.promptSponsor(input, output, currentDrawnEventCard);
            int count = 0;
            String id = currentPlayer.getID();
            if (response.equals("N")){
                while (count < 3) {
                    if (id.equals("P1")) {
                        responseP2 = p2.promptSponsor(input, output, currentDrawnEventCard);
                        if (responseP2.equals("Y")){
                            System.out.println("Player 2 Sponsored Quest");
                            sponsoringPlayer = p2;
                            break;
                        } else {
                            id = "P2";
                        }
                    } else if (id.equals("P2")) {
                        responseP3 = p3.promptSponsor(input, output, currentDrawnEventCard);
                        if (responseP3.equals("Y")){
                            System.out.println("Player 3 Sponsored Quest");
                            sponsoringPlayer = p3;
                            break;
                        } else {
                            id = "P3";
                        }
                    } else if (id.equals("P3")) {
                        responseP4 = p4.promptSponsor(input, output, currentDrawnEventCard);
                        if (responseP4.equals("Y")){
                            System.out.println("Player 4 Sponsored Quest");
                            sponsoringPlayer = p4;
                            break;
                        } else {
                            id = "P4";
                        }
                    } else if (id.equals("P4")) {
                        responseP1 = p1.promptSponsor(input, output, currentDrawnEventCard);
                        if (responseP1.equals("Y")){
                            System.out.println("Player 1 Sponsored Quest");
                            sponsoringPlayer = p1;
                            break;
                        } else {
                            id = "P1";
                        }
                    }
                    count++;
                }
                if (count == 4 && (responseP1.equals("N") && responseP2.equals("N") && responseP3.equals("N")) || (responseP4.equals("N") && responseP1.equals("N") && responseP2.equals("N")) || (responseP2.equals("N") && responseP3.equals("N") && responseP4.equals("N"))){
                    // no one sponsored it end turn next player
                    System.out.println("No sponsored this quest, next player's turn");
                    nextPlayer();
                }
            } else if (response.equals("Y")){
                System.out.println("Current Player " + currentPlayer.getID() + " Sponsored Quest");
                sponsoringPlayer = currentPlayer;
            }
        }
    }

    public void overwriteCard(ArrayList<Card> cards, int index, String type, String name, int value){
        cards.get(index).name = name;
        cards.get(index).type = type;
        cards.get(index).value = value;
    }

}
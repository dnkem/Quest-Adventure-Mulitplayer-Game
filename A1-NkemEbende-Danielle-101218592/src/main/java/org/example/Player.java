package org.example;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Player {
    public List<Card> cards = new ArrayList<>();
    public List<Card> attack = new ArrayList<>();
    String id;          // P1, P2, P3, P4
    int numShields = 0;
    Game game;

    Player(String ID, Game game) {
        this.id = ID;
        this.game = game;
    }

    // getters and setters
    public String getID() { return id; }
    public int getNumShields() { return numShields;}
    public void setId(String i) { this.id = i; }
    public void setNumShields(int s) {this.numShields = s;}
    public int getCardsSize() { return cards.size();}
    public Card getCard(int i) { return cards.get(i); }

    // Commit 7
    public String cardsToString() {
        String cards = "";
        for (int i = 0; i < getCardsSize(); i++) {
            cards += getCard(i).getName() + getCard(i).getValue() + " ";
        }
        return cards;
    }

    public void add(Card c) {
        cards.add(c);
    }

    // COMMIT 4 - RESP 4 - REFACTOR 1
    public void printPlayersCards(PrintWriter printWriter) {
        sortCards();
        // collect player card info into a string
        String cards = getID() + ": ";
        for (int i = 0; i < getCardsSize(); i++) {
            cards += getCard(i).getName() + getCard(i).getValue() + " ";
        }
        printWriter.println("Checks there's items in card: " + cards);
        System.out.println(cards);

        // print into the terminal
        printWriter.println("Printing " + getID() + " Cards:");
        printWriter.printf("%s", cards);
        printWriter.flush();
        printWriter.close();
    }

    // Commit 13
    public String promptSponsor(Scanner input, PrintWriter output, Card c) {
        System.out.println(this.getID() + " do you want to sponsor " + c.getName() + c.getValue() + " Y/N: ");
        output.println(this.getID() + " do you want to sponsor " + c.getName() + c.getValue() + " Y/N: ");
        output.flush();
        String inputStr = input.nextLine();

        try {
            if (inputStr.equals("Y") || inputStr.equals("N")) {
                output.println("input is valid");
                output.flush();
                if (inputStr.equals("Y")) {
                    output.println("Y");
                    output.flush();
                    System.out.println(inputStr);
                    return inputStr;
                } else {
                    output.println("N");
                    output.flush();
                    System.out.println(inputStr);
                    return inputStr;
                }
            } else {
                throw new Exception("wrong item");
            }
        } catch (Exception e) {
            output.println("input is not valid");
            output.flush();
            return "input is not valid";
        }
    }

    public void singleSponsorQuestion(Scanner input, PrintWriter output){
        if (game.sponsoringPlayer != null){
            System.out.println("Can't prompt as there is already a sponsoring player: " + game.sponsoringPlayer.getID());
            return;
        }

        String decision = this.promptSponsor(input, output, game.currentDrawnEventCard);
        if (decision.equals("Y")){
            game.sponsoringPlayer = this;
        }
    }

    // COMMIT 7
    public void promptPosition(Scanner input, PrintWriter output) {
        output.println("Enter a Position from 1 to " + this.getCardsSize() + ": ");
        output.flush();
        String inputStr = input.nextLine();
        int inputNum = -1;

        try {
            inputNum = Integer.parseInt(inputStr);
            output.println("input is valid");
            output.flush();
            System.out.println();
        } catch (NumberFormatException e) {
            output.println("input is not valid");
            output.flush();
            return;
        }

        // delete at index
        trimCard(inputNum);
    }

    public String trimCard(int index) {
        sortCards();
        // can't trim if hand is equal to 12
        if (cards.size() <= 12) {
            System.out.println("Can't trim hand if the size is 12 or less!!");
            return "";
        }

        // print
        System.out.println("Cards Before Deletion:      " + cardsToString());

        // delete at index
        if (index > 0 && index <= this.getCardsSize()) {
            this.discardAdvCard(cards.remove(index -1));
            System.out.println("Deleted card at position: " + index);
        }

        // re print correctly
        System.out.println("Cards After deletion:       " + cardsToString());
        return "" + index;
    }

    public void trimToTwelve(Scanner input, PrintWriter output) {
        if (getCardsSize() <= 12) return;
        int extraCards = this.getCardsSize() - 12;
        System.out.println(this.getID() + " BEFORE Deletions: " + cardsToString());
        for (int i = 0; i < extraCards; i++) {
            promptPosition(input, output);
        }
        System.out.println(this.getID() + " AFTER Deletions: " + cardsToString());
        game.clearScreen(output);
    }

    // COMMIT 5 - RESP 5
    public void drawAdvCard() {
        if (game.advDeck.cards.isEmpty()){
//           game.cycleInDeck(game.advDeck, game.discardAdvDeck);
//            System.out.println("\n**Cycled in New Cards From the Discarded Deck\n");
        }
        cards.add(game.advDeck.getDeck().remove(game.advDeck.size() - 1));
    }

    public void drawFirstEventCard(){
        game.currentDrawnEventCard = game.eventDeck.removeLast();
    }

    public void drawEventCard() {
        game.currentDrawnEventCard = game.eventDeck.removeLast();
        System.out.println("    " + game.currentDrawnEventCard.type + ": " + game.currentDrawnEventCard.getName() + game.currentDrawnEventCard.getValue());
        if (game.currentDrawnEventCard.getName().equals("Queen’s favor")) {
            playQueenEventCard(game.currentPlayer);
            game.nextPlayer();
        } else if (game.currentDrawnEventCard.getName().equals("Prosperity")) {
            playProsperityCard(game.currentPlayer);
            game.nextPlayer();
        } else if (game.currentDrawnEventCard.getName().equals("Plague")) {
            playPlagueCard(game.currentPlayer);
            game.nextPlayer();
        } else {
            return;
        }

        // deal with used event card
        discardEventCard(game.currentDrawnEventCard);
    }

    // COMMIT 13
    public void drawQuestCard(Scanner input, PrintWriter output) {
        game.currentDrawnEventCard = game.eventDeck.removeLast();
        if (game.currentDrawnEventCard.getName().equals("Q")) {
            // replace w/ playersSponsorPrompt(input, output);
            System.out.println("    " + game.currentDrawnEventCard.type + ": " + game.currentDrawnEventCard.getName() + game.currentDrawnEventCard.getValue());
            game.currentPlayer.promptSponsor(input, output, game.currentDrawnEventCard);
        }
        // discardEventCard(game.currentDrawnEventCard);
    }

    public void playQueenEventCard(Player p) {
        if (game.currentPlayer.getID().equals(p.id) && game.currentDrawnEventCard.getName().equals("Queen’s favor")) {
            p.drawAdvCard();
            p.drawAdvCard();
            p.sortCards();
        } else {
            System.out.println("Can't draw adv cards for Queens favor event");
        }
    }

    public void playProsperityCard(Player p) {
        if (game.currentPlayer.getID().equals(p.id) && game.currentDrawnEventCard.getName().equals("Prosperity")) {
            game.p1.drawAdvCard();
            game.p1.drawAdvCard();
            game.p1.sortCards();
            game.p2.drawAdvCard();
            game.p2.drawAdvCard();
            game.p2.sortCards();
            game.p3.drawAdvCard();
            game.p3.drawAdvCard();
            game.p3.sortCards();
            game.p4.drawAdvCard();
            game.p4.drawAdvCard();
            game.p4.sortCards();
        } else {
            System.out.println("Can't draw adv cards for Prosperity event");
        }
    }

    // Commit 11
    public void playPlagueCard(Player p) {
        if (game.currentPlayer.getID().equals(p.id) && game.currentDrawnEventCard.getName().equals("Plague")) {
            if (p.getNumShields() == 0 || p.getNumShields() == 1) {
                p.numShields = 0;
            } else {
                p.numShields -= 2;
            }
        } else {
            System.out.println("Can't do Plague  event");
        }
    }


    public void discardAdvCard(Card c) {
        game.discardAdvDeck.add(c);
    }

    public void discardEventCard(Card c) {
        game.discardEventDeck.add(c);
    }

    public String promptJoin(Scanner input, PrintWriter output) {
        System.out.println(this.getID() + " do you want to join the quest (Y/N): ");
        output.println(this.getID() + " do you want to join the quest (Y/N): ");
        output.flush();
        String inputStr = input.nextLine();

        try {
            if (inputStr.equals("Y") || inputStr.equals("N")) {
                output.println("input is valid");
                output.flush();
                if (inputStr.equals("Y")) {
                    output.println("Y");
                    output.flush();
                    System.out.println(inputStr);
                    return inputStr;
                } else {
                    output.println("N");
                    output.flush();
                    System.out.println(inputStr);
                    return inputStr;
                }
            } else {
                throw new Exception("wrong item");
            }
        } catch (Exception e) {
            output.println("input is not valid");
            output.flush();
            return "input is not valid";
        }
    }

    public void singleJoinQuestion(Scanner input, PrintWriter output){
        // can't be the sponsor
        if (this.getID().equals(game.sponsoringPlayer.getID())) {
            System.out.println("This player is the sponsor!! Please try again.");
            return;
        }

        // has to only be eligible players that are asked to participate
        boolean flag = false;
        for (int i=0; i<game.eligiblePlayers.size(); i++){
            if (this.getID().equals(game.eligiblePlayers.get(i).getID())) flag = true;
        }
        if (!flag) {
            System.out.println("This player is not eligible to join this match.");
            return;
        }

        // eligible and not a sponsor so remove from eligible list if declined
        String response = this.promptJoin(input, output);
        if (response.equals("N")){
            game.noLongerEligible.add(this);
            game.removeIneligiblePlayersFromList();
        }
    }

    public boolean eligibleStage(ArrayList<Card> array) {
        boolean eligible = false;
        // check if array has a foe
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equals("F")) {
                eligible = true;
            }
        }
        // no repeated weapons
        for (int i = 0; i < array.size(); i++) {
            for (int j = i+1; j < array.size(); j++) {
                if (array.get(i).getName().equals(array.get(j).getName())) {
                    eligible = false;
                    cards.add(array.remove(j)); // put back in hand
                }
            }
        }
        return eligible;
    }

    public void buildStages(Scanner input) {
        // loop the (no. of stages) times
        for (int i = 0; i < game.currentDrawnEventCard.getValue(); i++) { // loops through stages
            boolean go = true;
            while (go) { // loops into a single stage
                System.out.println(getID() + " Cards: " + cardsToString());
                System.out.println("Stage " + (i+1) + ": Select what position (1-" + getCardsSize() + ") should be used in this stage (enter 'Q' to quit): ");
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
                        buildSingleStage(i + 1, inputNum);
                    }
                } catch (NumberFormatException e) {
                    if (i == 0 && game.stage1.isEmpty()){
                        System.out.println("*This stage has no cards, A stage cannot be empty"); continue;
                    } else if (i == 1 && game.stage2.isEmpty()) {
                        System.out.println("*This stage has no cards, A stage cannot be empty"); continue;
                    } else if (i == 2 && game.stage3.isEmpty()) {
                        System.out.println("*This stage has no cards, A stage cannot be empty"); continue;
                    } else if (i == 3 && game.stage4.isEmpty()) {
                        System.out.println("*This stage has no cards, A stage cannot be empty"); continue;
                    } else if (i == 4 && game.stage5.isEmpty()) {
                        System.out.println("*This stage has no cards, A stage cannot be empty"); continue;
                    } else {
                        System.out.println("Q");
                        go = false;
                        break;
                    }
                }
            }

            if (i == 0) {
                if (!eligibleStage(game.stage1)){
                    System.out.println("Stage 1 is not eligible! Missing a Foe or has repeated Weapons");
                    break;
                }
            } else if (i==1) {
                if (!eligibleStage(game.stage2)) {
                    System.out.println("Stage 2 is not eligible! Missing a Foe or has repeated Weapons");
                    break;
                }
            }else if (i==2) {
                if (!eligibleStage(game.stage3)) {
                    System.out.println("Stage 3 is not eligible! Missing a Foe or has repeated Weapons");
                    break;
                }
            } else if (i==3) {
                if (!eligibleStage(game.stage4)) {
                    System.out.println("Stage 4 is not eligible! Missing a Foe or has repeated Weapons");
                    break;
                }
            }

            // assign the stages values and check if valid
            boolean eligible = assignStageValues(i+1);

            // print stages
            if (eligible) {
                printStage(i+1);
            }
        }
    }

    public void buildSingleStage(int stageNum, int position){
        if (stageNum > game.currentDrawnEventCard.getValue()){
            System.out.println(stageNum + " > " + game.currentDrawnEventCard.getValue());
            System.out.println("Can't build more stages than the Quest card allows.");
            return;
        }

        if (!this.getID().equals(game.sponsoringPlayer.getID())){
            System.out.println("Only the Sponsoring player can build stages.");
            return;
        }

        switch (stageNum) {
            case 1:
                game.stage1.add(cards.remove(position - 1));
                break;
            case 2:
                game.stage2.add(cards.remove(position - 1));
                break;
            case 3:
                game.stage3.add(cards.remove(position - 1));
                break;
            case 4:
                game.stage4.add(cards.remove(position - 1));
                break;
            case 5:
                game.stage5.add(cards.remove(position - 1));
                break;
        }
    }

    public boolean assignStageValues(int stageNum) {
        boolean eligible = false;
        switch (stageNum) {
            case 1:
                game.stage1Value = game.getValues(game.stage1);
                break;
            case 2:
                if (game.getValues(game.stage2) > game.stage1Value) {
                    game.stage2Value = game.getValues(game.stage2);
                    eligible = true;
                    System.out.println("\n                *Sufficient");
                } else {
                    System.out.println("\n                *Insufficient value for the below stage 2");
                    return false;
                }
                break;
            case 3:
                if (game.getValues(game.stage3) > game.stage2Value) {
                    game.stage3Value = game.getValues(game.stage3);
                    eligible = true;
                    System.out.println("\n                *Sufficient");
                } else {
                    System.out.println("\n                *Insufficient value for the below stage 3");
                    return false;
                }
                break;
            case 4:
                if (game.getValues(game.stage4) > game.stage3Value) {
                    game.stage4Value = game.getValues(game.stage4);
                    eligible = true;
                    System.out.println("\n                *Sufficient");
                } else {
                    System.out.println("\n                *Insufficient value for the below stage 4");
                    return false;
                }
                break;
            case 5:
                if (game.getValues(game.stage5) > game.stage4Value) {
                    game.stage5Value = game.getValues(game.stage5);
                    eligible = true;
                    System.out.println("\n                *Sufficient");
                } else {
                    System.out.println("\n                *Insufficient value for the below stage 5");
                    return false;
                }
                break;
        }
        return eligible;
    }

    public void printStage(int num){
        switch (num) {
            case 1:
                String s1 = game.arrayToString(game.stage1);
                System.out.println("    Stage 1: " + s1);
                break;
            case 2:
                String s2 = game.arrayToString(game.stage2);
                System.out.println("    Stage 2: " + s2);
                break;
            case 3:
                String s3 = game.arrayToString(game.stage3);
                System.out.println("    Stage 3: " + s3);
                break;
            case 4:
                String s4 = game.arrayToString(game.stage4);
                System.out.println("    Stage 4: " + s4);
                break;
            case 5:
                String s5 = game.arrayToString(game.stage5);
                System.out.println("    Stage 5: " + s5);
                break;
        }
    }

    public void discardStageCards() {
        int num = game.stage1.size();
        for (int i = 0; i < num; i++) {
            discardAdvCard(game.stage1.remove(0));
        }
        num = game.stage2.size();
        for (int i = 0; i < num; i++) {
            discardAdvCard(game.stage2.remove(game.stage2.size() - 1));
        }
        num = game.stage3.size();
        for (int i = 0; i < num; i++) {
            discardAdvCard(game.stage3.remove(game.stage3.size() - 1));
        }
        num = game.stage4.size();
        for (int i = 0; i < num; i++) {
            discardAdvCard(game.stage4.remove(game.stage4.size() - 1));
        }
        num = game.stage5.size();
        for (int i = 0; i < num; i++) {
            discardAdvCard(game.stage5.remove(game.stage5.size() - 1));
        }
    }

    public void discardAttackCards() {
        int num = attack.size();
        for (int i = 0; i < num; i++) {
            discardAdvCard(attack.remove(0));
        }
    }

    public void drawAdvCardsTo12() {
        int num = 12 - this.getCardsSize();
        for (int j = 0; j < num; j++) {
            drawAdvCard();
        }
    }

    public void printAttack(){
        String attackStr = this.getID() + " Attack: ";
        for (int i=0; i<attack.size(); i++){
            attackStr += attack.get(i).getName() + attack.get(i).getValue() + " ";
        }
        System.out.println(attackStr);
    }

    public String printHand(){
        String handStr = this.getID() + " Cards: ";
        for (int i=0; i<cards.size(); i++){
            handStr += cards.get(i).getName() + cards.get(i).getValue() + " ";
        }
        return handStr;
    }

    public String promptAttack(Scanner input) {
        if (this.getID().equals(game.sponsoringPlayer.getID())) {
            System.out.println("Sponsoring Player Can't Set Up an Attack");
            return "";
        }

        System.out.println(getID() + " Cards: " + cardsToString());
        System.out.println(getID() + " select what position (1-" + getCardsSize() + ") should be used in the attack (enter 'Q' to quit): ");
        String inputStr = input.nextLine();
        int inputNum = -1;

        try {
            inputNum = Integer.parseInt(inputStr);
            attack.add(cards.remove(inputNum - 1));
            System.out.println(inputNum);
            return inputStr;
        } catch (NumberFormatException e) {
            System.out.println("Q");
            return inputStr;
        }
    }

    public void setUpAttack(Scanner input) {
        boolean go = true;
        while (go) {
            String item = promptAttack(input);
            if (item.equals("Q")) {
                go = false;
                break;
            }
        }
    }

    public void attackStage(ArrayList<Card> stage, String stageStr) {
        // define attack value
        int attackValue = 0;
        for (int i = 0; i < attack.size(); i++) {
            attackValue += attack.get(i).getValue();
        }
        printAttack();

        if (stageStr.equals("stage1")) {
            System.out.println("Attack Value: " + attackValue);
            if (attackValue < game.stage1Value) {
                discardAttackCards();
                game.noLongerEligible.add(this);
//                game.updateEligiblePlayers(this); // remove this player from eligibility list of players
                System.out.println("Didn't clear stage, removed from eligible players");
            } else {
                System.out.println("Stage is cleared successful");
            }
        } else if (stageStr.equals("stage2")) {
            System.out.println("Attack Value:" + attackValue);
            if (attackValue < game.stage2Value) {
                discardAttackCards();
                game.noLongerEligible.add(this);
//                game.updateEligiblePlayers(this);
                System.out.println("Didn't clear stage, removed from eligible players");
            } else {
                System.out.println("Stage is cleared successful");
            }
        } else if (stageStr.equals("stage3")) {
            System.out.println("Attack Value:" + attackValue);
            if (attackValue < game.stage3Value) {
                discardAttackCards();
                game.noLongerEligible.add(this);
//                game.updateEligiblePlayers(this);
                System.out.println("Didn't clear stage, removed from eligible players");
            } else {
                System.out.println("Stage is cleared successfully");
            }
        } else if (stageStr.equals("stage4")) {
            System.out.println("Attack Value:" + attackValue);
            if (attackValue < game.stage4Value) {
                discardAttackCards();
                game.noLongerEligible.add(this);
//                game.updateEligiblePlayers(this);
                System.out.println("Didn't clear stage, removed from eligible players");
            } else {
                System.out.println("Stage is cleared successfully");
            }
        } else if (stageStr.equals("stage5")) {
            System.out.println("Attack Value:" + attackValue);
            if (attackValue < game.stage5Value) {
                discardAttackCards();
                game.noLongerEligible.add(this);
//                game.updateEligiblePlayers(this);
                System.out.println("Didn't clear stage, removed from eligible players");
            } else {
                System.out.println("Stage is cleared successfully");
            }
        }
    }

    public void sortCards() {
        List<Card> newCards = new ArrayList<>();
        ArrayList<Integer> numF = new ArrayList<>();
        int numH = 0;
        int numS = 0;
        int numD = 0;
        int numB = 0;
        int numL = 0;
        int numE = 0;

        for (int i = 0; i < getCardsSize(); i++) {
            if (getCard(i).getName().equals("F")) {
                numF.add(getCard(i).getValue());
            } else if (getCard(i).getName().equals("D")) {
                numD++;
            } else if (getCard(i).getName().equals("H")) {
                numH++;
            } else if (getCard(i).getName().equals("S")) {
                numS++;
            } else if (getCard(i).getName().equals("B")) {
                numB++;
            } else if (getCard(i).getName().equals("L")) {
                numL++;
            } else if (getCard(i).getName().equals("E")) {
                numE++;
            }
        }

        Collections.sort(numF);

        // add in f's to new card
        if (!numF.isEmpty()) {
            for (int i = 0; i < numF.size(); i++) {
                newCards.add(new Card("Adventure", "F", numF.get(i)));
            }
        }
        int total = numF.size();

        // add in the rest
        total += numD;
        for (int i = numF.size(); i < total; i++) {
            newCards.add(new Card("Adventure", "D", 5));
        }

        total += numS;
        for (int i = total; i < total + numS; i++) {
            newCards.add(new Card("Adventure", "S", 10));
        }
        total += numH;
        for (int i = total; i < total + numH; i++) {
            newCards.add(new Card("Adventure", "H", 10));
        }
        total += numB;
        for (int i = total; i < total + numB; i++) {
            newCards.add(new Card("Adventure", "B", 15));
        }
        total += numL;
        for (int i = total; i < total + numL; i++) {
            newCards.add(new Card("Adventure", "L", 20));
        }
        total += numE;
        for (int i = total; i < total + numE; i++) {
            newCards.add(new Card("Adventure", "E", 30));
        }
        cards = newCards;
    }
}

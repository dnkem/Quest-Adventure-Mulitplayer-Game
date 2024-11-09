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
        // collect player card info into a string
        String cards = "";
        for (int i = 0; i < getCardsSize(); i++) {
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
            System.out.println(inputNum);
        } catch (NumberFormatException e) {
            output.println("input is not valid");
            output.flush();
            return;
        }

        // delete at index
        trimCard(inputNum);
    }

    public void trimCard(int index) {
        // print
        System.out.println("Cards Before Deletion:      " + cardsToString());

        // delete at index
        if (index > 0 && index <= this.getCardsSize()) {
            this.discardAdvCard(cards.remove(index -1));
            System.out.println("Deleted card at position: " + index);
        }

        // re print correctly
        System.out.println("Cards After deletion:       " + cardsToString());
    }

    public void trimToTwelve(Scanner input, PrintWriter output) {
        if (getCardsSize() <= 12) return;
        int extraCards = this.getCardsSize() - 12;
        for (int i = 0; i < extraCards; i++) {
            promptPosition(input, output);
        }
        System.out.println(cardsToString());
    }

    // COMMIT 5 - RESP 5
    public void drawAdvCard() {
        cards.add(game.advDeck.getDeck().removeLast());
    }

    public void drawEventCard() {
        game.currentDrawnEventCard = game.eventDeck.removeLast();
        System.out.println("    " + game.currentDrawnEventCard.type + ": " + game.currentDrawnEventCard.getName() + game.currentDrawnEventCard.getValue());
        if (game.currentDrawnEventCard.getName().equals("Queen’s favor")) {
            playQueenEventCard(game.currentPlayer);
        } else if (game.currentDrawnEventCard.getName().equals("Prosperity")) {
            playProsperityCard(game.currentPlayer);
        } else if (game.currentDrawnEventCard.getName().equals("Plague")) {
            playPlagueCard(game.currentPlayer);
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
        } else {
            System.out.println("Can't draw adv cards for Queens favor event");
        }
    }

    public void playProsperityCard(Player p) {
        if (game.currentPlayer.getID().equals(p.id) && game.currentDrawnEventCard.getName().equals("Prosperity")) {
            game.p1.drawAdvCard();
            game.p1.drawAdvCard();
            game.p2.drawAdvCard();
            game.p2.drawAdvCard();
            game.p3.drawAdvCard();
            game.p3.drawAdvCard();
            game.p4.drawAdvCard();
            game.p4.drawAdvCard();
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

    public boolean eligibleStage(ArrayList<Card> array) {
        boolean eligible = false;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equals("F")) {
                eligible = true;
            }
        }
        for (int i = 0; i < array.size(); i++) {
            for (int j = 1; j < array.size() - 1; j++) {
                if (array.get(i).getName().equals(array.get(j).getName())) {
                    eligible = false;
                    cards.add(array.remove(j));
                }
            }
        }
        return eligible;
    }

    public void buildStages(Scanner input) {
        for (int i = 0; i < game.currentDrawnEventCard.getValue(); i++) {
            boolean go = true;
            while (go) {
                System.out.println(getID() + " Cards: " + cardsToString());
                System.out.println("Stage " + (i + 1) + ": Select what position (1-" + getCardsSize() + ") should be used in this stage (enter 'Q' to quit): ");
                String inputStr = input.nextLine();

                int inputNum = -1;
                try {
                    inputNum = Integer.parseInt(inputStr);
                    System.out.println(inputNum);
                    if (getCardsSize() == 0) {
                        System.out.println("*The player's hand of cards is empty");
                        break;
                    } else if (inputNum > getCardsSize() || inputNum < 1) {
                        System.out.println("*This number, " + inputNum + ", is an invalid position");
                    } else {
                        switch (i) {
                            case 0:
                                game.stage1.add(cards.remove(inputNum - 1));
                                break;
                            case 1:
                                game.stage2.add(cards.remove(inputNum - 1));
                                break;
                            case 2:
                                game.stage3.add(cards.remove(inputNum - 1));
                                break;
                            case 3:
                                game.stage4.add(cards.remove(inputNum - 1));
                                break;
                            case 4:
                                game.stage5.add(cards.remove(inputNum - 1));
                                break;
                        }
                    }
                } catch (NumberFormatException e) {
                    if (i == 0 && game.stage1.isEmpty()) {
                        System.out.println("*This stage has no cards, A stage cannot be empty");
                        continue;
                    } else if (i == 1 && game.stage2.isEmpty()) {
                        System.out.println("*This stage has no cards, A stage cannot be empty");
                        continue;
                    } else if (i == 2 && game.stage3.isEmpty()) {
                        System.out.println("*This stage has no cards, A stage cannot be empty");
                        continue;
                    } else if (i == 3 && game.stage4.isEmpty()) {
                        System.out.println("*This stage has no cards, A stage cannot be empty");
                        continue;
                    } else if (i == 4 && game.stage5.isEmpty()) {
                        System.out.println("*This stage has no cards, A stage cannot be empty");
                        continue;
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
                case 0:
                    game.stage1Value = game.getValues(game.stage1);
                    break;
                case 1:
                    if (game.getValues(game.stage2) > game.stage1Value) {
                        game.stage2Value = game.getValues(game.stage2);
                        eligible = true;
                    } else {
                        System.out.println("*Insufficient value for this stage");
                        eligible = false;
                        i -= 1;
                    }
                    break;
                case 2:
                    if (game.getValues(game.stage3) > game.stage2Value) {
                        game.stage3Value = game.getValues(game.stage3);
                        eligible = true;
                    } else {
                        System.out.println("*Insufficient value for this stage");
                        eligible = false;
                        i -= 1;
                    }
                    break;
                case 3:
                    if (game.getValues(game.stage4) > game.stage3Value) {
                        game.stage4Value = game.getValues(game.stage4);
                        eligible = true;
                    } else {
                        System.out.println("*Insufficient value for this stage");
                        eligible = false;
                        i -= 1;
                    }
                    break;
                case 4:
                    if (game.getValues(game.stage5) > game.stage4Value) {
                        game.stage5Value = game.getValues(game.stage5);
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
                        String s1 = game.arrayToString(game.stage1);
                        System.out.println("    Stage 1: " + s1);
                        break;
                    case 1:
                        String s2 = game.arrayToString(game.stage2);
                        System.out.println("    Stage 2: " + s2);
                        break;
                    case 2:
                        String s3 = game.arrayToString(game.stage3);
                        System.out.println("    Stage 3: " + s3);
                        break;
                    case 3:
                        String s4 = game.arrayToString(game.stage4);
                        System.out.println("    Stage 4: " + s4);
                        break;
                    case 4:
                        String s5 = game.arrayToString(game.stage5);
                        System.out.println("    Stage 5: " + s5);
                        break;
                }
            }
        }
    }

    public void discardStageCards() {
        int num = game.stage1.size();
        for (int i = 0; i < num; i++) {
            discardAdvCard(game.stage1.removeFirst());
        }
        num = game.stage2.size();
        for (int i = 0; i < num; i++) {
            discardAdvCard(game.stage2.removeLast());
        }
        num = game.stage3.size();
        for (int i = 0; i < num; i++) {
            discardAdvCard(game.stage3.removeLast());
        }
        num = game.stage4.size();
        for (int i = 0; i < num; i++) {
            discardAdvCard(game.stage4.removeLast());
        }
        num = game.stage5.size();
        for (int i = 0; i < num; i++) {
            discardAdvCard(game.stage5.removeLast());
        }
    }

    public void discardAttackCards() {
        int num = attack.size();
        for (int i = 0; i < num; i++) {
            discardAdvCard(attack.removeFirst());
        }
    }

    public void drawAdvCardsTo12() {
        int num = 12 - this.getCardsSize();
        for (int j = 0; j < num; j++) {
            drawAdvCard();
        }
    }

    public String promptAttack(Scanner input) {
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

        if (stageStr.equals("stage1")) {
            System.out.println("Attack Value:" + attackValue);
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

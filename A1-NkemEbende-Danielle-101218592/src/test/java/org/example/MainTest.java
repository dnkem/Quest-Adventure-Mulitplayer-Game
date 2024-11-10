package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MainTest {
    @Test
    @DisplayName("Check Adventure Deck Size")
    public void RESP_1_test_01(){
        Game game = new Game();
        game.advDeck.initAdvDeck();

        // test 1: there should be 100 adventure cards
        int advDeckSize = game.advDeck.getDeckSize();
        assertEquals(100, advDeckSize);
    }

    @Test
    @DisplayName("Check Event Deck Size")
    public void RESP_1_test_02(){
        Game game = new Game();
        game.eventDeck.initEventDeck();

        // test 2: there should be 17 cards
        int eventDeckSize = game.eventDeck.getDeckSize();
        assertEquals(17, eventDeckSize);
    }

    @Test
    @DisplayName("Check Adventure Deck contents")
    public void RESP_1_test_03(){
        Game game = new Game();
        game.advDeck.initAdvDeck();
        List<Card> advDeck = game.advDeck.getDeck();

        // test 3: check that all card types of Foe and Weapon cards in the adventure deck
        // check foe and weapon cards
        int i=0;
        while (i < (game.advDeck.getDeckSize() / 2)){
            if (i >= 0 && i < 8) {
                assertTrue(advDeck.get(i).getName().equals("F") && advDeck.get(i).getValue() == 5, "F5s issue");
            } else if (i>=8 && i<15){
                assertTrue(advDeck.get(i).getName() == "F" && advDeck.get(i).getValue() == 10,"F10s issue");
            } else if (i>=15 && i<23){
                assertTrue(advDeck.get(i).getName() == "F" && advDeck.get(i).getValue() == 15, "F15 issue");
            } else if (i>=23 && i<30){
                assertTrue(advDeck.get(i).getName() == "F" && advDeck.get(i).getValue() == 20, "F20 issue");
            } else if (i>=30 && i<37){
                assertTrue(advDeck.get(i).getName() == "F" && advDeck.get(i).getValue() == 25, "F25 issue");
            } else if (i>=37 && i<41){
                assertTrue(advDeck.get(i).getName() == "F" && advDeck.get(i).getValue() == 30, "F30 issue");
            } else if (i>=41 && i<45) {
                assertTrue(advDeck.get(i).getName() == "F" && advDeck.get(i).getValue() == 35, "F35 issue");
            } else if (i>=45 && i<47) {
                assertTrue(advDeck.get(i).getName() == "F" && advDeck.get(i).getValue() == 40, "F40 issue");
            } else if (i==47 || i==48) {
                assertTrue(advDeck.get(i).getName() == "F" && advDeck.get(i).getValue() == 50, "F50 issue");
            } else if (i == 49) {
                assertTrue(advDeck.get(i).getName() == "F" && advDeck.get(i).getValue() == 70, "F70 issue");
            }
            i++;
        }

        // check weapon cards
        i=50;
        while (i<game.advDeck.getDeckSize()){
            if (i < 56){
                assertTrue(advDeck.get(i).getName() == "D" && advDeck.get(i).getValue() == 5, "D5 issue");
            } else if (i >= 56 && i < 68){
                assertTrue(advDeck.get(i).getName() == "H" && advDeck.get(i).getValue() == 10, "H10 issue");
            } else if (i >= 68 && i < 84){
                assertTrue(advDeck.get(i).getName() == "S" && advDeck.get(i).getValue() == 10, "S10 issue");
            } else if (i >= 84 && i < 92){
                assertTrue(advDeck.get(i).getName() == "B" && advDeck.get(i).getValue() == 15, "B15 issue");
            } else if (i >= 92 && i < 98){
                assertTrue(advDeck.get(i).getName() == "L" && advDeck.get(i).getValue() == 20, "L20 issue");
            } else if (i >= 98 && i < 100){
                assertTrue(advDeck.get(i).getName() == "E" && advDeck.get(i).getValue() == 30, "E30 issue");
            }
            i++;
        }
    }

    @Test
    @DisplayName("Check Event Deck contents")
    public void RESP_1_test_04(){
        Game game = new Game();
        game.eventDeck.initEventDeck();
        List<Card> eventDeck = game.eventDeck.getDeck();

        // test 4: check that all card types of Quest and Event cards in the event deck
        // check quests
        int i=0;
        while (i<game.eventDeck.getDeckSize() - 6){ // minus 5 for Events and minus 1 for index
            if (i < 3) {
                assertTrue(eventDeck.get(i).getName() == "Q" && eventDeck.get(i).getValue() == 2, "Q2 issue");
            } else if (i >= 3 && i < 7){
                assertTrue(eventDeck.get(i).getName() == "Q" && eventDeck.get(i).getValue() == 3, "Q3 issue");
            } else if (i >= 7 && i < 10){
                assertTrue(eventDeck.get(i).getName() == "Q" && eventDeck.get(i).getValue() == 4, "Q4 issue");
            } else if (i >= 10 && i < 12){
                assertTrue(eventDeck.get(i).getName() == "Q" && eventDeck.get(i).getValue() == 5, "Q5 issue");
            }
            i++;
        }

        // check events
        i=12;
        while (i<game.eventDeck.getDeckSize()){
            if (i==12) {
                assertTrue(eventDeck.get(i).getName() == "Plague" && eventDeck.get(i).getValue() == 2, "Plague issue");
            } else if(i==13 || i==14){
                assertTrue(eventDeck.get(i).getName() == "Queen’s favor" && eventDeck.get(i).getValue() == 2, "Queens favor issue");
            } else if (i==15 || i == 16){
                assertTrue(eventDeck.get(i).getName() == "Prosperity" && eventDeck.get(i).getValue() == 2, "Proseperity issue");
            }
            i++;
        }


    }

    @Test
    @DisplayName("Check for Shuffled Cards")
    public void RESP_2_test_01(){
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();

        // test 1: check that both decks are shuffled

        // after decks that get updated once shuffled
        List<Card> afterAdvDeck = game.advDeck.getDeck();
        List<Card> afterEventDeck = game.eventDeck.getDeck();

        // create deep copy of decks before shuffle
        ArrayList<Card> beforeAdvDeck = new ArrayList<Card>();
        for (int i=0; i< game.advDeck.getDeckSize(); i++){
            Card card = new Card(afterAdvDeck.get(i).getType(), afterAdvDeck.get(i).getName(), afterAdvDeck.get(i).getValue());
            beforeAdvDeck.add(card);
        }
        ArrayList<Card> beforeEventDeck = new ArrayList<Card>();
        for (int i=0; i< game.eventDeck.getDeckSize(); i++){
            Card card = new Card(afterEventDeck.get(i).getType(), afterEventDeck.get(i).getName(), afterEventDeck.get(i).getValue());
            beforeEventDeck.add(card);
        }

        //shuffle
        game.advDeck.shuffleDeck();
        game.eventDeck.shuffleDeck();

        // check and compare
        assertNotEquals(beforeAdvDeck, afterAdvDeck);
        assertNotEquals(beforeEventDeck, afterEventDeck);
    }

    @Test
    @DisplayName("Check for Card Distribution")
    public void RESP_2_test_02() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();

        Player p1 = game.p1;
        Player p2 = game.p2;
        Player p3 = game.p3;
        Player p4 = game.p4;

        // don't shuffle cards first so we can tell they are being removed
        game.distributeCards();

        // test 1: check that all players have 12 cards
        assertEquals(12, p1.getCardsSize(), "P1 card number issue");
        assertEquals(12, p2.getCardsSize(), "P2 card number issue");
        assertEquals(12, p3.getCardsSize(), "P3 card number issue");
        assertEquals(12, p4.getCardsSize(), "P4 card number issue");
    }

    @Test
    @DisplayName("Check that the Adventure Deck was Updated")
    public void RESP_2_test_03() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();

        // test 1: check adventure size to ensure cards were distributed (100 - 12 - 12 - 12 - 12 = 52)
        assertEquals(52, game.advDeck.getDeckSize(), "Cards were not distributed");
    }

    // COMMIT 3 - RESP 3
    @Test
    @DisplayName("Check Game's First Player")
    public void RESP_3_test_01() {
        Game game = new Game();

        // test 1: check that the game starts with player 1
        assertEquals("P1", game.currentPlayer.getID(), "Current player is incorrect");
    }

    @Test
    @DisplayName("Game assigns current player")
    public void RESP_3_test_02() {
        Game game = new Game();

        // test 2: check that the game loops in the correct order for 2 rounds
        int i=0;
        while (i<9) {
            if (i == 0 || i == 4 || i == 8) {
                assertEquals("P1", game.currentPlayer.getID());
            } else if (i == 1 || i == 5){
                assertEquals("P2", game.currentPlayer.getID());
            } else if (i == 2 || i == 6){
                assertEquals("P3", game.currentPlayer.getID());
            } else if (i == 3 || i == 7){
                assertEquals("P4", game.currentPlayer.getID());
            }
            game.nextPlayer();
            i++;
        }
    }

    // COMMIT 4 - RESP 4
    @Test
    @DisplayName("A Player's Cards Are Visible") // deck is unshuffled so we know what the player's card should display
    public void RESP_4_test_01() {
        String string = "";
        StringWriter stringWriter = new StringWriter(); // use stringWriter as a replacement for Scanner for JUnit tests

        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.distributeCards();

        // test 1: check that a player's cards were printed to the screen
        game.p1.printPlayersCards(new PrintWriter(stringWriter));
        string = stringWriter.toString();
        assertTrue(string.contains("E30 E30 L20 L20 L20 L20 L20 L20 B15 B15 B15 B15"));
        // note that the test doesn't need to actually print but it should when the corresponding function runs in main
    }

    // COMMIT 5 - RESP 5
    @Test
    @DisplayName("Player Draws Single Event Card and the event deck updates")
    public void RESP_5_test_01() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        // non-shuffled deck

        // test 1: a card is removed from event deck
        game.p1.drawEventCard();
        assertEquals(16, game.eventDeck.size(), "Event card drawn issue");
    }

    @Test
    @DisplayName("Player Draws Many Event Card and the event deck updates")
    public void RESP_5_test_02() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        // non-shuffled deck

        // test 2: Multiple drawn cards are removed from event deck
        game.p1.drawEventCard();
        game.p1.drawEventCard();
        game.p1.drawEventCard();
        assertEquals(14, game.eventDeck.getDeckSize(), "Event card drawn issue");

    }

    @Test
    @DisplayName("Player Draws Event Card and the correct card is drawn")
    public void RESP_5_test_03() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        // non-shuffled deck

        // test 3: a card is removed from event deck
        // getting last card in eventDeck
        String name = game.eventDeck.get(game.eventDeck.getDeckSize() - 1).name;
        String type = game.eventDeck.get(game.eventDeck.getDeckSize() - 1).type;
        int value = game.eventDeck.get(game.eventDeck.getDeckSize() - 1).value;


        game.p1.drawEventCard();
        assertEquals(name, game.currentDrawnEventCard.name, "Wrong card");
        assertEquals(type, game.currentDrawnEventCard.type, "Wrong card");
        assertEquals(value, game.currentDrawnEventCard.value, "Wrong card");

    }

    @Test
    @DisplayName("Player Draws Many Event Cards and the correct card is drawn")
    public void RESP_5_test_04() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        // non-shuffled deck

        // test 4:  Multiple cards drawn are removed form the event deck
        // getting last card in eventDeck
        String name = game.eventDeck.get(game.eventDeck.getDeckSize()-3).name;
        String type = game.eventDeck.get(game.eventDeck.getDeckSize()-3).type;
        int value = game.eventDeck.get(game.eventDeck.getDeckSize()-3).value;

        game.p1.drawEventCard();
        game.p1.drawEventCard();
        game.p1.drawEventCard();
        assertEquals(name, game.currentDrawnEventCard.name, "Wrong card");
        assertEquals(type, game.currentDrawnEventCard.type, "Wrong card");
        assertEquals(value, game.currentDrawnEventCard.value, "Wrong card");
    }

    // COMMIT 6 - RESP 6
    @Test
    @DisplayName("Player Draws Queens Favour E Card is Correct")
    public void RESP_6_test_01() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck(); // no shuffle
        game.distributeCards();

        // test 1: check that the drawn card is Queens favor
        game.eventDeck.get(game.eventDeck.getDeckSize()-1).name = "Queen’s favor"; // set last card as Queens favor
        game.p1.drawEventCard();
        assertEquals("Queen’s favor", game.currentDrawnEventCard.getName());
    }

    @Test
    @DisplayName("Player Draws Queens Favour E Card draws 2 adv card")
    public void RESP_6_test_02() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck(); // no shuffle
        game.distributeCards();

        // test 2: the player drew 2 cards
        game.eventDeck.get(game.eventDeck.getDeckSize()-1).name = "Queen’s favor"; // set last card as Queens favor
//        game.drawEventCard();

        if (game.currentPlayer.getID().equals("P1")){
            game.p1.drawEventCard();
            assertEquals(14, game.p1.cards.size());
        } else if (game.currentPlayer.getID().equals("P2")){
            game.p2.drawEventCard();
            assertEquals(14, game.p2.cards.size());
        } else if (game.currentPlayer.getID().equals("P3")){
            game.p3.drawEventCard();
            assertEquals(14, game.p3.cards.size());
        } else if (game.currentPlayer.getID().equals("P4")){
            game.p4.drawEventCard();
            assertEquals(14, game.p4.cards.size());
        }
    }

    @Test
    @DisplayName("Player Draws Queens Favour E Card number of Event and Adventure deck")
    public void RESP_6_test_03() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck(); // no shuffle
        game.distributeCards();

        // test 3: check number of cards in deck after
        game.eventDeck.get(game.eventDeck.getDeckSize()-1).name = "Queen’s favor"; // set last card as Queens favor
        game.p1.drawEventCard();
        assertEquals(50, game.advDeck.getDeckSize());
    }

    // COMMIT 7
    @Test
    @DisplayName("Player Trims Cards by 1")
    public void RESP_7_test_01() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck(); // no shuffle
        game.distributeCards();
        game.p1.drawAdvCard();

        // test 1: check that last card is removed
        game.p1.trimCard(12);
        assertEquals(12, game.p1.getCardsSize()); // updated the trim user, they can't reduce below 12 so this neeeded an update
    }

    @Test
    @DisplayName("Player Trims Cards by 3")
    public void RESP_7_test_02() {
        System.out.println("\n\n *Trim By 3*");
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck(); // no shuffle
        game.distributeCards();
        game.p1.drawAdvCard(); // updated the trim user, they can't reduce below 12 so this needed to be added
        game.p1.drawAdvCard();
        game.p1.drawAdvCard();

        // test 2: check that cards are removed
        game.p1.trimCard(9);
        game.p1.trimCard(9);
        game.p1.trimCard(9);
        assertEquals(12, game.p1.getCardsSize()); // updated the trim user so they can't reduce below 12
    }

    @Test
    @DisplayName("Player Trims Cards by 4 Again")
    public void RESP_7_test_03() {
        System.out.println("\n\n *Trim By LAST 4*");
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck(); // no shuffle
        game.distributeCards();
        game.p1.drawAdvCard(); // updated the trim user so they can't reduce below 12
        game.p1.drawAdvCard(); // updated the trim user so they can't reduce below 12

        // getting last card after last 4 cards were trimmed from hand
        String name = game.p1.cards.get(game.p1.getCardsSize() - 3).name;
        String type = game.p1.cards.get(game.p1.getCardsSize()  - 3).type;
        int value = game.p1.cards.get(game.p1.getCardsSize()  - 3).value;

        // test 3: check that 3 last cards were removed and that the last card in hand is correct
        game.p1.trimCard(game.p1.getCardsSize());
        game.p1.trimCard(game.p1.getCardsSize());
        assertEquals(name, game.p1.cards.get(game.p1.getCardsSize()-1).getName(), "Wrong card");
        assertEquals(type, game.p1.cards.get(game.p1.getCardsSize()-1).getType(), "Wrong card");
        assertEquals(value, game.p1.cards.get(game.p1.getCardsSize()-1).getValue(), "Wrong card");
    }

    @Test
    @DisplayName("Player Trims Cards and Console Shows Update")
    public void RESP_7_test_04() {
        System.out.println("\n\n *Trim By LAST 1 & Check Print*");
        String string = "";
        StringWriter stringWriter = new StringWriter();

        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.distributeCards();
        game.p1.drawAdvCard();// updated the trim user so they can't reduce below 12
        // UNSHUFFLED CARDS SO THIS IS P1s ORG HAND: E30   E30   L20   L20   L20   L20   L20   L20   B15   B15   B15   B15

        // test 4: check that a player's cards were printed to the screen after trim
        game.p1.trimCard(12); // trim last card B15
        game.p1.printPlayersCards(new PrintWriter(stringWriter));
        string = stringWriter.toString();
        assertFalse(string.contains("E30   E30   L20   L20   L20   L20   L20   L20   B15   B15   B15   B15 ")); // updated the trim user so they can't reduce below 12
        // note that the test doesn't need to actually print but it should when the corresponding function runs in main
    }

    @Test
    @DisplayName("Player has 12+ Cards and Trims Cards")
    public void RESP_7_test_05() {
        System.out.println("\n\n *Trim By LAST 5 Down to 12*");
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.distributeCards();
        String input = String.valueOf("12\n12\n12\n12\n12\n");
        StringWriter output = new StringWriter();
        // UNSHUFFLED CARDS SO THIS IS P1s ORG HAND: E30   E30   L20   L20   L20   L20   L20   L20   B15   B15   B15   B15

        // test 5: add 2 cards to the initial 12 and trim down to 12 cards
        game.p1.drawAdvCard();
        game.p1.drawAdvCard();
        game.p1.drawAdvCard();
        game.p1.drawAdvCard();
        game.p1.drawAdvCard();
        game.p1.trimToTwelve(new Scanner(input), new PrintWriter(output));
        assertEquals(12, game.p1.getCardsSize());
    }

    @Test
    @DisplayName("Player Trims Cards and Console Shows Update")
    public void RESP_7_test_06() {
        String input = "12\n";
        StringWriter output = new StringWriter();
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.distributeCards();

        // test 4: check that a player's cards were printed to the screen after trim
        game.p1.promptPosition(new Scanner(input), new PrintWriter(output));
        assertTrue(output.toString().contains("input is valid"));

    }

    // COMMIT 8
    @Test
    @DisplayName("From Hand to Discard pile via Trim")
    public void RESP_8_test_01(){
        Game game = new Game();
        game.advDeck = new Deck();

        // test 1: add in adv cards and assign them to P1 then they discard them
        Card cardF5 = new Card("Adventure","F",5);
        game.advDeck.add(cardF5);
        Card cardF10 = new Card("Adventure","F",10);
        game.advDeck.add(cardF10);

        game.p1.drawAdvCard();
        game.p1.drawAdvCard();
        assertEquals(2, game.p1.getCardsSize());
        assertEquals(0, game.discardAdvDeck.getDeckSize());
        game.p1.trimCard(1);
        game.p1.trimCard(1);
        assertEquals(2, game.p1.getCardsSize());            // updated the trim user so they can't reduce below 12
        assertEquals(0, game.discardAdvDeck.getDeckSize()); // updated the trim user so they can't reduce below 12
    }

    @Test
    @DisplayName("From Hand to Discard pile via Trim to 12")
    public void RESP_8_test_02() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.distributeCards();
        String input = String.valueOf("12\n12\n12\n12\n12\n");
        StringWriter output = new StringWriter();
        // UNSHUFFLED CARDS SO THIS IS P1s ORG HAND: E30   E30   L20   L20   L20   L20   L20   L20   B15   B15   B15   B15

        // test 2: add 5 cards to the initial 12 and trim down to 12 cards and make sure they go to discard pile
        game.p1.drawAdvCard();
        game.p1.drawAdvCard();
        game.p1.drawAdvCard();
        game.p1.drawAdvCard();
        game.p1.drawAdvCard();
        game.p1.trimToTwelve(new Scanner(input), new PrintWriter(output));
        assertEquals(12, game.p1.getCardsSize());
        assertEquals(5, game.discardAdvDeck.getDeckSize());
    }

    // COMMIT 9
    @Test
    @DisplayName("Player Draws Prosperity E Card Correctly")
    public void RESP_9_test_01() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck(); // no shuffle
        game.distributeCards();

        // test 1: check that the drawn card is Prosperity
        game.eventDeck.get(game.eventDeck.getDeckSize()-1).name = "Prosperity"; // set last card as Prosperity
        game.p1.drawEventCard();
        assertEquals("Prosperity", game.currentDrawnEventCard.getName());
    }

    @Test
    @DisplayName("Player Draws Prosperity E Card then draws 2 adv card")
    public void RESP_9_test_02() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck(); // no shuffle
        game.distributeCards();

        // test 2: all players drew 2 cards
        game.eventDeck.get(game.eventDeck.getDeckSize()-1).name = "Prosperity"; // set last card as Prosperity

        if (game.currentPlayer.getID().equals("P1")){
            game.p1.drawEventCard();
            assertEquals(14, game.p1.cards.size());
            assertEquals(14, game.p2.cards.size());
            assertEquals(14, game.p3.cards.size());
            assertEquals(14, game.p4.cards.size());
        } else if (game.currentPlayer.getID().equals("P2")){
            game.p2.drawEventCard();
            assertEquals(14, game.p1.cards.size());
            assertEquals(14, game.p2.cards.size());
            assertEquals(14, game.p3.cards.size());
            assertEquals(14, game.p4.cards.size());
        } else if (game.currentPlayer.getID().equals("P3")){
            game.p3.drawEventCard();
            assertEquals(14, game.p1.cards.size());
            assertEquals(14, game.p2.cards.size());
            assertEquals(14, game.p3.cards.size());
            assertEquals(14, game.p4.cards.size());
        } else if (game.currentPlayer.getID().equals("P4")){
            game.p4.drawEventCard();
            assertEquals(14, game.p1.cards.size());
            assertEquals(14, game.p2.cards.size());
            assertEquals(14, game.p3.cards.size());
            assertEquals(14, game.p4.cards.size());
        }
    }

    @Test
    @DisplayName("Player Draws Prosperity E Card number of Event and Adventure deck")
    public void RESP_9_test_03() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck(); // no shuffle
        game.distributeCards();

        // test 3: check number of cards in adv deck after prosperity is drawn
        game.eventDeck.get(game.eventDeck.getDeckSize()-1).name = "Prosperity"; // set last card as Prosperity
        game.p1.drawEventCard();
        assertEquals(44, game.advDeck.getDeckSize());
    }

    @Test
    @DisplayName("All Players have 12+ Cards and Trims to 12")
    public void RESP_10_test_01() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();
        String input = String.valueOf("12\n12\n12\n12\n12\n");
        StringWriter output = new StringWriter();

        // test 1: p1 picks Prosperity card and all players pick 2 and trim down to 12 cards
        game.eventDeck.get(game.eventDeck.getDeckSize()-1).name = "Prosperity"; // set last card as Prosperity
        game.p1.drawEventCard();
        game.p1.trimToTwelve(new Scanner(input), new PrintWriter(output));
        game.p2.trimToTwelve(new Scanner(input), new PrintWriter(output));
        game.p3.trimToTwelve(new Scanner(input), new PrintWriter(output));
        game.p4.trimToTwelve(new Scanner(input), new PrintWriter(output));
        assertEquals(12, game.p1.getCardsSize());
        assertEquals(12, game.p2.getCardsSize());
        assertEquals(12, game.p3.getCardsSize());
        assertEquals(12, game.p4.getCardsSize());
    }

    @Test
    @DisplayName("Player Trim Cards, Screen Clears, and Console Shows Update")
    public void RESP_10_test_02() {
        String input = "12\n12\n";
        StringWriter output = new StringWriter();
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();

        // test 2: check that all player's cards were printed when trimmed & cleared on the screen after trim
        game.eventDeck.get(game.eventDeck.getDeckSize()-1).name = "Prosperity"; // set last card as Prosperity
        game.p1.drawEventCard();

        game.p1.trimToTwelve(new Scanner(input), new PrintWriter(output));
        assertTrue(output.toString().contains("input is valid"));
        game.clearScreen(new PrintWriter(output));
        assertTrue(output.toString().contains("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"));

        game.p2.trimToTwelve(new Scanner(input), new PrintWriter(output));
        assertTrue(output.toString().contains("input is valid"));
        game.clearScreen(new PrintWriter(output));
        assertTrue(output.toString().contains("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"));

        game.p3.trimToTwelve(new Scanner(input), new PrintWriter(output));
        assertTrue(output.toString().contains("input is valid"));
        game.clearScreen(new PrintWriter(output));
        assertTrue(output.toString().contains("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"));

        game.p4.trimToTwelve(new Scanner(input), new PrintWriter(output));
        assertTrue(output.toString().contains("input is valid"));
        game.clearScreen(new PrintWriter(output));
        assertTrue(output.toString().contains("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"));
    }

    @Test
    @DisplayName("Player Plays Plague E card")
    public void RESP_11_test_01() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();

        // test 1: Player plays plague card with 0  shields
        assertEquals(17, game.eventDeck.getDeckSize());
        game.eventDeck.get(game.eventDeck.getDeckSize()-1).name = "Plague"; // set last card as Plague
        game.p1.drawEventCard();
        assertEquals(0, game.p1.getNumShields());
        assertEquals(16, game.eventDeck.getDeckSize());
    }

    @Test
    @DisplayName("Player w/ 3 shields Plays Plague E card")
    public void RESP_11_test_02() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();

        // test 2: Player plays plague card with many shields
        assertEquals(17, game.eventDeck.getDeckSize());
        game.eventDeck.get(game.eventDeck.getDeckSize()-1).name = "Plague"; // set last card as Plague
        game.p1.setNumShields(6);
        game.p1.drawEventCard();
        assertEquals(4, game.p1.getNumShields());
        assertEquals(16, game.eventDeck.getDeckSize());

    }

    @Test
    @DisplayName("Player draws an E card then discarded")
    public void RESP_12_test_01() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();

        // test 1: Player draws an E card, it gets played then discarded
        game.eventDeck.get(game.eventDeck.getDeckSize()-1).name = "Plague"; // set last card as Plague
        assertEquals(0, game.discardEventDeck.getDeckSize());
        game.p1.drawEventCard();
        assertEquals("Plague", game.discardEventDeck.getDeck().get(0).getName());
    }

    @Test
    @DisplayName("Player draws many E cards then discarded")
    public void RESP_12_test_02() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();

        // test 2: Player draws many E cards, they get played then discarded
        game.eventDeck.get(game.eventDeck.getDeckSize()-1).name = "Plague"; // set last card as Plague
        assertEquals(0, game.discardEventDeck.getDeckSize());
        game.p1.drawEventCard();
        assertEquals("Plague", game.discardEventDeck.getDeck().get(0).getName());

        game.eventDeck.get(game.eventDeck.getDeckSize()-1).name = "Queen's favour";
        assertEquals(1, game.discardEventDeck.getDeckSize());
        game.p1.drawEventCard();
        assertEquals("Queen's favour", game.discardEventDeck.getDeck().get(1).getName());

        game.eventDeck.get(game.eventDeck.getDeckSize()-1).name = "Prosperity";
        assertEquals(2, game.discardEventDeck.getDeckSize());
        game.p1.drawEventCard();
        assertEquals("Prosperity", game.discardEventDeck.getDeck().get(2).getName());
        assertEquals(3, game.discardEventDeck.getDeckSize());

    }

    @Test
    @DisplayName("Player draws a Q card and doesn't sponsor it")
    public void RESP_13_test_01() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();
        String input = "N\n";
        StringWriter output = new StringWriter();

        // test 1:
        game.eventDeck.get(game.eventDeck.getDeckSize()-1).name = "Q"; // set last card as a Q card
        game.p1.drawQuestCard(new Scanner(input), new PrintWriter(output));
        assertTrue(output.toString().contains("input is valid"));
    }

    @Test
    @DisplayName("Game prompts many players to sponsor quest")
    public void RESP_14_test_01() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();
        String input = "N\nN\nY\nN\n";
        StringWriter output = new StringWriter();

        // test 1: Game prompts many players to sponsor quest and p3 accepts and sponsors
        game.eventDeck.get(game.eventDeck.getDeckSize()-1).name = "Q"; // set last card as a Q card
        game.currentDrawnEventCard = game.eventDeck.removeLast();
        game.playersSponsorPrompt(new Scanner(input), new PrintWriter(output));
        assertEquals(game.p3, game.sponsoringPlayer);
    }

    @Test
    @DisplayName("Test that no one sponsored and it's the next persons turn")
    public void RESP_14_test_02() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();
        String input = "N\nN\nN\nN\n";
        StringWriter output = new StringWriter();

        // test 2: Test that no one sponsored and it's the next persons turn
        game.eventDeck.get(game.eventDeck.getDeckSize()-1).name = "Q"; // set last card as a Q card
        game.currentDrawnEventCard = game.eventDeck.removeLast();
        assertEquals(game.p1, game.currentPlayer);
        game.playersSponsorPrompt(new Scanner(input), new PrintWriter(output));
        assertEquals(game.p2, game.currentPlayer);


    }

    @Test
    @DisplayName("Current player accepts sponsor")
    public void RESP_14_test_03() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();
        String input = "Y\nN\nN\nN\n";
        StringWriter output = new StringWriter();

        // test 2: Test that no one sponsored and it's the next persons turn
        game.eventDeck.get(game.eventDeck.getDeckSize()-1).name = "Q"; // set last card as a Q card
        game.currentDrawnEventCard = game.eventDeck.removeLast();
        assertEquals(game.p1, game.currentPlayer);
        game.playersSponsorPrompt(new Scanner(input), new PrintWriter(output));
        assertEquals(game.p1, game.sponsoringPlayer);
    }

    @Test
    @DisplayName("Player builds stage for quest")
    public void RESP_15_test_01() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();
        String input = "12\n11\nQ\n10\n8\nQ\n7\n6\nQ\n1\n2\nQ\n1\n2\nQ\n";
        StringWriter output = new StringWriter();
        game.sponsoringPlayer = game.p1;

        // test 1: player 1 builds stage by adding into each stage and
        game.eventDeck.getDeck().get(game.eventDeck.getDeckSize()-1).name = "Q"; // set last card as a Q card
        game.eventDeck.getDeck().get(game.eventDeck.getDeckSize()-1).value = 4; // set last card as a Q card
        game.currentDrawnEventCard = game.eventDeck.getDeck().removeLast();
        game.currentPlayer.buildStages(new Scanner(input));
        assertEquals(2, game.stage1.size());
        assertEquals(2, game.stage2.size());
        assertEquals(2, game.stage3.size());
        assertEquals(2, game.stage4.size());
        assertEquals(0, game.stage5.size());
        assertTrue(game.stage1Value != 0);
        assertEquals(30, game.stage1Value);
        assertTrue(game.stage2Value != 0);
        assertEquals(35, game.stage2Value);
        assertTrue(game.stage3Value != 0);
        assertEquals(40, game.stage3Value);
        assertTrue(game.stage4Value != 0);
        assertEquals(50, game.stage4Value);
    }

    @Test
    @DisplayName("Player tries to quit w/ empty stage")
    public void RESP_15_test_02() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();
        String input = "12\n11\nQ\nQ\n10\n8\nQ\n";
        StringWriter output = new StringWriter();
        game.sponsoringPlayer = game.p1;


        // test 2: player 1 builds stage and tries to quit with an empty stage but is reprompted to continue
        game.eventDeck.getDeck().get(game.eventDeck.getDeckSize() - 1).name = "Q"; // set last card as a Q card
        game.eventDeck.getDeck().get(game.eventDeck.getDeckSize() - 1).value = 2; // set last card as a Q card
        game.currentDrawnEventCard = game.eventDeck.getDeck().removeLast();
        game.currentPlayer.buildStages(new Scanner(input));
        assertEquals(2, game.stage1.size());
        assertEquals(2, game.stage2.size());
    }

    @Test
    @DisplayName("Player tries to enter invalid position")
    public void RESP_15_test_03() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();
        String input = "12\n11\nQ\n10\n8\n0\nQ\n";
        StringWriter output = new StringWriter();
        game.sponsoringPlayer = game.p1;

        // test 3: player 1 builds stage and tries to enter invalid position
        game.eventDeck.getDeck().get(game.eventDeck.getDeckSize() - 1).name = "Q"; // set last card as a Q card
        game.eventDeck.getDeck().get(game.eventDeck.getDeckSize() - 1).value = 2; // set last card as a Q card
        game.currentDrawnEventCard = game.eventDeck.getDeck().removeLast();
        game.currentPlayer.buildStages(new Scanner(input));
        assertEquals(2, game.stage1.size());
        assertEquals(2, game.stage2.size());
    }

    @Test
    @DisplayName("Player tries to add to last stage with empty hand")
    public void RESP_15_test_04() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();
        String input = "12\n11\nQ\n10\n8\nQ\n7\n6\nQ\n1\n2\nQ\n1\n2\n1\n1\n1\nQ\n";
        StringWriter output = new StringWriter();
        game.sponsoringPlayer = game.p1;


        // test 4: player 1 builds stage and add to last stage with empty hand
        game.eventDeck.getDeck().get(game.eventDeck.getDeckSize()-1).name = "Q"; // set last card as a Q card
        game.eventDeck.getDeck().get(game.eventDeck.getDeckSize()-1).value = 5; // set last card as a Q card
        game.currentDrawnEventCard = game.eventDeck.getDeck().removeLast();
        game.currentPlayer.buildStages(new Scanner(input));
        assertEquals(2, game.stage1.size());
        assertEquals(4, game.stage5.size());
    }

    @Test
    @DisplayName("Check that stage values are valid")
    public void RESP_15_test_05() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();
        String input = "12\n11\nQ\n10\n8\nQ\n7\n6\nQ\n";
        StringWriter output = new StringWriter();
        game.sponsoringPlayer = game.p1;

        // test 5:
        game.eventDeck.getDeck().get(game.eventDeck.getDeckSize()-1).name = "Q"; // set last card as a Q card
        game.eventDeck.getDeck().get(game.eventDeck.getDeckSize()-1).value = 3; // set last card as a Q card
        game.currentDrawnEventCard = game.eventDeck.getDeck().removeLast();
        game.currentPlayer.buildStages(new Scanner(input));
        assertEquals(2, game.stage1.size());
        assertEquals(30, game.stage1Value);
        assertEquals(2, game.stage2.size());
        assertEquals(35, game.stage2Value);
        assertEquals(2, game.stage3.size());
        assertEquals(40, game.stage3Value);
    }
    @Test
    @DisplayName("Game gives eligible players")
    public void RESP_16_test_01() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();
        String input = "N\nY\n";
        StringWriter output = new StringWriter();

        // test
        game.eventDeck.get(game.eventDeck.getDeckSize()-1).name = "Q"; // set last card as a Q card
        game.currentDrawnEventCard = game.eventDeck.removeLast();
        game.playersSponsorPrompt(new Scanner(input), new PrintWriter(output));
        assertEquals(game.p2, game.sponsoringPlayer);
        game.getEligiblePlayers();
        game.printEligiblePlayers();
        assertEquals(game.p1, game.eligiblePlayers.get(0));
        assertEquals(game.p3, game.eligiblePlayers.get(1));
        assertEquals(game.p4, game.eligiblePlayers.get(2));
    }

    @Test
    @DisplayName("Prompt eligible players to join quest")
    public void RESP_17_test_01() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();
        String input = "N\nY\nN\n";
        String input2 = "Y\nN\nY\n";
        StringWriter output = new StringWriter();
        StringWriter output2 = new StringWriter();

        // test 1: Some yes's
        game.eventDeck.get(game.eventDeck.getDeckSize() - 1).name = "Q"; // set last card as a Q card
        game.currentDrawnEventCard = game.eventDeck.removeLast();
        game.playersSponsorPrompt(new Scanner(input), new PrintWriter(output));
        assertEquals(0, game.eligiblePlayers.size());
        game.getEligiblePlayers();
        assertEquals(3, game.eligiblePlayers.size());
        game.printEligiblePlayers();
        game.askEligiblePlayers(new Scanner(input2), new PrintWriter(output2));
        game.printEligiblePlayers();
        assertEquals(2, game.eligiblePlayers.size());
    }

    @Test
    @DisplayName("Prompt eligible players to join quest w/ all no's")
    public void RESP_17_test_02() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();
        String input = "N\nY\nN\n";
        String input2 = "N\nN\nN\n";
        StringWriter output = new StringWriter();
        StringWriter output2 = new StringWriter();

        // test 1: All no's for asking eligible players to join quest
        game.eventDeck.get(game.eventDeck.getDeckSize() - 1).name = "Q"; // set last card as a Q card
        game.currentDrawnEventCard = game.eventDeck.removeLast();
        game.playersSponsorPrompt(new Scanner(input), new PrintWriter(output));
        assertEquals(0, game.eligiblePlayers.size());
        game.getEligiblePlayers();
        assertEquals(3, game.eligiblePlayers.size());
        game.printEligiblePlayers();
        game.askEligiblePlayers(new Scanner(input2), new PrintWriter(output2));
        game.printEligiblePlayers();
        assertEquals(0, game.eligiblePlayers.size());
    }

    @Test
    @DisplayName("No quest participants end quest")
    public void RESP_18_test_01() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();
        String input = "Y\nN\nN\n";
        String input2 = "N\nN\nN\n";
        String input3 = "12\n11\nQ\n10\n8\nQ\n7\n6\nQ\n";
        StringWriter output = new StringWriter();
        StringWriter output2 = new StringWriter();

        // test 1: End quest cause of no quest participants
        game.eventDeck.get(game.eventDeck.getDeckSize() - 1).name = "Q"; // set last card as a Q card
        game.eventDeck.get(game.eventDeck.getDeckSize() - 1).value = 3; // set last card as a Q card
        game.currentDrawnEventCard = game.eventDeck.removeLast();
        game.playersSponsorPrompt(new Scanner(input), new PrintWriter(output));
        game.sponsoringPlayer.buildStages(new Scanner(input3));
        assertEquals(6, game.sponsoringPlayer.getCardsSize());

        game.getEligiblePlayers();
        game.printEligiblePlayers();
        game.askEligiblePlayers(new Scanner(input2), new PrintWriter(output2));
        game.printEligiblePlayers();

        game.sponsoringPlayer.discardStageCards();
        assertEquals(0, game.stage1.size());
        assertEquals(0, game.stage2.size());
        assertEquals(0, game.stage3.size());
        assertEquals(0, game.stage4.size());
        assertEquals(0, game.stage5.size());

        game.sponsoringPlayer.drawAdvCardsTo12();
        assertEquals(12, game.sponsoringPlayer.getCardsSize());

        game.nextPlayer();
        assertEquals(game.currentPlayer, game.p2);
    }

    @Test
    @DisplayName("P2 sets up attack")
    public void RESP_19_test_01() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();
        String input = "1\n2\n2\nQ\n";
        StringWriter output = new StringWriter();
        game.sponsoringPlayer = game.p1; // have to set sponsoring player to something to run

        assertEquals(12, game.p2.getCardsSize());
        game.p2.setUpAttack(new Scanner(input));
        assertEquals(3, game.p2.attack.size());
        assertEquals(9, game.p2.getCardsSize());
    }

    @Test
    @DisplayName("All eligible set up attack")
    public void RESP_19_test_02() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();
        String input = "1\n2\n2\nQ\n1\n2\n2\nQ\n1\n2\nQ\n"; // updated cause of switch of direction
        String input2 = "Y\nN\nN\n";
        String input3 = "12\n11\nQ\n10\n1\nQ";
        StringWriter output = new StringWriter();

        game.eventDeck.get(game.eventDeck.getDeckSize() - 1).name = "Q"; // set last card as a Q card
        game.eventDeck.get(game.eventDeck.getDeckSize() - 1).value = 2; // set last card as a Q card
        game.currentDrawnEventCard = game.eventDeck.removeLast();
        game.playersSponsorPrompt(new Scanner(input2), new PrintWriter(output));
        game.sponsoringPlayer.buildStages(new Scanner(input3));
        game.getEligiblePlayers();

        assertEquals(12, game.p2.getCardsSize());
        game.participantsSetUpAttack(new Scanner(input), new PrintWriter(output));
        assertEquals(3, game.p2.attack.size());
        assertEquals(9, game.p2.getCardsSize());
        assertEquals(3, game.p3.attack.size());
        assertEquals(9, game.p3.getCardsSize());
        assertEquals(2, game.p4.attack.size());
        assertEquals(10, game.p4.getCardsSize());
    }

    @Test
    @DisplayName("Do attacks for all eligible")
    public void RESP_20_test_01() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();
        String attackSetUp = "1\n2\nQ\n1\n2\n2\nQ\n1\n2\n2\nQ\n";
        String sponsorPrompt = "Y\nN\nN\n";
        String buildStages = "12\n11\nQ\n1\n1\n1\nQ";
        String joinQuestInput = "Y\nY\nY\n";
        StringWriter output = new StringWriter();

        game.eventDeck.get(game.eventDeck.getDeckSize() - 1).name = "Q"; // set last card as a Q card
        game.eventDeck.get(game.eventDeck.getDeckSize() - 1).value = 2; // set last card as a Q card
        game.currentDrawnEventCard = game.eventDeck.removeLast();
        game.playersSponsorPrompt(new Scanner(sponsorPrompt), new PrintWriter(output));
        game.sponsoringPlayer.buildStages(new Scanner(buildStages));
        game.getEligiblePlayers();
        game.askEligiblePlayers(new Scanner(joinQuestInput), new PrintWriter(output));
        game.participantsSetUpAttack(new Scanner(attackSetUp), new PrintWriter(output));

        // test 1: testing stage1 for successful attack
        game.allEligiblePlayersAttackStage(game.stage1, "stage1");
        assertEquals(3, game.eligiblePlayers.size());
    }

    @Test
    @DisplayName("Do attacks for all eligible and discard all attack cards")
    public void RESP_20_test_02() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();
        String attackSetUp = "1\n2\nQ\n1\n2\n2\nQ\n1\n2\n2\nQ\n";
        String sponsorPrompt = "Y\nN\nN\n";
        String buildStages = "12\n11\nQ\n1\n1\n1\nQ";
        String joinQuestInput = "Y\nY\nY\n";
        StringWriter output = new StringWriter();

        game.eventDeck.get(game.eventDeck.getDeckSize() - 1).name = "Q"; // set last card as a Q card
        game.eventDeck.get(game.eventDeck.getDeckSize() - 1).value = 2; // set last card as a Q card
        game.currentDrawnEventCard = game.eventDeck.removeLast();
        game.playersSponsorPrompt(new Scanner(sponsorPrompt), new PrintWriter(output));
        game.sponsoringPlayer.buildStages(new Scanner(buildStages));
        game.getEligiblePlayers();
        game.askEligiblePlayers(new Scanner(joinQuestInput), new PrintWriter(output));
        game.participantsSetUpAttack(new Scanner(attackSetUp), new PrintWriter(output));

        // test 2: discard all eligible attack cards
        game.allEligiblePlayersAttackStage(game.stage1, "stage1");
        assertEquals(3, game.eligiblePlayers.size());
        game.discardAllEligibleAttackCards();
        assertEquals(0, game.p2.attack.size());
        assertEquals(0, game.p3.attack.size());
        assertEquals(0, game.p4.attack.size());
    }

    @Test
    @DisplayName("Do attacks for all eligible for 2 stages")
    public void RESP_20_test_03() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();
        String attackSetUp = "1\n2\nQ\n1\n2\n2\nQ\n1\n2\n2\nQ\n";
        String sponsorPrompt = "Y\nN\nN\n";
        String buildStages = "12\n11\nQ\n1\n1\n1\nQ";
        String joinQuestInput = "Y\nY\nY\n";
        String attackSetUp2 = "1\n2\nQ\n1\n2\n2\nQ\n1\n2\n2\nQ\n";
        StringWriter output = new StringWriter();

        game.eventDeck.get(game.eventDeck.getDeckSize() - 1).name = "Q"; // set last card as a Q card
        game.eventDeck.get(game.eventDeck.getDeckSize() - 1).value = 2; // set last card as a Q card
        game.currentDrawnEventCard = game.eventDeck.removeLast();
        game.playersSponsorPrompt(new Scanner(sponsorPrompt), new PrintWriter(output));
        game.sponsoringPlayer.buildStages(new Scanner(buildStages));
        game.getEligiblePlayers();
        game.askEligiblePlayers(new Scanner(joinQuestInput), new PrintWriter(output));
        game.participantsSetUpAttack(new Scanner(attackSetUp), new PrintWriter(output));

        // test 3: Do attacks for all eligible players for 2 stages
        game.allEligiblePlayersAttackStage(game.stage1, "stage1");
        assertEquals(3, game.eligiblePlayers.size());
        game.discardAllEligibleAttackCards();
        assertEquals(0, game.p2.attack.size());
        assertEquals(0, game.p3.attack.size());
        assertEquals(0, game.p4.attack.size());


        game.participantsSetUpAttack(new Scanner(attackSetUp), new PrintWriter(output));
        game.allEligiblePlayersAttackStage(game.stage2, "stage2");
        assertEquals(0, game.eligiblePlayers.size());
        game.discardAllEligibleAttackCards();

    }

    @Test
    @DisplayName("Conclude Quest, distribute shields and check for winners")
    public void RESP_21_test_01() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.distributeCards();
        String attackSetUp = "12\n1\n2\nQ\n1\n2\n2\nQ\n1\n2\nQ\n";
//        String attackSetUp = "1\n2\nQ\n12\n1\n2\nQ\n1\n2\n2\nQ\n";
        String sponsorPrompt = "Y\nN\nN\n";
        String buildStages = "12\n11\nQ\n10\n7\nQ\n";
        String joinQuestInput = "Y\nY\nN\n";
        String attackSetUp2 = "1\n2\n2\nQ\n1\n2\n2\nQ\n1\n2\nQ\n";
//        String attackSetUp2 = "1\n2\nQ\n1\n2\n2\nQ\n1\n2\n2\nQ\n";
        StringWriter output = new StringWriter();

        game.eventDeck.get(game.eventDeck.getDeckSize() - 1).name = "Q"; // set last card as a Q card
        game.eventDeck.get(game.eventDeck.getDeckSize() - 1).value = 2; // set last card as a Q card
        game.p1.cards.get(11).value = 5;

        game.p3.cards.get(11).value = 20;
        game.p2.setNumShields(5);

        game.currentDrawnEventCard = game.eventDeck.removeLast();
        game.playersSponsorPrompt(new Scanner(sponsorPrompt), new PrintWriter(output));
        game.sponsoringPlayer.buildStages(new Scanner(buildStages));
        game.getEligiblePlayers();
        game.printEligiblePlayers();
        game.askEligiblePlayers(new Scanner(joinQuestInput), new PrintWriter(output));
        game.participantsSetUpAttack(new Scanner(attackSetUp), new PrintWriter(output));

        // test 1:
        game.allEligiblePlayersAttackStage(game.stage1, "stage1");
        game.discardAllEligibleAttackCards();
        game.participantsSetUpAttack(new Scanner(attackSetUp2), new PrintWriter(output));
        game.allEligiblePlayersAttackStage(game.stage2, "stage2");
        game.removeIneligiblePlayersFromList();
        game.discardAllEligibleAttackCards();

        game.concludeQuest(new PrintWriter(output));
        assertEquals(0, game.eligiblePlayers.size());
        game.checkForWinners();
        assertEquals(7, game.p2.getNumShields());
        assertEquals(1, game.gameWinners.size());
        game.printWinners();
    }

    @Test
    @DisplayName("Rig hand")
    public void RESP_22_test_01() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.distributeCards();
        game.overwriteCard(game.p1.cards, 0, "Adventure", "F", 10);

        assertEquals(10, game.p1.getCard(0).value);
        assertEquals("F", game.p1.getCard(0).name);
        assertEquals("Adventure", game.p1.getCard(0).type);
    }

    @Test
    @DisplayName("Sort player's hand")
    public void RESP_23_test_01() {
        Game game = new Game();
        game.advDeck.initAdvDeck();
        game.distributeCards();
        StringWriter output = new StringWriter();
        game.overwriteCard(game.p1.cards, 0, "Adventure", "F", 10);

        game.p1.printPlayersCards(new PrintWriter(output));
        game.p1.sortCards();
        game.p1.printPlayersCards(new PrintWriter(output));
        assertEquals("F", game.p1.getCard(0).getName());assertEquals(10, game.p1.getCard(0).getValue());
        assertEquals("B", game.p1.getCard(1).getName());assertEquals(15, game.p1.getCard(1).getValue());
        assertEquals("B", game.p1.getCard(2).getName());assertEquals(15, game.p1.getCard(2).getValue());
        assertEquals("B", game.p1.getCard(3).getName());assertEquals(15, game.p1.getCard(3).getValue());
        assertEquals("B", game.p1.getCard(4).getName());assertEquals(15, game.p1.getCard(4).getValue());
        assertEquals("L", game.p1.getCard(5).getName());assertEquals(20, game.p1.getCard(5).getValue());
        assertEquals("L", game.p1.getCard(6).getName());assertEquals(20, game.p1.getCard(6).getValue());
        assertEquals("L", game.p1.getCard(7).getName());assertEquals(20, game.p1.getCard(7).getValue());
        assertEquals("L", game.p1.getCard(8).getName());assertEquals(20, game.p1.getCard(8).getValue());
        assertEquals("L", game.p1.getCard(9).getName());assertEquals(20, game.p1.getCard(9).getValue());
        assertEquals("L", game.p1.getCard(10).getName());assertEquals(20, game.p1.getCard(10).getValue());
        assertEquals("E", game.p1.getCard(11).getName());assertEquals(30, game.p1.getCard(11).getValue());
    }

}
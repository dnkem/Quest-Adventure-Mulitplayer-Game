package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Scanner;

class MainTest {
    @Test
    @DisplayName("Check Adventure Deck Size")
    public void RESP_1_test_01(){
        Main game = new Main();
        game.initAdvDeck();

        // test 1: there should be 100 adventure cards
        int advDeckSize = game.getAdvDeckSize();
        assertEquals(100, advDeckSize);
    }

    @Test
    @DisplayName("Check Event Deck Size")
    public void RESP_1_test_02(){
        Main game = new Main();
        game.initEventDeck();

        // test 2: there should be 17 cards
        int eventDeckSize = game.getEventDeckSize();
        assertEquals(17, eventDeckSize);
    }

    @Test
    @DisplayName("Check Adventure Deck contents")
    public void RESP_1_test_03(){
        Main game = new Main();
        game.initAdvDeck();
        ArrayList<Main.Card> advDeck = game.getAdvDeck();

        // test 3: check that all card types of Foe and Weapon cards in the adventure deck
        // check foe and weapon cards
        int i=0;
        while (i < (game.getAdvDeckSize() / 2)){
            if (i >= 0 && i < 8) {
                assertTrue(advDeck.get(i).name.equals("F") && advDeck.get(i).value == 5, "F5s issue");
            } else if (i>=8 && i<15){
                assertTrue(advDeck.get(i).name == "F" && advDeck.get(i).value == 10,"F10s issue");
            } else if (i>=15 && i<23){
                assertTrue(advDeck.get(i).name == "F" && advDeck.get(i).value == 15, "F15 issue");
            } else if (i>=23 && i<30){
                assertTrue(advDeck.get(i).name == "F" && advDeck.get(i).value == 20, "F20 issue");
            } else if (i>=30 && i<37){
                assertTrue(advDeck.get(i).name == "F" && advDeck.get(i).value == 25, "F25 issue");
            } else if (i>=37 && i<41){
                assertTrue(advDeck.get(i).name == "F" && advDeck.get(i).value == 30, "F30 issue");
            } else if (i>=41 && i<45) {
                assertTrue(advDeck.get(i).name == "F" && advDeck.get(i).value == 35, "F35 issue");
            } else if (i>=45 && i<47) {
                assertTrue(advDeck.get(i).name == "F" && advDeck.get(i).value == 40, "F40 issue");
            } else if (i==47 || i==48) {
                assertTrue(advDeck.get(i).name == "F" && advDeck.get(i).value == 50, "F50 issue");
            } else if (i == 49) {
                assertTrue(advDeck.get(i).name == "F" && advDeck.get(i).value == 70, "F70 issue");
            }
            i++;
        }

        // check weapon cards
        i=50;
        while (i<game.getAdvDeckSize()){
            if (i < 56){
                assertTrue(advDeck.get(i).name == "D" && advDeck.get(i).value == 5, "D5 issue");
            } else if (i >= 56 && i < 68){
                assertTrue(advDeck.get(i).name == "H" && advDeck.get(i).value == 10, "H10 issue");
            } else if (i >= 68 && i < 84){
                assertTrue(advDeck.get(i).name == "S" && advDeck.get(i).value == 10, "S10 issue");
            } else if (i >= 84 && i < 92){
                assertTrue(advDeck.get(i).name == "B" && advDeck.get(i).value == 15, "B15 issue");
            } else if (i >= 92 && i < 98){
                assertTrue(advDeck.get(i).name == "L" && advDeck.get(i).value == 20, "L20 issue");
            } else if (i >= 98 && i < 100){
                assertTrue(advDeck.get(i).name == "E" && advDeck.get(i).value == 30, "E30 issue");
            }
            i++;
        }
    }

    @Test
    @DisplayName("Check Event Deck contents")
    public void RESP_1_test_04(){
        Main game = new Main();
        game.initEventDeck();
        ArrayList<Main.Card> eventDeck = game.getEventDeck();

        // test 4: check that all card types of Quest and Event cards in the event deck
        // check quests
        int i=0;
        while (i<game.getEventDeckSize() - 6){ // minus 5 for Events and minus 1 for index
            if (i < 3) {
                assertTrue(eventDeck.get(i).name == "Q" && eventDeck.get(i).value == 2, "Q2 issue");
            } else if (i >= 3 && i < 7){
                assertTrue(eventDeck.get(i).name == "Q" && eventDeck.get(i).value == 3, "Q3 issue");
            } else if (i >= 7 && i < 10){
                assertTrue(eventDeck.get(i).name == "Q" && eventDeck.get(i).value == 4, "Q4 issue");
            } else if (i >= 10 && i < 12){
                assertTrue(eventDeck.get(i).name == "Q" && eventDeck.get(i).value == 5, "Q5 issue");
            }
            i++;
        }

        // check events
        i=12;
        while (i<game.getEventDeckSize()){
            if (i==12) {
                assertTrue(eventDeck.get(i).name == "Plague" && eventDeck.get(i).value == 2, "Plague issue");
            } else if(i==13 || i==14){
                assertTrue(eventDeck.get(i).name == "Queen’s favor" && eventDeck.get(i).value == 2, "Queens favor issue");
            } else if (i==15 || i == 16){
                assertTrue(eventDeck.get(i).name == "Prosperity" && eventDeck.get(i).value == 2, "Proseperity issue");
            }
            i++;
        }


    }

    @Test
    @DisplayName("Check for Shuffled Cards")
    public void RESP_2_test_01(){
        Main game = new Main();
        game.initAdvDeck();
        game.initEventDeck();

        // test 1: check that both decks are shuffled

        // after decks that get updated once shuffled
        ArrayList<Main.Card> afterAdvDeck = game.getAdvDeck();
        ArrayList<Main.Card> afterEventDeck = game.getEventDeck();

        // create deep copy of decks before shuffle
        ArrayList<Main.Card> beforeAdvDeck = new ArrayList<Main.Card>();
        for (int i=0; i< game.getAdvDeckSize(); i++){
            Main.Card card = new Main.Card(afterAdvDeck.get(i).type,afterAdvDeck.get(i).name, afterAdvDeck.get(i).value);
            beforeAdvDeck.add(card);
        }
        ArrayList<Main.Card> beforeEventDeck = new ArrayList<Main.Card>();
        for (int i=0; i< game.getEventDeckSize(); i++){
            Main.Card card = new Main.Card(afterEventDeck.get(i).type,afterEventDeck.get(i).name, afterEventDeck.get(i).value);
            beforeEventDeck.add(card);
        }

        //shuffle
        game.shuffleDecks();

        // check and compare
        assertNotEquals(beforeAdvDeck, afterAdvDeck);
        assertNotEquals(beforeEventDeck, afterEventDeck);
    }

    @Test
    @DisplayName("Check for Card Distribution")
    public void RESP_2_test_02() {
        Main game = new Main();
        game.initAdvDeck();
        game.initEventDeck();

        Main.Player p1 = game.p1;
        Main.Player p2 = game.p2;
        Main.Player p3 = game.p3;
        Main.Player p4 = game.p4;

        // don't shuffle cards first so we can tell they are being removed
        game.distributeCards();

        // test 1: check that all players have 12 cards
        assertEquals(12, p1.cards.size(), "P1 card number issue");
        assertEquals(12, p2.cards.size(), "P2 card number issue");
        assertEquals(12, p3.cards.size(), "P3 card number issue");
        assertEquals(12, p4.cards.size(), "P4 card number issue");
    }

    @Test
    @DisplayName("Check that the Adventure Deck was Updated")
    public void RESP_2_test_03() {
        Main game = new Main();
        game.initAdvDeck();
        game.initEventDeck();
        game.distributeCards();

        // test 1: check adventure size to ensure cards were distributed (100 - 12 - 12 - 12 - 12 = 52)
        assertEquals(52, game.getAdvDeckSize(), "Cards were not distributed");
    }

    // COMMIT 3 - RESP 3
    @Test
    @DisplayName("Check Game's First Player")
    public void RESP_3_test_01() {
        Main game = new Main();

        // test 1: check that the game starts with player 1
        assertEquals("P1", game.currentPlayer, "Current player is incorrect");
    }

    @Test
    @DisplayName("Game assigns current player")
    public void RESP_3_test_02() {
        Main game = new Main();

        // test 2: check that the game loops in the correct order for 2 rounds
        int i=0;
        while (i<9) {
            if (i == 0 || i == 4 || i == 8) {
                assertEquals("P1", game.currentPlayer);
            } else if (i == 1 || i == 5){
                assertEquals("P2", game.currentPlayer);
            } else if (i == 2 || i == 6){
                assertEquals("P3", game.currentPlayer);
            } else if (i == 3 || i == 7){
                assertEquals("P4", game.currentPlayer);
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

        Main game = new Main();
        game.initAdvDeck();
        game.distributeCards();

        // test 1: check that a player's cards were printed to the screen
        game.printPlayersCards(game.p1, new PrintWriter(stringWriter));
        string = stringWriter.toString();
        assertTrue(string.contains("E30   E30   L20   L20   L20   L20   L20   L20   B15   B15   B15   B15"));
        // note that the test doesn't need to actually print but it should when the corresponding function runs in main
    }

    // COMMIT 5 - RESP 5
    @Test
    @DisplayName("Player Draws Single Event Card and the event deck updates")
    public void RESP_5_test_01() {
        Main game = new Main();
        game.initAdvDeck();
        game.initEventDeck();
        // non-shuffled deck

        // test 1: a card is removed from event deck
        game.drawEventCard();
        assertEquals(16, game.eventDeck.size(), "Event card drawn issue");
    }

    @Test
    @DisplayName("Player Draws Many Event Card and the event deck updates")
    public void RESP_5_test_02() {
        Main game = new Main();
        game.initAdvDeck();
        game.initEventDeck();
        // non-shuffled deck

        // test 2: Multiple drawn cards are removed from event deck
        game.drawEventCard();
        game.drawEventCard();
        game.drawEventCard();
        assertEquals(14, game.eventDeck.size(), "Event card drawn issue");

    }

    @Test
    @DisplayName("Player Draws Event Card and the correct card is drawn")
    public void RESP_5_test_03() {
        Main game = new Main();
        game.initAdvDeck();
        game.initEventDeck();
        // non-shuffled deck

        // test 3: a card is removed from event deck
        // getting last card in eventDeck
        String name = game.eventDeck.get(game.getEventDeckSize() - 1).name;
        String type = game.eventDeck.get(game.getEventDeckSize() - 1).type;
        int value = game.eventDeck.get(game.getEventDeckSize() - 1).value;


        game.drawEventCard();
        assertEquals(name, game.currentDrawnEventCard.name, "Wrong card");
        assertEquals(type, game.currentDrawnEventCard.type, "Wrong card");
        assertEquals(value, game.currentDrawnEventCard.value, "Wrong card");

    }

    @Test
    @DisplayName("Player Draws Many Event Cards and the correct card is drawn")
    public void RESP_5_test_04() {
        Main game = new Main();
        game.initAdvDeck();
        game.initEventDeck();
        // non-shuffled deck

        // test 4:  Multiple cards drawn are removed form the event deck
        // getting last card in eventDeck
        String name = game.eventDeck.get(game.getEventDeckSize()-3).name;
        String type = game.eventDeck.get(game.getEventDeckSize()-3).type;
        int value = game.eventDeck.get(game.getEventDeckSize()-3).value;

        game.drawEventCard();
        game.drawEventCard();
        game.drawEventCard();
        assertEquals(name, game.currentDrawnEventCard.name, "Wrong card");
        assertEquals(type, game.currentDrawnEventCard.type, "Wrong card");
        assertEquals(value, game.currentDrawnEventCard.value, "Wrong card");
    }

}
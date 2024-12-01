package org.example;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class A3_Controller {
    public Game game;

    public A3_Controller() {
        resetGame();
    }

    @GetMapping("/startRandomGame")
    public String startRandomGame() {
        resetGame();
        game.currentPlayer.drawEventCard();
        return "Random Game started. P1 draws an Event Card: " + game.currentDrawnEventCard.getNameType();
    }

    @GetMapping("/startA1ScenarioGame")
    public String startA1ScenarioGame() {
        setUpA1Scenario();
        game.currentPlayer.drawEventCard();
        return "A1 Scenario Game started. P1 draws an Event Card: " + game.currentDrawnEventCard.getNameType();
    }

    @GetMapping("/start2WinnerGame")
    public String start2WinnerGame() {
        setUp2Winner();
        game.currentPlayer.drawEventCard();
        return "2 Winner Game started. P1 draws an Event Card: " + game.currentDrawnEventCard.getNameType();
    }

    @GetMapping("/start1WinnerGame")
    public String start1WinnerGame() {
        setUp1Winner();
        game.currentPlayer.drawEventCard();
        return "1 Winner Game started. P1 draws an Event Card: " + game.currentDrawnEventCard.getNameType();
    }

    @GetMapping("/start0WinnerGame")
    public String start0WinnerGame() {
        setUp0Winner();
        game.currentPlayer.drawEventCard();
        return "0 Winner Game started. P1 draws an Event Card: " + game.currentDrawnEventCard.getNameType();
    }

    @GetMapping("/printP1Hand")
    public String printP1Hand() {
        return game.p1.printHand();
    }

    @GetMapping("/printP2Hand")
    public String printP2Hand() {
        return game.p2.printHand();
    }

    @GetMapping("/printP3Hand")
    public String printP3Hand() {
        return game.p3.printHand();
    }

    @GetMapping("/printP4Hand")
    public String printP4Hand() {
        return game.p4.printHand();
    }

    private void resetGame() {
        game = new Game();
        game.advDeck.initAdvDeck();
        game.eventDeck.initEventDeck();
        game.advDeck.shuffleDeck();
        game.eventDeck.shuffleDeck();
        game.distributeCards();
    }

    private void setUpA1Scenario() {
        game = new Game();
        // initialize and distribute the Adv cards
        List<Card> advCards = Arrays.asList(
                // extra cards for sponsor to pick up
                new Card("Adventure", "F", 5),
                new Card("Adventure", "L", 20),
                new Card("Adventure", "B", 15),
                new Card("Adventure", "B", 15),
                new Card("Adventure", "H", 10),

                new Card("Adventure", "H", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "D", 5),

                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 5),
                new Card("Adventure", "F", 5),


                // pick ups
                new Card("Adventure", "L", 20), // 9)
                new Card("Adventure", "F", 30), // 9)
                new Card("Adventure", "S", 10), // 8)
                new Card("Adventure", "B", 15), // 8)
                new Card("Adventure", "L", 20), // 7)
                new Card("Adventure", "L", 20), // 7)
                new Card("Adventure", "F", 10), // 7)
                new Card("Adventure", "B", 15), // 6)
                new Card("Adventure", "S", 10), // 6)
                new Card("Adventure", "F", 30), // 6)
                // pick ups scenario 1

                new Card("Adventure", "E", 30),
                new Card("Adventure", "L", 20),
                new Card("Adventure", "B", 15),
                new Card("Adventure", "H", 10),

                new Card("Adventure", "H", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "D", 5),
                new Card("Adventure", "D", 5),

                new Card("Adventure", "F", 40),
                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 5),
                // p4's

                new Card("Adventure", "L", 20),
                new Card("Adventure", "B", 15),
                new Card("Adventure", "H", 10),
                new Card("Adventure", "H", 10),

                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "D", 5),

                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 5),
                new Card("Adventure", "F", 5),
                new Card("Adventure", "F", 5),
                // p3's cards

                new Card("Adventure", "E", 30),
                new Card("Adventure", "B", 15),
                new Card("Adventure", "B", 15),
                new Card("Adventure", "H", 10),


                new Card("Adventure", "H", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "D", 5),
                new Card("Adventure", "F", 40),

                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 5),
                new Card("Adventure", "F", 5),
                // p2's cards

                new Card("Adventure", "L", 20),
                new Card("Adventure", "B", 15),
                new Card("Adventure", "B", 15),
                new Card("Adventure", "H", 10),

                new Card("Adventure", "H", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "D", 5),

                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 5),
                new Card("Adventure", "F", 5)
                // p1's cards
        );

        game.advDeck = new Deck(advCards);
        game.distributeCards();

        // initialize the events cards
        List<Card> eventCards = Arrays.asList(
                new Card("Event", "Q", 2),
                new Card("Event", "Q", 4)
        );
        game.eventDeck = new Deck(eventCards);
    }

    private void setUp2Winner(){
        game = new Game();
        List<Card> advCards = Arrays.asList(

                // Round 2 extra random (drawing 6)
                new Card("Adventure", "F", 40),
                new Card("Adventure", "F", 40),
                new Card("Adventure", "L", 20),
                new Card("Adventure", "F", 35),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "F", 70),


                // extra cards for sponsor to pick up hypothetically from discarded (13)
                new Card("Adventure", "D", 5),
                new Card("Adventure", "L", 20),
                new Card("Adventure", "B", 15),
                new Card("Adventure", "B", 15),
                new Card("Adventure", "E", 30),

                new Card("Adventure", "H", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "D", 5),

                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 5),
                new Card("Adventure", "F", 5),


                // pick ups Round 1
                new Card("Adventure", "B", 15),// 4th set
                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10), // 3rd set
                new Card("Adventure", "H", 10),
                new Card("Adventure", "S", 10), // 2nd set
                new Card("Adventure", "D", 5), // - discarded D5 card from previous round
                new Card("Adventure", "L", 20), // first set of drawn card
                new Card("Adventure", "D", 5),
                new Card("Adventure", "H", 10),
                // pick ups scenario 2

                new Card("Adventure", "E", 30),
                new Card("Adventure", "L", 20),
                new Card("Adventure", "L", 20),
                new Card("Adventure", "B", 15),

                new Card("Adventure", "B", 15),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10),

                new Card("Adventure", "H", 10),
                new Card("Adventure", "H", 10),
                new Card("Adventure", "F", 70),
                new Card("Adventure", "F", 50),
                // p4's

                new Card("Adventure", "H", 10),
                new Card("Adventure", "H", 10),
                new Card("Adventure", "H", 10),
                new Card("Adventure", "H", 10),

                new Card("Adventure", "H", 10),
                new Card("Adventure", "D", 5),
                new Card("Adventure", "D", 5),
                new Card("Adventure", "D", 5),

                new Card("Adventure", "F", 5),
                new Card("Adventure", "F", 5),
                new Card("Adventure", "F", 5),
                new Card("Adventure", "F", 5),
                // p3's cards

                new Card("Adventure", "E", 30),
                new Card("Adventure", "L", 20),
                new Card("Adventure", "L", 20),
                new Card("Adventure", "B", 15),

                new Card("Adventure", "B", 15),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10),


                new Card("Adventure", "H", 10),
                new Card("Adventure", "H", 10),
                new Card("Adventure", "F", 50),
                new Card("Adventure", "F", 40),
                // p2's cards

                new Card("Adventure", "L", 20),
                new Card("Adventure", "B", 15),
                new Card("Adventure", "B", 15),
                new Card("Adventure", "H", 10),

                new Card("Adventure", "H", 10),
                new Card("Adventure", "D", 5),
                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 15),

                new Card("Adventure", "F", 10),
                new Card("Adventure", "F", 10),
                new Card("Adventure", "F", 5),
                new Card("Adventure", "F", 5)
                // p1's cards
        );

        game.advDeck = new Deck(advCards);
        game.distributeCards();

        List<Card> eventCards = Arrays.asList(
                new Card("Event", "Q", 3),
                new Card("Event", "Q", 4)
        );

        game.eventDeck = new Deck(eventCards);
    }

    private void setUp1Winner() {
        game = new Game();
        List<Card> advCards = Arrays.asList(

                // filler
                new Card("Adventure", "B", 15),
                new Card("Adventure", "B", 15),
                new Card("Adventure", "H", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "F", 20),
                new Card("Adventure", "D", 5),
                new Card("Adventure", "F", 35),

                // queens favor
                new Card("Adventure", "S", 10),//
                new Card("Adventure", "F", 5),

                // Round 2 extra random (for prosperity event)
                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 5),
                new Card("Adventure", "E", 30),
                new Card("Adventure", "L", 20),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "F", 35),
                new Card("Adventure", "E", 30),
                new Card("Adventure", "L", 20),



                // extra cards for sponsor to pick up hypothetically from discarded (13)
                new Card("Adventure", "D", 5),
                new Card("Adventure", "L", 20),
                new Card("Adventure", "B", 15),
                new Card("Adventure", "B", 15),
                new Card("Adventure", "E", 30),

                new Card("Adventure", "H", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "D", 5),

                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 5),
                new Card("Adventure", "F", 5),


                // pick ups Round 1
                new Card("Adventure", "B", 15), // set 4
                new Card("Adventure", "H", 10), // p3
                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10), // set 3
                new Card("Adventure", "B", 15), // TBDDD P3
                new Card("Adventure", "H", 10),
                new Card("Adventure", "S", 10), // 2nd set
                new Card("Adventure", "F", 25), // p3
                new Card("Adventure", "D", 5), // - discarded D5 card from previous round
                new Card("Adventure", "L", 20), // first set of drawn card
                new Card("Adventure", "S", 10),
                new Card("Adventure", "H", 10),
                // pick ups scenario 2


                new Card("Adventure", "L", 20),
                new Card("Adventure", "L", 20),
                new Card("Adventure", "B", 15),
                new Card("Adventure", "B", 15),

                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "H", 10),

                new Card("Adventure", "H", 10),
                new Card("Adventure", "F", 70),
                new Card("Adventure", "F", 30),
                new Card("Adventure", "F", 25),
                // p4's

                new Card("Adventure", "E", 30),
                new Card("Adventure", "L", 20),
                new Card("Adventure", "L", 20),
                new Card("Adventure", "B", 15),

                new Card("Adventure", "B", 15),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10),


                new Card("Adventure", "H", 10),
                new Card("Adventure", "H", 10),
                new Card("Adventure", "F", 30),
                new Card("Adventure", "F", 25),
                // p3's cards

                new Card("Adventure", "E", 30),
                new Card("Adventure", "L", 20),
                new Card("Adventure", "L", 20),
                new Card("Adventure", "B", 15),

                new Card("Adventure", "B", 15),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10),


                new Card("Adventure", "H", 10),
                new Card("Adventure", "H", 10),
                new Card("Adventure", "F", 30),
                new Card("Adventure", "F", 25),
                // p2's cards


                new Card("Adventure", "D", 5),
                new Card("Adventure", "D", 5),
                new Card("Adventure", "D", 5),
                new Card("Adventure", "D", 5),

                new Card("Adventure", "F", 20),
                new Card("Adventure", "F", 20),
                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 15),

                new Card("Adventure", "F", 10),
                new Card("Adventure", "F", 10),
                new Card("Adventure", "F", 5),
                new Card("Adventure", "F", 5)
                // p1's cards
        );

        game.advDeck = new Deck(advCards);
        game.distributeCards();

        List<Card> eventCards = Arrays.asList(
                new Card("Event", "Q", 3),
                new Card("Event", "Queen’s favor", 2),
                new Card("Event", "Prosperity", 2),
                new Card("Event", "Plague", 2),
                new Card("Event", "Q", 4)
        );

        game.eventDeck = new Deck(eventCards);
    }

    private void setUp0Winner(){
        game = new Game();
        List<Card> advCards = Arrays.asList(

                // Round 2 extra random (drawing 6)
                new Card("Adventure", "F", 40),
                new Card("Adventure", "F", 40),
                new Card("Adventure", "L", 20),
                new Card("Adventure", "F", 35),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "F", 70),


                // extra cards for sponsor to pick up hypothetically from discarded (13)
                new Card("Adventure", "D", 5),
                new Card("Adventure", "L", 20),
                new Card("Adventure", "B", 15),
                new Card("Adventure", "B", 15),
                new Card("Adventure", "E", 30),

                new Card("Adventure", "H", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "D", 5),

                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 5),
                new Card("Adventure", "F", 5),


                // pick ups Round 1
                new Card("Adventure", "B", 15),// 4th set
                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10), // 3rd set
                new Card("Adventure", "H", 10),
                new Card("Adventure", "S", 10), // 2nd set
                new Card("Adventure", "D", 5), // - discarded D5 card from previous round
                new Card("Adventure", "L", 20), // first set of drawn card
                new Card("Adventure", "D", 5),
                new Card("Adventure", "H", 10),
                // pick ups scenario 2

                new Card("Adventure", "E", 30),
                new Card("Adventure", "F", 50),
                new Card("Adventure", "F", 30),
                new Card("Adventure", "F", 25),

                new Card("Adventure", "F", 25),
                new Card("Adventure", "F", 20),
                new Card("Adventure", "F", 20),
                new Card("Adventure", "F", 15),

                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 10),
                new Card("Adventure", "F", 5),
                new Card("Adventure", "F", 5),
                // p4's

                new Card("Adventure", "L", 20),
                new Card("Adventure", "F", 40),
                new Card("Adventure", "F", 30),
                new Card("Adventure", "F", 25),

                new Card("Adventure", "F", 25),
                new Card("Adventure", "F", 20),
                new Card("Adventure", "F", 20),
                new Card("Adventure", "F", 15),

                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 10),
                new Card("Adventure", "F", 5),
                new Card("Adventure", "F", 5),
                // p3's cards

                new Card("Adventure", "E", 30),
                new Card("Adventure", "F", 40),
                new Card("Adventure", "F", 30),
                new Card("Adventure", "F", 30),

                new Card("Adventure", "F", 25),
                new Card("Adventure", "F", 20),
                new Card("Adventure", "F", 20),
                new Card("Adventure", "F", 15),

                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 10),
                new Card("Adventure", "F", 5),
                new Card("Adventure", "F", 5),
                // p2's cards

                new Card("Adventure", "L", 20),
                new Card("Adventure", "L", 20),
                new Card("Adventure", "B", 15),
                new Card("Adventure", "B", 15),

                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "H", 10),
                new Card("Adventure", "H", 10),

                new Card("Adventure", "D", 5),
                new Card("Adventure", "D", 5),
                new Card("Adventure", "F", 70),
                new Card("Adventure", "F", 50)
                // p1's cards
        );

        game.advDeck = new Deck(advCards);
        game.distributeCards();

        List<Card> eventCards = Arrays.asList(
                new Card("Event", "Q", 2),
                new Card("Event", "Q", 2)
        );

        game.eventDeck = new Deck(eventCards);
    }
}


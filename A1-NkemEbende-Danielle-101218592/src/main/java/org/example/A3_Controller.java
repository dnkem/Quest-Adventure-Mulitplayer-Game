package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


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
        game.currentPlayer.drawFirstEventCard();
        return "Random Game started. P1 draws an Event Card: " + game.currentDrawnEventCard.getNameType();
    }

    @GetMapping("/startA1ScenarioGame")
    public String startA1ScenarioGame() {
        setUpA1Scenario();
        game.currentPlayer.drawFirstEventCard();
        return "A1 Scenario Game started. P1 draws an Event Card: " + game.currentDrawnEventCard.getNameType();
    }

    @GetMapping("/start2WinnerGame")
    public String start2WinnerGame() {
        setUp2Winner();
        game.currentPlayer.drawFirstEventCard();
        return "2 Winner Game started. P1 draws an Event Card: " + game.currentDrawnEventCard.getNameType();
    }

    @GetMapping("/start1WinnerGame")
    public String start1WinnerGame() {
        setUp1Winner();
        game.currentPlayer.drawFirstEventCard();
        return "1 Winner Game started. P1 draws an Event Card: " + game.currentDrawnEventCard.getNameType();
    }

    @GetMapping("/start0WinnerGame")
    public String start0WinnerGame() {
        setUp0Winner();
        game.currentPlayer.drawFirstEventCard();
        return "0 Winner Game started. P1 draws an Event Card: " + game.currentDrawnEventCard.getNameType();
    }

    @PostMapping("/playEventCard")
    public String playEventCard() {
        if (game.currentDrawnEventCard.getName().equals("Queen’s favor")){
            game.currentPlayer.playQueenEventCard(game.currentPlayer);
            return game.currentPlayer.getID() + " drew 2 adventure cards";
        } else if (game.currentDrawnEventCard.getName().equals("Plague")){
            game.currentPlayer.playPlagueCard(game.currentPlayer);
            return game.currentPlayer.getID() + " loses 2 shields if any";
        } else if (game.currentDrawnEventCard.getName().equals("Prosperity")){
            game.currentPlayer.playProsperityCard(game.currentPlayer);
            return "All players drew 2 adventure cards";
        }
        // initialize/reset prompted players if Q
        game.initPromptedPlayers();
        return "Does " + game.currentPlayer.getID() + " want to Sponsor the Quest?";
    }


    @PostMapping("/prompt")
    public ResponseEntity<String> prompt(@RequestParam String response, @RequestParam String question) {
        String responseCopy = response + "\n";
        if (question.contains("Sponsor") && !game.promptedPlayers.isEmpty()) {
            sponsorPrompt(responseCopy);
        } else if (!game.trimmingPlayers.isEmpty() || question.contains("trimming")) {
            trimPrompt(response);
        } else if (question.contains("Stage")){
            stagePrompt(response);
        } else if (question.contains("Join")){
            joinPrompt(response);
        } else if (question.contains("Attack")){
            buildPrompt(response);
        }
        String responseMessage = "The input was received: " + response;
        return ResponseEntity.ok(responseMessage);
    }

    @GetMapping("/setBuildGameStatus")
    public String setBuildGameStatus(String newStatus) {
        if (game.buildingPlayers.isEmpty()){
            System.out.println("All Players Built an Attack");
            return "All Players Built an Attack, Enter * to Continue";
        }
        return game.buildingPlayers.get(0).getID() + " Build your Attack by Entering a Position from your Cards (Enter Q to Quit)";
    }

    public void buildPrompt(String position){
        int inputNum = -1;
        try {
            inputNum = parseInt(position);
            game.buildingPlayers.get(0).promptAttack(new Scanner((position)));
        } catch (NumberFormatException e){ // if it's not, update
            if (position.contains("Q")){
                game.updateBuildingPlayers();
            }
        }
    }

    @GetMapping("/trimHand")
    public String trimHand(String position) {
        if (!game.trimmingPlayers.isEmpty()){
            return game.trimmingPlayers.get(0).getID() + " is trimming their hand, Enter a position";
        }
        return "No Hands to trim, Enter * to continue";
    }

    public void trimPrompt(String position){
        if (!game.trimmingPlayers.isEmpty()){
            game.trimmingPlayers.get(0).trimCard(parseInt(position));
            game.updateTrimmingPlayers();
        }
    }

    @GetMapping("/eligiblePlayersDrawAdv")
    public String eligiblePlayersDrawAdv(String newStatus) {
        if (!game.eligiblePlayers.isEmpty()){
            game.eligiblePlayersDrawAdvCard();
            game.initTrimmingPlayers("eligible");
            return "Eligible Players drew an Adventure Card, Enter * to continue";
        }
        return "Conclude Quest and Next Players Turn";
    }

    @GetMapping("/setJoinGameStatus")
    public String setJoinGameStatus(String newStatus) {
        if (game.promptedEligiPlayers.isEmpty()){
            System.out.println("All Eligible Players Responded to the Prompt, Enter * to continue");
            game.initBuildingPlayers();
            return "All Eligible Players Responded to the Prompt, Enter * to continue";
        }
        return "Does " + game.promptedEligiPlayers.get(0).getID() + " want to Join the Quest?";
    }

    public void joinPrompt(String response){
        StringWriter output = new StringWriter();
        game.promptedEligiPlayers.get(0).singleJoinQuestion(new Scanner(response), new PrintWriter(output));

        if (response.contains("N") || response.contains("Y")) {
            game.updatePromptedEligiPlayers();
        }
    }

    @GetMapping("/setStageGameStatus")
    public String setStageGameStatus(String newStatus) {
        if (game.promptedStage.isEmpty()){
            System.out.println("Stages Done");
            return "All Stages are Complete, Enter * For Player Join Prompt";
        }
        return game.sponsoringPlayer.getID() + " Build your Stage " + game.currentStage + " by Entering a Position from your Cards (Enter Q for next stage)";
    }

    public void stagePrompt(String position){
        // if its a num, call build
        int inputNum = -1;
        try {
            inputNum = parseInt(position);
            game.sponsoringPlayer.buildSingleStage(game.currentStage, inputNum);
           // worry about eligible later
        } catch (NumberFormatException e){ // if it's not, update
            if (position.contains("Q")){
                game.updatePromptedStages();
            }
        }
    }

    @GetMapping("/setSponsorGameStatus")
    public String setSponsorGameStatus(String newStatus) {
        if (game.promptedPlayers.isEmpty()){
            System.out.println("All Players Declined Sponsoring");
            return "All Players Declined Sponsoring";
        }
        System.out.println("Does " + game.promptedPlayers.get(0).getID() + " want to Sponsor the Quest?");
        return "Does " + game.promptedPlayers.get(0).getID() + " want to Sponsor the Quest?";
    }

    public void sponsorPrompt(String response){
        // ask the sponsor question and respond
        StringWriter output = new StringWriter();
        game.promptedPlayers.get(0).singleSponsorQuestion(new Scanner(response), new PrintWriter(output));

        // check the response
        if (response.contains("N") && !(game.promptedPlayers.isEmpty())){
            System.out.println(game.updatePromptedPlayers());
        } else if (response.contains("Y") && !(game.promptedPlayers.isEmpty())){
            game.initPromptedStages();
            game.getEligiblePlayers();
            game.initPromptedEligiPlayers();
            game.printEligiblePlayers();
        }
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

    @GetMapping("/getP1Shields")
    public String getP1Shields() {
        return "P1 Shields: " + game.p1.getNumShields();
    }

    @GetMapping("/getP2Shields")
    public String getP2Shields() {
        return "P2 Shields: " + game.p2.getNumShields();
    }

    @GetMapping("/getP3Shields")
    public String getP3Shields() {
        return "P3 Shields: " + game.p3.getNumShields();
    }

    @GetMapping("/getP4Shields")
    public String getP4Shields() {
        return "P4 Shields: " + game.p4.getNumShields();
    }

    // methods

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


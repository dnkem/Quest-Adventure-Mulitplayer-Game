package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.compare;
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
        // this is for when starting with and action card
        if (game.sponsoringPlayer == null){
            game.sponsoringPlayer = game.p1;
        }

        if (game.currentDrawnEventCard.getName().equals("Queen’s favor")){
            game.currentPlayer.playQueenEventCard(game.currentPlayer);
            return "Queen's Favour Event: " + game.currentPlayer.getID() + " drew 2 adventure cards";
        } else if (game.currentDrawnEventCard.getName().equals("Plague")){
            game.currentPlayer.playPlagueCard(game.currentPlayer);
            return "Plague Event: " +  game.currentPlayer.getID() + " loses 2 shields if any, This Quest is Over";
        } else if (game.currentDrawnEventCard.getName().equals("Prosperity")){
            game.currentPlayer.playProsperityCard(game.currentPlayer);
            return "Prosperity Event: " +  "All players drew 2 adventure cards";
        }
        // initialize/reset prompted players if Q
        game.initPromptedPlayers();
        return "Does " + game.currentPlayer.getID() + " want to Sponsor the Quest? " + game.currentDrawnEventCard.getNameType();
    }


    @PostMapping("/prompt")
    public ResponseEntity<String> prompt(@RequestParam String response, @RequestParam String question) {
        String responseCopy = response + "\n";
        if (question.contains("Sponsor") && !game.promptedPlayers.isEmpty()) {
            sponsorPrompt(responseCopy);
        } else if (!game.trimmingPlayers.isEmpty() || question.contains("trimming")) {
            trimPrompt(response);
        } else if (question.contains("All Eligible Players Built an Attack")){
//            System.out.println(question + " AND THE STAGE NAME: " + game.currentAttack);
            playersAttack(game.currentAttack);
        } else if (question.contains("Stage")){
            stagePrompt(response);
        } else if (question.contains("Join")){
            joinPrompt(response);
        } else if (question.contains("Build your Attack")){
            buildPrompt(response);
        }
//        else if (question.contains("All Eligible Players Responded to the Prompt")){
//            if (game.eligiblePlayers.isEmpty()){
//                g
//            }
//            System.out.println("SPONSOR DOESNT PICK UP");
//        }
//        else if (){ // next player
//            game.currentPlayer.drawEventCard();
//        }
        String responseMessage = "The input was received: " + response;
        return ResponseEntity.ok(responseMessage);
    }

    @GetMapping("/questValue")
    public String questValue() {
        return "" + game.currentDrawnEventCard.getValue();
    }

    @GetMapping("/nextTurn")
    public String nextTurn() {
        game.currentPlayer.drawFirstEventCard();
        return "Game Continues, "  + game.currentPlayer.getID() + " draws an Event Card: " + game.currentDrawnEventCard.getNameType();
    }

    // sponsor draws their card back and Trims
    @GetMapping("/sponsorDrawsCardsBack")
    public String sponsorDrawsCardsBack() {
        if (game.eligiblePlayers.isEmpty()) { // if no one joing
            game.sponsorDrawsAdvCards();
            game.initTrimmingPlayers("everyone");
        } else if ((game.currentDrawnEventCard.getValue() + 1) < game.currentAttack){
            // indicate it's the last stage
            System.out.println(">    Q" + (game.currentDrawnEventCard.getValue() + 1) + " and Current Stage: " + game.currentAttack);
            game.sponsorDrawsAdvCards();
            game.initTrimmingPlayers("everyone");
        } else if ((game.currentDrawnEventCard.getValue() + 1) == game.currentAttack){
            // indicate it's the last stage
            System.out.println("==    Q" + (game.currentDrawnEventCard.getValue() + 1) + " and Current Stage: " + game.currentAttack);
            game.sponsorDrawsAdvCards();
            game.initTrimmingPlayers("everyone");
        }
        return "Sponsor Picks up";
    }

    @PostMapping("/concludeQuest")
    public String concludeQuest() {
        StringWriter output = new StringWriter();
        game.concludeQuest(new PrintWriter(output));
        return game.printWinners() + ", Enter * to continue";
    }

    @GetMapping("/setBuildGameStatus")
    public String setBuildGameStatus(String newStatus) {
        // there were no eligible players at all, no one joined
        if (game.eligiblePlayers.isEmpty()){
            return "This Quest is Over, Enter * to Continue";
        }
        // completed the last stage therefore the attacks and quest are over
        if ((game.currentDrawnEventCard.getValue() + 1) == game.currentAttack){
            return "This Quest is Over, Enter * to Continue";
        }
        // people joined but eligible players is still full
        if (game.buildingPlayers.isEmpty() && !game.eligiblePlayers.isEmpty()){
            System.out.println("All Eligible Players Built an Attack");
            return "All Eligible Players Built an Attack, Enter * to Continue";
        }
        // there are still eligible players that need to build their attack
        return game.buildingPlayers.get(0).getID() + " Build your Attack for stage " + game.currentAttack + " by Entering a Position from your Cards (Enter Q to Quit)";
    }

    public void buildPrompt(String position){
        int inputNum = -1;
        try {
            inputNum = parseInt(position);
            game.buildingPlayers.get(0).promptAttack(new Scanner((position)));
//            System.out.println("ADDED ATTACK: " + game.buildingPlayers.get(0).attack.get(0).getNameType());
        } catch (NumberFormatException e){ // if it's not, update
            if (position.contains("Q") && game.buildingPlayers.get(0).attack.isEmpty()){
                game.updateEligiblePlayers(game.buildingPlayers.get(0));
                game.updateBuildingPlayers();
            } else if (position.contains("Q")){
                game.updateBuildingPlayers();
            }
        }
    }

    @GetMapping("/attackStage")
    public String attackStage() {
        if (!game.eligiblePlayers.isEmpty()){
            int num = game.currentAttack - 1;
//            game.removeIneligiblePlayersFromList();
            String result = "Players: ";
            for (int i=0; i<game.eligiblePlayers.size(); i++){
                result += game.eligiblePlayers.get(i).getID() + " ";
            }
            result += "Cleared Stage " + num + " successfully";
            return "Eligible Players Attack the Stage, \n" + result + "\n Enter * to continue";
        }
        return "Eligible Players Attack the Stage Unsuccessfully, \nNo Eligible Players \nConclude Quest and Next Players Turn";
    }

    public void playersAttack(int stage){
        String str = "stage" + stage;
        if (!game.eligiblePlayers.isEmpty()){
            if (str.contains("stage1")){
                game.allEligiblePlayersAttackStage(game.stage1, str);
            } else if (str.contains("stage2")){
                game.allEligiblePlayersAttackStage(game.stage2, str);
            } else if (str.contains("stage3")){
                game.allEligiblePlayersAttackStage(game.stage3, str);
            } else if (str.contains("stage4")){
                game.allEligiblePlayersAttackStage(game.stage4, str);
            } else if (str.contains("stage5")){
                game.allEligiblePlayersAttackStage(game.stage5, str);
            }
            System.out.println("ELIGIBLE PLAYERS:");
            game.printEligiblePlayers();
            game.updateCurrentAttack();
            game.discardAllEligibleAttackCards();
        }
    }

    @GetMapping("/trimHand")
    public String trimHand(String position) {
        // end game for other non quest events
        if (!game.currentDrawnEventCard.getName().equals("Q")){
            game.initTrimmingPlayers("everyone");
        }

        if (!game.trimmingPlayers.isEmpty()){
            return game.trimmingPlayers.get(0).getID() + " is trimming their hand, Enter a position";
        }

        // this is for the 4/4 completed stages where players won the quest
        // basically for the sponsor to trim their cards
        if (game.currentDrawnEventCard.getName().equals("Q") && game.sponsoringPlayer.getCardsSize() != 12){
            game.initTrimmingPlayers("everyone");
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
        return "No Eligible Players, Conclude Quest and Next Players Turn";
    }

    @GetMapping("/setJoinGameStatus")
    public String setJoinGameStatus(String newStatus) {
        if (game.promptedEligiPlayers.isEmpty()){
            System.out.println("All Eligible Players Responded to the Prompt, Enter * to continue");
            game.initBuildingPlayers();
            return "All Eligible Players Responded to the Prompt, Enter * to continue";
        }
        return "Does " + game.promptedEligiPlayers.get(0).getID() + " want to Join the Quest? " + game.currentDrawnEventCard.getNameType();
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
//        int attack = game.currentAttack - 1;
        if (game.promptedStage.isEmpty()){
            if (game.currentAttack > game.currentDrawnEventCard.getValue()){
                System.out.println("This Quest is Over " + game.currentAttack);
                return "This Quest is Over, Enter * to Continue";
            }
            System.out.println("This stage is complete " + game.currentAttack + " Q" + game.currentDrawnEventCard.getValue());
            game.initPromptedEligiPlayers();
            return "This stage is complete, Enter * For Player Join Prompt";
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
                game.sponsoringPlayer.assignStageValues(game.currentStage);
                System.out.println("BUILDING SPONSORS STAGE: " + game.currentStage);
                game.sponsoringPlayer.printStage(game.currentStage);
                game.updatePromptedStages();
            }
        }
    }

    @GetMapping("/setSponsorGameStatus")
    public String setSponsorGameStatus(String newStatus) {
        if (game.promptedPlayers.isEmpty()){
            System.out.println("All Players Declined Sponsoring, This Quest is Over");
            return "All Players Declined Sponsoring, This Quest is Over \nEnter * to continue";
        }
        System.out.println("Does " + game.promptedPlayers.get(0).getID() + " want to Sponsor the Quest?");
        return "Does " + game.promptedPlayers.get(0).getID() + " want to Sponsor the Quest? " + game.currentDrawnEventCard.getNameType();
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
            game.initCurrentAttack();
            game.initCurrentStage();
        }
    }

    @GetMapping("/printP1HandNum")
    public String printP1HandNum() {
        return "P1 # Cards: " + game.p1.getCardsSize();
    }

    @GetMapping("/printP2HandNum")
    public String printP2HandNum() {
        return "P2 # Cards: " + game.p2.getCardsSize();
    }

    @GetMapping("/printP3HandNum")
    public String printP3HandNum() {
        return "P3 # Cards: " + game.p3.getCardsSize();
    }

    @GetMapping("/printP4HandNum")
    public String printP4HandNum() {
        return "P4 # Cards: " + game.p4.getCardsSize();
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

                // FILLER
                new Card("Adventure", "F", 40),
                new Card("Adventure", "F", 40),
                new Card("Adventure", "L", 20),
                new Card("Adventure", "F", 35),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "F", 70),

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

                new Card("Adventure", "B", 15),// 4th set
                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10), // 3rd set
                new Card("Adventure", "H", 10),
                new Card("Adventure", "S", 10), // 2nd set
                new Card("Adventure", "D", 5), // - discarded D5 card from previous round
                new Card("Adventure", "L", 20), // first set of drawn card
                new Card("Adventure", "D", 5),
                new Card("Adventure", "H", 10),
                // FILLER

                // Sponsor pick up
                new Card("Adventure", "L", 20),
                new Card("Adventure", "B", 15),
                new Card("Adventure", "B", 15),
                new Card("Adventure", "S", 10),

                new Card("Adventure", "F", 30),
                new Card("Adventure", "F", 25),
                new Card("Adventure", "F", 20),
                new Card("Adventure", "F", 20),
                // Sponsor pick up

                // Q3 pick ups
                new Card("Adventure", "F", 25),
                new Card("Adventure", "F", 15),

                new Card("Adventure", "D", 5),
                new Card("Adventure", "D", 5),
                new Card("Adventure", "D", 5),
                // Q3 pick ups

                // sponsor pick up after Q4
                new Card("Adventure", "F", 30),

                new Card("Adventure", "F", 25),
                new Card("Adventure", "F", 25),

                new Card("Adventure", "F", 20),
                new Card("Adventure", "F", 20),
                new Card("Adventure", "F", 20),
                new Card("Adventure", "F", 20),

                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 10),
                new Card("Adventure", "F", 5),
                // sponsor pick up after Q4

                // end of Q4 pick ups
                new Card("Adventure", "F", 20),
                new Card("Adventure", "F", 15),

                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 30),

                new Card("Adventure", "F", 30),
                new Card("Adventure", "F", 10),

                new Card("Adventure", "F", 10),
                new Card("Adventure", "F", 40),
                new Card("Adventure", "F", 5),
                // participation pick up

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
                new Card("Adventure", "S", 10),//
                new Card("Adventure", "F", 5),
                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 5),
                new Card("Adventure", "E", 30),
                new Card("Adventure", "L", 20),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "F", 35),
                new Card("Adventure", "E", 30),
                new Card("Adventure", "L", 20),
                // extra cards for sponsor to pick up hypothetically from discarded (13)

                // end
                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10),

                new Card("Adventure", "H", 10),
                new Card("Adventure", "H", 10),
                new Card("Adventure", "H", 10),
                new Card("Adventure", "F", 35),

                // & sponsor
                new Card("Adventure", "F", 50),
                new Card("Adventure", "F", 40),
                new Card("Adventure", "S", 10),

                new Card("Adventure", "S", 10),
                new Card("Adventure", "F", 50),
                new Card("Adventure", "H", 10),
                new Card("Adventure", "B", 15),
                // // participation draw

                new Card("Adventure", "F", 30),
                new Card("Adventure", "F", 25),

                new Card("Adventure", "D", 5),
                new Card("Adventure", "D", 5),
                new Card("Adventure", "F", 40),
                new Card("Adventure", "B", 15),

                new Card("Adventure", "H", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "F", 25),
                new Card("Adventure", "F", 25),
                // prosperity pick ups

                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 15),

                new Card("Adventure", "F", 10),
                new Card("Adventure", "F", 10),
                new Card("Adventure", "F", 5),
                new Card("Adventure", "F", 5),
                // sponsor pick up

                // pick ups Round 1
                new Card("Adventure", "F", 20),
                new Card("Adventure", "F", 10),
                new Card("Adventure", "F", 5),
                new Card("Adventure", "F", 20),// 4th set
                new Card("Adventure", "F", 10),
                new Card("Adventure", "F", 5), // 3rd set
                new Card("Adventure", "F", 25),
                new Card("Adventure", "F", 5), // 2nd set
                new Card("Adventure", "F", 15), // - discarded D5 card from previous round
                new Card("Adventure", "F", 20), // first set of drawn card
                new Card("Adventure", "F", 10),
                new Card("Adventure", "F", 5),
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
                new Card("Adventure", "F", 50),
                // extra

                // for p1
                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10),
                new Card("Adventure", "S", 10),

                new Card("Adventure", "H", 10),
                new Card("Adventure", "H", 10),
                new Card("Adventure", "H", 10),
                new Card("Adventure", "H", 10),

                new Card("Adventure", "D", 5),
                new Card("Adventure", "D", 5),
                new Card("Adventure", "D", 5),
                new Card("Adventure", "D", 5),
                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 10),
                new Card("Adventure", "F", 5),
                // for p1 to pick up

//                Round 1
                new Card("Adventure", "F", 10),
                new Card("Adventure", "F", 15),
                new Card("Adventure", "F", 5),
                // pick ups scenario

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


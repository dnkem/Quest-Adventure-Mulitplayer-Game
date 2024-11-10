package cucumber;

import io.cucumber.java.en.*;
import org.example.Card;
import org.example.Game;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class GameSteps {
    private Game game;

    @Given("the game starts")
    public void the_game_starts(){
        game = new Game();
    }

    @Given("the cards are rigged for scenario 1")
    public void the_game_starts_and_the_cards_are_rigged_for_scenario_1() {
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
                // pick ups

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

        List<Card> eventCards = Arrays.asList(
            new Card("Event", "Q", 2),
            new Card("Event", "Q", 4)
        );
        game = new Game(new TestAdvDeck(advCards), new TestEventDeck(eventCards));
    }

    @Given("the cards are distributed to all 4 players")
    public void the_cards_are_distributed_to_all_4_players() {
        game.distributeCards();
    }

    @When("P{int} draws an event card")
    public void pDrawsAnEventCard(int num){
        switch (num){
            case 1:
                game.p1.drawEventCard();
                break;
            case 2:
                game.p2.drawEventCard();
                break;
            case 3:
                game.p3.drawEventCard();
                break;
            case 4:
                game.p4.drawEventCard();
                break;
        }
    }

    @When("P{int} is asked to sponsor and {string}")
    public void pIsAskedToSponsorAnd(int playerNum, String decision) {
        StringWriter output = new StringWriter();
        String response = "";

        if (decision.equals("declines")){
            response = "N\n";
        } else if (decision.equals("accepts")) {
            response = "Y\n";
        }

        switch (playerNum){
            case 1:
                game.p1.singleSponsorQuestion(new Scanner(response), new PrintWriter(output));
                break;
            case 2:
                game.p2.singleSponsorQuestion(new Scanner(response), new PrintWriter(output));
                break;
            case 3:
                game.p3.singleSponsorQuestion(new Scanner(response), new PrintWriter(output));
                break;
            case 4:
                game.p4.singleSponsorQuestion(new Scanner(response), new PrintWriter(output));
                break;
        }
    }

    @When("Sponsor builds stage {int} and adds card from position {int}")
    public void sponsorBuildsStageAndAddsCardFromPosition(int stageNum, int position) {
        StringWriter output = new StringWriter();
        game.sponsoringPlayer.buildSingleStage(stageNum, position);
        game.sponsoringPlayer.assignStageValues(stageNum);
        game.sponsoringPlayer.printStage(stageNum);
        game.sponsoringPlayer.printPlayersCards(new PrintWriter(output));
    }

    @When("Get eligible players")
    public void getEligiblePlayers() {
        StringWriter input = new StringWriter();
        game.clearScreen(new PrintWriter(input));
        game.getEligiblePlayers();
    }

    // Additional STEP
//    @When("Sponsor builds the stages of the quest")
//    public void sponsorBuildsTheStagesOfTheQuest() {
//        String stages = "1\n7\nQ\n2\n5\nQ\n2\n3\n5\nQ\n2\n3\nQ\n";
//        StringWriter output = new StringWriter();
//
//        game.clearScreen(new PrintWriter(output));
//        game.sponsoringPlayer.buildStages(new Scanner(stages));
//        game.clearScreen(new PrintWriter(output));
//        game.getEligiblePlayers();
//    }

    @When("P{int} is asked to participate and {string}")
    public void pIsAskedToParticipateAnd(int playerNum, String decision) {
        game.printEligiblePlayers();

        StringWriter output = new StringWriter();
        String response = "";

        if (decision.equals("declines")){
            response = "N\n";
        } else if (decision.equals("accepts")) {
            response = "Y\n";
        }

        switch (playerNum){
            case 1:
                game.p1.singleJoinQuestion(new Scanner(response), new PrintWriter(output));
                break;
            case 2:
                game.p2.singleJoinQuestion(new Scanner(response), new PrintWriter(output));
                break;
            case 3:
                game.p3.singleJoinQuestion(new Scanner(response), new PrintWriter(output));
                break;
            case 4:
                game.p4.singleJoinQuestion(new Scanner(response), new PrintWriter(output));
                break;
        }
    }

    @When("P{int} draws adventure card and discards position {int}")
    public void p_draws_adventure_card_and_discards_position(int playerNum, int position) {
        switch (playerNum){
            case 1:
                game.p1.drawAdvCard();
                game.p1.sortCards();
                game.p1.trimCard(position);
                break;
            case 2:
                game.p2.drawAdvCard();
                game.p2.sortCards();
                game.p2.trimCard(position);
                break;
            case 3:
                game.p3.drawAdvCard();
                game.p3.sortCards();
                game.p3.trimCard(position);
                break;
            case 4:
                game.p4.drawAdvCard();
                game.p4.sortCards();
                game.p4.trimCard(position);
                break;
        }
        StringWriter output = new StringWriter();
        game.clearScreen(new PrintWriter(output));
    }

    @When("P{int} sets up an attack with card in position {int}")
    public void pSetsUpAnAttackWithCardInPosition(int playerNum, int position) {
        StringWriter output = new StringWriter();
        String pos = "" + position;
        switch (playerNum){
            case 1:
                game.p1.promptAttack(new Scanner(pos));
                game.p1.printAttack();
                break;
            case 2:
                game.p2.promptAttack(new Scanner(pos));
                game.p2.printAttack();
                break;
            case 3:
                game.p3.promptAttack(new Scanner(pos));
                game.p3.printAttack();
                break;
            case 4:
                game.p4.promptAttack(new Scanner(pos));
                game.p4.printAttack();
                break;
        }
        game.clearScreen(new PrintWriter(output));
    }

    @When("Participants attack stage {int}")
    public void participantsAttackStage(int stageNum) {
        switch (stageNum){
            case 1:
                game.allEligiblePlayersAttackStage(game.stage1, "stage1");
                break;
            case 2:
                game.allEligiblePlayersAttackStage(game.stage2, "stage2");
                break;
            case 3:
                game.allEligiblePlayersAttackStage(game.stage3, "stage3");
                break;
            case 4:
                game.allEligiblePlayersAttackStage(game.stage4, "stage4");
                break;
        }
        game.discardAllEligibleAttackCards();
    }

    // Additional STEP
//    @When("Participants set up attack stage {int} for scenario 1")
//    public void participantsSetUpAttackStageForScenario(int stage) {
//        switch (stage){
//            case 1:
//                String attackStage1 = "5\n5\nQ\n5\n4\nQ\n4\n6\nQ\n"; // P1 -> P4
//                StringWriter output1 = new StringWriter();
//                game.participantsSetUpAttack(new Scanner(attackStage1), new PrintWriter(output1));
//                game.allEligiblePlayersAttackStage(game.stage1, "stage1");
//                break;
//            case 2:
//                String attackStage2 = "7\n6\nQ\n9\n4\nQ\n6\n6\nQ\n"; // P1 -> P4
//                StringWriter output2 = new StringWriter();
//                game.participantsSetUpAttack(new Scanner(attackStage2), new PrintWriter(output2));
//                game.allEligiblePlayersAttackStage(game.stage2, "stage2");
//                break;
//            case 3:
//                String attackStage3 = "10\n6\n4\nQ\n7\n5\n7\nQ"; // P3 -> P4
//                StringWriter output3 = new StringWriter();
//                game.participantsSetUpAttack(new Scanner(attackStage3), new PrintWriter(output3));
//                game.allEligiblePlayersAttackStage(game.stage3, "stage3");
//                break;
//            case 4:
//                String attackStage4 = "7\n6\n6\nQ\n4\n4\n4\n5\nQ"; // P3 -> P4
//                StringWriter output4 = new StringWriter();
//                game.participantsSetUpAttack(new Scanner(attackStage4), new PrintWriter(output4));
//                game.allEligiblePlayersAttackStage(game.stage4, "stage4");
//                break;
//        }
//        game.discardAllEligibleAttackCards();
//    }

    @When("Participants draw an adventure card")
    public void participantsDrawAnAdventureCard() {
        game.eligiblePlayersDrawAdvCard();
    }

    // Additional STEP
//    @When("The quest is completed and the sponsor draws and trim cards")
//    public void theQuestIsCompletedAndTheSponsorDrawsAndTrimCards() {
//        String removed = "1\n1\n1\n1\n1\n1";
//        StringWriter output = new StringWriter();
//
//        game.sponsorDrawsAdvCards();
//        game.sponsoringPlayer.trimToTwelve(new Scanner(removed), new PrintWriter(output));
//    }

    @When("The quest is completed and the sponsor draws adventure cards")
    public void theQuestIsCompletedAndTheSponsorDrawsAdventureCards() {
        game.sponsorDrawsAdvCards();
    }

    @When("The sponsor trims their hand in position: {int}")
    public void theSponsorTrimsTheirHandInPosition(int position) {
        StringWriter output = new StringWriter();
        game.clearScreen(new PrintWriter(output));
        game.sponsoringPlayer.trimCard(position);
    }


    @Then("P{int} has {int} cards and has {int} shields")
    public void pHasCardsAndHasShields(int player, int cards, int shields) {
        StringWriter output = new StringWriter();
        if (player == 1){
            assertEquals(shields, game.p1.getNumShields());
            assertEquals(cards, game.p1.cards.size());
        } else if (player == 2) {
            assertEquals(shields, game.p2.getNumShields());
            assertEquals(cards, game.p2.cards.size());
        } else if (player == 3) {
            assertEquals(shields, game.p3.getNumShields());
            assertEquals(cards, game.p3.cards.size());
        } else if (player == 4) {
            assertEquals(shields, game.p4.getNumShields());
            assertEquals(cards, game.p4.cards.size());
        }
    }

    @Then("the quest ends")
    public void theGameEnds() {
        StringWriter output = new StringWriter();
        game.concludeQuest(new PrintWriter(output));
    }

    @Given("the cards are rigged for scenario 2")
    public void theCardsAreRiggedForScenario() {
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
                // pick ups

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

        List<Card> eventCards = Arrays.asList(
                new Card("Event", "Q", 2),
                new Card("Event", "Q", 2)
        );
        game = new Game(new TestAdvDeck(advCards), new TestEventDeck(eventCards));
    }
}
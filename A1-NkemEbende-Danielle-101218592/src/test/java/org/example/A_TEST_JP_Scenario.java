package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class A_TEST_JP_Scenario {
    @Test
    @DisplayName("A-TEST-JP-Scenario")
    public void RESP_1_test_01() {
        // 1) Start game,decks are created, hands of the 4 players are set up with random cards
        Main game = new Main();
        game.initAdvDeck();
        game.initEventDeck();
        game.shuffleDecks();
        game.distributeCards();

        // extra tests
        assertEquals(52, game.getAdvDeckSize());
        assertEquals(17, game.getEventDeckSize());

        // 2) Rig 4 hands
        // P1
        game.overwriteCard(game.p1.cards, 0, "Adventure", "F", 5);
        game.overwriteCard(game.p1.cards, 1, "Adventure", "F", 5);
        game.overwriteCard(game.p1.cards, 2, "Adventure", "F", 15);
        game.overwriteCard(game.p1.cards, 3, "Adventure", "F", 15);

        game.overwriteCard(game.p1.cards, 4, "Adventure", "D", 5);
        game.overwriteCard(game.p1.cards, 5, "Adventure", "S", 10);
        game.overwriteCard(game.p1.cards, 6, "Adventure", "S", 10);
        game.overwriteCard(game.p1.cards, 7, "Adventure", "H", 10);

        game.overwriteCard(game.p1.cards, 8, "Adventure", "H", 10);
        game.overwriteCard(game.p1.cards, 9, "Adventure", "B", 15);
        game.overwriteCard(game.p1.cards, 10, "Adventure", "B", 15);
        game.overwriteCard(game.p1.cards, 11, "Adventure", "L", 20);
        // P2
        game.overwriteCard(game.p2.cards, 0, "Adventure", "F", 5);
        game.overwriteCard(game.p2.cards, 1, "Adventure", "F", 5);
        game.overwriteCard(game.p2.cards, 2, "Adventure", "F", 15);
        game.overwriteCard(game.p2.cards, 3, "Adventure", "F", 15);

        game.overwriteCard(game.p2.cards, 4, "Adventure", "F", 40);
        game.overwriteCard(game.p2.cards, 5, "Adventure", "D", 5);
        game.overwriteCard(game.p2.cards, 6, "Adventure", "S", 10);
        game.overwriteCard(game.p2.cards, 7, "Adventure", "H", 10);

        game.overwriteCard(game.p2.cards, 8, "Adventure", "H", 10);
        game.overwriteCard(game.p2.cards, 9, "Adventure", "B", 15);
        game.overwriteCard(game.p2.cards, 10, "Adventure", "B", 15);
        game.overwriteCard(game.p2.cards, 11, "Adventure", "E", 30);
        // P3
        game.overwriteCard(game.p3.cards, 0, "Adventure", "F", 5);
        game.overwriteCard(game.p3.cards, 1, "Adventure", "F", 5);
        game.overwriteCard(game.p3.cards, 2, "Adventure", "F", 5);
        game.overwriteCard(game.p3.cards, 3, "Adventure", "F", 15);

        game.overwriteCard(game.p3.cards, 4, "Adventure", "D", 5);
        game.overwriteCard(game.p3.cards, 5, "Adventure", "S", 10);
        game.overwriteCard(game.p3.cards, 6, "Adventure", "S", 10);
        game.overwriteCard(game.p3.cards, 7, "Adventure", "S", 10);

        game.overwriteCard(game.p3.cards, 8, "Adventure", "H", 10);
        game.overwriteCard(game.p3.cards, 9, "Adventure", "H", 10);
        game.overwriteCard(game.p3.cards, 10, "Adventure", "B", 15);
        game.overwriteCard(game.p3.cards, 11, "Adventure", "L", 20);
        // P4
        game.overwriteCard(game.p4.cards, 0, "Adventure", "F", 5);
        game.overwriteCard(game.p4.cards, 1, "Adventure", "F", 15);
        game.overwriteCard(game.p4.cards, 2, "Adventure", "F", 15);
        game.overwriteCard(game.p4.cards, 3, "Adventure", "F", 40);

        game.overwriteCard(game.p4.cards, 4, "Adventure", "D", 5);
        game.overwriteCard(game.p4.cards, 5, "Adventure", "D", 5);
        game.overwriteCard(game.p4.cards, 6, "Adventure", "S", 10);
        game.overwriteCard(game.p4.cards, 7, "Adventure", "H", 10);

        game.overwriteCard(game.p4.cards, 8, "Adventure", "H", 10);
        game.overwriteCard(game.p4.cards, 9, "Adventure", "B", 15);
        game.overwriteCard(game.p4.cards, 10, "Adventure", "L", 20);
        game.overwriteCard(game.p4.cards, 11, "Adventure", "E", 30);

        // extra tests
        assertEquals(12, game.p1.getCardsSize());
        assertEquals(12, game.p2.getCardsSize());
        assertEquals(12, game.p3.getCardsSize());
        assertEquals(12, game.p4.getCardsSize());

        // 3) P1 draws a quest of 4 stages
        game.overwriteCard(game.eventDeck, 16, "Event", "Q", 4);
        String sponsorPrompt = "N\nY\nN\nN\n";
        StringWriter output = new StringWriter();
        game.currentDrawnEventCard = game.eventDeck.get(16);

        // 4) p1 declines
        game.playersSponsorPrompt(new Scanner(sponsorPrompt), new PrintWriter(output));

        // 5) p2 accepts and builds
        String stages = "1\n7\nQ\n2\n5\nQ\n2\n3\n5\nQ\n2\n3\nQ\n";
        game.clearScreen(new PrintWriter(output));
        game.sponsoringPlayer.buildStages(new Scanner(stages));
        game.clearScreen(new PrintWriter(output));

        // 6)
        game.getEligiblePlayers();
        game.printEligiblePlayers();
        String promptQuest1 = "Y\nY\nY\n";
        game.askEligiblePlayers(new Scanner(promptQuest1), new PrintWriter(output));
        game.clearScreen(new PrintWriter(output));

        game.overwriteCard(game.advDeck, game.getAdvDeckSize() -1, "Adventure", "F", 30);
        game.p1.drawAdvCard();
        game.p1.sortCards();
        String index3 = "1\nQ\n";
        game.p1.trimToTwelve(new Scanner(index3), new PrintWriter(output));
        assertEquals(12, game.p1.getCardsSize()); // extra tests
        game.clearScreen(new PrintWriter(output));

        game.overwriteCard(game.advDeck, game.getAdvDeckSize() -1, "Adventure", "S", 10);
        game.p3.drawAdvCard();
        game.p3.sortCards();
        String index2 = "1\nQ\n";
        game.p3.trimToTwelve(new Scanner(index2), new PrintWriter(output));
        assertEquals(12, game.p3.getCardsSize()); // extra tests
        game.clearScreen(new PrintWriter(output));

        game.overwriteCard(game.advDeck, game.getAdvDeckSize() -1, "Adventure", "B", 15);
        game.p4.drawAdvCard();
        game.p4.sortCards();
        // extra tests
        assertEquals("B", game.p4.getCard(10).getName()); // extra tests
        assertEquals(15, game.p4.getCard(10).getValue()); // extra tests
        assertEquals(13, game.p4.getCardsSize());
        String index = "1\nQ\n";
        game.p4.trimToTwelve(new Scanner(index), new PrintWriter(output));
        assertEquals(12, game.p4.getCardsSize());
        game.clearScreen(new PrintWriter(output));

        String attackStage1 = "5\n5\nQ\n5\n4\nQ\n4\n6\nQ\n"; // P1 -> P4
        game.participantsSetUpAttack(new Scanner(attackStage1), new PrintWriter(output));

        game.allEligiblePlayersAttackStage(game.stage1, "stage1");
        game.discardAllEligibleAttackCards();

        // extra tests
        assertEquals(0, game.p1.attack.size());
        assertEquals(0, game.p3.attack.size());
        assertEquals(0, game.p4.attack.size());

        // 7)
        String promptQuest2 = "Y\nY\nY\n";
        game.askEligiblePlayers(new Scanner(promptQuest2), new PrintWriter(output));

        game.overwriteCard(game.advDeck, game.getAdvDeckSize() -1, "Adventure", "F", 10);
        game.p1.drawAdvCard();
        game.p1.sortCards();
        game.overwriteCard(game.advDeck, game.getAdvDeckSize() -1, "Adventure", "L", 20);
        game.p3.drawAdvCard();
        game.p3.sortCards();
        game.overwriteCard(game.advDeck, game.getAdvDeckSize() -1, "Adventure", "L", 20);
        game.p4.drawAdvCard();
        game.p4.sortCards();


        String attackStage2 = "7\n6\nQ\n9\n4\nQ\n6\n6\nQ\n"; // P1 -> P4
        game.participantsSetUpAttack(new Scanner(attackStage2), new PrintWriter(output));
        game.allEligiblePlayersAttackStage(game.stage2, "stage2");
        game.discardAllEligibleAttackCards();
        game.printEligiblePlayers();

        // OFFICIAL ASSERT TEST
        assertEquals("F", game.p1.getCard(0).getName());assertEquals(5, game.p1.getCard(0).getValue());
        assertEquals("F", game.p1.getCard(1).getName());assertEquals(10, game.p1.getCard(1).getValue());
        assertEquals("F", game.p1.getCard(2).getName());assertEquals(15, game.p1.getCard(2).getValue());
        assertEquals("F", game.p1.getCard(3).getName());assertEquals(15, game.p1.getCard(3).getValue());
        assertEquals("F", game.p1.getCard(4).getName());assertEquals(30, game.p1.getCard(4).getValue());
        assertEquals("H", game.p1.getCard(5).getName());assertEquals(10, game.p1.getCard(5).getValue());
        assertEquals("B", game.p1.getCard(6).getName());assertEquals(15, game.p1.getCard(6).getValue());
        assertEquals("B", game.p1.getCard(7).getName());assertEquals(15, game.p1.getCard(7).getValue());
        assertEquals("L", game.p1.getCard(8).getName());assertEquals(20, game.p1.getCard(8).getValue());

        // 8)
        String promptQuest3 = "Y\nY\n";
        game.askEligiblePlayers(new Scanner(promptQuest3), new PrintWriter(output));

        game.overwriteCard(game.advDeck, game.getAdvDeckSize() -1, "Adventure", "B", 15);
        game.p3.drawAdvCard();
        game.p3.sortCards();
        game.overwriteCard(game.advDeck, game.getAdvDeckSize() -1, "Adventure", "S", 10);
        game.p4.drawAdvCard();
        game.p4.sortCards();

        String attackStage3 = "10\n6\n4\nQ\n7\n5\n7\nQ"; // P3 -> P4
        game.participantsSetUpAttack(new Scanner(attackStage3), new PrintWriter(output));
        game.allEligiblePlayersAttackStage(game.stage3, "stage3");
        game.discardAllEligibleAttackCards();
        game.printEligiblePlayers();

        // 9)
        String promptQuest4 = "Y\nY\n";
        game.askEligiblePlayers(new Scanner(promptQuest4), new PrintWriter(output));

        game.overwriteCard(game.advDeck, game.getAdvDeckSize() -1, "Adventure", "F", 30);
        game.p3.drawAdvCard();
        game.p3.sortCards();
        game.overwriteCard(game.advDeck, game.getAdvDeckSize() -1, "Adventure", "L", 20);
        game.p4.drawAdvCard();
        game.p4.sortCards();

        String attackStage4 = "7\n6\n6\nQ\n4\n4\n4\n5\nQ"; // P3 -> P4
        game.participantsSetUpAttack(new Scanner(attackStage4), new PrintWriter(output));
        game.allEligiblePlayersAttackStage(game.stage4, "stage4");
        game.discardAllEligibleAttackCards();
        game.printEligiblePlayers();
        game.concludeQuest(new PrintWriter(output));

        // OFFICIAL ASSERT TEST
        assertEquals(0, game.p3.getNumShields());
        assertEquals(5, game.p3.getCardsSize());
        assertEquals("F", game.p3.getCard(0).getName());assertEquals(5, game.p3.getCard(0).getValue());
        assertEquals("F", game.p3.getCard(1).getName());assertEquals(5, game.p3.getCard(1).getValue());
        assertEquals("F", game.p3.getCard(2).getName());assertEquals(15, game.p3.getCard(2).getValue());
        assertEquals("F", game.p3.getCard(3).getName());assertEquals(30, game.p3.getCard(3).getValue());
        assertEquals("S", game.p3.getCard(4).getName());assertEquals(10, game.p3.getCard(4).getValue());

        assertEquals(4, game.p4.getNumShields());
        assertEquals(4, game.p4.getCardsSize());
        assertEquals("F", game.p4.getCard(0).getName());assertEquals(15, game.p4.getCard(0).getValue());
        assertEquals("F", game.p4.getCard(1).getName());assertEquals(15, game.p4.getCard(1).getValue());
        assertEquals("F", game.p4.getCard(2).getName());assertEquals(40, game.p4.getCard(2).getValue());
        assertEquals("L", game.p4.getCard(3).getName());assertEquals(20, game.p4.getCard(3).getValue());


        // 10
        game.sponsoringPlayer.discardStageCards();
        game.sponsoringPlayer.drawAdvCard();
        game.sponsoringPlayer.drawAdvCard();
        game.sponsoringPlayer.drawAdvCard();
        game.sponsoringPlayer.drawAdvCard();
        game.sponsoringPlayer.drawAdvCard();
        game.sponsoringPlayer.drawAdvCard();
        game.sponsoringPlayer.drawAdvCard();
        game.sponsoringPlayer.drawAdvCard();
        game.sponsoringPlayer.drawAdvCard();

        game.sponsoringPlayer.drawAdvCard();
        game.sponsoringPlayer.drawAdvCard();
        game.sponsoringPlayer.drawAdvCard();
        game.sponsoringPlayer.sortCards();

        String trim = "1\n3\n7\n4\n";
        game.sponsoringPlayer.trimToTwelve(new Scanner(trim), new PrintWriter(output));
        game.clearScreen(new PrintWriter(output));
        // OFFICIAL ASSERT TEST
        assertEquals(12, game.p2.getCardsSize());
    }
}

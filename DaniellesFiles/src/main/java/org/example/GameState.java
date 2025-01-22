package org.example;

import java.util.List;

public class GameState {
    private List<Card> p1Hand;
    private List<Card> p1Attack;

    private List<Card> p2Hand;
    private List<Card> p2Attack;

    private List<Card> p3Hand;
    private List<Card> p3Attack;

    private List<Card> p4Hand;
    private List<Card> p4Attack;

    private int p1Score;
    private int p2Score;
    private int p3Score;
    private int p4Score;
    private boolean gameEnded;
    private String message;

//    Do I need the attack sets?

    public GameState(String message, boolean gameEnded, int p4Score, int p3Score, int p2Score, int p1Score, List<Card> p4Attack, List<Card> p4Hand, List<Card> p3Attack, List<Card> p3Hand, List<Card> p2Attack, List<Card> p2Hand, List<Card> p1Attack, List<Card> p1Hand) {
        this.message = message;
        this.gameEnded = gameEnded;
        this.p4Score = p4Score;
        this.p3Score = p3Score;
        this.p2Score = p2Score;
        this.p1Score = p1Score;
        this.p4Attack = p4Attack;
        this.p4Hand = p4Hand;
        this.p3Attack = p3Attack;
        this.p3Hand = p3Hand;
        this.p2Attack = p2Attack;
        this.p2Hand = p2Hand;
        this.p1Attack = p1Attack;
        this.p1Hand = p1Hand;
    }

    public List<Card> getP1Hand() {
        return p1Hand;
    }

    public List<Card> getP1Attack() {
        return p1Attack;
    }

    public List<Card> getP4Attack() {
        return p4Attack;
    }

    public List<Card> getP4Hand() {
        return p4Hand;
    }

    public List<Card> getP3Attack() {
        return p3Attack;
    }

    public List<Card> getP3Hand() {
        return p3Hand;
    }

    public List<Card> getP2Attack() {
        return p2Attack;
    }

    public List<Card> getP2Hand() {
        return p2Hand;
    }

    public int getP4Score() {
        return p4Score;
    }

    public int getP3Score() {
        return p3Score;
    }

    public int getP2Score() {
        return p2Score;
    }

    public int getP1Score() {
        return p1Score;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public String getMessage() {
        return message;
    }
}

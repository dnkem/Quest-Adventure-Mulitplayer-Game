Feature: Danielle's Game

  Scenario: A1_scenario
#    Give: Defines what must be true when the story/test starts
    Given the game starts
    And the cards are rigged for scenario 1
    And the cards are distributed to all 4 players

#    When: Defines the event/trigger
    When P1 draws an event card
    And P1 is asked to sponsor and "declines"
    And P2 is asked to sponsor and "accepts"
    And Sponsor builds stage 1 and adds card from position 1
    And Sponsor builds stage 1 and adds card from position 7
    And Sponsor builds stage 2 and adds card from position 2
    And Sponsor builds stage 2 and adds card from position 5
    And Sponsor builds stage 3 and adds card from position 2
    And Sponsor builds stage 3 and adds card from position 3
    And Sponsor builds stage 3 and adds card from position 5
    And Sponsor builds stage 4 and adds card from position 2
    And Sponsor builds stage 4 and adds card from position 3
    And Get eligible players
        #  Stage 1
    And P1 is asked to participate and "accepts"
    And P1 draws adventure card and discards position 1
    And P3 is asked to participate and "accepts"
    And P3 draws adventure card and discards position 1
    And P4 is asked to participate and "accepts"
    And P4 draws adventure card and discards position 1
    And P1 sets up an attack with card in position 5
    And P1 sets up an attack with card in position 5
    And P3 sets up an attack with card in position 5
    And P3 sets up an attack with card in position 4
    And P4 sets up an attack with card in position 4
    And P4 sets up an attack with card in position 6
    And Participants attack stage 1
          #  Stage 2
    And P1 is asked to participate and "accepts"
    And P3 is asked to participate and "accepts"
    And P4 is asked to participate and "accepts"
    And Participants draw an adventure card
    And P1 sets up an attack with card in position 7
    And P1 sets up an attack with card in position 6
    And P3 sets up an attack with card in position 9
    And P3 sets up an attack with card in position 4
    And P4 sets up an attack with card in position 6
    And P4 sets up an attack with card in position 6
    And Participants attack stage 2
        #  Stage 3
    And P3 is asked to participate and "accepts"
    And P4 is asked to participate and "accepts"
    And Participants draw an adventure card
    And P3 sets up an attack with card in position 10
    And P3 sets up an attack with card in position 6
    And P3 sets up an attack with card in position 4
    And P4 sets up an attack with card in position 7
    And P4 sets up an attack with card in position 5
    And P4 sets up an attack with card in position 7
    And Participants attack stage 3
        #  Stage 4
    And P3 is asked to participate and "accepts"
    And P4 is asked to participate and "accepts"
    And Participants draw an adventure card
    And P3 sets up an attack with card in position 7
    And P3 sets up an attack with card in position 6
    And P3 sets up an attack with card in position 6
    And P4 sets up an attack with card in position 4
    And P4 sets up an attack with card in position 4
    And P4 sets up an attack with card in position 4
    And P4 sets up an attack with card in position 5
    And Participants attack stage 4
        #  Sponsor discards and retrieves cards
    And The quest is completed and the sponsor draws adventure cards
    And The sponsor trims their hand in position: 1
    And The sponsor trims their hand in position: 1
    And The sponsor trims their hand in position: 1
    And The sponsor trims their hand in position: 1

#   Additional WHEN Steps Below - these Steps are the previous version of some established steps above that take in a string of input instead of manual and single inputs
#                               -  they would need to be commented in in both files to run
#   And Sponsor builds the stages of the quest
#   And The quest is completed and the sponsor draws and trim cards
#   And Participants set up attack stage 3 for scenario 1


#    Then: verifies ideal result
    Then the quest ends
    And P3 has 5 cards and has 0 shields
    And P4 has 4 cards and has 4 shields
    And P2 has 12 cards and has 0 shields
    And P1 has 9 cards and has 0 shields



  Scenario: 2winner_game_2winner_quest
    Given the game starts
    And the cards are rigged for scenario 1
    And the cards are distributed to all 4 players


  Scenario: 1winner_game_with_events


  Scenario: 0_winner_quest
    Given the game starts
    And the cards are rigged for scenario 2
    And the cards are distributed to all 4 players

    When P1 draws an event card
    And P1 is asked to sponsor and "accepts"
    And Sponsor builds stage 1 and adds card from position 12
    And Sponsor builds stage 1 and adds card from position 11
    And Get eligible players
    #    Stage 1
    And P2 is asked to participate and "accepts"
    And P2 draws adventure card and discards position 1
    And P3 is asked to participate and "accepts"
    And P3 draws adventure card and discards position 1
    And P4 is asked to participate and "accepts"
    And P4 draws adventure card and discards position 1
    And P2 sets up an attack with card in position 1
    And P2 sets up an attack with card in position 5
    And P3 sets up an attack with card in position 1
    And P3 sets up an attack with card in position 5
    And P4 sets up an attack with card in position 4
    And P4 sets up an attack with card in position 4
    And Participants attack stage 1

    And The quest is completed and the sponsor draws adventure cards
    And The sponsor trims their hand in position: 1

    Then the quest ends
    And P2 has 10 cards and has 0 shields
    And P3 has 10 cards and has 0 shields
    And P4 has 10 cards and has 0 shields
    And P1 has 12 cards and has 0 shields

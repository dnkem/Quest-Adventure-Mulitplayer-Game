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
    And the quest ends

#   Additional WHEN Steps Below - these Steps are the previous version of some established steps above that take in a string of input instead of manual and single inputs
#                               -  they would need to be commented in in both files to run and note they're specific to Scenario 1
#   And Sponsor builds the stages of the quest
#   And The quest is completed and the sponsor draws and trim cards
#   And Participants set up attack stage 3 for scenario 1

#    Then: verifies ideal result
    Then P3 has 5 cards and has 0 shields
    And P4 has 4 cards and has 4 shields
    And P2 has 12 cards and has 0 shields
    And P1 has 9 cards and has 0 shields


# SCENARIO 2 ********************************************************************************************************************************************************
  Scenario: 2winner_game_2winner_quest
    # GIVEN
    Given the game starts
    And the cards are rigged for scenario 2
    And the cards are distributed to all 4 players

    # WHEN
    When P1 draws an event card
    And P1 is asked to sponsor and "accepts"
    And Sponsor builds stage 1 and adds card from position 3
    And Sponsor builds stage 2 and adds card from position 1
    And Sponsor builds stage 2 and adds card from position 3
    And Sponsor builds stage 2 and adds card from position 4
    And Sponsor builds stage 3 and adds card from position 2
    And Sponsor builds stage 3 and adds card from position 2
    And Sponsor builds stage 4 and adds card from position 1
    And Sponsor builds stage 4 and adds card from position 1
    And Sponsor builds stage 4 and adds card from position 4
    And Get eligible players
#        #  Stage 1
    And P2 is asked to participate and "accepts"
    And P2 draws adventure card and discards position 1
    And P3 is asked to participate and "accepts"
    And P3 draws adventure card and discards position 1
    And P4 is asked to participate and "accepts"
    And P4 draws adventure card and discards position 1
    And P2 sets up an attack with card in position 5
    And P2 sets up an attack with card in position 6
    And P3 sets up an attack with card in position 4
    And P4 sets up an attack with card in position 4
    And P4 sets up an attack with card in position 7
    And Participants attack stage 1
        #  Stage 2
    And P2 is asked to participate and "accepts"
    And P4 is asked to participate and "accepts"
    And Participants draw an adventure card
    And P2 sets up an attack with card in position 6
    And P2 sets up an attack with card in position 6
    And P4 sets up an attack with card in position 4
    And P4 sets up an attack with card in position 7
    And Participants attack stage 2
        #  Stage 3
    And P2 is asked to participate and "accepts"
    And P4 is asked to participate and "accepts"
    And Participants draw an adventure card
    And P2 sets up an attack with card in position 6
    And P2 sets up an attack with card in position 7
    And P4 sets up an attack with card in position 4
    And P4 sets up an attack with card in position 7
    And Participants attack stage 3
        #  Stage 4
    And P2 is asked to participate and "accepts"
    And P4 is asked to participate and "accepts"
    And Participants draw an adventure card
    And P2 sets up an attack with card in position 5
    And P2 sets up an attack with card in position 8
    And P4 sets up an attack with card in position 6
    And P4 sets up an attack with card in position 8
    And Participants attack stage 4

    And The quest is completed and the sponsor draws adventure cards
    And The sponsor trims their hand in position: 1
    And The sponsor trims their hand in position: 1
    And The sponsor trims their hand in position: 1
    And The sponsor trims their hand in position: 2
    And the quest ends

    And P2 draws an event card
    And P2 is asked to sponsor and "declines"
    And P3 is asked to sponsor and "accepts"
    And Sponsor builds stage 1 and adds card from position 1
    And Sponsor builds stage 2 and adds card from position 1
    And Sponsor builds stage 2 and adds card from position 2
    And Sponsor builds stage 3 and adds card from position 1
    And Get eligible players
        #  Stage 1
    And P1 is asked to participate and "declines"
    And P2 is asked to participate and "accepts"
    And P4 is asked to participate and "accepts"
    And Participants draw an adventure card
    And P2 sets up an attack with card in position 6
    And P4 sets up an attack with card in position 6
    And Participants attack stage 1
        #  Stage 2
    And P2 is asked to participate and "accepts"
    And P4 is asked to participate and "accepts"
    And Participants draw an adventure card
    And P2 sets up an attack with card in position 7
    And P4 sets up an attack with card in position 6
    And Participants attack stage 2
        #  Stage 3
    And P2 is asked to participate and "accepts"
    And P4 is asked to participate and "accepts"
    And Participants draw an adventure card
    And P2 sets up an attack with card in position 8
    And P4 sets up an attack with card in position 5
    And P4 sets up an attack with card in position 6
    And Participants attack stage 3
    And the quest ends

    # THEN
    Then P1 has 12 cards and has 0 shields
    And P3 has 7 cards and has 0 shields
#    P3 has 7 cards because there are winners of the game therefore the sponsor doesn't pick up more adventure cards
    And P2 has 7 cards and has 7 shields
    And P4 has 6 cards and has 7 shields
    And P2 is a winner
    And P4 is a winner


# SCENARIO 3 ********************************************************************************************************************************************************
  Scenario: 1winner_game_with_events
    # GIVEN
    Given the game starts
    And the cards are rigged for scenario 3
    And the cards are distributed to all 4 players

    # WHEN
    When P1 draws an event card
    And P1 is asked to sponsor and "accepts"
    And Sponsor builds stage 1 and adds card from position 3
    And Sponsor builds stage 2 and adds card from position 1
    And Sponsor builds stage 2 and adds card from position 3
    And Sponsor builds stage 2 and adds card from position 4
    And Sponsor builds stage 3 and adds card from position 2
    And Sponsor builds stage 3 and adds card from position 2
    And Sponsor builds stage 4 and adds card from position 1
    And Sponsor builds stage 4 and adds card from position 1
    And Sponsor builds stage 4 and adds card from position 4
    And Get eligible players
        #  Stage 1
    And P2 is asked to participate and "accepts"
    And P2 draws adventure card and discards position 1
    And P3 is asked to participate and "accepts"
    And P3 draws adventure card and discards position 1
    And P4 is asked to participate and "accepts"
    And P4 draws adventure card and discards position 1
    And P2 sets up an attack with card in position 5
    And P2 sets up an attack with card in position 6
    And P3 sets up an attack with card in position 4
    And P3 sets up an attack with card in position 8
    And P4 sets up an attack with card in position 4
    And P4 sets up an attack with card in position 7
    And Participants attack stage 1
        #  Stage 2
    And P2 is asked to participate and "accepts"
    And P4 is asked to participate and "accepts"
    And Participants draw an adventure card
    And P2 sets up an attack with card in position 6
    And P2 sets up an attack with card in position 6
    And P3 sets up an attack with card in position 5
    And P3 sets up an attack with card in position 8
    And P4 sets up an attack with card in position 4
    And P4 sets up an attack with card in position 7
    And Participants attack stage 2
        #  Stage 3
    And P2 is asked to participate and "accepts"
    And P3 is asked to participate and "accepts"
    And P4 is asked to participate and "accepts"
    And Participants draw an adventure card
    And P2 sets up an attack with card in position 6
    And P2 sets up an attack with card in position 7
    And P3 sets up an attack with card in position 5
    And P3 sets up an attack with card in position 8
    And P4 sets up an attack with card in position 4
    And P4 sets up an attack with card in position 7
    And Participants attack stage 3
        #  Stage 4
    And P2 is asked to participate and "accepts"
    And P3 is asked to participate and "accepts"
    And P4 is asked to participate and "accepts"
    And Participants draw an adventure card
    And P2 sets up an attack with card in position 5
    And P2 sets up an attack with card in position 8
    And P3 sets up an attack with card in position 5
    And P3 sets up an attack with card in position 6
    And P3 sets up an attack with card in position 7
    And P4 sets up an attack with card in position 6
    And P4 sets up an attack with card in position 8
    And Participants attack stage 4

    And The quest is completed and the sponsor draws adventure cards
    And The sponsor trims their hand in position: 16
    And The sponsor trims their hand in position: 15
    And The sponsor trims their hand in position: 14
    And The sponsor trims their hand in position: 13
    And the quest ends

    And P2 draws an event card
    And P3 draws an event card
    And P1 trims their hand at position 14
    And P1 trims their hand at position 13
    And P4 draws an event card
    And P1 draws an event card
    And P1 is asked to sponsor and "accepts"
    And Sponsor builds stage 1 and adds card from position 3
    And Sponsor builds stage 2 and adds card from position 3
    And Sponsor builds stage 2 and adds card from position 3
    And Sponsor builds stage 3 and adds card from position 1
    And Sponsor builds stage 3 and adds card from position 2
    And Sponsor builds stage 3 and adds card from position 6
    And Get eligible players

        #  Stage 1
    And P2 is asked to participate and "accepts"
    And P3 is asked to participate and "accepts"
    And P4 is asked to participate and "accepts"
    And Participants draw an adventure card
    And P2 sets up an attack with card in position 10
    And P3 sets up an attack with card in position 7
    And P4 sets up an attack with card in position 9
    And Participants attack stage 1
        #  Stage 2
    And P2 is asked to participate and "accepts"
    And P3 is asked to participate and "accepts"
    And Participants draw an adventure card
    And P2 sets up an attack with card in position 7
    And P2 sets up an attack with card in position 9
    And P3 sets up an attack with card in position 8
    And Participants attack stage 2
        #  Stage 3
    And P2 is asked to participate and "accepts"
    And P3 is asked to participate and "accepts"
    And Participants draw an adventure card
    And P2 sets up an attack with card in position 7
    And P2 sets up an attack with card in position 8
    And P3 sets up an attack with card in position 9
    And Participants attack stage 3

    And the quest ends
    # THEN
    Then P3 has 8 cards and has 7 shields
    And P3 is a winner
    And P4 has 11 cards and has 4 shields
    And P2 has 7 cards and has 5 shields
    And P1 has 6 cards and has 0 shields





# SCENARIO 4 ********************************************************************************************************************************************************
  Scenario: 0_winner_quest
    # GIVEN
    Given the game starts
    And the cards are rigged for scenario 4
    And the cards are distributed to all 4 players

    # WHEN
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

    # THEN
    Then the quest ends
    And P2 has 10 cards and has 0 shields
    And P3 has 10 cards and has 0 shields
    And P4 has 10 cards and has 0 shields
    And P1 has 12 cards and has 0 shields

# To see Test Driven Development (TDD) Approach with JUnit
- Go to the main branch for the code and commits
## Main Files of Note:
  - Main.java (Danielles-File/src/main/java/org/example/Main.java)
    : code with main responsibilities, functionalities, and classes
  - MainTest.java (Danielles-File/src/test/java/org/example/MainTest.java)
    : test cases with assertions for all the responsibilies related to the TDD Approach
  - A_Test_JP_Scenario (Danielles-File/src/test/java/org/example/A_TEST_JP_Scenario.java)
    : Additional specific test scenario with specific cards using functions from the main file to get to a certain point
    
- the link of it running:
# To see Behaviour Driven Development (BDD) Approach with Cucumber
- Go to the A2branch for the code
## Main Files of Note:
- Main.java (Danielles-Files/src/main/java/org/example/Main.java)
  : now an empty file after refactoring
- Card.java (Danielles-Files/src/main/java/org/example/Card.java)
  : card class with member variables, constructor, and getters
- Deck.java (Danielles-Files/src/main/java/org/example/Deck.java)
  : deck class with a member variable and methods(add, remove, init, etc.)
- Player.java (Danielles-Files/src/main/java/org/example/Player.java)
  : player class with member variables and methods(promptSponsor, trimCard, buildStages, etc.)
- Game.java (Danielles-Files/src/main/java/org/example/Game.java)
  : game class with instances of all the other classes ie. objects, member variables(eligiblePlayers, gameWinners, etc), and overall game methods(clearScreen, distributeCards, getEligiblePlayers, etc)
- GameSteps.java (Danielles-Files/src/test/java/cucumber/GameSteps.java)
  : game steps and behaviours are defined (Given, Then, When)
- RunCucumberTest.java (Danielles-Files/src/test/java/cucumber/RunCucumberTest.java)
  : empty file to run the cucumber tests
- TestAdvDeck.java (Danielles-Files/src/test/java/cucumber/TestAdvDeck.java)
  : inheriting class to support the init of cards in GameStep file
- TestEventDeck.java (Danielles-Files/src/test/java/cucumber/TestEventDeck.java)
  : inheriting class to support the init of cards in GameStep file
- A2_Tests.feature (Danielles-Files/src/test/resources/A2_Tests.feature)
  : feature file with specific scenarios using the GameStep behaviours
 
- the link of it running: 
# To see Web interface tested with Selenium
- Go to the A3branch for the code
## Main Files of Note:
- A3_Controller.java (DaniellesFiles/src/main/java/org/example/A3_Controller.java)
  : Backend portion of the Springboot framework (REST Controller responsible for handling incoming HTTP requests and returning an appropriate response)
- A3_Application.java (DaniellesFiles/src/main/java/org/example/A3_Application.java)
  : empty file to run the springboot application (executable)
- script.js (DaniellesFiles/frontend/script.js)
  : client porrtion of the Springboot framework (Javascript functions that call the backend)
- A1_scenario_test.js (DaniellesFiles/frontend/A1_scenario_test.js)
  : specific selenium test scenario
- 2_winner_test.js (DaniellesFiles/frontend/2_winner_test.js)
  : specific selenium test scenario
- 0_winner_test.js (DaniellesFiles/frontend/0_winner_test.js)
  : specific selenium test scenario
  

- the link of it running: 

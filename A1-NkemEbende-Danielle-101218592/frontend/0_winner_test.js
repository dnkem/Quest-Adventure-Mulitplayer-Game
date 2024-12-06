const { Builder, By, until, Key } = require('selenium-webdriver');
// import { startRandomGame } from "./script.js";

async function runTest() {
    try {
        let driver = await new Builder().forBrowser('chrome').build();
        await driver.get('http://127.0.0.1:8081');

        await driver.sleep(2000);

        // click Start 0 Winner Game Button
        let startButton = await driver.findElement(By.xpath("//button[contains(text(), 'Start 0 Winner Game')]"));
        await startButton.click();

        // check for notif status to be corrects
        await driver.wait(until.elementTextContains(driver.findElement(By.id('game-status')), '0 Winner Game started. P1 draws an Event Card'), 10000);
        console.log("Game started successfully.");

        await driver.sleep(2000);

        // click Play Event Card
        let playEventButton = await driver.findElement(By.xpath("//button[contains(text(), 'Current Player Play Event Card')]"));
        await playEventButton.click();
        console.log("Playing the Event Card");

        await driver.sleep(2000);

        // Enter Yes to Sponsor the Quest
        let inputBox = await driver.findElement(By.xpath("//input[@id='input-box']"));
        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        console.log("P1 Decides to Sponsor");
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("2"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("3");
        await driver.sleep(1500); 
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("4"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("5"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        
        await inputBox.clear();
        await inputBox.sendKeys("6"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        
        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        console.log("Stage 1 is Built")

        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        console.log("Stage 2 is built")
        console.log("P1 Finished Building the Stages");

        await inputBox.clear();
        await inputBox.sendKeys("*");
        await driver.sleep(1500); 
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        console.log("P2 Joins Quest");

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        console.log("P3 Joins Quest");

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        console.log("P4 Joins Quest");

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        console.log("Eligible Players drew an Adventure Card");

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        console.log("P2 Discards F5");

        await inputBox.clear();
        await inputBox.sendKeys("4"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        console.log("P3 Discards F15");

        await inputBox.clear();
        await inputBox.sendKeys("3"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        console.log("P4 Discards F10");

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("12"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        console.log("P2 Attacks with E30");

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        
        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        console.log("P3 Attacks with empty stage");

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        console.log("P4 Attacks with empty stage");

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        console.log("Display shows who passed");

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        
        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        
        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        console.log("\nSponsor Picks Up");

        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        console.log("P1 Trims F5");

        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        console.log("P1 Trims 10");

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        console.log("The Quest is Over");

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        console.log("The Quest is Over");

        // click
        let concludeButton = await driver.findElement(By.xpath("//button[contains(text(), 'Conclude Quest')]"));
        await concludeButton.click();
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        console.log("\n\nEnd of 0 Winner Scenario");
        

    } catch (error) {
        console.error("Test encountered an error:", error);
    } finally {
        await driver.quit();
    }
}

runTest();
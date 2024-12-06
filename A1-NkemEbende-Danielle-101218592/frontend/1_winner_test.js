const { Builder, By, until, Key } = require('selenium-webdriver');
// import { startRandomGame } from "./script.js";

async function runTest() {
    try {
        let driver = await new Builder().forBrowser('chrome').build();
        await driver.get('http://127.0.0.1:8081');

        await driver.sleep(2000);

        // click Start 0 Winner Game Button
        let startButton = await driver.findElement(By.xpath("//button[contains(text(), 'Start 1 Winner Game')]"));
        await startButton.click();

        // check for notif status to be correct
        await driver.wait(until.elementTextContains(driver.findElement(By.id('game-status')), '1 Winner Game started. P1 draws an Event Card'), 10000);
        console.log("Game started successfully.");
        await driver.sleep(2000);

        // click Play Event Card
        let playEventButton = await driver.findElement(By.xpath("//button[contains(text(), 'Current Player Play Event Card')]"));
        await playEventButton.click();
        console.log("Playing the Event Card\n");

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
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        
        await inputBox.clear();
        await inputBox.sendKeys("2"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("3"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("4"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        console.log("P1 Built all 4 Stages");

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

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        console.log("All eligible players decided to participate.");

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
        console.log("All eligible players picked up an adventure card.");

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
        await inputBox.sendKeys("*"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        console.log("All eligible players trimmed their hand.");

        await inputBox.clear();
        await inputBox.sendKeys("3"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("3"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("4"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
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
        console.log("Stage is complete");

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
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

        await inputBox.clear();
        await inputBox.sendKeys("7"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("7"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("7"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
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

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
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

        console.log("Building Attack 3")
        await inputBox.clear();
        await inputBox.sendKeys("9"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("9"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("9"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
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

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        console.log("Building Q4 Attack");
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

        console.log("Building Attack 4")
        await inputBox.clear();
        await inputBox.sendKeys("11"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("11"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("11"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
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

        let concludeButton = await driver.findElement(By.xpath("//button[contains(text(), 'Conclude Quest')]"));
        await concludeButton.click();
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        // ??? WHERE IS THE spponsor add

        await startButton.click();
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await concludeButton.click();
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await startButton.click();
        await driver.sleep(2000);
        
        // await inputBox.clear();
        // await inputBox.sendKeys("*"); 
        // await driver.sleep(1500);
        // await inputBox.sendKeys(Key.RETURN); 
        // await driver.sleep(2000);

        // await inputBox.clear();
        // await inputBox.sendKeys("*"); 
        // await driver.sleep(1500);
        // await inputBox.sendKeys(Key.RETURN); 
        // await driver.sleep(2000);

        // await inputBox.clear();
        // await inputBox.sendKeys("*"); 
        // await driver.sleep(1500);
        // await inputBox.sendKeys(Key.RETURN); 
        // await driver.sleep(2000);



    } catch (error) {
        console.error("Test encountered an error:", error);
    } finally {
        await driver.quit();
    }
}

runTest();
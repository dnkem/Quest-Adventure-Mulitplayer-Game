const { Builder, By, until, Key } = require('selenium-webdriver');
// import { startRandomGame } from "./script.js";

async function runTest() {
    let driver = await new Builder().forBrowser('chrome').build();
    try {
        await driver.get('http://127.0.0.1:8081');

        await driver.sleep(2000);

        // click Start 1 Winner Game Button
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

        console.log("Trimming Sponsor's cards");
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
        await inputBox.sendKeys("2"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("2"); 
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

        await playEventButton.click();
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

        await playEventButton.click();
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        console.log("Trimming after Prosperity Card")
        await inputBox.clear();
        await inputBox.sendKeys("1"); // used to be 9
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("1"); // used to be 9
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
        await inputBox.sendKeys("*"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
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

        await playEventButton.click();
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
        await inputBox.sendKeys("2"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("5"); 
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

        await concludeButton.click();
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await playEventButton.click();
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        console.log("P1 building stages for Q3")
        await inputBox.clear();
        await inputBox.sendKeys("1"); // used to be 4
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("1"); // used to be 4
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("8"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("4"); // F20: used to be 6
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("8"); 
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

        console.log("Eligible players are trimming their hand");
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

        console.log("Building Attacks")
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
        await inputBox.sendKeys("10"); 
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

        console.log("Building attacks");
        await inputBox.clear();
        await inputBox.sendKeys("9"); 
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
        await inputBox.sendKeys("5"); 
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

        console.log("Attacks for Stage 3");
        await inputBox.clear();
        await inputBox.sendKeys("6"); 
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

        // Sponsor trims
        await inputBox.clear();
        await inputBox.sendKeys("1"); // used to be 3
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("1"); // used to be 3
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("1"); // used to be 3
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

        await concludeButton.click();
        await driver.sleep(2000);

        console.log("End of Game, Starting Asserts")

        // ASSERTS
        let request = await driver.findElement(By.id('p1-shields'));
        let response = await request.getText();
        console.assert(response == "P1 Shields: 0", "P1 Shields Assertion Failed");
       
        let shield2 = await driver.findElement(By.id('p2-shields'));
        let response2 = await shield2.getText();
        console.assert(response2 == "P2 Shields: 5", "P2 Shields Assertion Failed");

        let shield3 = await driver.findElement(By.id('p3-shields'));
        let response3 = await shield3.getText();
        console.assert(response3 == "P3 Shields: 7", "P3 Shields Assertion Failed");

        let shield4 = await driver.findElement(By.id('p4-shields'));
        let response4 = await shield4.getText();
        console.assert(response4 == "P4 Shields: 4", "P4 Shields Assertion Failed");

        let numRequest = await driver.findElement(By.id('p1-num'));
        let num1 = await numRequest.getText();
        console.assert(num1 == "P1 # Cards: 12", "P1 Shields Assertion Failed");

        let numRequest2 = await driver.findElement(By.id('p2-num'));
        let num2 = await numRequest2.getText();
        console.assert(num2 == "P2 # Cards: 9", "P2 Shields Assertion Failed");

        let numRequest3 = await driver.findElement(By.id('p3-num'));
        let num3 = await numRequest3.getText();
        console.assert(num3 == "P3 # Cards: 10", "P3 Shields Assertion Failed");

        let numRequest4 = await driver.findElement(By.id('p4-num'));
        let num4 = await numRequest4.getText();
        console.assert(num4 == "P4 # Cards: 11", "P4 Shields Assertion Failed");


    } catch (error) {
        console.error("Test encountered an error:", error);
    } finally {
        await driver.quit();
    }
}

runTest();
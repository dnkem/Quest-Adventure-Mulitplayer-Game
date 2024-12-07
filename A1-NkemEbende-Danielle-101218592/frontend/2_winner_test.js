const { Builder, By, until, Key } = require('selenium-webdriver');

async function runTest() {
    let driver = await new Builder().forBrowser('chrome').build();
    try {
        await driver.get('http://127.0.0.1:8081');

        await driver.sleep(1400);

        // click Start 2 Winner Game Button
        let startButton = await driver.findElement(By.xpath("//button[contains(text(), 'Start 2 Winner Game')]"));
        await startButton.click();

        // check for notif status to be correct
        await driver.wait(until.elementTextContains(driver.findElement(By.id('game-status')), '2 Winner Game started. P1 draws an Event Card'), 10000);
        console.log("Game started successfully.");
        await driver.sleep(1400);

        // click Play Event Card
        let playEventButton = await driver.findElement(By.xpath("//button[contains(text(), 'Current Player Play Event Card')]"));
        await playEventButton.click();
        console.log("Playing the Event Card\n");

        await driver.sleep(1400);

        // Enter Yes to Sponsor the Quest
        let inputBox = await driver.findElement(By.xpath("//input[@id='input-box']"));
        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        console.log("P1 Decides to Sponsor");
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);
        
        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("5"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("4"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("4"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);
        // end of stage building

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        // await inputBox.clear();
        // await inputBox.sendKeys("*"); 
        // await driver.sleep(1100);
        // await inputBox.sendKeys(Key.RETURN); 
        // await driver.sleep(1400);

        // agree to stage 1 of q4
        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        //
        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("6"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("7"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);
        // finished attack 1

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        // agree to participate
        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);
        
        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("4"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("4"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);
        // built stage 2

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        // agree to participate
        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);
        
        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("5"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("6"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("5"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("6"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        // participate in stage 4
        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);
        
        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        // attack 4
        await inputBox.clear();
        await inputBox.sendKeys("6"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("6"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("6"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("6"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        // trimming sponsors hand
        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        // end of quest

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        let concludeButton = await driver.findElement(By.xpath("//button[contains(text(), 'Conclude Quest')]"));
        await concludeButton.click();
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await playEventButton.click();
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("N"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        // stages q3
        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("3"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("4"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        // P1 declinse joining q3
        await inputBox.clear();
        await inputBox.sendKeys("N"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        // others agree
        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        // attacks 1
        await inputBox.clear();
        await inputBox.sendKeys("6"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("6"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        // attack 2
        await inputBox.clear();
        await inputBox.sendKeys("7"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("7"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        // attack 3
        await inputBox.clear();
        await inputBox.sendKeys("10"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("10"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        // sponsor trims
        await inputBox.clear();
        await inputBox.sendKeys("1"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("2"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("2"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await inputBox.clear();
        await inputBox.sendKeys("*"); 
        await driver.sleep(1100);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(1400);

        await concludeButton.click();
        await driver.sleep(1400);


        // ASSERTS
        let request = await driver.findElement(By.id('p1-shields'));
        let response = await request.getText();
        console.assert(response == "P1 Shields: 0", "P1 Shields Assertion Failed");
       
        let shield2 = await driver.findElement(By.id('p2-shields'));
        let response2 = await shield2.getText();
        console.assert(response2 == "P2 Shields: 7", "P2 Shields Assertion Failed");

        let shield3 = await driver.findElement(By.id('p3-shields'));
        let response3 = await shield3.getText();
        console.assert(response3 == "P3 Shields: 0", "P3 Shields Assertion Failed");

        let shield4 = await driver.findElement(By.id('p4-shields'));
        let response4 = await shield4.getText();
        console.assert(response4 == "P4 Shields: 7", "P4 Shields Assertion Failed");

        let numRequest = await driver.findElement(By.id('p1-num'));
        let num1 = await numRequest.getText();
        console.assert(num1 == "P1 # Cards: 12", "P1 Shields Assertion Failed");

        let numRequest2 = await driver.findElement(By.id('p2-num'));
        let num2 = await numRequest2.getText();
        console.assert(num2 == "P2 # Cards: 9", "P2 Shields Assertion Failed");

        let numRequest3 = await driver.findElement(By.id('p3-num'));
        let num3 = await numRequest3.getText();
        console.assert(num3 == "P3 # Cards: 12", "P3 Shields Assertion Failed");

        let numRequest4 = await driver.findElement(By.id('p4-num'));
        let num4 = await numRequest4.getText();
        console.assert(num4 == "P4 # Cards: 9", "P4 Shields Assertion Failed");

    } catch (error) {
        console.error("Test encountered an error:", error);
    } finally {
        await driver.quit();
    }
}

runTest();
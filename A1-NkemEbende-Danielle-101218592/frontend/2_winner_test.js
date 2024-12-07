const { Builder, By, until, Key } = require('selenium-webdriver');

async function runTest() {
    let driver = await new Builder().forBrowser('chrome').build();
    try {
        await driver.get('http://127.0.0.1:8081');

        await driver.sleep(2000);

        // click Start 2 Winner Game Button
        let startButton = await driver.findElement(By.xpath("//button[contains(text(), 'Start 2 Winner Game')]"));
        await startButton.click();

        // check for notif status to be correct
        await driver.wait(until.elementTextContains(driver.findElement(By.id('game-status')), '2 Winner Game started. P1 draws an Event Card'), 10000);
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
        await inputBox.sendKeys("1"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("5"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("1"); 
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
        await inputBox.sendKeys("1"); 
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
        // end of stage building

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

        // agree to stage 1 of q4
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
        await inputBox.sendKeys("6"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

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
        // finished attack 1

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

        // agree to participate
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
        await inputBox.sendKeys("4"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Q"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);
        // built stage 2

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

        // agree to participate
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

        // participate in stage 4
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

        // attack 4
        await inputBox.clear();
        await inputBox.sendKeys("6"); 
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

        await inputBox.clear();
        await inputBox.sendKeys("6"); 
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

        // trimming sponsors hand
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

        // end of quest

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

        await playEventButton.click();
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("N"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        await inputBox.clear();
        await inputBox.sendKeys("Y"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        // stages q3
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
        await inputBox.sendKeys("1"); 
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
        await inputBox.sendKeys("1"); 
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

        // P1 declinse joining q3
        await inputBox.clear();
        await inputBox.sendKeys("N"); 
        await driver.sleep(1500);
        await inputBox.sendKeys(Key.RETURN); 
        await driver.sleep(2000);

        // others agree
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

        // attacks 1
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

        // attack 2
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

        // attack 3
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

        // sponsor trims
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

        await concludeButton.click();
        await driver.sleep(2000);


        // ASSERTS
        let request = await driver.findElement(By.id('p1-shields'));
        let response = await request.getText();
        console.assert(response == "P1 Shields: 0", "P1 Shields Assertion Failed");


        // console.assert(playCards.length &gt;= 2, "Player should have at least 2 cards after pitting.");

        // driver.findElement(By.id('p1-num')).getText().then(textValue => {
        //     assert.equal('P1 # Cards: 12', textValue);
        // });
        // driver.findElement(By.id('p2-num')).getText().then(textValue => {
        //     assert.equal('P2 # Cards: 9', textValue);
        // });
        // driver.findElement(By.id('p3-num')).getText().then(textValue => {
        //     assert.equal('P3 # Cards: 10', textValue);
        // });
        // driver.findElement(By.id('p4-num')).getText().then(textValue => {
        //     assert.equal('P4 # Cards: 11', textValue);
        // });

        // driver.findElement(By.id('game-status')).getText().then(textValue => {
        //     assert.equal('WINNER(S) of the game: P3', textValue);
        // });

        // driver.findElement(By.id('p1-shields')).getText().then(textValue => {
        //     assert.equal('P1 Shields: 0', textValue);
        // });
        // driver.findElement(By.id('p2-shields')).getText().then(textValue => {
        //     assert.equal('P2 Shields: 5', textValue);
        // });
        // driver.findElement(By.id('p3-shields')).getText().then(textValue => {
        //     assert.equal('P3 Shields: 7', textValue);
        // });
        // driver.findElement(By.id('p4-shields')).getText().then(textValue => {
        //     assert.equal('P4 Shields: 4', textValue);
        // });


    } catch (error) {
        console.error("Test encountered an error:", error);
    } finally {
        await driver.quit();
    }
}

runTest();
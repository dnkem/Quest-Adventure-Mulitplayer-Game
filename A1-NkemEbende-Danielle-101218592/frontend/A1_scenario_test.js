const { Builder, By, until } = require('selenium-webdriver');

async function runTest() {
    try {
        let driver = await new Builder().forBrowser('chrome').build();
        await driver.get('http://127.0.0.1:8081');

        // let startButton = await driver.findElement(By.xpath("//button[contains(text(), 'Start A1 Scenario Game')]"));
        // await startButton.click();

        // await driver.wait(until.elementTextContains(driver.findElement(By.id('game-status')), 'A1 Scenario Game started. P1 draws an Event Card'), 10000);
        // console.log("Game started successfully.");

        // let p1Hand = await driver.findElement(By.id('p1-hand')).getText();
        // // if (p1Hand.includes("F70")) {
        //     console.log("F70 is in P1's HAND!");
        // }
        
    } catch (error) {
        console.error("Test encountered an error:", error);
    } finally {
        await driver.quit();
    }
}

runTest();
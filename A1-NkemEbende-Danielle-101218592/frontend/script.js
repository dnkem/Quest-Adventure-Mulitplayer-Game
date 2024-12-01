const apiBaseUrl = "http://localhost:8080";

async function startRandomGame() {
    try {
        const response = await fetch(`${apiBaseUrl}/startRandomGame`);
        const result = await response.text();
        console.log("Start Random Game Response:", result);
        document.getElementById("game-status").innerText = result;
        updateHands();
    } catch (error) {
        console.error("Error in startRandomGame:", error);
    }
}

async function startA1ScenarioGame() {
    try {
        const response = await fetch(`${apiBaseUrl}/startA1ScenarioGame`);
        const result = await response.text();
        console.log("Start A1 Scenario Game Response:", result);
        document.getElementById("game-status").innerText = result;
        updateHands();

    } catch (error) {
        console.error("Error in A1ScenarioGame:", error);
    }
}

async function start2WinnerGame() {
    try {
        const response = await fetch(`${apiBaseUrl}/start2WinnerGame`);
        const result = await response.text();
        console.log("Start 2 Winner Game Response:", result);
        document.getElementById("game-status").innerText = result;
        updateHands();
    } catch (error) {
        console.error("Error in 2WinnerGame:", error);
    }
}
async function start1WinnerGame() {
    try {
        const response = await fetch(`${apiBaseUrl}/start1WinnerGame`);
        const result = await response.text();
        console.log("Start 1 Winner Game Response:", result);
        document.getElementById("game-status").innerText = result;
        updateHands();
    } catch (error) {
        console.error("Error in 1WinnerGame:", error);
    }
}

async function start0WinnerGame() {
    try {
        const response = await fetch(`${apiBaseUrl}/start0WinnerGame`);
        const result = await response.text();
        console.log("Start 0 Winner Game Response:", result);
        document.getElementById("game-status").innerText = result;
        updateHands();
    } catch (error) {
        console.error("Error in 0WinnerGame:", error);
    }
}

async function updateHands() {
    try {
        const response = await fetch(`${apiBaseUrl}/printP1Hand`);
        const p1Hand = await response.text();
        document.getElementById("p1-hand").innerText = p1Hand;

        const response2 = await fetch(`${apiBaseUrl}/printP2Hand`);
        const p2Hand = await response2.text();
        console.log("Update Hands of Players", p2Hand);
        document.getElementById("p2-hand").innerText = p2Hand;

        const response3 = await fetch(`${apiBaseUrl}/printP3Hand`);
        const p3Hand = await response3.text();
        console.log("Update Hands of Players", p3Hand);
        document.getElementById("p3-hand").innerText = p3Hand;

        const response4 = await fetch(`${apiBaseUrl}/printP4Hand`);
        const p4Hand = await response4.text();
        console.log("Update Hands of Players", p4Hand);
        document.getElementById("p4-hand").innerText = p4Hand;

        console.log("Update Hands of Players (", p1Hand, " ", p2Hand, " ", p3Hand, " ", p4Hand, ")");

        
    } catch (error) {
        console.error("Error in Updating Hands:", error);
    }
}
const apiBaseUrl = "http://localhost:8080";

async function startRandomGame() {
    try {
        switchVisibilityOff("input-container")
        const response = await fetch(`${apiBaseUrl}/startRandomGame`);
        const result = await response.text();
        console.log("Start Random Game Response:", result);
        document.getElementById("game-status").innerText = result;
        updateHands();
        updateShields();
        switchVisibilityOn("playEvent");
    } catch (error) {
        console.error("Error in startRandomGame:", error);
    }
}

async function startA1ScenarioGame() {
    try {
        switchVisibilityOff("input-container")
        const response = await fetch(`${apiBaseUrl}/startA1ScenarioGame`);
        const result = await response.text();
        console.log("Start A1 Scenario Game Response:", result);
        document.getElementById("game-status").innerText = result;
        updateHands();
        updateShields();
        switchVisibilityOn("playEvent");
    } catch (error) {
        console.error("Error in A1ScenarioGame:", error);
    }
}

async function start2WinnerGame() {
    try {
        switchVisibilityOff("input-container")
        const response = await fetch(`${apiBaseUrl}/start2WinnerGame`);
        const result = await response.text();
        console.log("Start 2 Winner Game Response:", result);
        document.getElementById("game-status").innerText = result;
        updateHands();
        updateShields();
        switchVisibilityOn("playEvent");
    } catch (error) {
        console.error("Error in 2WinnerGame:", error);
    }
}
async function start1WinnerGame() {
    try {
        switchVisibilityOff("input-container")
        const response = await fetch(`${apiBaseUrl}/start1WinnerGame`);
        const result = await response.text();
        console.log("Start 1 Winner Game Response:", result);
        document.getElementById("game-status").innerText = result;
        updateHands();
        updateShields();
        switchVisibilityOn("playEvent");
    } catch (error) {
        console.error("Error in 1WinnerGame:", error);
    }
}

async function start0WinnerGame() {
    try {
        switchVisibilityOff("input-container")
        const response = await fetch(`${apiBaseUrl}/start0WinnerGame`);
        const result = await response.text();
        console.log("Start 0 Winner Game Response:", result);
        document.getElementById("game-status").innerText = result;
        updateHands();
        updateShields();
        switchVisibilityOn("playEvent");
    } catch (error) {
        console.error("Error in 0WinnerGame:", error);
    }
}

async function updateHands() {
    try {
        const response = await fetch(`${apiBaseUrl}/printP1Hand`);
        const p1Hand = await response.text();
        document.getElementById("p1-hand").innerText = p1Hand;
        console.log(p1Hand);

        const response2 = await fetch(`${apiBaseUrl}/printP2Hand`);
        const p2Hand = await response2.text();
        document.getElementById("p2-hand").innerText = p2Hand;

        const response3 = await fetch(`${apiBaseUrl}/printP3Hand`);
        const p3Hand = await response3.text();
        document.getElementById("p3-hand").innerText = p3Hand;

        const response4 = await fetch(`${apiBaseUrl}/printP4Hand`);
        const p4Hand = await response4.text();
        document.getElementById("p4-hand").innerText = p4Hand;

        console.log("Update Hands of Players");
    } catch (error) {
        console.error("Error in Updating Hands:", error);
    }
}

async function updateShields() {
    try {
        const response = await fetch(`${apiBaseUrl}/getP1Shields`);
        const p1Shields = await response.text();
        document.getElementById("p1-shields").innerText = p1Shields;

        const response2 = await fetch(`${apiBaseUrl}/getP2Shields`);
        const p2Shields = await response2.text();
        document.getElementById("p2-shields").innerText = p2Shields;

        const response3 = await fetch(`${apiBaseUrl}/getP3Shields`);
        const p3Shields = await response3.text();
        document.getElementById("p3-shields").innerText = p3Shields;

        const response4 = await fetch(`${apiBaseUrl}/getP4Shields`);
        const p4Shields = await response4.text();
        document.getElementById("p4-shields").innerText = p4Shields;

        console.log("Update Shields of Players (", p1Shields, p2Shields, p3Shields, p4Shields, ")");
    } catch (error) {
        console.error("Error in Updating Shields:", error);
    }
}

async function playEventCard() {
    try {
        const response = await fetch(`${apiBaseUrl}/playEventCard`, { method: "POST" });
        const result = await response.text();
        document.getElementById("game-status").innerText = result;

        if (result.includes("drew 2")){
            updateHands();
            // click next player
        } else if (result.includes("loses 2")){
            updateShields();
            // click next player
        } else {
            // make the prompt sponsor buttons appear
            switchVisibilityOn("input-container");
            console.log("sponsor prompt");
        }
        switchVisibilityOff("playEvent");
        console.log("Event Card was played");
    } catch (error) {
        console.error("Error in Playing Event Card:", error);
    }
}

// async function sleep(seconds){
//     return new Promise((resolve)=>setTimeout(resolve, seconds * 1000));
// }

async function switchVisibilityOff(id){
    // make play event button visible
    var btn = document.getElementById(id);
    btn.style.display = 'none';
}

async function switchVisibilityOn(id){
    // make play event button not visible
    var btn = document.getElementById(id);
    btn.style.display = 'block';
}

// handles the submission of the prompt
document.getElementById('input-container').addEventListener('submit', async function(e) {
    e.preventDefault(); // Prevent the default form submission

    // for input box
    const inputBox = document.getElementById('input-box');
    const response = inputBox.value;
    // for game status question
    const question = document.getElementById("game-status").innerText;

    // Send the response using fetch
    const res = await fetch(`${apiBaseUrl}/prompt`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded' // sets the content type for form-encoded data
        },
        body: new URLSearchParams({ response, question }) // encode your data
    });

    const responseText = await res.text();
    console.log(responseText); // logs the response from the server
    inputBox.value = '';
    handleInput(response, question);
    updateHands();
});

async function handleInput(response, question){
    console.log("IN HANDLER");
    if (response.includes("N") && question.includes("Sponsor")){
        const item = await fetch(`${apiBaseUrl}/setSponsorGameStatus`);
        const result = await item.text();
        console.log("Update game-status: " + result);
        document.getElementById("game-status").innerText = result;
    } 
    else if (response.includes("Y") && question.includes("Sponsor")) {
        document.getElementById("input-box").placeholder = "No.";
        const item = await fetch(`${apiBaseUrl}/setStageGameStatus`);
        const result = await item.text();
        console.log("Update sponsor game-status: " + result);
        document.getElementById("game-status").innerText = result;
    } 
    else if ((question.includes("Join") && (response.includes("Y") || response.includes("N"))) || (question.includes("Join") && response.includes("*"))){
        console.log("QUESTION " + question);
        document.getElementById("input-box").placeholder = "Y/N";
        const item = await fetch(`${apiBaseUrl}/setJoinGameStatus`);
        const result = await item.text();
        console.log("Update concluded build game-status: " + result);
        document.getElementById("game-status").innerText = result;
    } 
    else if (isNaN(response) && question.includes("Stage")){
        // document.getElementById("input-box").placeholder = "";
        const item = await fetch(`${apiBaseUrl}/setStageGameStatus`);
        const result = await item.text();
        console.log("Update stage game-status: " + result);
        document.getElementById("game-status").innerText = result;
    } 

}
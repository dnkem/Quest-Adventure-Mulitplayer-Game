const apiBaseUrl = "http://localhost:8080";

async function startRandomGame() {
    try {
        switchVisibilityOff("input-container");
        switchVisibilityOff("concludeQuest");
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
        switchVisibilityOff("input-container");
        switchVisibilityOff("concludeQuest");
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
        switchVisibilityOff("input-container");        switchVisibilityOff("concludeQuest");
        switchVisibilityOff("concludeQuest");
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
        switchVisibilityOff("input-container");
        switchVisibilityOff("concludeQuest");
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
        switchVisibilityOff("input-container");
        switchVisibilityOff("concludeQuest");
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
        // console.log(p1Hand);

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
            switchVisibilityOn("concludeQuest");
        } else if (result.includes("loses 2")){
            updateShields();
            switchVisibilityOn("concludeQuest");
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

async function concludeQuest() {
    switchVisibilityOff("concludeQuest");
    const response = await fetch(`${apiBaseUrl}/concludeQuest`, { method: "POST" });
    const result = await response.text();
    document.getElementById("game-status").innerText = result;
    updateShields();
}

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
    // console.log("IN HANDLER");
    if (response.includes("N") && question.includes("Sponsor")){
        setSponsorGameStatus(response, question);
    } 
    else if (response.includes("Y") && question.includes("Sponsor")) {
        setStageGameStatus(response, question)
    } 
    else if ((question.includes("Join") && (response.includes("Y") || response.includes("N"))) || (question.includes("Join") && response.includes("*"))){
        setJoinGameStatus(response, question)
    }  
    else if (question.includes("All Eligible Players Responded to the Prompt") && response.includes("*")){
        eligiblePlayersDrawAdv(response, question)
    } else if ((question.includes("Eligible Players drew an Adventure Card") && response.includes("*")) || question.includes("trimming their hand,")){
        trimHand(response, question);
    } else if ((question.includes("No Hands to trim") && response.includes("*")) || question.includes("Build your Attack for")){
        setBuildGameStatus(response, question);
    } else if ((question.includes("All Eligible Players Built an Attack") && response.includes("*"))){
        attackStage(response, question)
    } else if (isNaN(response) && question.includes("Stage")){
        setStageGameStatus(response, question)
    } else if (question.includes("This Quest is Over") || question.includes("Queen's Favour Event") || question.includes("Prosperity Event") || question.includes("Plague Event") && response.includes("*")){
        switchVisibilityOn("concludeQuest");
    } else if (question.includes("No Winners") && response.includes("*")){
        nextTurn()
        switchVisibilityOn("playEvent");
    } 

}

async function setSponsorGameStatus(response, question) {
    const item = await fetch(`${apiBaseUrl}/setSponsorGameStatus`);
    const result = await item.text();
    console.log("Update game-status: " + result);
    document.getElementById("game-status").innerText = result;
}

async function setStageGameStatus(response, question) {
    document.getElementById("input-box").placeholder = "No.";
    const item = await fetch(`${apiBaseUrl}/setStageGameStatus`);
    const result = await item.text();
    console.log("Update sponsor game-status: " + result);
    document.getElementById("game-status").innerText = result;
}

async function setJoinGameStatus(response, question) {
    console.log("QUESTION " + question);
    document.getElementById("input-box").placeholder = "Y/N";
    const item = await fetch(`${apiBaseUrl}/setJoinGameStatus`);
    const result = await item.text();
    console.log("Update concluded build game-status: " + result);
    document.getElementById("game-status").innerText = result;
}
async function setStageGameStatus(response, question) {
    // document.getElementById("input-box").placeholder = "";
    const item = await fetch(`${apiBaseUrl}/setStageGameStatus`);
    const result = await item.text();
    console.log("Update stage game-status: " + result);
    document.getElementById("game-status").innerText = result;   
}

async function eligiblePlayersDrawAdv(response, question) {
    const item = await fetch(`${apiBaseUrl}/eligiblePlayersDrawAdv`);
    const result = await item.text();
    document.getElementById("game-status").innerText = result;
}

async function trimHand(response, question) {
    const item = await fetch(`${apiBaseUrl}/trimHand`);
    const result = await item.text();
    document.getElementById("game-status").innerText = result;
    console.log("Update trimming game-status: " + result);
}

async function setBuildGameStatus(response, question) {
    const item = await fetch(`${apiBaseUrl}/setBuildGameStatus`);
    const result = await item.text();
    document.getElementById("game-status").innerText = result;
    console.log("Update BUILD attack game-status: " + result);
}

async function attackStage(response, question) {
    const item = await fetch(`${apiBaseUrl}/attackStage`);
    const result = await item.text();
    document.getElementById("game-status").innerText = result;
    console.log("Update attack STAGE game-status: " + result);
    if (result.includes("Conclude Quest and Next Players Turn")){
        switchVisibilityOn("concludeQuest");
    }
}

async function nextTurn() {
    const item = await fetch(`${apiBaseUrl}/nextTurn`);
    const result = await item.text();
    document.getElementById("game-status").innerText = result;
    console.log("Update NEXT game-status: " + result);

}

// export { startRandomGame };
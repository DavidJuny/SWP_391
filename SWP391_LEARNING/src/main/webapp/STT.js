runSpeechRecog = (questionID) => {
    const output = document.getElementById(`output-${questionID}`);
    const action = document.getElementById(`action-${questionID}`);
    const transcriptInput = document.getElementById(`transcriptInput-${questionID}`);
    const speechForm = document.getElementById(`speechForm-${questionID}`);

    output.innerHTML = "Loading text...";

    const recognition = new webkitSpeechRecognition();

    recognition.onstart = () => {
        action.innerHTML = "Listening...";
    }

    recognition.onresult = (e) => {
        const transcript = e.results[0][0].transcript;
        output.innerHTML = transcript;
        output.classList.remove("hide");
        action.innerHTML = "";
        transcriptInput.value = transcript;
        speechForm.submit();
    }

    recognition.start();
}

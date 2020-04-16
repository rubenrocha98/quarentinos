var myAudio = document.getElementById("music");

function togglePlay()
{
    return myAudio.paused ? myAudio.play() : myAudio.pause();
};
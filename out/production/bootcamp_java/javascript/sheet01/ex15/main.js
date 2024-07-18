var counter;

document.getElementById('startBtn').addEventListener('click', () => {
    counter = setInterval(startTime, 1);
});

document.getElementById('stopBtn').addEventListener('click', () => {
    clearInterval(counter);
});

document.getElementById('resetBtn').addEventListener('click', () => {
    document.getElementById('resultDiv').innerText = '00:00:00';
});

function startTime() {
    let count = document.getElementById('resultDiv').innerText;
    count = checkTime(count);
    document.getElementById('resultDiv').innerText = count;
}

function checkTime(count) {
    let arr = count.split(':');
    let seconds = parseInt(arr[2]);
    let minutes = parseInt(arr[1]);
    let hours = parseInt(arr[0]);

    seconds ++;

    if (seconds == 60) {
        minutes ++;
        seconds = 0;
    }

    if (minutes == 60) {
        hours ++;
        minutes = 0;
    }
    
    if (seconds < 10) { 
        seconds = '0' + seconds;
    };

    if (minutes < 10) {
        minutes = '0' + minutes;
    }

    if (hours < 10) {
        hours = '0' + hours;
    }    

    return hours + ':' + minutes + ':' + seconds ;
}
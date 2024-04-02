const endDate = "25 Dec 2024 08:20:00 PM"

document.getElementById("end-date").innerText = endDate;
const inputs = document.querySelectorAll("input")
const monthsInput = document.querySelector('#months');
monthsInput.value =8;
    // const clock = () => {

// }

function clock() {
    const end = new Date(endDate)
    const now = new Date()
    const diff = (end - now) / 1000;

    if (diff < 0) return;

    // convert into days;
    inputs[0].value = Math.floor(diff / 3600/24/ 30);
    inputs[1].value = Math.floor(diff / 3600/ 24) % 30;
    inputs[2].value = Math.floor(diff /3600) % 24;
    inputs[3].value = Math.floor(diff/ 60) % 60;
    inputs[4].value = Math.floor(diff)% 60;
}

// initial call
clock()

/**
 *  1 day = 24 hrs
 *  1 hr = 60 mins
 *  60 min = 3600 sec
 */

setInterval(
    () => {
        clock()
    },
    1000
)
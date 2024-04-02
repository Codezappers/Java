function rollDice(){
    var die1 = document.getElementById("die1");
    var die2 = document.getElementById("die2");
    var die3 = document.getElementById("die3");
    var status = document.getElementById("status");
    var d1 = Math.floor(Math.random() * 6) + 1;
    var d2 = Math.floor(Math.random() * 6) + 1;
    var d3 = Math.floor(Math.random() * 6) + 1;
    var diceTotal = d1 + d2 + d3;
    die1.innerHTML = d1;
    die2.innerHTML = d2;
    die3.innerHTML = d3;
    status.innerHTML = "You rolled "+diceTotal+".";
    if(d1 == d3 && d1 == d3){
        status.innerHTML += "Triples! You get a free turn!!";
    }
}
function addRanking() {
    const req = new XMLHttpRequest();
    const sport = document.getElementById('sport').value;
    const rank = document.getElementById('rank').value;

    const params = new URLSearchParams({
        sport: sport,
        rank: rank,
    });

    req.open('POST', '/athlete/addinfo?' + params.toString());
    req.setRequestHeader("Content-Type", "application/json");
    req.send(params.toString());

    location.href='/main/athlete';
}

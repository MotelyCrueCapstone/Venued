"use strict";

fetch("http://localhost:8083/event/food?latitude=29.424122&longitude=-98.493629", {method: "GET"})
     .then(response => response.json())
     .then(json =>  console.log(json))


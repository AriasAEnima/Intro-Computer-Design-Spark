/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


 function calcular(){   
    
      var inputVal = document.getElementById('datos').value;        
        fetch("/calcule", {
            method: 'POST',
            body: inputVal
        })
                .then(function (response) {
                    return response.json();
                })
                .then(function (myJson) {
                    document.querySelector("#resultado").innerHTML ="Mean: "+ myJson.mean+" ; Deviation:   "+myJson.deviation;
                })
                .catch(function (error) {
                    console.log("Error: " + error);
                });
 }
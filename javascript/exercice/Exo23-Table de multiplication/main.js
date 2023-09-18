const table = document.querySelector(".container")
const row = document.querySelector(".row")
for (let i = 1; i < 11; i++) {
    table.innerHTML+= `<br> Table de : ${i} <br>`
   for (let j = 1; j < 11; j++) {
    table.innerHTML += `
        <li>
            ${i}x${j}= ${i*j} <br>
        </li>
    `
        
   }
    
}
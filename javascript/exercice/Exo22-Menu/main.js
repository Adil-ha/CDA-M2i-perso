let chapitre = document.querySelector(".chapitre")

for (let i = 1; i < 4; i++) {
    chapitre.innerHTML+=`
        <li>
            Chapitre ${i}
        </li>
    `

    for (let j = 1; j < 4; j++) {
        chapitre.innerHTML+=
        `
            
                
                <ul>
                    <li>Partie${i}.${j}</li>
                </ul>
            
    
    `
    console.log(i);
    }
    
}
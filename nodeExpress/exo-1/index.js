import fs from "fs";
import path from "path";

let names = ["support", "demos", "exercices", "corrections"];

let string = names.join("\n");

fs.appendFile("./fichier.txt", string, (err) => {
  if (err) {
    console.error(err);
    return;
  }
  console.log("Données ajoutées avec succès !");
});

fs.readFile("./fichier.txt", "utf8", (err, data) => {
  if (err) {
    console.error(`Erreur lors de la lecture du fichier : ${err}`);
    return;
  }

  const lines = data.split("\n");

  lines.forEach((line) => {
    const directoryName = line.trim();
    if (directoryName) {
      const directoryPath = path.join("./", directoryName);

      if (!fs.existsSync(directoryPath)) {
        fs.mkdirSync(directoryPath);
        console.log(`Répertoire créé : ${directoryName}`);
      } else {
        console.log(`Répertoire existant : ${directoryName}`);
      }
    }
  });
});

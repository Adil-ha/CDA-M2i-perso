import { useEffect } from "react";
import "./App.css";
import axios from "axios";

function App() {
  useEffect(() => {
    axios
      .get("http://localhost:5000/personnes")
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.log("Error :" + error);
      });
  }, []);

  const addPerson = () => {
    axios
      .post("http://localhost:5000/personnes", {
        nom: "truck",
        prenom: "machin",
      })
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const deletePerson = (e) => {
    const id = 7;
    axios
      .delete(`http://localhost:5000/personnes/${id}`)
      .then((response) => {
        console.log(
          "la personne dont l'id est " +
            id +
            "a etait supprimer" +
            response.data
        );
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const updatePerson = () => {
    const id = 6;
    axios
      .put(`http://localhost:5000/personnes/${id}`, {
        nom: "Delacroix",
        prenom: "pauline",
      })
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.error("Erreur : ", error);
      });
  };

  return (
    <div className="App">
      <button onClick={addPerson}>Add person</button>
      <button onClick={deletePerson}>Delete person</button>
      <button onClick={updatePerson}>Modification</button>
    </div>
  );
}

export default App;

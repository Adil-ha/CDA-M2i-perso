// import { useContext } from "react";
// import { UseContext } from "../context/UseContext";

// const Form = () => {
//   const [name, setName] = useContext(UseContext);
//   const [race, setRace] = useContext(UseContext);
//   const [age, setAge] = useContext(UseContext);
//   const [picture, setPicture] = useContext(UseContext);

//   return (
//     <form action="#" className="form-group row">
//       <div class="form-group">
//         <label for="name" class="form-label mt-4">
//           Nom
//         </label>
//         <input
//           type="text"
//           name={name}
//           onInput={(e) => setName(e.target.value)}
//           class="form-control"
//           id="name"
//         />
//       </div>
//       <div class="form-group">
//         <label for="race" class="form-label mt-4">
//           Race
//         </label>
//         <input
//           type="text"
//           race={race}
//           onInput={(e) => setRace(e.target.value)}
//           class="form-control"
//           id="race"
//         />
//       </div>
//       <div class="form-group">
//         <label for="name" class="form-label mt-4">
//           Age
//         </label>
//         <input
//           type="number"
//           age={age}
//           onInput={(e) => setAge(e.target.value)}
//           class="form-control"
//           id="Age"
//         />
//       </div>
//       <div class="form-group">
//         <label for="picture" class="form-label mt-4">
//           image
//         </label>
//         <input
//           type="number"
//           picture={picture}
//           onInput={(e) => setPicture(e.target.value)}
//           class="form-control"
//           id="picture"
//         />
//       </div>
//       <button type="button" class="btn btn-primary mt-4 w-50 m-auto">
//         Valider
//       </button>
//     </form>
//   );
// };
// export default Form;

import React, { useState } from "react";
import { useEntities } from "../context/UseContext";

const Form = () => {
  const { addEntity } = useEntities();
  const [name, setName] = useState("");
  const [race, setRace] = useState("");
  const [age, setAge] = useState("");
  const [picture, setPicture] = useState("");
  const [isFormValid, setIsFormValid] = useState(true);

  const handleSubmit = () => {
    if (name && race && age && picture) {
      addEntity({ name, race, age, picture });
      setName("");
      setRace("");
      setAge("");
      setPicture("");
      setIsFormValid(true);
    } else {
      setIsFormValid(false);
    }
  };

  return (
    <form action="#" className="form-group row">
      <div className="form-group">
        <label htmlFor="name" className="form-label mt-4">
          Nom
        </label>
        <input
          type="text"
          value={name}
          onChange={(e) => setName(e.target.value)}
          className={`form-control ${isFormValid ? "" : "is-invalid"}`}
          id="name"
        />
      </div>
      <div className="form-group">
        <label htmlFor="race" className="form-label mt-4">
          Race
        </label>
        <input
          type="text"
          value={race}
          onChange={(e) => setRace(e.target.value)}
          className={`form-control ${isFormValid ? "" : "is-invalid"}`}
          id="race"
        />
      </div>
      <div className="form-group">
        <label htmlFor="age" className="form-label mt-4">
          Age
        </label>
        <input
          type="number"
          value={age}
          onChange={(e) => setAge(e.target.value)}
          className={`form-control ${isFormValid ? "" : "is-invalid"}`}
          id="age"
        />
      </div>
      <div className="form-group">
        <label htmlFor="picture" className="form-label mt-4">
          Image
        </label>
        <input
          type="text"
          value={picture}
          onChange={(e) => setPicture(e.target.value)}
          className={`form-control ${isFormValid ? "" : "is-invalid"}`}
          id="picture"
        />
      </div>
      <button
        type="button"
        className="btn btn-primary mt-4 w-50 m-auto"
        onClick={handleSubmit}
      >
        Valider
      </button>
      {!isFormValid && (
        <div className="invalid-feedback">
          Veuillez remplir tous les champs.
        </div>
      )}
    </form>
  );
};

export default Form;

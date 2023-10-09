// import Button from "./Button";

// const Card = () => {
//   return (
//     <div className="card text-white bg-dark mb-3 w-50 p-2">
//       <div className="card-header">Header</div>
//       <div className="card-body">
//         <h4 className="card-title">Dark card title</h4>
//         <p className="card-text">
//           Some quick example text to build on the card title and make up the
//           bulk of the card's content.
//         </p>
//       </div>
//       <Button />
//     </div>
//   );
// };

// export default Card;

import React from "react";
import { useEntities } from "../context/UseContext";

const Card = () => {
  const { entities } = useEntities();

  const handleDetailsClick = (entity) => {
    console.log(entity);
  };

  return (
    <div>
      {entities.map((entity, index) => (
        <div key={index} className="card text-white bg-dark mb-3 w-50 p-2">
          <div className="card-header">{entity.name}</div>
          <div className="card-body">
            <h4 className="card-title">{entity.race}</h4>
            <p className="card-text">Age: {entity.age}</p>
            <img src={entity.picture} alt="Entity" />
            <button
              onClick={() => handleDetailsClick(entity)}
              className="btn btn-primary w-25"
            >
              Détails
            </button>
          </div>
        </div>
      ))}
    </div>
  );
};

export default Card;

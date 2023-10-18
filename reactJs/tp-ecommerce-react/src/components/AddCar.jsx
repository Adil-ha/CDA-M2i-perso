import { useNavigate } from "react-router-dom";
import { useRef, useState } from "react";
import Car from "../models/Car";
import axios from "axios";

const AddCar = () => {
  const navigate = useNavigate();

  const titleRef = useRef();
  const descriptionRef = useRef();
  const priceRef = useRef();

  const [errorMessage, setErrorMessage] = useState("");

  const handleFormSubmit = (e) => {
    e.preventDefault();

    const title = titleRef.current.value;
    const description = descriptionRef.current.value;
    const price = priceRef.current.value;

    if (!title || !description || !price) {
      setErrorMessage("Tous les champs sont obligatoires");
      return;
    }

    const newCar = new Car(title, description, +price);

    axios
      .post("http://localhost:5000/cars", newCar)
      .then((response) => {
        console.log(response.data);
        navigate("/");
      })
      .catch((error) => {
        console.error("Erreur : ", error);
      });
  };

 
  const handleLogout = () => {
    
    localStorage.removeItem("username");
    localStorage.removeItem("password");
    
    navigate("/");
  };

  return (
    <>
      <div className="d-flex justify-content-end">
        <button onClick={handleLogout} className="btn btn-danger">
          Se déconnecter
        </button>
      </div>

      <h1>Ajouter une voiture</h1>
      <hr />
      <form onSubmit={handleFormSubmit}>
        <div className="mb-3">
          <label htmlFor="title" className="form-label">
            Marque
          </label>
          <input
            type="text"
            className="form-control"
            id="title"
            ref={titleRef}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="description" className="form-label">
            Description
          </label>
          <input
            type="text"
            className="form-control"
            id="description"
            ref={descriptionRef}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="price" className="form-label">
            Prix
          </label>
          <input
            type="text"
            className="form-control"
            id="price"
            ref={priceRef}
          />
        </div>

        {errorMessage && <p className="text-danger">{errorMessage}</p>}

        <button type="submit" className="btn btn-primary">
          Submit
        </button>
      </form>
    </>
  );
};

export default AddCar;

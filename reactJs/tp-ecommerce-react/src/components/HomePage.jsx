import { useEffect, useContext } from "react";
import axios from "axios";
import CarsContext from "../contexts/CarsContext";
import { useNavigate } from "react-router-dom";

const HomePage = () => {
  const { cars, setCars } = useContext(CarsContext);
  const navigate = useNavigate();

  useEffect(() => {
    axios
      .get("http://localhost:5000/cars")
      .then((response) => {
        
        setCars((prev) => [...response.data]);
      })
      .catch((error) => {
        console.error("Erreur : ", error);
      });
  }, []);

  const viewDetails = (id) => {
    navigate(`/DescriptionCar/${id}`);
  };

  return (
    <>
    <h1>Nos voitures</h1>
    <hr />
      {cars.length === 0 ? (
        <p>Aucun véhicule disponible pour le moment.</p>
      ) : (
        cars.map((car, index) => (
       
            <div className="card w-75 m-auto my-3" key={index}>
              <img src="..." className="card-img-top" alt="..." />
              <div className="card-body">
                <h5 className="card-title">{car.title}</h5>
                <a onClick={() => viewDetails(car.id)} className="btn btn-primary">
                  Voir les détails
                </a>
              </div>
            </div>
        
        ))
      )}
    </>
  );
};

export default HomePage;

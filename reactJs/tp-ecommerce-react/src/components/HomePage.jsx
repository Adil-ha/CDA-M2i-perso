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
        console.log(response.data);
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
      {cars.map((car) => (
        <div className="card" key={car.id}>
          <img src="..." className="card-img-top" alt="..." />
          <div className="card-body">
            <h5 className="card-title">{car.title}</h5>

            <a onClick={() => viewDetails(car.id)} className="btn btn-primary">
              Voir details
            </a>
          </div>
        </div>
      ))}
    </>
  );
};
export default HomePage;

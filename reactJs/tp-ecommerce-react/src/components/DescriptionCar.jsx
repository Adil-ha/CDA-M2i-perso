import CarsContext from "../contexts/CarsContext";
import { useContext } from "react";
import { useParams } from "react-router-dom";
import { useNavigate } from "react-router-dom";

const DescriptionCar = () => {
  const { cars } = useContext(CarsContext);
  const { id } = useParams();
  const navigate = useNavigate();

  const car = cars.find((car) => car.id === +id);

  if (!car) {
    return <div>Voiture non trouvée</div>;
  }

  const addCart = (id) => {
    navigate(`/cart?id=${id}`);
  };
  return (
    <>
      <div className="card">
        <img src={car.picture} className="card-img-top" alt={car.title} />
        <div className="card-body">
          <h5 className="card-title">{car.title}</h5>
          <p className="card-text">{car.description}</p>
          <h5 className="card-title">Prix: {car.price} €</h5>
          <a onClick={() => addCart(car.id)} className="btn btn-primary">
            Ajouter au panier
          </a>
        </div>
      </div>
    </>
  );
};

export default DescriptionCar;

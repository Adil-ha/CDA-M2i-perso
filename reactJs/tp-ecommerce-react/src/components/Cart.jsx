import { useContext, useState } from "react";
import { useNavigate, useSearchParams } from "react-router-dom";
import CarsContext from "../contexts/CarsContext";
import CartContext from "../contexts/CartContext";

const Cart = () => {
  const { cars } = useContext(CarsContext);
  const [params] = useSearchParams();
  const id = params.get("id");
  const navigate = useNavigate();

  // Créez un état pour le panier, initialisez-le avec un tableau vide.
  const [cart, setCart] = useContext(CartContext);

  // Fonction pour ajouter une voiture au panier
  const addToCart = (id) => {
    // Recherchez la voiture correspondante dans la liste des voitures
    const carToAdd = cars.find((car) => car.id === +id);

    // Vérifiez si la voiture n'a pas déjà été ajoutée au panier
    if (!cart.some((item) => item.id === carToAdd.id)) {
      // Ajoutez la voiture au panier
      setCart([...cart, carToAdd]);
    }
  };

  if (id) {
    // Si un ID de voiture est présent dans les paramètres d'URL, ajoutez-la au panier
    addToCart(id);
    navigate("/cart"); // Redirige vers la page du panier après ajout
  }

  return (
    <>
      <h1>Mon panier</h1>
      {cart.length === 0 ? (
        <p>Le panier est vide</p>
      ) : (
        <div>
          <h2>Votre panier</h2>
          <ul>
            {cart.map((car) => (
              <li key={car.id}>
                <strong>{car.title}</strong> - {car.price} €
              </li>
            ))}
          </ul>
        </div>
      )}
    </>
  );
};

export default Cart;

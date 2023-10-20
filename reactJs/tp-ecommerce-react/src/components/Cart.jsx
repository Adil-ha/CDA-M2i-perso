import React, { useContext, useEffect, useRef } from "react";
import { useNavigate, useSearchParams } from "react-router-dom";
import CarsContext from "../contexts/CarsContext";
import CartContext from "../contexts/CartContext";
import "bootstrap/dist/css/bootstrap.min.css";

const Cart = () => {
  const { cars } = useContext(CarsContext);
  const [params] = useSearchParams();
  const id = params.get("id");
  const navigate = useNavigate();

  const { cart, setCart } = useContext(CartContext);

  const quantityRef = useRef();

  const addToCart = (id) => {
    const carToAdd = cars.find((car) => car.id === +id);

    const existingCartItem = cart.find((item) => item.id === carToAdd.id);

    if (existingCartItem) {
      existingCartItem.quantity += 1;
    } else {
      carToAdd.quantity = 1;
      setCart([...cart, carToAdd]);
    }
    
    saveCartToLocalStorage([...cart, carToAdd]);
  };

  const removeCarFromCart = (id) => {
    const updatedCart = cart.filter((car) => car.id !== id);
    setCart(updatedCart);
    saveCartToLocalStorage(updatedCart);
  };

  const calculateTotalPrice = () => {
    let totalPrice = 0;
    cart.forEach((car) => {
      totalPrice += car.price * car.quantity;
    });
    return totalPrice;
  };

  const saveCartToLocalStorage = (cart) => {
    localStorage.setItem("cart", JSON.stringify(cart));
  };

  useEffect(() => {
    const savedCart = JSON.parse(localStorage.getItem("cart"));
    if (savedCart) {
      setCart(savedCart);
    }
  }, [setCart]);

  useEffect(() => {
    if (id) {
      addToCart(id);
      navigate("/cart");
    }
  }, [id, navigate]);

  return (
    <>
      <h1>Mon panier</h1>
      <hr />
      {cart.length === 0 ? (
        <p>Le panier est vide</p>
      ) : (
        <div>
          <ul>
            {cart.map((car) => (
              <li
                key={car.id}
                className="d-flex justify-content-between my-2" 
              >
                <strong>{car.title}</strong> - {car.price} € x {car.quantity}
                <button className="btn btn-danger" onClick={() => removeCarFromCart(car.id)}>Supprimer</button>
              </li>
            ))}
          </ul>
          <p>Prix total du panier : {calculateTotalPrice()} €</p>
        </div>
      )}
    </>
  );
};

export default Cart;

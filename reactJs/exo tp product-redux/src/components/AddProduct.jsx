import { useDispatch } from "react-redux";
import { addProduct } from "./ProductSlice";
import { useRef } from "react";

const AddProduct = () => {
  const nameProductRef = useRef();
  const priceProductRef = useRef();
  const dispatch = useDispatch();

  const handleSubmit = (event) => {
    event.preventDefault();

    const productName = nameProductRef.current.value;
    const productPrice = priceProductRef.current.value;

    if (productName.trim() !== "" && productPrice.trim() !== "") {
      dispatch(
        addProduct({
          text: productName,
          price: productPrice,
        })
      );

      nameProductRef.current.value = "";
      priceProductRef.current.value = "";
    } else {
      // Gérez l'erreur ou affichez un message à l'utilisateur
      alert("Les champs ne peuvent pas être vides.");
    }
  };

  return (
    <>
      <form onSubmit={handleSubmit} className="text-center">
        <h2 className="text-center">Ajouter un produit</h2>
        <div className="form-group">
          <label htmlFor="nameProduct" className="form-label mt-4">
            Nom du produit
          </label>
          <input
            ref={nameProductRef}
            type="text"
            className="form-control"
            id="nameProduct"
          />
        </div>
        <div className="form-group">
          <label htmlFor="priceProduct" className="form-label mt-4">
            Prix du produit
          </label>
          <input
            ref={priceProductRef}
            type="number"
            className="form-control"
            id="priceProduct"
          />
        </div>
        <button type="submit" className="btn btn-success mt-3 w-100">
          Submit
        </button>
      </form>
    </>
  );
};

export default AddProduct;

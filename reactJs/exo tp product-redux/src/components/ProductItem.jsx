import { useDispatch } from "react-redux";
import { editProduct, deleteProduct } from "./ProductSlice";
import { useState } from "react";

const ProductItem = (props) => {
  const product = props.product;
  const dispatch = useDispatch();
  const [update, setUpdate] = useState(false);
  const [newText, setNewText] = useState(product.text);
  const [newPrice, setNewPrice] = useState(product.price);

  const handleUpdateClick = () => {
    setUpdate(true);
  };

  const handleSaveClick = () => {
    if (newText.trim() !== "" && newPrice.trim() !== "") {
      dispatch(editProduct({ id: product.id, newText, newPrice }));
      setUpdate(false);
    } else {
      alert("Les champs ne peuvent pas être vides.");
    }
  };

  const handleCancelClick = () => {
    // Reset the input fields and exit edit mode
    setNewText(product.text);
    setNewPrice(product.price);
    setUpdate(false);
  };

  return (
    <tr>
      <td>
        {update ? (
          <input
            className="form-control"
            type="text"
            value={newText}
            onChange={(e) => setNewText(e.target.value)}
          />
        ) : (
          newText
        )}
      </td>
      <td>
        {update ? (
          <input
            className="form-control"
            type="text"
            value={newPrice}
            onChange={(e) => setNewPrice(e.target.value)}
          />
        ) : (
          newPrice
        )}
      </td>
      <td className="d-flex justify-content-center">
        {update ? (
          <>
            <button onClick={handleSaveClick} className="btn btn-success me-1">
              Enregistrer
            </button>
            <button onClick={handleCancelClick} className="btn btn-secondary">
              Annuler
            </button>
          </>
        ) : (
          <>
            <button
              onClick={handleUpdateClick}
              className="btn btn-primary me-1"
            >
              Modifier
            </button>
            <button
              onClick={() => dispatch(deleteProduct(product.id))}
              className="btn btn-danger ml-2"
            >
              Supprimer
            </button>
          </>
        )}
      </td>
    </tr>
  );
};

export default ProductItem;

import { useSelector } from "react-redux";
import ProductItem from "./ProductItem";

const ProductList = () => {
  const products = useSelector((state) => state.product.products);

  return (
    <>
      <table className="table table-hover text-center">
        <thead className="">
          <tr>
            <th>
              <strong>Nom</strong>
            </th>

            <th>
              <strong>Prix</strong>
            </th>

            <th>
              <strong>Actions</strong>
            </th>
          </tr>
        </thead>
        <tbody className="table-group-divider">
          {products.map((product, index) => (
            <ProductItem product={product} key={index} />
          ))}
        </tbody>
      </table>
    </>
  );
};

export default ProductList;

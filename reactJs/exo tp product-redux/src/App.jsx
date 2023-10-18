import { Provider } from "react-redux";
import AddProduct from "./components/AddProduct";
import ProductList from "./components/ProductList";
import store from "./store";

function App() {
  return (
    <>
      <Provider store={store}>
        <div className="container">
          <h1 className="text-center">Application de gestion de produits</h1>
          <ProductList />
          <AddProduct />
        </div>
      </Provider>
    </>
  );
}

export default App;

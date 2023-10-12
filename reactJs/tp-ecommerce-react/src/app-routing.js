import { createBrowserRouter } from "react-router-dom";
import App from "./App";
import Cart from "./components/Cart";
import ErrorPage from "./components/ErrorPage";
import HomePage from "./components/HomePage";
import AddCar from "./components/AddCar";
import FormAdmin from "./components/FormAdmin";
import DescriptionCar from "./components/DescriptionCar";
import ProtectedRoute from "./components/ProtectedRoute";

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    errorElement: <ErrorPage />,
    children: [
      {
        path: "/",
        element: <HomePage />,
      },
      {
        path: "/cart",
        element: <Cart />,
      },
      {
        path: "/formAdmin",
        element: <FormAdmin />,
      },
      {
        path: "/DescriptionCar/:id",
        element: <DescriptionCar />,
      },
      {
        path: "/AddCar",
        element: (
          <ProtectedRoute>
            <AddCar />
          </ProtectedRoute>
        ),
      },
    ],
  },
]);

export default router;

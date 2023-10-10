import { createBrowserRouter } from "react-router-dom";
import App from "./App";
import ErrorPage from "./routes/ErrorPage";
import HomePage from "./routes/HomePage";
import ContactMePage from "./routes/ContactMePage";
import ListContact from "./routes/ListContact";

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    errorElement: <ErrorPage />,
    children: [
      {
        path: "/listContact/",
        element: <ListContact />,
        errorElement: <ErrorPage />,
      },
      {
        path: "/",
        element: <HomePage />,
        errorElement: <ErrorPage />,
      },

      {
        path: "/contact",
        element: <ContactMePage />,
        errorElement: <ErrorPage />,
      },
    ],
  },
]);

export default router;

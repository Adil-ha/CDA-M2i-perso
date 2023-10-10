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
        path: "/listContact/:id",
        element: <ListContact />,
      },
      {
        path: "/",
        element: <HomePage />,
      },

      {
        // path: "/contact/:firstname/:lastname/:email/:telephone",
        path: "/contact",
        element: <ContactMePage />,
      },
    ],
  },
]);

export default router;

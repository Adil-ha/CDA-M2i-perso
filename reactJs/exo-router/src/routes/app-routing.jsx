import { createBrowserRouter } from "react-router-dom";
import App from "../App";
import ErrorPage from "../components/ErrorPage";
import Menu from "../components/Menu";
import Contact from "../components/Contact";
import Project from "../components/Project";
import About from "../components/About";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Menu />,
    errorElement: <ErrorPage />,
    children: [
      {
        path: "/",
        element: <App />,
      },
      {
        path: "/Contact",
        element: <Contact />,
      },
      {
        path: "/Project",
        element: <Project />,
      },
      {
        path: "/About",
        element: <About />,
      },
    ],
  },
]);

export default router;

import { createBrowserRouter } from "react-router-dom";
import App from "./App";
import ErrorPage from "./components/ErrorPage";
import ProtectedRoute from "./components/ProtectedRoute";
import AlbumDisplay from "./components/album/AlbumDisplay";
import AlbumForm from "./components/album/AlbumForm";
import AlbumItem from "./components/album/AlbumItem";

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    errorElement: <ErrorPage />,
    children: [
      {
        path: "/",
        element: <AlbumDisplay />,
        children: [
          {
            element: <AlbumItem />,
          },
        ],
      },
      {
        path: "/addAlbum",
        element: (
          <ProtectedRoute>
            <AlbumForm />
          </ProtectedRoute>
        ),
      },
    ],
  },
]);

export default router;

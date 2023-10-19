import { Navigate } from "react-router-dom";

const ProtectedRoute = (props) => {
  const authCheck = () => {
    const token = localStorage.getItem("token");

    if (token) {
      return true;
    } else {
      return false;
    }
  };

  if (authCheck()) {
    return <>{props.children}</>;
  } else {
    return <Navigate to={"/"}></Navigate>;
  }
};

export default ProtectedRoute;

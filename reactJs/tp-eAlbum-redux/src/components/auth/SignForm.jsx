import { useDispatch, useSelector } from "react-redux";
import { setAuthMode, setUser } from "./authSlice";
import { SIGN_IN_URL, SIGN_UP_URL } from "../../fireBaseConfig";
import { useRef } from "react";

const SignForm = () => {
  const authMode = useSelector((state) => state.auth.authMode);
  const user = useSelector((state) => state.auth.user);
  const dispatch = useDispatch();

  const emailRef = useRef();
  const passwordRef = useRef();

  const submitFormHandler = async (event) => {
    event.preventDefault();

    const email = emailRef.current.value;
    const password = passwordRef.current.value;

    if (!email || !password) {
      alert("Veuillez remplir tous les champs.");
      return;
    }

    const credentials = {
      email,
      password,
      returnSecureToken: true,
    };

    const URL = authMode === "Se connecter" ? SIGN_IN_URL : SIGN_UP_URL;

    try {
      const response = await fetch(URL, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(credentials),
      });
      if (!response.ok) {
        throw new Error("Something went wrong during the" + authMode);
      }

      const data = await response.json();
      console.log(data);

      localStorage.setItem("token", data.idToken);
      dispatch(setUser(data));
      if (user) {
        dispatch(setAuthMode(""));
      }
    } catch (error) {
      console.error(error.message);
    }
  };

  return (
    <>
      <h3>{authMode}</h3>
      <hr />
      <form className="form-group w-75 m-auto" onSubmit={submitFormHandler}>
        <div className="form-group">
          <label htmlFor="email">Email</label>
          <input
            ref={emailRef}
            className="form-control"
            type="email"
            id="email"
          />
        </div>
        <div className="form-group">
          <label htmlFor="password">Password</label>
          <input
            ref={passwordRef}
            className="form-control"
            type="password"
            id="password"
          />
        </div>
        <button className="btn btn-primary">{authMode}</button>
        <button
          className="btn btn-success"
          onClick={() =>
            dispatch(
              setAuthMode(
                authMode === "Se connecter" ? "S'inscrire" : "Se connecter"
              )
            )
          }
        >
          {authMode === "Se connecter" ? "S'inscrire" : "Se connecter"}
        </button>
      </form>
    </>
  );
};
export default SignForm;

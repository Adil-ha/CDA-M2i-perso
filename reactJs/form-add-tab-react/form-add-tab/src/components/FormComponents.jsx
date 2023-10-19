import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

const FormComponent = (props) => {
  const { addUser } = props;

  const [lastname, setLastname] = useState("");
  const [firstname, setFirstname] = useState("");
  const [date, setDate] = useState("");

  const submitHandler = (e) => {
    e.preventDefault();

    if (!lastname || !firstname || !date) {
      alert("Tous les champs doivent être remplis.");
      return;
    }
    addUser({
      lastname,
      firstname,
      date,
    });

    setLastname("");
    setFirstname("");
    setDate("");
  };

  return (
    <form onSubmit={submitHandler}>
      <h1 className="mb-4">Form User</h1>
      <hr className="mb-4" />
      <div className="mb-3">
        <label htmlFor="lastname" className="form-label">
          Lastname
        </label>
        <input
          type="text"
          id="lastname"
          name="lastname"
          value={lastname}
          onChange={(e) => setLastname(e.target.value)}
          className="form-control"
        />
      </div>
      <div className="mb-3">
        <label htmlFor="firstname" className="form-label">
          Firstname
        </label>
        <input
          type="text"
          id="firstname"
          name="firstname"
          value={firstname}
          onChange={(e) => setFirstname(e.target.value)}
          className="form-control"
        />
      </div>
      <div className="mb-3">
        <label htmlFor="date" className="form-label">
          Date of birth
        </label>
        <input
          type="date"
          id="date"
          name="date"
          value={date}
          onChange={(e) => setDate(e.target.value)}
          className="form-control"
        />
      </div>
      <button type="submit" className="btn btn-primary">
        Submit
      </button>
    </form>
  );
};

export default FormComponent;

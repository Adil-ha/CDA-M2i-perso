import { useRef, useContext } from "react";
import { useNavigate } from "react-router-dom";
import Contact from "../models/Contact";
import ContactContext from "../contexts/ContactContext";

const ContactMePage = () => {
  const { setContacts } = useContext(ContactContext);

  const firstnameRef = useRef();
  const lastnameRef = useRef();
  const emailRef = useRef();
  const telephoneRef = useRef();

  const navigate = useNavigate();

  const submitFormHandler = (e) => {
    e.preventDefault();

    const firstname = firstnameRef.current.value;
    const lastname = lastnameRef.current.value;
    const email = emailRef.current.value;
    const telephone = telephoneRef.current.value;

    if (!firstname || !lastname || !email || !telephone) {
      return;
    }

    const newContact = new Contact(firstname, lastname, email, telephone);

    setContacts((prevContacts) => [...prevContacts, newContact]);

    firstnameRef.current.value = "";
    lastnameRef.current.value = "";
    emailRef.current.value = "";
    telephoneRef.current.value = "";

    navigate(`/ListContact/${newContact.id}`);
  };

  return (
    <>
      <h3>Form Contact</h3>
      <hr />
      <form onSubmit={submitFormHandler}>
        <div className="mb-3">
          <label htmlFor="firstname" className="form-label">
            Prénom
          </label>
          <input
            type="text"
            id="firstname"
            ref={firstnameRef}
            className="form-control"
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="lastname" className="form-label">
            Nom
          </label>
          <input
            type="text"
            id="lastname"
            ref={lastnameRef}
            className="form-control"
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="senderMail" className="form-label">
            Email
          </label>
          <input
            type="email"
            id="senderMail"
            ref={emailRef}
            className="form-control"
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="telephone" className="form-label">
            Téléphone
          </label>
          <input
            type="tel"
            id="telephone"
            ref={telephoneRef}
            className="form-control"
            required
          />
        </div>

        <div className="text-end">
          <button type="submit" className="btn btn-outline-light">
            <i className="bi bi-send"></i> Ajouter
          </button>
        </div>
      </form>
    </>
  );
};

export default ContactMePage;

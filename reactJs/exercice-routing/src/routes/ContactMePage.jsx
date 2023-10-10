import { useRef, useContext, useEffect, useState } from "react";
import { useNavigate, useSearchParams } from "react-router-dom";
import Contact from "../models/Contact";
import ContactContext from "../contexts/ContactContext";

const ContactMePage = () => {
  const { setContacts, contacts } = useContext(ContactContext);
  console.log(contacts);
  const [searchParams] = useSearchParams();
  const monId = searchParams.get("id");
  const mode = searchParams.get("mode");

  const [firstname, setFirstname] = useState("");
  const [lastname, setLastname] = useState("");
  const [email, setEmail] = useState("");
  const [telephone, setTelephone] = useState("");

  const firstnameRef = useRef();
  const lastnameRef = useRef();
  const emailRef = useRef();
  const telephoneRef = useRef();

  const navigate = useNavigate();

  const editContact = () => {
    if (mode === "edit" && monId) {
      const contactToEdit = contacts.find((contact) => contact.id == monId);
      if (contactToEdit) {
        setFirstname(contactToEdit.firstname);
        setLastname(contactToEdit.lastname);
        setEmail(contactToEdit.email);
        setTelephone(contactToEdit.telephone);
      }
      console.log(contactToEdit);
    }
  };

  useEffect(() => {
    editContact();
  }, [mode, monId, contacts]);

  const submitFormHandler = (e) => {
    e.preventDefault();

    const newFirstname = firstnameRef.current.value;
    const newLastname = lastnameRef.current.value;
    const newEmail = emailRef.current.value;
    const newTelephone = telephoneRef.current.value;

    if (!newFirstname || !newLastname || !newEmail || !newTelephone) {
      return;
    }

    if (mode === "edit" && monId) {
      const updatedContactsList = contacts.map((contact) => {
        if (contact.id == monId) {
          return new Contact(newFirstname, newLastname, newEmail, newTelephone);
        }
        return contact;
      });
      setContacts(updatedContactsList);
    } else {
      const newContact = new Contact(
        newFirstname,
        newLastname,
        newEmail,
        newTelephone
      );
      setContacts((prevContacts) => [...prevContacts, newContact]);
    }

    navigate("/ListContact");
  };

  return (
    <>
      <h3>{mode === "edit" ? "Edit Contact" : "Add Contact"}</h3>
      <hr />
      <form onSubmit={submitFormHandler}>
        <div className="mb-3">
          <label htmlFor="firstname" className="form-label">
            Prénom
          </label>
          <input
            type="text"
            id="firstname"
            value={firstname}
            onChange={(e) => setFirstname(e.target.value)}
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
            value={lastname}
            onChange={(e) => setLastname(e.target.value)}
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
            value={email}
            onChange={(e) => setEmail(e.target.value)}
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
            type="number"
            id="telephone"
            value={telephone}
            onChange={(e) => setTelephone(e.target.value)}
            ref={telephoneRef}
            className="form-control"
            required
          />
        </div>

        <div className="text-end">
          <button type="submit" className="btn btn-outline-light">
            <i className="bi bi-send"></i>{" "}
            {mode === "edit" ? "Éditer" : "Ajouter"}
          </button>
        </div>
      </form>
    </>
  );
};

export default ContactMePage;

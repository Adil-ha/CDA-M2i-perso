import React, { useContext } from "react";
import { useNavigate, useSearchParams } from "react-router-dom";
import ContactContext from "../contexts/ContactContext";

const ListContact = () => {
  const { contacts, setContacts } = useContext(ContactContext);
  const navigate = useNavigate();
  const [searchParams] = useSearchParams();
  const monId = searchParams.get("id");

  const handleEdit = (monId) => {
    navigate(`/contact/?mode=edit&id=${monId}`);
  };

  const handleDelete = (monId) => {
    const updatedContacts = contacts.filter((contact) => contact.id !== monId);
    setContacts(updatedContacts);
  };

  const handleFormRedirect = () => {
    navigate("/contact");
  };

  return (
    <div>
      <h3>Liste des Contacts</h3>
      <button onClick={handleFormRedirect}>Fermeture</button>
      {contacts.length === 0 ? (
        <p>Aucun contact disponible.</p>
      ) : (
        <ul>
          {contacts.map((contact) => (
            <li key={contact.id}>
              <strong>Nom:</strong> {contact.lastname}, <strong>Prénom:</strong>{" "}
              {contact.firstname}, <strong>Email:</strong> {contact.email},{" "}
              <strong>Téléphone:</strong> {contact.telephone}
              <button onClick={() => handleEdit(contact.id)}>Éditer</button>
              <button onClick={() => handleDelete(contact.id)}>
                Supprimer
              </button>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default ListContact;

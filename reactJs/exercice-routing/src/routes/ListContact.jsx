import React, { useContext } from "react";
import { useNavigate, useParams } from "react-router-dom"; // Import useParams
import ContactContext from "../contexts/ContactContext";

const ListContact = () => {
  const { contacts, setContacts } = useContext(ContactContext);
  const navigate = useNavigate();
  const { id } = useParams(); // Get the contact ID from the URL

  const handleEdit = (id) => {
    // Implement your edit logic here using the contact ID
    // Example: navigate(`/EditContact/${id}`)
  };

  const handleDelete = (id) => {
    const updatedContacts = contacts.filter((contact) => contact.id !== id);
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

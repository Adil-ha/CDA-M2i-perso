import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";

const ArrayComponent = (props) => {
  const { users } = props;

  if (!users && users.length <= 0) {
    return (
      <>
        <h1 className="mb-4">Array Users</h1>
        <p>Aucun utilisateur trouvé.</p>
      </>
    );
  } else {
    return (
      <>
        <h1 className="mb-4">Array Users</h1>
        <hr className="mb-4" />
        <table className="table table-dark rounded text-center stripped overflow-hidden table-striped">
          <thead>
            <tr>
              <td>id</td>
              <th>Lastname</th>
              <th>Firstname</th>
              <th>Date of birth</th>
            </tr>
          </thead>
          <tbody>
            {users.map((user, index) => (
              <tr key={index}>
                <td>{index + 1}</td>
                <td>{user.lastname}</td>
                <td>{user.firstname}</td>
                <td>{user.date}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </>
    );
  }
};

export default ArrayComponent;

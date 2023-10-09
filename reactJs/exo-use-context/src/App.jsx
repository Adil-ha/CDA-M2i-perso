// import Card from "./components/Card";
// import Form from "./components/Form";
// import "bootstrap/dist/css/bootstrap.min.css";
// import { UseContext } from "./context/UseContext";

// function App() {
//   return (
//     <UseContext.Provider>
//       <div className="App">
//         <div className="container">
//           <div className="row">
//             <div className="col-4">
//               <Form />
//             </div>
//             <div className="col-8">
//               <Card />
//             </div>
//           </div>
//         </div>
//       </div>
//     </UseContext.Provider>
//   );
// }

// export default App;

import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import Form from "./components/Form";
import Card from "./components/Card";
import { UseContextProvider } from "./context/UseContext";

function App() {
  return (
    <UseContextProvider>
      <div className="App">
        <div className="container">
          <div className="row">
            <div className="col-4">
              <Form />
            </div>
            <div className="col-8">
              <Card />
            </div>
          </div>
        </div>
      </div>
    </UseContextProvider>
  );
}

export default App;

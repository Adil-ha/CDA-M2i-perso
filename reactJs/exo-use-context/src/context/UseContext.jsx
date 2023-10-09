// import { createContext } from "react";

// export const UseContext = createContext();

import { createContext, useContext, useState } from "react";

export const UseContext = createContext();

export const UseContextProvider = ({ children }) => {
  const [entities, setEntities] = useState([]);

  const addEntity = (entity) => {
    setEntities([...entities, entity]);
  };

  return (
    <UseContext.Provider value={{ entities, addEntity }}>
      {children}
    </UseContext.Provider>
  );
};

export function useEntities() {
  const context = useContext(UseContext);
  if (!context) {
    throw new Error("useEntities must be used within a UseContextProvider");
  }
  return context;
}

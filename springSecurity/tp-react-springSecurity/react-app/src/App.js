import React from 'react';
import { Outlet } from 'react-router-dom';

import Header from './shared/Header';



function App() {
  return (
    
    <>
     <header>
       <Header />
    </header>
    <main>
      <Outlet />
    </main>
    </>
   
  
  );
}

export default App;


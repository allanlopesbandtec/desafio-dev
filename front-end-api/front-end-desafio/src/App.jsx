import React from "react";
import Home from "./componentes/Home"
import ListagemLojas from "./componentes/ListagemLojas"

import {
  BrowserRouter,
  Route
} from 'react-router-dom'


function App() {
  return (
    <>
      <BrowserRouter>
          <Route path="/" exact component={Home}/>
          <Route path="/listagem" component={ListagemLojas}/>
      </BrowserRouter>
    </>
  );
};

export default App;


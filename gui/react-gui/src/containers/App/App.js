import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import CustomLayout from "./CustomLayout";
import BaseRouter from "../../routes";
import {BrowserRouter as Router} from "react-router-dom";

function App() {
  return (
    <div className="App">
      <Router>
        <CustomLayout>
          <BaseRouter/>
        </CustomLayout>
      </Router>
    </div>
  );
}

export default App;

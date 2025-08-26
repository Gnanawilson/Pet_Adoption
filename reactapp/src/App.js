import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import PetListing from "./components/PetListing";
import PetDetails from "./components/PetDetails";

function App() {
  return (
    <Router>
      <div>
        <h1>🐾 Pet Adoption Management System</h1>
        <Routes>
          <Route path="/" element={<PetListing />} />
          <Route path="/pets/:id" element={<PetDetails />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;

import './App.css';

import React, { useState } from "react";
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import LoginPage from "./pages/LoginPage";
import HomePage from "./pages/HomePage";
import AdminPage from './pages/AdminPage';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element = {<LoginPage/>} ></Route>
        <Route path="/home" element = {<HomePage/>} ></Route>
        <Route path= "/admin" element = {<AdminPage/>} ></Route>
      </Routes>
    </Router>
  );
}

export default App;

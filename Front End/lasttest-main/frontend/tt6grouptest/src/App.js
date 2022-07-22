import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './App.css';
import Header from './components/Header';
import { ExchangeRate } from './components/ExchangeRate';

function App() {
  return (
    <div className="App">
      <Header/>
      <ExchangeRate />
    </div>
  );
}
export default App;

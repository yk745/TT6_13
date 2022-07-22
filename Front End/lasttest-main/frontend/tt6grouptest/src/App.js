
import './App.css';
import React from 'react';
import EWallet from './components/e-wallet/ewallet';
import { ExchangeRate } from './exchange/ExchangeRate';


function App() {
 return (

  <div className="App">


      <EWallet />
      <ExchangeRate />
      
 </div>
 );
}

export default App;

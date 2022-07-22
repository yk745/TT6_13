import {React, useEffect, useState} from "react";
import AddWallet from "./addWallet";
import SingleWallet from "./singlewallet";
import axios from 'axios';


const EWallet = () => {

const LOCAL_STORAGE_KEY = "walletDetails";
const [walletDetails, setWalletDetails] = useState([]);
const addWalletHandler = (walletDetail) => {
  console.log(walletDetail);
  setWalletDetails([...walletDetails,{ ...walletDetails}]);
};

useEffect(() => {
  localStorage.setItem(LOCAL_STORAGE_KEY, JSON.stringify(walletDetails));
}, [walletDetails]);

useEffect(() => {
  axios.get('https://86c9-219-74-57-140.ap.ngrok.io/countryExchangeRate')
    .then(response => console.log(response.data + "dddddddddddddd"));
}, []);

return (
  <div className="container" style={{'padding':'50px'}}>
   
    {/* <Router>
    <Header />
      <Routes>

        <Route exact path="/createWallet" render={(props) => (<AddWallet {...props} addWalletHandler={addWalletHandler}/>)}></Route>


      </Routes>
    </Router> */}

    <AddWallet addWalletHandler={addWalletHandler}/>
    <SingleWallet/>
     
  
  </div>
);
}

export default EWallet;
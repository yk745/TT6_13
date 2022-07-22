import {React, useEffect, useState} from "react";
import AddWallet from "./addWallet";
import SingleWallet from "./singlewallet";


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

return (
  <div className="container">
   
    {/* <Router>
    <Header />
      <Routes>

        <Route exact path="/createWallet" render={(props) => (<AddWallet {...props} addWalletHandler={addWalletHandler}/>)}></Route>


      </Routes>
    </Router> */}

    <AddWallet addWalletHandler={addWalletHandler}/>
    {/* <SingleWallet setWalletDetails={addWalletHandler}/> */}
  </div>
);
}

export default EWallet;
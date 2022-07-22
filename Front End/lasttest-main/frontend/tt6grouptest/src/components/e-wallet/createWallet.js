import React from "react";
import SingleWallet from "./singlewallet";
import {Link} from 'react-router-dom';


const CreateWallet = (props) => {

    const renderWalletDetails = props.walletDetails.map((walletDetail) => {
        return (
            <SingleWallet walletDetails={walletDetail}/>
        )
    }); 

    return (
       
        
        <div>
<h2> testing</h2>
            {/* <Link to="/addWallet">
                <button className="ui button blue">Add a new wallet</button>
            </Link> */}

            <div className="ui celled list">{renderWalletDetails}</div>
        </div>        
        
    );
}

export default CreateWallet;

import React from "react";


const SingleWallet = (props) => {
    // const {walletName, walletCurrency} = props.walletDetails;

    // const walletDetails = [{
    //     walletName: "wallet 1",
    //     WalletDescription: "SGD"
    // }];

    return (
        <div className="ui cards">
            <div className="card">
                <div className="content">
                    <div className="header">
                       Wallet Name: 
                    </div>
                    <div className="description">
                        Currency:
                    </div>

                </div>
            </div>

        </div>
    );
};

export default SingleWallet;

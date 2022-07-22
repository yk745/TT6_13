import React from "react";


const SingleWallet = (props) => {
    // const {walletName, walletCurrency} = props.walletDetails;

    // const walletDetails = [{
    //     walletName: "wallet 1",
    //     WalletDescription: "SGD"
    // }];

    return (
        <div>
        <div className="ui dividing header" style={{"margin-top":"30px"}}> My Wallets:</div>

        <div className="ui cards" style={{"marginTop":'30px'}}>
            <div className="card">
                <div className="content">
                    <div className="header">
                       Wallet Name: Wallet 1
                    </div>
                    <div className="description">
                        Currency: SGD
                    </div>
                    <div className="description">
                        Amount: SGD 500
                    </div>
                </div>
            </div>


            <div className="card">
                <div className="content">
                    <div className="header">
                       Wallet Name: Wallet 2
                    </div>
                    <div className="description">
                        Currency: MYR
                    </div>
                    <div className="description">
                        Amount: MYR 500
                    </div>
                </div>
            </div>

            <div className="card">
                <div className="content">
                    <div className="header">
                       Wallet Name: Wallet 3
                    </div>
                    <div className="description">
                        Currency: USD
                    </div>
                    <div className="description">
                        Amount: USD 500
                    </div>
                </div>
            </div>

            <div className="card">
                <div className="content">
                    <div className="header">
                       Wallet Name: Wallet 4
                    </div>
                    <div className="description">
                        Currency: EUR
                    </div>
                    <div className="description">
                        Amount: EUR 500
                    </div>

                </div>
            </div>

        </div>
        </div>
        
    );
};

export default SingleWallet;

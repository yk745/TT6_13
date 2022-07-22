import React from "react";


const SingleWallet = (props) => {
    const {walletName, walletCurrency} = props.walletDetails;

    // const walletDetails = [{
    //     walletName: "wallet 1",
    //     WalletDescription: "SGD"
    // }];

    return (
        <div className="ui cards">
            <div className="card">
                <div className="content">
                    <div className="header">
                       {walletName}
                    </div>
                    <div className="meta">
                        {walletCurrency}
                    </div>

                </div>
            </div>

        </div>
    );
};

export default SingleWallet;

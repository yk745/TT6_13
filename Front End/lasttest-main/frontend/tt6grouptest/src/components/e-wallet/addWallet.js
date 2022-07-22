import React from "react";


class AddWallet extends React.Component {
    state = {
        walletName: "",
        walletCurrency:""
    };

    add = (e)=> {
        e.preventDefault();
        if ( this.state.walletName === "" && this.state.walletCurrency === "") {
            alert("All fields are mandatory");
            return;
        };

        this.props.addContactHandler(this.state);
        this.setState({walletName: "", walletCurrency:""}) //App.js there
        //this.props.history.push("/");
    };


    render() {
        return (
            <div className="ui main">
                <h2 style={{paddingTop:'50px'}}>Add a new wallet</h2>
                <form className="ui form" onSubmit={this.add}>
                    <div className="field">
                        <label>Wallet Name:</label>
                        <input 
                        type="text" 
                        name="name" 
                        placeholder="Wallet Name" 
                        value = {this.state.walletName }
                        onChange={(e) => this.setState({walletName: e.target.value})}></input>
                    </div>

                    <div className="field">
                        <label>Wallet Currency:</label>
                        <input 
                        type="text"
                        name="email" 
                        placeholder="Select Currency"                         
                        value = {this.state.walletCurrency}
                        onChange={(e) => this.setState({walletCurrency: e.target.value})}></input>
                    </div>

                    <button className="ui button green">Add</button>
                </form>
            </div>
        );
    }
}

export default AddWallet;
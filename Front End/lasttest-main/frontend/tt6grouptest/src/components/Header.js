import React, { useState } from "react";
import { Link } from "react-router-dom";
import "./styles/Header.css";
import logo from "./assets/logo.jpg";
import MenuIcon from "@mui/icons-material/Menu";
import CloseIcon from "@mui/icons-material/Close";
import {BrowserRouter as Route, Routes, Router} from 'react-router-dom';
import EWallet from "./e-wallet/ewallet";

const Header = () => {
  const [active, setActive] = useState(false);

  function toggle() {
    setActive(!active);
  }

  return (
    <Router>
    <div className="header">
      <div className="header--logo">
        <img src={logo} alt="" />
      </div>

      <div className="menu--icon">
        <MenuIcon className="menu" onClick={toggle} />
      </div>

      <nav>
        <ul className={active ? "list--items active" : "list--items"}>
          <div className="menu--close">
            <CloseIcon className="close" onClick={toggle} />
          </div>

          <li>
            <Link to="/">Home</Link>
          </li>

          <li>
            <Link to="/wallets">Wallets</Link>
          </li>

          <li>
            <Link to="/registration">Login</Link>
          </li>

        </ul>
      </nav>
      
      <Routes>
        <Route exact path="/" component={EWallet}/>
        {/* <Route exact path="/" component={<Header />} /> */}

      </Routes>
      
    </div>
    </Router>
  );
};

export default Header;
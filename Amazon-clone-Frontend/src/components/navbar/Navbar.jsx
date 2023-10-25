import MenuIcon from "@mui/icons-material/Menu";
import { NavLink } from "react-router-dom";
import { useState } from "react";

import "./Navbar.css";

const Navbar = () => {
  const [toggler, setToggler] = useState(false);

  const navLinkStyles = ({ isActive }) => {
    return {
      fontWeight: isActive ? "bold" : "normal",
      textDecoration: isActive ? "underline" : "none",
    };
  };

  return (
    <nav className="main-nav">
      <div className="logo">
        <h2> Amazon </h2>
      </div>
      <div className={`search-input ${toggler ? "mobile-search-input" : ""}`}>
        <input type="text" placeholder="search here...." />
      </div>
      <div className={`menu-link ${toggler ? "mobile-menu" : " "}  `}>
        <ul>
          <li>
            <NavLink style={navLinkStyles} to="/">
              Home
            </NavLink>
          </li>
          <li>
            <NavLink style={navLinkStyles} to="sigin">
              Sign In
            </NavLink>
          </li>
          <li>
            <NavLink style={navLinkStyles} to="signup">
              Sign Up
            </NavLink>
          </li>
          {/* <li>
            <NavLink style={navLinkStyles} to="signup">
              Cart
            </NavLink>
          </li> */}
        </ul>
      </div>
      <div className="menu-bar">
        <MenuIcon onClick={() => setToggler(!toggler)} />
      </div>
    </nav>
  );
};

export default Navbar;

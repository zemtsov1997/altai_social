import React from 'react';
import {Navbar} from "react-bootstrap";
import {Link} from "react-router-dom";

class Header extends React.Component {
  render() {
    return (
      <div className="Header">
        <Navbar collapseOnSelect bg="light" expand="lg">
          <Navbar.Brand as={Link} to="/">Altai Social</Navbar.Brand>
          <Navbar.Toggle/>
          <Navbar.Collapse className="justify-content-end">
            {/*<Nav className="mr-auto">*/}
            {/*  <Nav.Link as={Link} to="/sign_in">Войти</Nav.Link>*/}
            {/*</Nav>*/}
          </Navbar.Collapse>
        </Navbar>
      </div>
    )
  }
}

export default Header;
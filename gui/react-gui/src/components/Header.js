import React from 'react';
import {Nav, Navbar} from "react-bootstrap";
import {Link} from "react-router-dom";

class Header extends React.Component {
  render() {
    return (
      <div className="Header">
        <Navbar collapseOnSelect bg="dark" variant="dark" expand="lg" fixed="top">
          <Navbar.Brand as={Link} to="/">Altai Social</Navbar.Brand>
          <Navbar.Toggle/>
          <Navbar.Collapse className="justify-content-end">
            <Nav className="mr-auto">
              <Nav.Link as={Link} to="/">
                Главная
              </Nav.Link>
              :
              <Nav.Link as={Link} to="/">
                Сайт министерства
              </Nav.Link>
              <Nav.Link as={Link} to="/">
                Инициативы
              </Nav.Link>
            </Nav>
            <Nav pullright="true">
              <Nav.Link as={Link} to="/">
                Регистрация
              </Nav.Link>
              <Nav.Link as={Link} to="/">
                Войти
              </Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Navbar>
      </div>
    )
  }
}

export default Header;
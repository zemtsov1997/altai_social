import React from 'react';
import avatar from '../assets/images/user.jpg';
import {Dropdown, DropdownItem, Image, Nav, Navbar} from "react-bootstrap";
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
              <Nav.Link as={Link} to="/">
                Указы
              </Nav.Link>
            </Nav>
            <Nav pullright="true">
              <Nav.Link as={Link} to="/">
                Регистрация
              </Nav.Link>
              <Nav.Link as={Link} to="/">
                Войти
              </Nav.Link>
              <Dropdown>
                <Image src={avatar} height={40} width={40} roundedCircle/>
                <Dropdown.Toggle split variant="dark" id="enter-dropdown">
                  Иванов И.
                </Dropdown.Toggle>
                <Dropdown.Menu>
                  <DropdownItem name="lk" as={Link} to="/user/page">
                    Личный кабинет
                  </DropdownItem>
                </Dropdown.Menu>
              </Dropdown>
            </Nav>
          </Navbar.Collapse>
        </Navbar>
      </div>
    )
  }
}

export default Header;
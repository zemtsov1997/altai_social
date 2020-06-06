import React from 'react';
import avatar from '../assets/images/user.jpg';
import {Dropdown, DropdownItem, Image, Nav, Navbar} from "react-bootstrap";
import {Link} from "react-router-dom";
import * as actions from '../store/actions/auth/actionCreators';
import {connect} from "react-redux";
import {withRouter} from "react-router";


class Header extends React.Component {
  render() {
    const {isAuthenticated} = this.props;

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
            {
              isAuthenticated ?
                <Nav pullright="true">
                  <Dropdown>
                    <Image src={avatar} height={40} width={40} roundedCircle/>
                    <Dropdown.Toggle split variant="dark" id="enter-dropdown">
                      Иванов И.
                    </Dropdown.Toggle>
                    <Dropdown.Menu>
                      <DropdownItem as={Link} to="/user/page">
                        Личный кабинет
                      </DropdownItem>
                      <DropdownItem onClick={this.props.logout}>
                        Выход
                      </DropdownItem>
                    </Dropdown.Menu>
                  </Dropdown>
                </Nav>
                : null
            }
          </Navbar.Collapse>
        </Navbar>
      </div>
    )
  }
}

const mapStateToProps = (state) => {
  return {
    isAuthenticated: state.auth.isAuthenticated,
  }
};

const mapDispatchToProps = dispatch => {
  return {
    logout: () => dispatch(actions.logout)
  }
};

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(Header));
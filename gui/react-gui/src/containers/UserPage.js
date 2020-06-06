import React from "react";
import {Col, Container, Row} from "react-bootstrap";

import UserMenu from "../components/UserMenu";
import UserInfo from "./UserInfo";
import {Redirect} from "react-router";
import {connect} from "react-redux";

class UserPage extends React.Component {
  render() {
    if (!this.props.isAuthenticated) {
      return <Redirect to="/"/>
    }

    return (
      <Container className="Content">
        <br/>
        <Row>
          <Col md="auto">
            <UserMenu/>
          </Col>
          <Col>
            <UserInfo/>
          </Col>
        </Row>
        <br/>
      </Container>
    )
  }

}

const mapStateToProps = (state) => {
  return {
    isAuthenticated: state.auth.isAuthenticated,
  }
};

export default connect(mapStateToProps, null)(UserPage);


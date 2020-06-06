import React from 'react';
import {Col, Container, Row} from "react-bootstrap";
import Auth from "./Auth";

class Content extends React.Component {
  render() {
    return (
      <Container className="Content">
        <Row>
          <Col md={9}>
            <a href={"/user/page"}>Личный кабинет</a>
          </Col>
          <Col md={3}>
            <Auth/>
          </Col>
        </Row>
      </Container>
    )
  }
}

export default Content;
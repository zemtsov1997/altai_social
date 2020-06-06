import React from 'react';
import {Col, Container, Row} from "react-bootstrap";
import Auth from "./Auth";
import Main from "./Main";

class Content extends React.Component {
  render() {
    return (
      <Container className="Content mt-4">
        <Row>
          <Col md={9}>
            <Main/>
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
import React from 'react';
import {Col, Container, Row} from "react-bootstrap";
import Auth from "./Auth";
import Main from "./Main";
import {connect} from "react-redux";
import Map from '../components/Map';
import {GOOGLE_API_KEY} from '../constants';

class Content extends React.Component {
  render() {
    const {isAuthenticated} = this.props;

    return (
      <Container className="Content mt-4">
        <Row className="">
          <Col md={isAuthenticated ? 12 : 9}>
            <Main/>
          </Col>
          {
            isAuthenticated ? null :
              <Col md={3}>
                <Auth/>
              </Col>
          }
        </Row>
      </Container>
    )
  }
}

const mapStateToProps = (state) => {
  return {
    isAuthenticated: state.auth.isAuthenticated,
  }
};

export default connect(mapStateToProps, null)(Content);
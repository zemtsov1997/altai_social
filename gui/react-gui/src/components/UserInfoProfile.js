import React from "react";
import {Button, Col, Container, Row} from "react-bootstrap";
import UserInfoProfileEdit from "./UserInfoProfileEdit";

class UserInfoProfile extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isEditable: false,
    }
  }

  switchEditable = () => {
    this.setState({isEditable: !this.state.isEditable});
  };

  render() {
    const {isEditable} = this.state;

    if (isEditable) {
      return <UserInfoProfileEdit/>
    }

    return (
      <Container className="Content">
        <Col>
          <Row className="justify-content-md-between">
            <h3>Иванов Иван Иванович</h3>
            <Col md={"auto"}>
              <Button variant="primary" onClick={this.switchEditable}>Редактировать</Button>
            </Col>
          </Row>
          <br/>
          <Row>
            <Col>
              <Row>
                <small>место жительства</small>
              </Row>
              <Row>
                <span>г. Горно-Алтайск</span>
              </Row>
            </Col>
            <br/>
            <Col>
              <Row>
                <small>дата рождения</small>
              </Row>
              <Row>
                <span>20.10.1990</span>
              </Row>
            </Col>
          </Row>
          <br/>
          <Row>
            <Col>
              <Row>
                <small>номер тел.</small>
              </Row>
              <Row>
                <span>+79530190297</span>
              </Row>
            </Col>
            <br/>
            <Col>
              <Row>
                <small>эл. почта</small>
              </Row>
              <Row>
                <span>ivanov@mail.ru</span>
              </Row>
            </Col>
          </Row>
        </Col>
      </Container>
    )
  }

}

export default UserInfoProfile;
import React from "react";
import {Button, Col, Container, Form, Row} from "react-bootstrap";
import UserInfoProfile from "./UserInfoProfile";

class UserInfoProfileEdit extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isEditable: true,
    }
  }

  switchEditable = () => {
    this.setState({isEditable: !this.state.isEditable});
  };

  render() {
    const {isEditable} = this.state;

    if (!isEditable) {
      return <UserInfoProfile/>
    }

    return (
      <Container className="Content">
        <Col>
          <Col>
            <Row className="justify-content-md-between">
              <Form.Group>
                <Form.Control type="text"
                              name="lastName"
                              placeholder="Фамилия"/>
              </Form.Group>
              <Col md={"auto"}>
                <Button variant="primary" onClick={this.switchEditable}>Сохранить</Button>
              </Col>
            </Row>
            <Row>
              <Form.Group>
                <Form.Control type="text"
                              name="firstName"
                              placeholder="Имя"/>
              </Form.Group>
            </Row>
            <Row>
              <Form.Group>
                <Form.Control type="text"
                              name="middleName"
                              placeholder="Отчество"/>
              </Form.Group>
            </Row>
          </Col>
          <br/>
          <Row>
            <Col>
              <Form.Group>
                <Form.Control type="date"
                              name="birthDate"
                              placeholder="Дата рождения"/>
              </Form.Group>
            </Col>
            <br/>
            <Col>
              <Form.Group>
                <Form.Control name="phone"
                              placeholder="Номер телефона"/>
              </Form.Group>
            </Col>
          </Row>
          <Row>
            <Col>
              <Form.Group>
                <Form.Control type="email"
                              name="email"
                              placeholder="Email"/>
              </Form.Group>
            </Col>
            <br/>
            <Col>
              <Form.Group controlId="exampleForm.ControlSelect1">
                <Form.Control as="select">
                  <option>Мужской</option>
                  <option>Женский</option>
                </Form.Control>
              </Form.Group>
            </Col>
          </Row>
        </Col>
      </Container>
    )
  }

}

export default UserInfoProfileEdit;
import React from 'react';

import {Button, Col, Form, Row} from "react-bootstrap";
import * as actions from "../store/actions/auth/actionCreators";
import {connect} from "react-redux";


class SignUpForm extends React.Component {
  handleSubmit = (event) => {
    event.preventDefault();
    const elements = event.target.elements;
    const data = {
      username: elements.username.value,
      password: elements.password.value,
      roles: [{
        id: 1,
      }],
      profile: {
        lastName: elements.lastName.value,
        firstName: elements.firstName.value,
        middleName: elements.middleName.value,
        genderId: elements.gender.value,
        numberPhone: {
          code: '+7',
          number: elements.phone.value,
        },
        email: elements.email.value,
        dateBirthday: elements.birthDate.value,
      }
    };
    this.props.signUp(data);
  };

  render() {
    return (
      <Form className="SignUpForm" onSubmit={this.handleSubmit}>
        <Form.Group>
          <Form.Control type="text"
                        name="username"
                        placeholder="Логин"/>
        </Form.Group>
        <Form.Group>
          <Form.Control type="password"
                        name="password"
                        placeholder="Пароль"
                        autoComplete="on"/>
        </Form.Group>
        <Form.Group>
          <Form.Control type="text"
                        name="lastName"
                        placeholder="Фамилия"/>
        </Form.Group>
        <Form.Group>
          <Form.Control type="text"
                        name="firstName"
                        placeholder="Имя"/>
        </Form.Group>
        <Form.Group>
          <Form.Control type="text"
                        name="middleName"
                        placeholder="Отчество"/>
        </Form.Group>
        <Form.Group>
          <Form.Control type="email"
                        name="email"
                        placeholder="Email"/>
        </Form.Group>
        <Form.Group>
          <Form.Control name="phone"
                        placeholder="Номер телефона"
                        maxLength="10"/>
        </Form.Group>
        <Form.Group>
          <Form.Control type="date"
                        name="birthDate"
                        placeholder="Дата рождения"/>
        </Form.Group>

        <Form.Group as={Row}>
          <Form.Label as="legend" column="gender" md={6}>Выберите пол</Form.Label>
          <Col md={6}>
            <Form.Check
              type="radio"
              label="Мужской"
              name="gender"
              value="1"
              custom
              id="male-radio"
            />
            <Form.Check
              type="radio"
              label="Женский"
              name="gender"
              value="2"
              custom
              id="female-radio"
            />
          </Col>
        </Form.Group>
        <Button type="submit" variant="outline-success" block>Создать аккаунт</Button>
      </Form>
    )
  }
}

const mapDispatchToProps = dispatch => {
  return {
    signUp: (data) => dispatch(actions.signUp(data))
  }
};

export default connect(null, mapDispatchToProps)(SignUpForm);
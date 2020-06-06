import React from 'react';
import axios from 'axios';

import {Button, Col, Form, Row} from "react-bootstrap";


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
    const options = {
          method: 'POST',
          url: 'http://localhost:8002/appUsers',
          data: data,
            headers: {
                "Content-Type": "application/json"
            }
    };
      const options2 = {
          method: 'POST',
          url: 'http://localhost:8002/token',
          data: {
              "username": data.username,
              "password": data.password
          },
          headers: { }
      };
    axios(options)
      .then(res => {
      console.log("Создали пользака");
        console.log(res.data);
          axios(options2)
              .then(res => {
                  console.log("Получили токен");
                  console.log(res.data);

              })
              .catch(err => {
                  console.log("Не Получили токен");
                  console.log(err.response.data);
                  console.log(err.response);
                  console.log(err.data);
              });
      })
      .catch(err => {
          console.log("Не Создали пользака");
        console.log(err.response.data);
        console.log(err.response);
        console.log(err.data);
      });
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
                        placeholder="Номер телефона"/>
        </Form.Group>
        <Form.Group>
          <Form.Control type="date"
                        name="birthDate"
                        placeholder="Дата рождения"/>
        </Form.Group>

        <Form.Group as={Row}>
          <Form.Label as="legend" column md={6}>Выберите пол</Form.Label>
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

export default SignUpForm;
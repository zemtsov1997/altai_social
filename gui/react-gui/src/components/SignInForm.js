import React from 'react';
import {Formik} from "formik";
import {Button, Form} from "react-bootstrap";
import * as Yup from "yup";
import {requiredMes, toLongMes, toShortMes} from "../constants/validate";
import axios from "axios";

const validateScheme = Yup.object({
  username: Yup.string()
    .required(requiredMes)
    .min(5, toShortMes)
    .max(30, toLongMes),
  password: Yup.string()
    .required(requiredMes)
    .min(5, toShortMes),
});

class SignInForm extends React.Component {
  handleSubmit = (event) => {
    event.preventDefault();
    const elements = event.target.elements;
    axios.post('http://localhost:8001/token', {
        username: elements.username.value,
        password: elements.password.value,
      }
    )
      .then(res => {
        console.log(res);
      })
      .catch(err => {
        console.log(err);
      });
  };

  render() {
    return (
      <Formik
        initialValues={{}}
        validationSchema={validateScheme}
        onSubmit={this.handleSubmit}>
        {({
            handleSubmit,
            handleChange,
            touched,
            errors,
          }) => (

          <Form noValidate className="SignInForm" onSubmit={handleSubmit}>
            <Form.Group>
              <Form.Control type="text"
                            name="username"
                            placeholder="Логин"
                            isValid={touched.username && !errors.username}
                            onChange={handleChange}
                            isInvalid={!!errors.username}/>
              <Form.Control.Feedback type="invalid">{errors.username}</Form.Control.Feedback>
            </Form.Group>
            <Form.Group>
              <Form.Control type="password"
                            name="password"
                            placeholder="Пароль"
                            autoComplete="on"
                            isValid={touched.password && !errors.password}
                            onChange={handleChange}
                            isInvalid={!!errors.password}/>
              <Form.Control.Feedback type="invalid">{errors.password}</Form.Control.Feedback>
            </Form.Group>
            <Button type="submit" variant="outline-success" block>Войти</Button>
          </Form>
        )}
      </Formik>
    )
  }
}

export default SignInForm;
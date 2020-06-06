import React from 'react';
import {Button, Form} from "react-bootstrap";
import * as actions from "../store/actions/auth/actionCreators";
import {connect} from "react-redux";
import {withRouter} from "react-router";

class SignInForm extends React.Component {
  handleSubmit = (event) => {
    event.preventDefault();
    const elements = event.target.elements;
    const data = {
      username: elements.username.value,
      password: elements.password.value,
    };
    this.props.signIn(data);
    this.props.history.push('/user/page');
  };

  render() {
    return (
      <Form className="SignInForm" onSubmit={this.handleSubmit}>
        <Form.Group>
          <Form.Control type="text"
                        name="username"
                        placeholder="Логин"
                        required/>
        </Form.Group>
        <Form.Group>
          <Form.Control type="password"
                        name="password"
                        placeholder="Пароль"
                        autoComplete="on"
                        required/>
        </Form.Group>
        <Button type="submit" variant="outline-success" block>Войти</Button>
      </Form>
    )
  }
}

const mapDispatchToProps = dispatch => {
  return {
    signIn: (data) => dispatch(actions.signIn(data))
  }
};

export default withRouter(connect(null, mapDispatchToProps)(SignInForm));
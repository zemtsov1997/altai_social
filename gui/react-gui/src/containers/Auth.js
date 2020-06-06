import React from 'react';
import SignUpForm from "../components/SignUpForm";
import SignInForm from "../components/SignInForm";
import {Button} from "react-bootstrap";

class Auth extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isSignUpForm: true,
    }
  }

  switch = () => {
    this.setState({isSignUpForm: !this.state.isSignUpForm})
  };

  render() {
    const {isSignUpForm} = this.state;

    return (
      <div className="Auth">
        {
          isSignUpForm ? <SignUpForm/> : <SignInForm/>
        }
        <hr/>
        <div className="text-center">
          {
            <Button variant="link">
              Забыли пароль?
            </Button>
          }
        </div>
        <div className="text-center">
          {
            isSignUpForm ?
              <Button variant="link" onClick={this.switch}>
                Уже есть аккаунт? Войдите!
              </Button>
              :
              <Button variant="link" onClick={this.switch}>Еще не зарегистрированы? Вам сюда!</Button>
          }
        </div>
      </div>
    )
  }
}

export default Auth;
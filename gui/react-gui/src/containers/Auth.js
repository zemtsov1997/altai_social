import React from 'react';
import SignUpForm from "../components/SignUpForm";
import SignInForm from "../components/SignInForm";

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
            <a href="#forgot_password">
              Забыли пароль?
            </a>
          }
        </div>
        <div className="text-center">
          {
            isSignUpForm ?
              <a href="#sign_in" role="button" onClick={this.switch}>
                Уже есть аккаунт? Войдите!
              </a>
              :
              <a href="#sign_up" role="button" onClick={this.switch}>Еще не зарегистрированы? Вам сюда!</a>
          }
        </div>
      </div>
    )
  }
}

export default Auth;
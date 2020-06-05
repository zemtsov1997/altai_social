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
            isSignUpForm ?
              <a href="#" role="button" onClick={this.switch}>
                Уже есть аккаунт? Войдите!
              </a>
              :
              <a href="#" role="button" onClick={this.switch}>Еще не зарегистрированы? Вам сюда!</a>
          }
        </div>
      </div>
    )
  }
}

export default Auth;
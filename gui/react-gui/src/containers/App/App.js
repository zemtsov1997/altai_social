import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import CustomLayout from "./CustomLayout";
import BaseRouter from "../../routes";
import {BrowserRouter as Router} from "react-router-dom";
import * as actions from "../../store/actions/auth/actionCreators";
import {connect} from "react-redux";

class App extends React.Component {
  componentDidMount() {
    this.props.authCheckState();
  }

  render() {
    return (
      <div className="App">
        <Router>
          <CustomLayout>
            <BaseRouter/>
          </CustomLayout>
        </Router>
      </div>
    )
  }
}


const mapDispatchToProps = dispatch => {
  return {
    authCheckState: () => dispatch(actions.authCheckState())
  }
};

export default connect(null, mapDispatchToProps)(App);

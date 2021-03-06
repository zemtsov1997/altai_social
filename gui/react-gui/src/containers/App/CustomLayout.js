import React, {Component} from 'react'
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";

class CustomLayout extends Component {
  render() {
    return (
      <div>
        <Header/>
        {this.props.children}
        <Footer/>
      </div>
    )
  }
}

export default CustomLayout;

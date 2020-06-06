import React from 'react';
import {Container} from "react-bootstrap";


class Error404 extends React.Component {
  render() {
    return (
      <Container className="Error404 text-center mt-4">
        <h1>Упс... Такой страницы не существует</h1>
      </Container>
    )
  };
}

export default Error404;


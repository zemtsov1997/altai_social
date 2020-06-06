import React from "react";
import {Button, Col, Container, Image, Row} from "react-bootstrap";

class UserInfoImg extends React.Component{

    render() {
        return (
            <Container className="Content">
                <Col>
                    <Row>
                        <Image src="/img/user.jpg" height={200} width={200} roundedCircle/>
                    </Row>
                    <br/>
                    <Row className="justify-content-md-center">
                        <Button variant="primary">Создать инициативу</Button>
                    </Row>
                    <Row className="justify-content-md-center">
                        <Button variant="link" size="sm">Как внести инициативу?</Button>
                    </Row>
                </Col>
            </Container>
        )
    }

}

export default UserInfoImg;
import React from "react";

import {Button, Col, Container, Image, Row} from "react-bootstrap";
import avatar from '../assets/images/big-man.jpg';

class UserMenu extends React.Component{

    render() {
        return (
            <Container>
                <Col>
                    <hr/>
                    <Button variant="link" size="lg">Все инициативы</Button>
                    <br/>
                    <Button variant="link" size="lg">Повестка дня</Button>
                    <br/>
                    <Button variant="link" size="lg">Обсуждаемое</Button>
                    <br/>
                    <Button variant="link" size="lg">Указы</Button>
                    <br/>
                    <Button variant="link" size="lg">Голосования</Button>
                    <br/>
                    <hr/>
                </Col>
                <Col>
                    <Row className="justify-content-md-center">
                        <Image src={avatar} height={100} width={100} roundedCircle/>
                    </Row>
                    <br/>
                    <Row className="justify-content-md-center">
                        <h5>Алымов Сергей</h5>
                    </Row>
                    <Row className="justify-content-md-center">
                        <small>Министерство цифрового развития</small>
                    </Row>
                    <Row className="justify-content-md-center">
                        <small>Республики Алтай</small>
                    </Row>
                    <br/>
                    <Row className="justify-content-md-center">
                        <Button variant="primary" size="sm">Написать</Button>
                    </Row>
                    <hr/>
                </Col>
            </Container>
        )
    }

}

export default UserMenu;
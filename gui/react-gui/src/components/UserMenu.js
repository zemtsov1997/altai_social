import React from "react";

import {Button, Col, Container} from "react-bootstrap";

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
            </Container>
        )
    }

}

export default UserMenu;
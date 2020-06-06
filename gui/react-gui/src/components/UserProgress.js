import React from "react";

import {Card, Col, Container, Row} from "react-bootstrap";

class UserProgress extends React.Component{

    render() {
        return(
            <Container>
                <Row className="justify-content-md-around">
                    <Card style={{ width: '18rem' }}>
                        <Card.Header>
                            <Col>
                                <Row className="justify-content-md-between">
                                    <small>Достижение</small>
                                    <small>06.06.2020</small>
                                </Row>
                            </Col>
                        </Card.Header>
                        <Card.Body>
                            <Card.Title>Эксперт</Card.Title>
                            <Card.Text>
                                Вы проголосовали за 50 инициатив
                            </Card.Text>
                        </Card.Body>
                    </Card>
                    <Card style={{ width: '18rem' }}>
                        <Card.Header>
                            <Col>
                                <Row className="justify-content-md-between">
                                    <small>Достижение</small>
                                    <small>06.06.2020</small>
                                </Row>
                            </Col>
                        </Card.Header>
                        <Card.Body>
                            <Card.Title>Мастер</Card.Title>
                            <Card.Text>
                                Принять участие в 5 обсуждениях документов с властью
                            </Card.Text>
                        </Card.Body>
                    </Card>
                </Row>
            </Container>
        )
    }

}

export default UserProgress;
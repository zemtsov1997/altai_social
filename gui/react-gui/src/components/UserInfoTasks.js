import React from "react";
import {Button, Card, Col, Container, Dropdown, DropdownButton, Row, Tab, Tabs} from "react-bootstrap";

class UserInfoTasks extends React.Component{

    render() {
        return (
            <Container className="Content">
                <Tabs defaultActiveKey="created" id="uncontrolled-tab-article">
                    <Tab eventKey="created" title="Созданные">
                        <br/>
                        <Card style={{ width: '18rem' }}>
                            <Card.Header>
                                <Col>
                                    <Row className="justify-content-md-between">
                                        <small>Общественная</small>
                                        <small>06.06.2020</small>
                                    </Row>
                                </Col>
                            </Card.Header>
                            <Card.Body>
                                <Card.Title>Спасти приют животных</Card.Title>
                                <Card.Text>
                                    Предлагаю спасти приют животных, так как состояние старого не удовлетворяет текущим
                                    санитарно-техническим нормам
                                </Card.Text>
                                <DropdownButton id="dropdown-basic-button" title="Действия">
                                    <Dropdown.Item href="#/action-1">Просмотр</Dropdown.Item>
                                    <Dropdown.Item href="#/action-2">Редактировать</Dropdown.Item>
                                    <Dropdown.Item href="#/action-3">Удалить</Dropdown.Item>
                                </DropdownButton>
                            </Card.Body>
                        </Card>
                    </Tab>
                    <Tab eventKey="voted" title="Голосование">
                        <br/>
                        <Card style={{ width: '18rem' }}>
                            <Card.Header>
                                <Col>
                                    <Row className="justify-content-md-between">
                                        <small>Политическая</small>
                                        <small>06.06.2020</small>
                                    </Row>
                                </Col>
                            </Card.Header>
                            <Card.Body>
                                <Card.Title>Увеличить финансирование</Card.Title>
                                <Card.Text>
                                    Предлагаю увеличить финансирование бюджетных организаций в связи с нехваткой
                                    соответствующей техники для работы
                                </Card.Text>
                                <Col>
                                    <Row className="justify-content-md-between">
                                        <Button variant="outline-success" block size="sm">Да</Button>
                                        <Button variant="outline-danger" block size="sm">Нет</Button>
                                    </Row>
                                </Col>
                            </Card.Body>
                        </Card>
                    </Tab>
                </Tabs>
                <Row>

                    {/*<Card style={{ width: '18rem' }}>
                        <Card.Header>
                            <Col>
                                <Row className="justify-content-md-between">
                                    <small>Общественная</small>
                                    <small>06.06.2020</small>
                                </Row>
                            </Col>
                        </Card.Header>
                        <Card.Body>
                            <Card.Title>Покрасить забор</Card.Title>
                            <Card.Text>
                                Предлагаю покрасить забор, так как старый меня не устраивает
                            </Card.Text>
                            <DropdownButton id="dropdown-basic-button" title="Действия">
                                <Dropdown.Item href="#/action-1">Просмотр</Dropdown.Item>
                                <Dropdown.Item href="#/action-2">Редактировать</Dropdown.Item>
                                <Dropdown.Item href="#/action-3">Удалить</Dropdown.Item>
                            </DropdownButton>
                        </Card.Body>
                    </Card>*/}
                </Row>
            </Container>
        )
    }

}

export default UserInfoTasks;
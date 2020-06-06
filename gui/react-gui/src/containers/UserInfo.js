import React from "react";
import {Col, Container, Row} from "react-bootstrap";
import UserInfoImg from "../components/UserInfoImg";
import UserInfoProfile from "../components/UserInfoProfile";
import UserInfoTasks from "../components/UserInfoTasks";
import UserProgress from "../components/UserProgress";

class UserInfo extends React.Component{
    render() {
        return (
            <Container className="Content">
                <hr/>
                <Row>
                    <Col md="auto">
                        <UserInfoImg/>
                    </Col>
                    <Col>
                        <UserInfoProfile/>
                    </Col>
                </Row>
                <br/>
                <hr/>
                <br/>
                <Row>
                    <Col>
                        <UserProgress/>
                    </Col>
                </Row>
                <br/>
                <hr/>
                <br/>
                <Row>
                    <Col>
                        <UserInfoTasks/>
                    </Col>
                </Row>
            </Container>
        )
    }
}

export default UserInfo;
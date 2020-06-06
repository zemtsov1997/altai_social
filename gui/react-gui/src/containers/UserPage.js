import React from "react";
import {Col, Container, Row} from "react-bootstrap";

import UserMenu from "../components/UserMenu";
import UserInfo from "./UserInfo";

class UserPage extends React.Component {

    render() {
        return (
            <Container className="Content">
                <br/>
                <Row>
                    <Col md="auto">
                        <UserMenu/>
                    </Col>
                    <Col>
                        <UserInfo/>
                    </Col>
                </Row>
                <br/>
            </Container>
        )
    }

}

export default UserPage;
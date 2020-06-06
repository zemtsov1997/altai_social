import React from 'react';
import './Initiative.css';
import avatar from '../../assets/images/user.jpg';
import figure from '../../assets/images/figure.png';

import {Badge, Button, ButtonGroup, Col, Container, Image, Row} from "react-bootstrap";
import like from "../../assets/images/like.png";
import dislike from "../../assets/images/dislike.png";
import Comment from "./Comment";

class Initiative extends React.Component {
  render() {
    return (
      <Container className="InitiativeDetail">
        <div className="media">
          <div className="media-left">
            <Image className="media-object"
                   src={avatar}
                   roundedCircle
            />
          </div>
          <div className="media-body">
            <div className="media-title">
              <h4>Запретить стройку парковки вместо парка отдыха</h4>
            </div>
          </div>
        </div>
        <div>
          <Badge className="rounded-inline-btn mb-1" variant="primary" size="sm">Строительство</Badge>
          <Badge className="rounded-inline-btn mb-1" variant="primary" size="sm">Центральный район</Badge>
          <Badge className="rounded-inline-btn mb-1" variant="primary" size="sm">Снос</Badge>
          <Badge className="rounded-inline-btn mb-1" variant="primary" size="sm">Общество</Badge>
          <Badge className="rounded-inline-btn mb-1" variant="primary" size="sm">Природа</Badge>
          <Badge className="rounded-inline-btn mb-1" variant="primary" size="sm">Экология</Badge>
        </div>
        <div className="media-font-small">
          <p>
            На улице парковой хотят построить парковку для бизнес-центра, при этом срубив весь парк!
            Не будьте пассивными в решении данного вопроса. От вашего участия зависит, убережем ли
            мы родной парк.
          </p>
          <p>
            Взамен предлагаю выделить незастроенную никакакими объектами территорию лесополосы
            находящуюся в 100 метрах от БЦ.
          </p>
          <p>
            На фотографии прикладываю проект планируемой парковки.
          </p>
        </div>
        <Image
          width="100%"
          height="200px"
          src={figure}
        />
        <h4 className="caption-blue text-center mt-4">Отдай голос за свой выбор</h4>
        <ButtonGroup style={{width: '100%'}}>
          <Button style={{width: '50%'}} type="submit" variant="success">Я за</Button>
          <Button style={{width: '50%'}} variant="danger">Я против</Button>
        </ButtonGroup>
        <Row>
          <Col md={6} className="text-center">
            31
            <Image className="evaluation-image"
                   src={like}
                   roundedCircle
            />
          </Col>
          <Col md={6} className="text-center">
            10
            <Image className="evaluation-image"
                   src={dislike}
                   roundedCircle
            />
          </Col>
        </Row>
        <h4 className="caption-blue text-left ml-4 mt-4" style={{width: '100%'}}>Комментарии</h4>
        <Comment author={'Иван Медведев'}
                 content={'У нас есть другой актуальный вопрос?'}
                 date={'Сегодня'}/>
        <Comment author={'Геннадий Филиппов'}
                 content={'Даже не знаю как проголосовать'}
                 date={'Сегодня'}/>

        <Button variant="outline-primary" block>Показать еще 10 комментариев</Button>
      </Container>
    )
  }
}

export default Initiative;
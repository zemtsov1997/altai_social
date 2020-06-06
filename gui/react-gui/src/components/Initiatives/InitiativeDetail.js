import React from 'react';
import './Initiative.css';
import avatar from '../../assets/images/user.jpg';
import figure from '../../assets/images/figure.png';

import {Button, Container, Figure, Image} from "react-bootstrap";

class Initiative extends React.Component {
  render() {
    return (
      <Container className="InitiativeDetail">
        <div className="media">
          <div className="media-left">
            <Image className="media-object"
                   src={avatar}
                   alt="Аватар"
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
          <Button className="rounded-inline-btn mb-2" variant="primary" size="sm">Строительство</Button>
          <Button className="rounded-inline-btn mb-2" variant="primary" size="sm">Центральный район</Button>
          <Button className="rounded-inline-btn mb-2" variant="primary" size="sm">Снос</Button>
          <Button className="rounded-inline-btn mb-2" variant="primary" size="sm">Общество</Button>
          <Button className="rounded-inline-btn mb-2" variant="primary" size="sm">Природа</Button>
          <Button className="rounded-inline-btn mb-2" variant="primary" size="sm">Экология</Button>
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
        <Figure>
          <Figure.Image
            width="100%"
            height="200px"
            src={figure}
          />
        </Figure>
      </Container>
    )
  }
}

export default Initiative;
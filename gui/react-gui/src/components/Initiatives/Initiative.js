import React from 'react';
import './Initiative.css';
import avatar from '../../assets/images/user.jpg';
import {Image} from "react-bootstrap";

class Initiative extends React.Component {
  render() {
    const {title, content, date, author} = this.props;

    return (
      <div className="Initiative">
        <div className="media media-font-small">
          <figure className="media-left-small">
            <Image className="media-object"
                   src={avatar}
                   alt="Аватар"
                   roundedCircle
            />
            <figcaption>{author}</figcaption>
          </figure>
          <div className="media-body">
            <div className="media-title">
              {title}
            </div>
            <div className="media-text">
              {content}
            </div>
            <div className="media-date">
              <span className="date">{date}</span>
            </div>
          </div>
        </div>
        <hr/>
      </div>
    )
  }
}

export default Initiative;
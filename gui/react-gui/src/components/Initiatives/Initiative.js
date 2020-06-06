import React from 'react';
import './Initiative.css';
import avatar from '../../assets/images/user.jpg';
import like from '../../assets/images/like.png';
import dislike from '../../assets/images/dislike.png';
import {Image} from "react-bootstrap";

class Initiative extends React.Component {
  render() {
    const {title, content, date, author, likes, dislikes} = this.props;

    return (
      <div className="Initiative">
        <div className="media media-font-small">
          <figure className="media-left-small">
            <Image className="media-object"
                   src={avatar}
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
            <div className="media-date" style={{float: 'left'}}>
              <span className="date">{date}</span>
            </div>
            <div style={{float: 'right'}}>
              {likes}
              <Image className="evaluation-image"
                     src={like}
                     roundedCircle
              />
              {dislikes}
              <Image className="evaluation-image"
                     src={dislike}
                     roundedCircle
              />
            </div>
          </div>
        </div>
        <hr/>
      </div>
    )
  }
}

export default Initiative;
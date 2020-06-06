import React from 'react';
import './Initiative.css';
import avatar from '../../assets/images/user.jpg';
import {Image} from "react-bootstrap";

class Initiative extends React.Component {
  render() {
    const {content, date, author} = this.props;

    return (
      <div className="Initiative">
        <div className="media media-font-small">
          <Image className="media-object"
                 src={avatar}
                 width="50px"
                 roundedCircle
          />
          <div className="media-body">
            <div className="media-title">
              {author}
            </div>
            <div className="media-text">
              {content}
            </div>
            <div className="media-date" style={{float: 'left'}}>
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
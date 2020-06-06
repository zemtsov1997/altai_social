import React from 'react';
import {Map, YMaps} from "react-yandex-maps";

class CustomMap extends React.Component {
  render() {
    return (
      <div>
        <YMaps>
          <Map height="500px" width="100%" defaultState={{center: [53.346785, 83.776856], zoom: 9}}/>
        </YMaps>
      </div>
    )
  };
}

export default CustomMap;

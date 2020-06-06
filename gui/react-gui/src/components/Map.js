import React from 'react';
import {GoogleMap, withGoogleMap, withScriptjs} from "react-google-maps";

class Map extends React.Component {
  render() {
    return (
      <GoogleMap
        defaultZoom={16}
        defaultCenter={{lat: 56.140775, lng: 47.249378}}
      />
    )
  };
}

const WrappedMap = withScriptjs(withGoogleMap(Map));

export default WrappedMap;

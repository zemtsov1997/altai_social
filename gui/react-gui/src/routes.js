import React from "react";
import {Route, Switch} from "react-router-dom";
import Error404 from "./components/Error404";
import Content from "./containers/Content";

const BaseRouter = () => (
  <div>
    <Switch>
      <Route exact path="/" component={Content}/>
      <Route component={Error404}/>
    </Switch>
  </div>
);

export default BaseRouter;
import React from "react";
import {Route, Switch} from "react-router-dom";
import Error404 from "./components/Error404";
import Content from "./containers/Content";
import UserPage from "./containers/UserPage";

const BaseRouter = () => (
  <div>
    <Switch>
        <Route exact path="/" component={Content}/>
        <Route exact path="/user/page" component={UserPage}/>
        <Route component={Error404}/>
    </Switch>
  </div>
);

export default BaseRouter;
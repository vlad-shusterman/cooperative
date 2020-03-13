import React from 'react';
import {Route, Router} from 'react-router';
import createBrowserHistory from './helpers/history';
import './App.css';
import {Requisites} from "./components/requisites/Requisities";
import {Register} from "./components/register/Register";
import MailSender from "./components/notifications/components/MailSender";

function App() {
  return (
      <Router history={createBrowserHistory}>
          <Route path='/requisites' component={Requisites}/>
        <Route path='/register' component={Register}/>
        <Route path='/notifications' component={MailSender}/>
      </Router>
  );
}

export default App;

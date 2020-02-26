import React from 'react';
import {Router, Route} from 'react-router';
import createBrowserHistory from './helpers/history';
import './App.css';
import {Requisites} from "./components/requisites/Requisities";
import {Register} from "./components/register/Register";

function App() {
  return (
      <Router history={createBrowserHistory}>
          <Route path='/requisites' component={Requisites}/>
        <Route path='/register' component={Register}/>
      </Router>
  );
}

export default App;

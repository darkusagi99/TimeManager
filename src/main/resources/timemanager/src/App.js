import React, { Component } from 'react';

import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';

import Users from './user/userlist';
import CreateUser from './user/createuser';
import UpdateUser from './user/updateuser';
import People from './people/peoplelist';
import CreatePeople from './people/createpeople';
import UpdatePeople from './people/updatepeople';
import Presence from './presence/presencelist';
import CreatePresence from './presence/createpresence';
import UpdatePresence from './presence/updatepresence';
import CreateFastPresence from './presence/createpresencefast';
import ReportPresence from './report/monthreport';
import logo from './logo.svg';
import './App.css';

class App extends Component {

      render() {
        return (
          <Router>
            <div className="container">
              <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <Link to={'/'} className="navbar-brand">TimeManager</Link>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                  <ul className="navbar-nav mr-auto">
                    <li className="nav-item">
                      <Link to={'/user/create'} className="nav-link">Create User</Link>
                    </li>
                    <li className="nav-item">
                      <Link to={'/user/list'} className="nav-link">View Users</Link>
                    </li>
                    <li className="nav-item">
                      <Link to={'/user/update'} className="nav-link">Update User</Link>
                    </li>
                    <li className="nav-item">
                      <Link to={'/people/create'} className="nav-link">Create People</Link>
                    </li>
                    <li className="nav-item">
                      <Link to={'/people/list'} className="nav-link">View People</Link>
                    </li>
                    <li className="nav-item">
                      <Link to={'/people/update'} className="nav-link">Update People</Link>
                    </li>
                    <li className="nav-item">
                      <Link to={'/presence/create'} className="nav-link">Create Presence</Link>
                    </li>
                    <li className="nav-item">
                      <Link to={'/presence/list'} className="nav-link">View Presence</Link>
                    </li>
                    <li className="nav-item">
                      <Link to={'/presence/update'} className="nav-link">Update Presence</Link>
                    </li>
                    <li className="nav-item">
                      <Link to={'/presence/updateShort'} className="nav-link">Update Presence - Short</Link>
                    </li>
                    <li className="nav-item">
                      <Link to={'/report/month'} className="nav-link">Month Report</Link>
                    </li>
                  </ul>
                </div>
              </nav> <br/>
              <h2>Welcome to React CRUD Tutorial</h2> <br/>
              <Switch>
                  <Route path='/user/create' component={ CreateUser } />
                  <Route path='/user/list' component={ Users } />
                  <Route path='/user/update' component={ UpdateUser } />
                  <Route path='/people/create' component={ CreatePeople } />
                  <Route path='/people/list' component={ People } />
                  <Route path='/people/update' component={ UpdatePeople } />
                  <Route path='/presence/create' component={ CreatePresence } />
                  <Route path='/presence/list' component={ Presence } />
                  <Route path='/presence/update' component={ UpdatePresence } />
                  <Route path='/presence/updateShort' component={ CreateFastPresence } />
                  <Route path='/report/month' component={ ReportPresence } />
              </Switch>
            </div>
          </Router>
        );
      }
}

    export default App;

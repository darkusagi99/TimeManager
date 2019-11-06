import React, { Component } from 'react'
import { Link } from 'react-router-dom';

class People extends Component {
                constructor(props) {
                  super(props);
                  this.state = { users: [] };
                }

                componentDidMount() {
                    fetch('http://localhost:8080/user/list')
                    .then(res => res.json())
                    .then((data) => {
                        this.setState({ users: data })
                    })
                    .catch(console.log)
                }

                render() {
                    return (
                        <div>
                            <center><h1>People </h1></center>

                            <div>
                                <Link to={'/people/create'} className="nav-link">Create People</Link>
                            </div>

                            {this.state.users.map((user) => (
                                <div class="card">
                                <div class="card-body">
                                <h5 class="card-title">{user.id}</h5>
                                <h6 class="card-subtitle mb-2 text-muted">{user.email}</h6>
                                <p class="card-text">{user.fullname}</p>

                                <Link to={'/people/update/' + user.id} className="nav-link">Update People</Link>
                            </div>
                        </div>
                        ))}
                        </div>
                    )
                }
     };


    export default People
import React, { Component } from 'react'
import { Link } from 'react-router-dom';

class People extends Component {
                constructor(props) {
                  super(props);
                  this.state = { peoples: [] };
                }

                componentDidMount() {
                    fetch('http://localhost:8080/people/list')
                    .then(res => res.json())
                    .then((data) => {
                        this.setState({ peoples: data })
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

                            {this.state.peoples.map((people) => (
                                <div class="card">
                                    <div class="card-body">
                                    <h5 class="card-title">{people.id}</h5>
                                    <p class="card-text">{people.fullname}</p>

                                    <Link to={'/people/update/' + people.id} className="nav-link">Update People</Link>
                                     </div>
                                </div>
                            ))}
                        </div>
                    )
                }
     };


    export default People
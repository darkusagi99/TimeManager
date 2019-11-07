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

                            <table class="table">
                                <tbody>
                                    {this.state.peoples.map((people) => (
                                        <tr>
                                            <td>{people.fullname}</td>

                                            <td>Morning : {people.standardArrival.join(' ')}</td>

                                            <td>Evening : {people.standardDeparture.join(' ')}</td>

                                            <td>Meal : {people.standardMeal.join(' ')}</td>

                                            <td><Link to={'/people/update/' + people.id} className="nav-link">Update People</Link></td>
                                        </tr>
                                    ))}
                                </tbody>
                            </table>

                        </div>
                    )
                }
     };


    export default People
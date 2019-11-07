import React, { Component } from 'react'
import { Link } from 'react-router-dom';

class Presence extends Component {

        constructor(props) {
          super(props);
          this.state = { presences: [] };
        }

        componentDidMount() {
            fetch('http://localhost:8080/presence/list')
            .then(res => res.json())
            .then((data) => {
                this.setState({ presences: data })
            })
            .catch(console.log)
        }

        render() {
            return (
                <div>
                    <center><h1>Presence</h1></center>

                    <div>
                        <Link to={'/presence/create'} className="nav-link">Create Presence</Link>
                    </div>

                    {this.state.presences.map((presence) => (
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">{presence.id}</h5>
                                <h6 class="card-subtitle mb-2 text-muted">{presence.personId}</h6>

                                <Link to={'/presence/update/' + presence.presence} className="nav-link">Update Presence</Link>
                            </div>
                        </div>
                     ))}
                </div>
            )
        }
     };


    export default Presence
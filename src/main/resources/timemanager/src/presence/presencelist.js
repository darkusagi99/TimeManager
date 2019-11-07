import React, { Component } from 'react'
import { Link } from 'react-router-dom';

class Presence extends Component {

        constructor(props) {
          super(props);
          this.state = { presences: [],
                        peoples: []};
        }

        componentDidMount() {
            fetch('http://localhost:8080/presence/list')
            .then(res => res.json())
            .then((data) => {
                this.setState({ presences: data })
            })
            .catch(console.log)


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
                    <center><h1>Presence</h1></center>

                    <div>
                        <Link to={'/presence/create'} className="nav-link">Create Presence</Link>
                    </div>

                     <table class="table">
                     <thead>
                         <tr>
                               <th scope="col">Name</th>
                               <th scope="col">Day</th>
                               <th scope="col">Arrival</th>
                               <th scope="col">Departure</th>
                               <th scope="col">Meal</th>
                               <th scope="col">&nbsp;</th>
                         </tr>
                     </thead>
                     <tbody>
                     {this.state.presences.map((presence) => (
                         <tr>
                             <td>{this.state.peoples.filter((people) => (people.id == presence.personId)).map((people) => people.fullname)}</td>
                             <td>{presence.presenceDay}</td>
                             <td>{presence.arrival}</td>
                             <td>{presence.departure}</td>
                             <td>{presence.hasMeal}</td>

                             <Link to={'/presence/update/' + presence.presence} className="nav-link">Update Presence</Link>
                         </tr>
                     ))}
                     </tbody>
                     </table>


                </div>
            )
        }
     };


    export default Presence
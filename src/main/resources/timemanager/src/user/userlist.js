import React, { Component } from 'react'


    class Users extends Component {

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
                    <center><h1>User List</h1></center>
                    {this.state.users.map((user) => (
                        <div class="card">
                        <div class="card-body">
                        <h5 class="card-title">{user.id}</h5>
                        <h6 class="card-subtitle mb-2 text-muted">{user.email}</h6>
                        <p class="card-text">{user.fullname}</p>
                    </div>
                </div>
                ))}
                </div>
            )
        }
    };


    export default Users


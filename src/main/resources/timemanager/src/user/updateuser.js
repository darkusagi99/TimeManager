import React, { Component } from 'react'
import axios from 'axios'

class UpdateUser extends Component {

        constructor(props) {
                  super(props);
                  this.onChangeName = this.onChangeName.bind(this);
                  this.onChangeEmail = this.onChangeEmail.bind(this);
                  this.onChangePassword = this.onChangePassword.bind(this);
                  this.onSubmit = this.onSubmit.bind(this);

                  this.state = {
                      user_id : '',
                      user_name: '',
                      user_email: '',
                      user_password:''
                  }
              }

              componentDidMount() {
                          fetch('http://localhost:8080/user/' + this.props.match.params.id)
                          .then(res => res.json())
                          .then((data) => {
                              this.setState({
                                user_id: data.id,
                                user_name: data.fullname,
                                user_email: data.email
                              })
                          })
                          .catch(console.log)
              }


              onChangeName(e) {
                this.setState({
                  user_name: e.target.value
                });
              }
              onChangeEmail(e) {
                this.setState({
                  user_email: e.target.value
                })
              }
              onChangePassword(e) {
                this.setState({
                  user_password: e.target.value
                })
              }

              onSubmit(e) {
                e.preventDefault();
                console.log(`The values are ${this.state.user_name}, ${this.state.user_email}, and ${this.state.user_password}`)

                const obj = {
                      id: this.state.user_id,
                      fullname: this.state.user_name,
                      email: this.state.user_email,
                      password: this.state.user_password
                    };
                    axios.post('http://localhost:8080/signup', obj)
                        .then(res => console.log(res.data));

                this.setState({
                  user_name: '',
                  user_email: '',
                  user_password: ''
                })
              }

                render() {
                    return (
                        <div style={{marginTop: 10}}>
                            <h3>Update User</h3>
                            <form onSubmit={this.onSubmit}>
                                <div className="form-group">
                                    <label>Name:  </label>
                                    <input type="text"
                                            className="form-control"
                                            value={this.state.user_name}
                                            onChange={this.onChangeName}/>
                                </div>
                                <div className="form-group">
                                    <label>Email: </label>
                                    <input type="text"
                                            className="form-control"
                                            value={this.state.user_email}
                                            onChange={this.onChangeEmail}/>
                                </div>
                                <div className="form-group">
                                    <label>Password: </label>
                                    <input type="text"
                                            className="form-control"
                                            value={this.state.user_password}
                                            onChange={this.onChangePassword}/>
                                </div>
                                <div className="form-group">
                                    <input type="submit" value="Save" className="btn btn-primary"/>
                                </div>
                            </form>
                        </div>
                    )
                }
             };


    export default UpdateUser
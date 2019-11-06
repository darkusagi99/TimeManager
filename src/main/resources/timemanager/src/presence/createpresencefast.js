import React, { Component } from 'react'

class CreateFastPresence extends Component {
        render() {
            return (
                <div style={{marginTop: 10}}>
                    <h3>Create Presence - fast</h3>
                    <form>
                        <div className="form-group">
                            <label>Name:  </label>
                            <input type="text" className="form-control"/>
                        </div>
                        <div className="form-group">
                            <label>Email: </label>
                            <input type="text" className="form-control"/>
                        </div>
                        <div className="form-group">
                            <label>Password: </label>
                            <input type="text" className="form-control"/>
                        </div>
                        <div className="form-group">
                            <input type="submit" value="Save" className="btn btn-primary"/>
                        </div>
                    </form>
                </div>
            )
        }
     };


    export default CreateFastPresence
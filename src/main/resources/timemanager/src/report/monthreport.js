import React, { Component } from 'react'

class ReportPresence extends Component {

        constructor(props) {

                  super(props);

                  this.state = {
                      presenceId : '',
                      personId : '',
                      selectedDate : new Date(),
                      arrivalTime : new Date(),
                      depatureTime : new Date(),
                      hasMeal : false,
                      peoples: [],
                      previousPresence: ''
                  }

        }


        getDaysInMonth = (month, year) => (new Array(31)).fill('').map((v,i)=>new Date(year,month-1,i+1)).filter(v=>v.getMonth()===month-1)

        render() {
            return (
                <div style={{marginTop: 10}}>
                    <h3>Report Presence</h3>
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

                        {this.getDaysInMonth(2019, 10).map((dayInMonth) => (
                                 "<h6>{dayInMonth.toLocaleDateString()}</h6>"
                         ))}

                    </form>
                </div>
            )
        }
     };


    export default ReportPresence
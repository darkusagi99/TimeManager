import React, { Component } from 'react'
import axios from 'axios';

class CreatePeople extends Component {


    constructor(props) {
          super(props);
          this.onChangeName = this.onChangeName.bind(this);
          this.onButtonArrivalChange = this.onButtonArrivalChange.bind(this);
          this.onButtonDepartureChange = this.onButtonDepartureChange.bind(this);
          this.onButtonMealChange = this.onButtonMealChange.bind(this);
          this.onSubmit = this.onSubmit.bind(this);

          this.state = {
              fullname : '',
              standardArrival: new Map(),
              standardDeparture: new Map(),
              standardMeal: new Map()
          }
      }


      onChangeName(e) {
        this.setState({
          fullname : e.target.value
        });
      }

      /** Méthode permettznt de gérer les changements du niveau des boutons - A mutualiser */
      onButtonArrivalChange(e) {
            const item = e.target.value;
            e.target.classList.toggle('active');
            const active = e.target.classList.contains('active');
            this.state.standardArrival.set(item, active);
      }
      onButtonDepartureChange(e) {
            const item = e.target.value;
            e.target.classList.toggle('active');
            const active = e.target.classList.contains('active');
            this.state.standardDeparture.set(item, active);
      }
      onButtonMealChange(e) {
            const item = e.target.value;
            e.target.classList.toggle('active');
            const active = e.target.classList.contains('active');
            this.state.standardMeal.set(item, active);
      }


      onSubmit(e) {
              e.preventDefault();
                  console.log(`The values are ${this.state.fullname}, ${this.state.standardArrival}`)

              const obj = {
                    fullname: this.state.fullname,
                    standardArrival: this.state.standardArrival,
                    standardDeparture: this.state.standardDeparture,
                    standardMeal: this.state.standardMeal
                  };
                  //axios.put('http://localhost:8080/people/create', obj)
                  //    .then(res => console.log(res.data));

              this.setState({
                    fullname: '',
                    standardArrival: [],
                    standardDeparture: [],
                    standardMeal: []
              })
      }


        render() {
            return (
                <div style={{marginTop: 10}}>
                    <h3>Create People</h3>
                    <form onSubmit={this.onSubmit}>
                        <div className="form-group">
                            <label>Name:  </label>
                            <input type="text"
                                className="form-control"
                                value={this.state.user_name}
                                onChange={this.onChangeName} />
                        </div>
                        <div className="form-group">
                            <div class="btn-group" role="group" aria-label="Basic example">
                                <button type="button" class="btn btn-light disabled">Morning</button>
                                <button type="button" class="btn btn-secondary" value="Monday"  onClick={this.onButtonArrivalChange} >Monday</button>
                                <button type="button" class="btn btn-secondary" value="Tuesday"  onClick={this.onButtonArrivalChange} >Tuesday</button>
                                <button type="button" class="btn btn-secondary" value="Thursday"  onClick={this.onButtonArrivalChange} >Thursday</button>
                                <button type="button" class="btn btn-secondary" value="Friday"  onClick={this.onButtonArrivalChange} >Friday</button>
                            </div>
                        </div>
                        <div className="form-group">
                            <div class="btn-group" role="group" aria-label="Basic example">
                                <button type="button" class="btn btn-light disabled">Evening</button>
                                <button type="button" class="btn btn-secondary" value="Monday"  onClick={this.onButtonDepartureChange} >Monday</button>
                                <button type="button" class="btn btn-secondary" value="Tuesday"  onClick={this.onButtonDepartureChange} >Tuesday</button>
                                <button type="button" class="btn btn-secondary" value="Thursday"  onClick={this.onButtonDepartureChange} >Thursday</button>
                                <button type="button" class="btn btn-secondary" value="Friday"  onClick={this.onButtonDepartureChange} >Friday</button>
                            </div>
                        </div>
                        <div className="form-group">
                            <div class="btn-group" role="group" aria-label="Basic example">
                                <button type="button" class="btn btn-light disabled">Meal</button>
                                <button type="button" class="btn btn-secondary" value="Monday"  onClick={this.onButtonMealChange} >Monday</button>
                                <button type="button" class="btn btn-secondary" value="Tuesday"  onClick={this.onButtonMealChange} >Tuesday</button>
                                <button type="button" class="btn btn-secondary" value="Thursday"  onClick={this.onButtonMealChange} >Thursday</button>
                                <button type="button" class="btn btn-secondary" value="Friday"  onClick={this.onButtonMealChange} >Friday</button>
                            </div>
                        </div>
                        <div className="form-group">
                            <input type="submit" value="Save" className="btn btn-primary"/>
                        </div>
                    </form>
                </div>
            )
        }
     };


    export default CreatePeople
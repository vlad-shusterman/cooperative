import React from 'react';
import axios from 'axios';

class NewMeter extends React.PureComponent {
    state = {
        person: 0,
        personList: [],
    }

    componentDidMount = () => {
        return axios.get(`http://localhost:8080/api/person`)
        .then(({ data }) => {
          this.setState({ personList: data, person: data[0].id })
        }).catch(res => {
            console.log(res) 
        })
    }

    saveModel = async event => {
        event.preventDefault()
        console.log(this.state)

        await axios.post(`http://localhost:8080/api/metres/heat`, 
            { 
                number: this.state.heat,
                person: {
                    id: this.state.person
                }
            })
        .then((data) => {
          console.log(data)
        }).catch(res => {
            console.log(res) 
        })

        await axios.post(`http://localhost:8080/api/metres/electric`, 
            { 
                number: this.state.electric,
                transformationRatio: this.state.transformationRatio,
                person: {
                    id: this.state.person
                }
            })
        .then((data) => {
          console.log(data)
        }).catch(res => {
            console.log(res) 
        })

        await axios.post(`http://localhost:8080/api/metres/water`, 
            { 
                number: this.state.hot,
                waterMeterType: 'HOT', 
                person: {
                    id: this.state.person
                }
            })
        .then((data) => {
          console.log(data)
        }).catch(res => {
            console.log(res) 
        })

        await axios.post(`http://localhost:8080/api/metres/water`, 
            { 
                number: this.state.cold,
                waterMeterType: 'COLD', 
                person: {
                    id: this.state.person
                }
            })
        .then((data) => {
          console.log(data)
        }).catch(res => {
            console.log(res) 
        })
    }

    updateValue = (type, e) => {
        this.setState({
            [type]: e.target.value
        })
    }

    render() {
        return <div className="container mt-5">
                    <div className="row mt-3">
                        <div className="col-md-12">
                            <form>
                                <div className="form-group row">
                                    <div className="col-md-6">
                                        <label htmlFor="type" className="col-sm-2 col-form-label">ФИО</label>
                                        <select className="form-control" id="type" onChange={(value) => this.updateValue('person', value)}>
                                            {this.state.personList && this.state.personList.map(person => {
                                                return <option 
                                                    key={person.id} 
                                                    value={person.id}>
                                                        {`${person.surname} ${person.name} ${person.lastName}`}</option>
                                            })}
                                        </select>
                                    </div>     
                                </div>
                                <div className="form-group">
                                    <label htmlFor="exampleInputPassword1">Теплосчетчик</label>
                                    <div className="input-group mb-3 col-md-6">
                                        <div className="input-group-prepend">
                                            <span className="input-group-text">№</span>
                                        </div>
                                        <input type="text" className="form-control" onChange={(e) => this.updateValue('heat', e)}/>
                                    </div>
                                </div>
                                <div className="form-group">
                                    <label htmlFor="exampleInputPassword1">Энергосчетчик</label>
                                    <div className="input-group mb-3 col-md-6">
                                        <div className="input-group-prepend">
                                            <span className="input-group-text">№</span>
                                        </div>
                                        <input type="text" className="form-control" onChange={(e) => this.updateValue('electric', e)}/>
                                    </div>
                                </div>
                                <div className="form-group">
                                    <label htmlFor="exampleInputPassword1">Коэффициент трансформации</label>
                                    <div className="input-group mb-3 col-md-6">
                                        <input type="text" className="form-control" onChange={(e) => this.updateValue('transformationRation', e)}/>
                                    </div>
                                </div>
                                <div className="form-group">
                                    <label htmlFor="exampleInputPassword1">Счетчик воды (Холодная)</label>
                                    <div className="input-group mb-3 col-md-6">
                                        <div className="input-group-prepend">
                                            <span className="input-group-text">№</span>
                                        </div>
                                        <input type="text" className="form-control" onChange={(e) => this.updateValue('cold', e)}/>
                                    </div>
                                </div>
                                <div className="form-group">
                                    <label htmlFor="exampleInputPassword1">Счетчик воды (Горочая)</label>
                                    <div className="input-group mb-3 col-md-6">
                                        <div className="input-group-prepend">
                                            <span className="input-group-text">№</span>
                                        </div>
                                        <input type="text" className="form-control" onChange={(e) => this.updateValue('hot', e)}/>
                                    </div>
                                </div>
                                <button type="submit" className="btn btn-primary" onClick={(e) => this.saveModel(e)}>Добавить</button>
                            </form>
                        </div>
                    </div>
                </div>
    }
}

export default NewMeter
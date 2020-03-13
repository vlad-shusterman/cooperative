import React from 'react';
import EnergyTableForm from './energyTableForm.js'

import axios from 'axios';

class EnergyTableContainer extends React.PureComponent {
    state = {
        dataList: [],
        data: {},
        type: 'heat',
    }

    getData = (type, page = 0) => {
        console.log(type)
        return axios.get(`http://localhost:8080/api/energy/${type}?page=${page}`)
        .then(({ data }) => {
          const dataList = data.content
          this.setState({ dataList, type, data })
        }).catch(res => {
            console.log(res) 
        })
    }

    render() {
        return <EnergyTableForm 
                    dataList={this.state.dataList} 
                    onChangeTab={this.getData} 
                    type={this.state.type} 
                    data={this.state.data}
                />
    }
}

export default EnergyTableContainer;
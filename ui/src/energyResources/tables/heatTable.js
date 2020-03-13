import React from 'react';
import { Table } from 'react-bootstrap';

class HeatTable extends React.PureComponent {
    render() {
        return <Table striped bordered hover size="sm">
        <thead>
          <tr>
            <th>№ счётчика</th>
            <th>ФИО</th>
            <th>Показания счётчика на месяц</th>
            <th>Дата последней поверки</th>
          </tr>
        </thead>
        <tbody>
            {this.props.type === 'heat' && this.props.data && this.props.data.map((record, index) => {
                return <tr key={index}>
                <td>{record.heatMeter.number}</td>
                <td>{`${record.heatMeter.person.surname} ${record.heatMeter.person.name} ${record.heatMeter.person.lastName}`}</td>
                <td>{record.value}</td>
                <td>{record.readingDate}</td>
              </tr>
            })}
        </tbody>
      </Table>
    }
}

export default HeatTable;

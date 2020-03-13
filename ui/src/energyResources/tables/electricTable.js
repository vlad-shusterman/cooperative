import React from 'react';
import { Table } from 'react-bootstrap';

class ElectricTable extends React.PureComponent {
    render() {
        return <Table striped bordered hover size="sm">
        <thead>
          <tr>
            <th>№ счётчика</th>
            <th>ФИО</th>
            <th>Показания счётчика на месяц</th>
            <th>Коэффициент трансформации</th>
            <th>Дата последней поверки</th>
          </tr>
        </thead>
        <tbody>
            {this.props.type === 'electric' && this.props.data && this.props.data.map((record, index) => {
                return <tr key={index}>
                <td>{record.electricMeter.number}</td>
                <td>{`${record.electricMeter.person.surname} ${record.electricMeter.person.name} ${record.electricMeter.person.lastName}`}</td>
                <td>{record.value}</td>
                <td>{record.electricMeter.transfarmationRatio}</td>
                <td>{record.readingDate}</td>
              </tr>
            })}
        </tbody>
      </Table>
    }
}

export default ElectricTable;

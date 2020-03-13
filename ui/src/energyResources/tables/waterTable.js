import React from 'react';
import { Table } from 'react-bootstrap';

class WaterTable extends React.PureComponent {
    render() {
        return <Table striped bordered hover size="sm">
        <thead>
          <tr>
            <th>№ счётчика</th>
            <th>ФИО</th>
            <th>Показания счётчика на месяц</th>
            <th>Дата последней поверки</th>
            <th>Тип (горячая/холодная)</th>
          </tr>
        </thead>
        <tbody>
          {this.props.type === 'water' && this.props.data && this.props.data.map((record, index) => {
                return <tr key={index}>
                <td>{record.waterMeter.number}</td>
                <td>{`${record.waterMeter.person.surname} ${record.waterMeter.person.name} ${record.waterMeter.person.lastName}`}</td>
                <td>{record.value}</td>
                <td>{record.readingDate}</td>
                <td>{record.waterMeter.waterMeterType}</td>
              </tr>
            })}
        </tbody>
      </Table>
    }
}

export default WaterTable;

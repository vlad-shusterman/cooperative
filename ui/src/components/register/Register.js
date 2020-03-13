import React, { useState, useEffect } from 'react'
import { Table } from 'reactstrap'
import {
  TabContent,
  TabPane,
  Nav,
  NavItem,
  NavLink,
  Card,
  Button,
  CardTitle,
  CardText,
  Row,
  Col,
} from 'reactstrap'
import { Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap'
import classnames from 'classnames'
import { InputGroup, InputGroupAddon, InputGroupText, Input } from 'reactstrap'
import RegisterService from './services/RegisterService'
import PropertiesService from './services/PropertiesService'
import TrustService from "./services/TrustService";
import PersonService from "./services/PersonService";

export const Register = () => {

  const [property, setProperty] = useState({});

  const [ownersFilter, setOwnersFilter] = useState('')
  const [trustsFilter, setTrustsFilter] = useState('')
  const [owner, setOwner] = useState({passportData:{}});
  const [owners, setOwners] = useState([])
  const [persons, setPersons] = useState(new Map());
  const [trusts, setTrusts] = useState([])
  const [properties, setProperties] = useState([])
  const [activeTab, setActiveTab] = useState('1')
  const [propertyModal, setPropertyModal] = useState(false)
  const [ownerModal, setOwnerModal] = useState(false)

  const togglePropertyModal = () => setPropertyModal(!propertyModal)
  const toggleOwnerModal = () => setOwnerModal(!ownerModal)

  const toggleTab = tab => {
    if (activeTab !== tab) setActiveTab(tab)
  }

  const renderTableData = () => {
    const filteredOwners = owners.length > 0 ? owners.filter(owner => owner.fio.includes(ownersFilter) || owner.properties.map(property => property.id)
      .toString().includes(ownersFilter)) : []
    return filteredOwners.map(owner =>
      <tr>
        <td>{owner ? owner.fio : ''}</td>
        <td>{owner ? owner.properties.map(property => property.inventoryNumber)
          .toString() : ''}</td>
      </tr>,
    )
  }

  const renderTrustJournalData = () => {
    const filteredTrusts = trusts.length > 0 ? trusts.filter(trust => trust.from.includes(trustsFilter)
        || trust.to.includes(trustsFilter) || trust.startDate.includes(trustsFilter) || trust.endDate.includes(trustsFilter)) : [];
    return filteredTrusts.map(trust =>
        <tr>
          <td>{trust.from}</td>
          <td>{trust.to}</td>
          <td>{trust.startDate}</td>
          <td>{trust.endDate}</td>
        </tr>,
    )
  }

  const renderRegisterTable = () => {
    return (
      <div>
        <InputGroup>
          <Input placeholder="Фильтр" value={ownersFilter} onChange={e => setOwnersFilter(e.target.value)}/>
        </InputGroup>
        <Table striped>
          <thead>
          <tr>
            <th>Собственник</th>
            <th>Недвижимости</th>
          </tr>
          </thead>
          <tbody>
          {renderTableData()}
          </tbody>
        </Table>
      </div>
    )
  }

  const renderPropertyTable = () => {
    return (
      <Table striped>
        <thead>
        <tr>
          <th>Инвентарный номер</th>
          <th>Площадь</th>
        </tr>
        </thead>
        <tbody>
        {renderPropertyTableData()}
        </tbody>
        <Button color="primary" onClick={togglePropertyModal}>Добавить недвижимость</Button>
      </Table>
    )
  }

  const renderOwnersTable = () => {
    return (
      <Table striped>
        <thead>
        <tr>
          <th>ФИО</th>
          <th>Паспортные данные</th>
          <th>Моб. Телефон</th>
          <th>Домащний телефон</th>
          <th>Почка</th>
          <th>Скайп</th>
          <th>Выданные доверенности</th>
        </tr>
        </thead>
        <tbody>
        {renderOwnersTableData()}
        </tbody>
        <Button color="primary" onClick={toggleOwnerModal}>Добавить владельца</Button>
      </Table>
    )
  }

  const renderPropertyTableData = () => {
    return properties.map(property =>
      <tr>
        <td>{property.number}</td>
        <td>{property.square}</td>
      </tr>,
    )
  }

  const renderOwnersTableData = () => {
    if (owners.length > 0) {
      return owners.map(owner =>
        <tr>
          <td>{owner ? owner.fio : ''}</td>
          <td>{owner ? owner.passportData : ''}</td>
          {/*<td>{owner.mobilePhone}</td>*/}
          {/*<td>{owner.homePhone}</td>*/}
          {/*<td>{owner.email}</td>*/}
          {/*<td>{owner.skype}</td>*/}
          {/*<td>{owner.trusts}</td>*/}
        </tr>,
      )
    }
  }

  const renderPropertyModal = () => {
    return (
      <Modal isOpen={propertyModal} toggle={togglePropertyModal}>
        <ModalHeader toggle={togglePropertyModal}>Недвижимость</ModalHeader>
        <ModalBody>
          <InputGroup>
            <Input placeholder="Инвентарный номер" onChange={e => {property.inventoryNumber = e.target.value}} value={property.inventoryNumber}/>
          </InputGroup>
          <InputGroup>
            <Input placeholder="Площадь" onChange={e => {property.square = e.target.value}} value={property.square}/>
          </InputGroup>
          <InputGroup>
            <Input placeholder="Passport data" onChange={e => {property.ownerPassportData = e.target.value}} value={property.passportData}/>
          </InputGroup>
        </ModalBody>
        <ModalFooter>
          <Button color="primary" onClick={() => addPropertyAction(property)}>Добавить</Button>
          <Button color="secondary" onClick={togglePropertyModal}>Закрыть</Button>
        </ModalFooter>
      </Modal>
    )
  }

  const addPropertyAction = (property) => {
    // PersonService.fetchPersons().then((persons) => {
    //   persons.map((person) => {
    //     person.passportData.data === property.ownerPassportData
    //   })
    // })
    addProperty(property).then(() => {
      togglePropertyModal();
      updateProperties();
    });
  }

  const renderOwnerModal = () => {
    return (
      <Modal isOpen={ownerModal} toggle={toggleOwnerModal}>
        <ModalHeader toggle={togglePropertyModal}>Владелец</ModalHeader>
        <ModalBody>
          <InputGroup>
            <Input placeholder="Имя" value={owner.name} onChange={e => {owner.name = e.target.value}}/>
          </InputGroup>
          <InputGroup>
            <Input placeholder="Фамилия" value={owner.surname} onChange={e => {owner.surname= e.target.value}}/>
          </InputGroup>
          <InputGroup>
            <Input placeholder="Last name" value={owner.lastName} onChange={e => {owner.lastName = e.target.value}}/>
          </InputGroup>
          <InputGroup>
            <Input placeholder="Номер паспорта" value={owner.passportData.number} onChange={e => {owner.passportData.number = e.target.value}}/>
          </InputGroup>
          <InputGroup>
            <Input placeholder="data" value={owner.passportData.data} onChange={e => {owner.passportData.data = e.target.value}}/>
          </InputGroup>
          <InputGroup>
            <Input placeholder="issuingAuthority" value={owner.passportData.issuingAuthority} onChange={e => {owner.passportData.issuingAuthority = e.target.value}}/>
          </InputGroup>
          <InputGroup>
            <Input placeholder="personalNumber" value={owner.passportData.personalNumber} onChange={e => {owner.passportData.personalNumber = e.target.value}}/>
          </InputGroup>
        </ModalBody>
        <ModalFooter>
          <Button color="primary" onClick={() => addOwnersAction(owner)}>Добавить</Button>
          <Button color="secondary" onClick={toggleOwnerModal}>Закрыть</Button>
        </ModalFooter>
      </Modal>
    )
  }

  const addOwnersAction = (owner) => {
    owner.documentType='passport';
    PersonService.addPerson(owner).then(() => {
      toggleOwnerModal();
      updateOwners();
    })
  }

  const updateOwners = () => {
    RegisterService.fetchOwners().then((value) => {
      value.data.forEach(owner => {
        RegisterService.fetchOwnerCommunications(owner.personEntity.id)
          .then((communications) => {
            setOwners([...owners, {
              fio: `${owner.personEntity.surname} ${owner.personEntity.name} ${owner.personEntity.lastName}`,
              passportData: owner.personEntity.documentType === 'passport' ? owner.personEntity.passportData : '',
              properties: owner.entities,
              id: owner.personEntity.id,
            }])
          })
      })
    })
  }

  const updatePersons = () => {
    PersonService.fetchPersons().then((value) => {
      value.data.forEach(person => {
        persons.set(person.id, person);
      });
      TrustService.fetchTrusts().then((value) => {
        value.data.forEach(trust => {
          const from = persons.get(trust.proprietorId);
          const to = persons.get(trust.personId);
          setTrusts([...trusts, {
            from: `${from.surname} ${from.name} ${from.lastName}`,
            to: `${to.surname} ${to.name} ${to.lastName}`,
            startDate: new Date(trust.startDate * 1000).toISOString().substring(0, 10),
            endDate: new Date(trust.startDate * 1000 + trust.duration * 24 * 60 * 60 * 1000).toISOString().substring(0, 10)
          }]);
        })
      })
    })
  };

  const updateProperties = () => {
    PropertiesService.fetchProperties().then((value) => {
      let cleanedProperties = value.data.map(property => {
        return {
          number: `${property.inventoryNumber}`,
          square: property.square,
          owners: property.owners,
          part: property.part,
          id: property.id,
        }
      })
      setProperties(cleanedProperties);
    })
  }

  const addProperty = (property) => {
    return PropertiesService.addProperty(property)
  }

  useEffect(() => updateOwners(), [])
  useEffect(() => updatePersons(), [])
  useEffect(() => updateProperties(), [])

  return (
    <Row style={{ width: '100%' }}>
      <Col xs="3">
        <Nav tabs vertical className="ml-3 mt-5">
          <NavItem>
            <NavLink
              className={classnames({ active: activeTab === '1' })}
              onClick={() => {
                toggleTab('1')
              }}
            >
              Реестр
            </NavLink>
          </NavItem>
          <NavItem>
            <NavLink
              className={classnames({ active: activeTab === '2' })}
              onClick={() => {
                toggleTab('2')
              }}
            >
              Журнал доверенностей
            </NavLink>
          </NavItem>
          <NavItem>
            <NavLink
              className={classnames({ active: activeTab === '3' })}
              onClick={() => {
                toggleTab('3')
              }}
            >
              Объекты недвижимости
            </NavLink>
          </NavItem>
          <NavItem>
            <NavLink
              className={classnames({ active: activeTab === '4' })}
              onClick={() => {
                toggleTab('4')
              }}
            >
              Собственники
            </NavLink>
          </NavItem>
        </Nav>
      </Col>
      <Col xs="9">
        <TabContent activeTab={activeTab} className="ml-5 mt-5 mr-2">
          <TabPane tabId="2">
            <InputGroup>
              <Input placeholder="Фильтр" value={trustsFilter} onChange={e => setTrustsFilter(e.target.value)}/>
            </InputGroup>
            <Table striped>
              <thead>
              <tr>
                <th>От кого</th>
                <th>Кому</th>
                <th>Дата начала</th>
                <th>Дата окончания</th>
              </tr>
              </thead>
              <tbody>
              {renderTrustJournalData()}
              </tbody>
            </Table>
          </TabPane>
          <TabPane tabId="1">
            {renderRegisterTable()}
          </TabPane>
          <TabPane tabId="3">
            {renderPropertyTable()}
          </TabPane>
          <TabPane tabId="4">
            {renderOwnersTable()}
          </TabPane>
        </TabContent>
      </Col>
      <div>
        {renderPropertyModal()}
        {renderOwnerModal()}
      </div>
    </Row>
  )
}

import * as React from "react";
import {Button, FormGroup} from "react-bootstrap";
import {Container, Modal, ModalFooter} from "reactstrap";
import Input from "reactstrap/es/Input";
import Form from "react-bootstrap/Form";
import ApiService from "../service/ApiService";
import ModalHeader from "reactstrap/es/ModalHeader";
import ModalBody from "reactstrap/es/ModalBody";

export default class MailSender extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            mailParams: {
                receivers: '',
                subject: '',
                text: '',
                sendingType: 'EMAIL',
                index: ''
            },
            showModal: false
        };

        this.handleChange = this.handleChange.bind(this);
        this.sendMail = this.sendMail.bind(this);
    }

    handleChange({target}) {
        this.setState(prevState => ({
            mailParams: {
                ...prevState.mailParams,
                [target.name]: target.value
            }
        }))
    }

    sendMail() {
        let receivers = this.state.mailParams.receivers;
        let params = this.state.mailParams;
        params.receivers = receivers.split(', ');
        ApiService.sendEmail(params)
            .then(response => {
                if(response.status == 200) {
                    this.setState(prevState => ({
                        mailParams: {
                            ...prevState.mailParams,
                            receivers: '',
                            subject: '',
                            text: '',
                            index: ''
                        },
                        showModal: true
                    }));
                }
            })
    }

    render() {
        return (
            <Container className='col-md-4'>
                <h2>Нотификации</h2>
                <Form>
                    <h3>Отправить сообщение</h3>
                    <FormGroup>
                        <label htmlFor='receivers'>Эл.адрес получателя</label>
                        <Input
                            name='receivers'
                            className='receivers'
                            value={this.state.mailParams.receivers}
                            onChange={this.handleChange}
                        />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor='subject'>Тема</label>
                        <Input
                            name='subject'
                            className='subject'
                            value={this.state.mailParams.subject}
                            onChange={this.handleChange}
                        />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor='emailText'>Тело сообщения</label>
                        <textarea
                            name='text'
                            className='form-control text'
                            value={this.state.mailParams.text}
                            onChange={this.handleChange}
                        />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor='sendingType'>Тип сообщения</label>
                        <select
                            name='sendingType'
                            className='form-control sendingType'
                            value={this.state.mailParams.sendingType}
                            onChange={this.handleChange}
                        >
                            <option value='EMAIL' selected='selected'>Электронное</option>
                            <option value='SIMPLE'>Бумажное</option>
                        </select>
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor='index'>Индекс</label>
                        <Input
                            name='index'
                            className='index'
                            value={this.state.mailParams.index}
                            onChange={this.handleChange}
                        />
                    </FormGroup>
                    <Button
                        type='button'
                        onClick={this.sendMail}
                    >Отправить</Button>
                </Form>
                    <Modal isOpen={this.state.showModal}>
                        <ModalHeader  toggle={() => this.setState({showModal: false})} >Уведомление</ModalHeader>
                        <ModalBody>
                            <h4>Сообщение отправлено</h4>
                        </ModalBody>
                        <ModalFooter>

                        </ModalFooter>
                    </Modal>

            </Container>
        )
    }
}
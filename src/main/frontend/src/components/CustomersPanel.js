import React from 'react';
import {
    Panel,
    FormGroup,
    InputGroup,
    FormControl,
    Button,
    ControlLabel,
    Modal
} from 'react-bootstrap';
import Griddle from 'griddle-react';

const CustomersPanel = React.createClass({

    getInitialState() {
        return {
            showModalAdd: false, showModalEdit: false,
            customerName: "",
            cellNumber: "",
            city: "",
            newPostOfficeNumber: "",
            balance: 0,
            additionalInfo: ""
        };
    },

    closeAdd() {
        this.setState({showModalAdd: false});
    },

    openAdd() {
        this.setState({showModalAdd: true});
    },

    closeEdit() {
        this.setState({showModalEdit: false});
    },

    onRowClick(row) {
        this.setState({showModalEdit: true, activeRow: row});
    },

    handleNameChange(e) {
        this.setState({customerName: e.target.value});
    },

    handleCellNumberChange(e) {
        this.setState({cellNumber: e.target.value});
    },

    handleCityChange(e) {
        this.setState({city: e.target.value});
    },

    handleNewPostOfficeNumberChange(e) {
        this.setState({newPostOfficeNumber: e.target.value});
    },

    handleBalanceChange(e) {
        this.setState({balance: e.target.value});
    },

    handleAdditionalInfoChange(e) {
        this.setState({additionalInfo: e.target.value});
    },

    render() {

        let customers = this.props.customers;
        let buttonDisabled = this.state.customerName === "" || this.state.cellNumber === "" || this.state.city === "";
        return (
            <div>
                <Panel className="TablePanel">
                    <Button onClick={this.openAdd}>Add Customer</Button>
                    <Griddle results={customers} tableClassName="CustomersTable" showFilter={true}
                             onRowClick={this.onRowClick}
                             showSettings={true}
                             columns={["id", "customerName", "city", "balance"]}
                    />
                </Panel>

                <Modal show={this.state.showModalAdd} onHide={this.closeAdd}>
                    <Modal.Header closeButton>
                        <Modal.Title>Add customer</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <FormGroup>
                            <InputGroup>
                                <div>
                                    <ControlLabel>Customer name</ControlLabel>
                                    <FormControl type="text"
                                                 value={this.state.customerName}
                                                 placeholder="Person name or organisation name"
                                                 onChange={this.handleNameChange}/>

                                </div>
                                <div>
                                    <ControlLabel>Tel. Number</ControlLabel>
                                    <FormControl type="text"
                                                 value={this.state.cellNumber}
                                                 placeholder="Enter phone number in format +380 00 000 00 00"
                                                 onChange={this.handleCellNumberChange}/>
                                </div>
                                <div>
                                    <ControlLabel>City</ControlLabel>
                                    <FormControl type="text"
                                                 value={this.state.city}
                                                 placeholder="City"
                                                 onChange={this.handleCityChange}/>
                                </div>
                                <div>
                                    <ControlLabel>New post office number</ControlLabel>
                                    <FormControl type="text"
                                                 value={this.state.newPostOfficeNumber}
                                                 placeholder="Secify number of office 'Нова пошта'"
                                                 onChange={this.handleNewPostOfficeNumberChange}/>
                                </div>
                                <div>
                                    <ControlLabel>Start balance</ControlLabel>
                                    <FormControl type="text"
                                                 value={this.state.balance}
                                                 placeholder="0"
                                                 onChange={this.handleBalanceChange}/>
                                </div>
                                <div>
                                    <ControlLabel>Additional information</ControlLabel>
                                    <FormControl type="text"
                                                 value={this.state.additionalInfo}
                                                 placeholder=""
                                                 onChange={this.handleAdditionalInfoChange}/>
                                </div>
                            </InputGroup>
                        </FormGroup>
                    </Modal.Body>
                    <Modal.Footer>
                        <Button onClick={this.closeAdd}>Close</Button>
                        <Button bsStyle="success" disabled={buttonDisabled} onClick={() => {
                            this.setState({
                                showModalAdd: false, showModalEdit: false,
                                customerName: "",
                                cellNumber: "",
                                city: "",
                                newPostOfficeNumber: "",
                                balance: 0,
                                additionalInfo: ""
                            });
                            this.props.onAddCustomer(this.state.customerName, this.state.cellNumber, this.state.city, this.state.newPostOfficeNumber, this.state.balance, this.state.additionalInfo, this.closeAdd);
                        }}>Add Customer</Button>
                    </Modal.Footer>
                </Modal>

                <Modal show={this.state.showModalEdit} onHide={this.closeEdit}>
                    <Modal.Header closeButton>
                        <Modal.Title>Edit customer data</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <ModalBody activeRow={this.state.activeRow}/>
                    </Modal.Body>
                    <Modal.Footer>
                        <Button onClick={this.closeEdit}>Close</Button>
                        <Button bsStyle="success" onClick={() => {
          //                  this.props.onDeleteUser(this.state.activeRow.props.data.id, this.closeEdit);
                        }}>Save Data</Button>
                    </Modal.Footer>
                </Modal>

            </div>
        );
    }
});

let ModalBody = (activeRow) => {
    if (activeRow === undefined ) {
        console.log("Empty");
        return <div></div>
    } else {
        return <FormGroup>
            <InputGroup>
                <div>
                    <ControlLabel>ID</ControlLabel>
                    <FormControl type="text"
                                 value={activeRow.props.data.id}
                                 placeholder="Person name or organisation name"
                                 onChange={this.handleNameChange}/>

                </div>
                <div>
                    <ControlLabel>Customer name</ControlLabel>
                    <FormControl type="text"
                                 value={activeRow.props.data.customerName}
                                 placeholder="Person name or organisation name"
                                 onChange={this.handleNameChange}/>

                </div>
                <div>
                    <ControlLabel>Tel. Number</ControlLabel>
                    <FormControl type="text"
                                 value={activeRow.props.data.cellNumber}
                                 placeholder="Enter phone number in format +380 00 000 00 00"
                                 onChange={this.handleCellNumberChange}/>
                </div>
                <div>
                    <ControlLabel>City</ControlLabel>
                    <FormControl type="text"
                                 value={activeRow.props.data.city}
                                 placeholder="City"
                                 onChange={this.handleCityChange}/>
                </div>
                <div>
                    <ControlLabel>New post office number</ControlLabel>
                    <FormControl type="text"
                                 value={activeRow.props.data.newPostOfficeNumber}
                                 placeholder="Secify number of office 'Нова пошта'"
                                 onChange={this.handleNewPostOfficeNumberChange}/>
                </div>
                <div>
                    <ControlLabel>Start balance</ControlLabel>
                    <FormControl type="text"
                                 value={activeRow.props.data.balance}
                                 placeholder="0"
                                 onChange={this.handleBalanceChange}/>
                </div>
                <div>
                    <ControlLabel>Additional information</ControlLabel>
                    <FormControl type="text"
                                 value={activeRow.props.data.additionalInfo}
                                 placeholder=""
                                 onChange={this.handleAdditionalInfoChange}/>
                </div>
            </InputGroup>
        </FormGroup>
    }
};

export default CustomersPanel;









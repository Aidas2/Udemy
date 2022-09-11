import React, { useState } from 'react';
import Button from '../UI/Button';

const AddUser = (props) => {

    const [enteredUsername, setEnteredUsername] = useState('Aidas');
    const [enteredAge, setEnteredAge] = useState('20');

    const addUserHandler = (event) => {
        event.preventDefault();
        props.onAddUser(enteredUsername, enteredAge);
    }

    const userNameHandler = (event) => {
        setEnteredUsername(event.target.value);
    }

    const ageChangeHandler = (event) => {
        setEnteredAge(event.target.value)
    }

    return (
        <form onSubmit={addUserHandler}>
            <label>Username</label>
            <input type="text" onChange={userNameHandler}></input>
            <label>Age (Years)</label>
            <input type="number" onChange={ageChangeHandler}></input>
            <Button typpe="submit"></Button>
        </form>
    );
}

export default AddUser;
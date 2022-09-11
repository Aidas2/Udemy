import React, { useState } from 'react';
import AddUser from './components/Users/AddUser';
import UsersList from './components/Users/UsersList';


function App() {
  const [usersList, setUsersList] = useState([]);

  const addUserHandler = (uName, uAge) => {
    console.log(uName, uAge);
    setUsersList((prevUsersList) => {
      return [...prevUsersList, {name: uName, age: uAge}];
    });
  };

  return (
    <div>
      <AddUser onAddUser={addUserHandler}/>
      <UsersList myUsers={usersList}/>
    </div>
  );
}

export default App;

import React from 'react';

const UsersList = (props) => {
    console.log(props.myUsers);
    return (
        <ul>
            {props.myUsers.map((myUser) => (
                <li>
                    {myUser.name} {myUser.age}
                </li>
            ))}
        </ul>
    );
}

export default UsersList;
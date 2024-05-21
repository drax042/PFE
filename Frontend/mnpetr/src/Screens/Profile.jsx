import React, {useState} from "react";


export const Profile = () => {
    const [isVisible, setIsVisible] = useState(false);

    const userProfile = {
        firstName: 'John',
        lastName: 'Doe',
        email: 'john.doe@example.com',
        idNumber: '123456',
        position: 'Software Engineer'
    };

    const toggleVisibility = () => {
        setIsVisible(!isVisible);
    };

    return (
        <div>
            <button onClick={toggleVisibility} className="profile-button"></button>
            {isVisible && (
                <div className="profile-popup">
                    <h1>Profile</h1>
                    <div className="profile-details">
                        <div className="profile-field">
                            <label>First Name:</label>
                            <span>{userProfile.firstName}</span>
                        </div>
                        <div className="profile-field">
                            <label>Last Name:</label>
                            <span>{userProfile.lastName}</span>
                        </div>
                        <div className="profile-field">
                            <label>Email:</label>
                            <span>{userProfile.email}</span>
                        </div>
                        <div className="profile-field">
                            <label>ID Number:</label>
                            <span>{userProfile.idNumber}</span>
                        </div>
                        <div className="profile-field">
                            <label>Position:</label>
                            <span>{userProfile.position}</span>
                        </div>
                    </div>
                </div>
            )}
        </div>
    );
};

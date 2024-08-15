import React, { useState } from 'react';
import axios from 'axios';
import './AdminLogin.css';

const AdminLogin = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            // Use Basic Authentication with the provided credentials
            const response = await axios.post('/admin-login', {}, {
                auth: {
                    username: username,
                    password: password
                }
            });

            if (response.status === 200) {
                window.location.href = '/admin-dashboard'; // Redirect to the admin dashboard on successful login
            } else {
                alert('Invalid username or password');
            }
        } catch (error) {
            alert('Invalid username or password');
        }
    };

    return (
        <div className="admin-login">
            <h2>Admin Login</h2>
            <form onSubmit={handleSubmit}>
                <label>
                    Username:
                    <input 
                        type="text" 
                        value={username} 
                        onChange={(e) => setUsername(e.target.value)} 
                        required 
                    />
                </label>
                <label>
                    Password:
                    <input 
                        type="password" 
                        value={password} 
                        onChange={(e) => setPassword(e.target.value)} 
                        required 
                    />
                </label>
                <button type="submit">Login</button>
            </form>
        </div>
    );
};

export default AdminLogin;

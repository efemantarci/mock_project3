import React, { useState } from 'react';
import './App.css';
import Login from './components/Login';
import Register from './components/Register';

function App() {
  const [currentView, setCurrentView] = useState<'login' | 'register'>('login');
  const [user, setUser] = useState<any>(null);

  if (user) {
    return (
      <div className="App">
        <div className="container">
          <h2>Welcome, {user.name}!</h2>
          <button onClick={() => setUser(null)}>Logout</button>
        </div>
      </div>
    );
  }

  return (
    <div className="App">
      <div className="container">
        <h1>Chess Application</h1>
        <div className="auth-buttons">
          <button
            onClick={() => setCurrentView('login')}
            className={currentView === 'login' ? 'active' : ''}
          >
            Login
          </button>
          <button
            onClick={() => setCurrentView('register')}
            className={currentView === 'register' ? 'active' : ''}
          >
            Register
          </button>
        </div>

        {currentView === 'login' ? (
          <Login onLoginSuccess={setUser} />
        ) : (
          <Register onRegisterSuccess={setUser} />
        )}
      </div>
    </div>
  );
}

export default App;

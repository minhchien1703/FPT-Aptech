import React from 'react';
import StudentManager from '../src/components/StudentManager.js';
import { ToastContainer } from "react-toastify";


function App() {
    return (
        <div>
            <ToastContainer position="top-right" autoClose={3000} />
            <StudentManager />
        </div>
    );
}

export default App;

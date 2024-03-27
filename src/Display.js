import axios from 'axios';
import React, { useState } from 'react';
import './Display.css';

const Display = ({data,getfunction,setEditmode,setEmpindex}) => {

    const handleDelete= async (i)=>{
     await axios.delete(`http://localhost:8080/api/v1/delete/${i}`);
     getfunction();
       

    }
    
  return (
   <div className='display-container'>
    <h2>TODO Application</h2>
    <table>
        <tr><th>Name</th><th>Position</th><th>City</th><th>Salary</th><th>option</th></tr>
        {data.map((val,i)=>{
            return <tr key={i}><td>{val.empname}</td><td>{val.position}</td><td>{val.city}</td><td>{val.salary}</td><td><button onClick={()=>{handleDelete(val.empid)}}>Del</button><button onClick={()=>{setEditmode(true); setEmpindex(val.empid)}}>Edit</button></td></tr>
        })}
    </table>
   </div>
  )
}

export default Display;
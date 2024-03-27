import React, { useEffect, useState } from 'react'
import './Editform.css';

const Editform = ({empindex,handleUpdate,data}) => {

    const [editdata,setEditdata]=useState({
        empname:"",
        position:"",
        city:"",
        salary:""
      
    });
     
    useEffect(()=>{
         const findData=data.find(val=>val.empid==empindex);
         setEditdata({
            empname: findData.empname,
            position: findData.position,
            city: findData.city,
            salary: findData.salary
        });

    },[empindex,data])
   
    const hanleChange=(e)=>{
        const {name,value}=e.target;
        setEditdata({...editdata,[name]:value});


    }
  return (
    <div className='form-container'>
        <form >
            <h1>Edit Form</h1>
    <table>
        <tr className='table-row'><td><label>Name</label></td><td> <input type='text' name='empname'  value={editdata.empname} onChange={hanleChange}/></td></tr>
        <tr className='table-row'><td><label>Position</label></td><td> <input type='text' name='position' value={editdata.position} onChange={hanleChange}/></td></tr>
        <tr className='table-row'><td><label>City</label></td><td><input type='text' name='city'  value={editdata.city} onChange={hanleChange}/><br/></td></tr>
        <tr className='table-row'><td> <label>Salary</label></td><td><input type='text' name='salary' value={editdata.salary} onChange={hanleChange}/></td></tr>
    </table>
    <button className='submit-btn' type='submit' onClick={(e)=>{handleUpdate(e,empindex,editdata)}}>submit</button>
 </form>
    </div>
  )
}

export default Editform
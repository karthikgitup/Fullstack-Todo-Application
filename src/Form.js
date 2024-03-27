import React, { useEffect, useState } from 'react';
import './Form.css';
import axios from 'axios';
import Display from './Display';
import Editform from './Editform';

const Form = () => {
    const [name,setName]=useState("");
    const [position,setPosition]=useState("");
    const [city,setCity]=useState("");
    const [salary,setSalary]=useState("");
    const [datas,setDatas]=useState([]);
    const [editmode,setEditmode]=useState(false);
    const [empindex,setEmpindex]=useState(null);

    const handlePostdata= async (e)=>{
        e.preventDefault();
        if(name&&position&&city&&salary){
            try{
                const res=await axios.post("http://localhost:8080/api/v1/save",{
                empname:name,
                position:position,
                city:city,
                salary:salary
               
            })
            handleGetdata();
                setName("");
                setPosition("");
                setCity("");
                setSalary("");
        
        
                }catch(err){
            console.error("error"+err);
        }

        }else{
            alert("required the data");
        }
         
   
        

    }
    const handleGetdata= async ()=>{
        try{
            const res= await axios.get("http://localhost:8080/api/v1/data");
            setDatas(res.data);
           
           


        }catch(err){
            console.log("error"+err);
        }finally{
            console.log(datas); 
        }
        

    }
    const handleUpdate=async (e,id,editdata)=>{
        e.preventDefault();
        try{
            axios.put(`http://localhost:8080/api/v1/update/${id}`,{
                empname:editdata.empname,
                position:editdata.position,
                city:editdata.city,
                salary:editdata.salary

                
             })
        
           setEditmode(false);
           setDatas(prevDatas => prevDatas.map(item => item.empid === id ? { ...item, ...editdata } : item));
        }catch(err){
            console.error("error"+err);
        }

    }
    useEffect(()=>{
      handleGetdata();
    },[])
  return (
    <>

   {!editmode?<div className='form-container'><form>
    <h1>form</h1>
    <table>
        <tr className='table-row'><td><label>Name</label></td><td> <input type='text'  value={name} onChange={(e)=>setName(e.target.value)}/></td></tr>
        <tr className='table-row'><td> <label>Position</label></td><td> <input type='text'  value={position} onChange={(e)=>setPosition(e.target.value)}/></td></tr>
        <tr className='table-row'><td><label>City</label></td><td><input type='text'  value={city} onChange={(e)=>setCity(e.target.value)}/><br/></td></tr>
        <tr className='table-row'><td> <label>Salary</label></td><td><input type='text'  value={salary} onChange={(e)=>setSalary(e.target.value)}/></td></tr>
    </table>
    <button className='submit-btn' type='submit' onClick={handlePostdata}>submit</button>
 </form></div>:<Editform empindex={empindex} handleUpdate={handleUpdate} data={datas} />}
 {datas.length>0&&<Display data={datas} getfunction={handleGetdata} editmode={editmode} setEditmode={setEditmode} setEmpindex={setEmpindex}/>}
    </>
  )
}

export default Form
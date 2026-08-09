import { useState } from "react" ;
import { v4 as uuid } from 'uuid' ;

function TodoList() {
    let [tasks, setTask] = useState([{task : "Sample Task", id: uuid(), isDone: false}]) ;
    let [newTask, setNewTask] = useState("") ;

    function addTask(event) {
        setTask((prevValue) => {
            return [...prevValue, {task: newTask, id: uuid(), isDone:false}]
        }) ;
        setNewTask("") ;
    }

    function updateTodoList(event) {
        setNewTask(event.target.value) ;
    }

    function deleteTask(id) {
        setTask((prevValue) => {
            return prevValue.filter((ele) => {
                return ele.id != id ;
            })
        })
    }

    function upperCaseAll() {
        setTask((prevValue) => {
            return prevValue.map((ele) => {
                return {
                    ...ele,
                    task: ele.task.toUpperCase()
                }
            })
        })
    }

    function upperCaseOne(id) {
        setTask((prevValue) => {
            return prevValue.map((ele) => {
                if(ele.id != id) {
                    return {
                        ...ele
                    }
                } else {
                    return {
                        ...ele,
                        task: ele.task.toUpperCase()
                    }
                }
            })
        })
    }

    function lowerCaseAll() {
        setTask((prevValue) => {
            return prevValue.map((ele) => {
                return {
                    ...ele,
                    task: ele.task.toLowerCase()
                }
            })
        })
    }

    function markDone(id) {
        console.log(id) ;
    }

    return (
        <div>
            <input placeholder="Enter your task here" value={newTask} onChange={updateTodoList}/>
            <br/>
            <button onClick={addTask}>Add Task</button>
            <br/><br/><br/>
            <hr></hr>
            <h3>Tasks to do</h3>
            <ol>{tasks.map((ele) => {return <li key={ele.id}>{ele.task} <button onClick={() => deleteTask(ele.id)}>Delete</button> &emsp; <button onClick={() => upperCaseOne(ele.id)}>upperCase</button> &emsp; <button onClick={() => markDone(ele.id)}>markDone</button></li>
            })}<br/><button onClick={upperCaseAll}>upperCaseAll</button>&emsp;<button onClick={lowerCaseAll}>lowerCaseAll</button></ol>
        </div>
    )
}

export default TodoList ;
//import FollowButton from './followButton/FollowButton.jsx'
import { useState } from 'react'
import './App.css'
import Sum from './sum/Sum.jsx'

function App() {
  const [op1, setOp1] = useState(0);
  const [op2, setOp2] = useState(0)
 
  function updateValue(e) {
    let value = parseInt(e.target.value)
    if (isNaN(value))
        value = 0
    if (e.target.name == 'op1')
      setOp1(value)
    else
      setOp2(value)
  }

  return (
    <> 
    <div>
      <input name="op1" type="number" onChange={updateValue} />
       <input name="op2" type="number" onChange={updateValue} />
       <p>Voy a hacer la suma de {op1} y {op2}</p>
       <Sum number1={op1} number2={op2}/>
    </div>
       
    </>
   
  )
}

export default App

import './App.css';
import { useState} from 'react';

function App() {

  const [people, setPeople] = useState([]);

  const getAllPeople = async (params) => {
    const url = "http://localhost:8080/api/v1/person";
    try {
      const response = await fetch(url, {mode: 'cors'});
      console.log(response)
      const data = await response.json();
      console.log(data)
      setPeople(data);
    } catch (error) {
      console.log(error)
    }
  }

  return (
    <div className="App">
      <button onClick={() => getAllPeople()}>GET ALL PEOPLE</button>
      <div id='peopleList'>
        {people.map((item, index) => (
          <div className='person'>
            <p className='personId'>{item.id}</p>
            <p className='personName'>{item.name}</p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;

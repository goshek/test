import './App.css';
import { Routes, Route } from 'react-router-dom';
import TestReact from './Pages/Page1';


function App() {
  return (
    <>
      <Routes>
        <Route path='/reacttest' element={<TestReact />}>
        </Route>
      </Routes>
    </>
  );
}

export default App;

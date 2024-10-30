import axios from "axios";
import { useEffect, useState } from "react";

const DOMAIN= 'http://localhost:8080';
const Book_API= 'api/test/books';

interface GetBookResponseDto{
  id: number;
  title: string;
  author: string;
  category: string;
}

export default function TestReact() {
  const [results, setResults]= useState<GetBookResponseDto[]>([]);
  const [title, setTitle] = useState('');
  const [author, setAuthor] = useState('');
  const [category, setCategory] = useState('');

  const fetchBookData=async()=>{
    try{
      const response= await axios.get(
        `${DOMAIN}/${Book_API}`);
      const data=response.data;
      setResults(data);
    }
    catch(e){
      console.log("Error Occured: ", e);
    }
  }

  useEffect(()=>{
    fetchBookData();
  },[]);

  const deleteButtonClick = async (id: number) => {
    try {
      await axios.delete(`${DOMAIN}/${Book_API}/${id}`); 
      setResults(p => p.filter(book => book.id !== id)); 
    } catch (e) {
      console.log("Error Occurred during deletion: ", e);
    }
  }

  const addBook = async () => {
    if (!title || !author || !category) {
      alert("빈 값!!!!!!!!!!!"); 
      return;
    }

    try {
      const response = await axios.post(`${DOMAIN}/${Book_API}`, {
        title,
        author,
        category
      });

      setResults(prevResults => [...prevResults, response.data]);
      setTitle('');
      setAuthor('');
      setCategory('');
    } catch (e) {
      console.log("Error Occurred while adding book: ", e);
    }
  }

  return (
    <div >
      <h1>도서관</h1>
      <hr />
      <div style={{ marginBottom: '20px' }}>
        <h2>신간 도사 추가</h2>
        <input 
          type="text" 
          value={title} 
          onChange={(e) => setTitle(e.target.value)} 
          placeholder="도서명"
          style={{ marginRight: '10px' }} 
        />
        <input 
          type="text" 
          value={author} 
          onChange={(e) => setAuthor(e.target.value)} 
          placeholder="작가"
          style={{ marginRight: '10px' }} 
        />
        <input 
          type="text" 
          value={category} 
          onChange={(e) => setCategory(e.target.value)} 
          placeholder="분류"
          style={{ marginRight: '10px' }} 
        />
        <button onClick={addBook} style={{ backgroundColor: 'green', color: 'white' }}>
          추가하기
        </button>
      </div>
      <hr />
        <h2>전체 책 목록</h2>
      <table style={{ borderCollapse: 'collapse', width: '100%' }}>
        <thead>
          <tr>
            <th style={{ border: '1px solid black', padding: '8px' }}></th>
            <th style={{ border: '1px solid black', padding: '8px' }}>도서명</th>
            <th style={{ border: '1px solid black', padding: '8px' }}>작가</th>
            <th style={{ border: '1px solid black', padding: '8px' }}>분류</th>
            <th style={{ border: '1px solid black', padding: '8px' }}>삭제</th>
          </tr>
        </thead>
        <tbody>
          {results.map((result, index) => (
            <tr key={index}>
              <td style={{ border: '1px solid black', padding: '8px' }}>{index+1}</td>
              <td style={{ border: '1px solid black', padding: '8px' }}>{result.title}</td>
              <td style={{ border: '1px solid black', padding: '8px' }}>{result.author}</td>
              <td style={{ border: '1px solid black', padding: '8px' }}>{result.category}</td>
              <td style={{ border: '1px solid black', padding: '8px', textAlign:'center'}}> 
                <button style={{backgroundColor: 'red'}} onClick={() => deleteButtonClick(result.id)}>
                  <p style={{width: '50px', color:'white'}}>삭제</p>
                </button></td>
            </tr>
          ))}
        </tbody>
      </table>

      <br />
      <hr />


      <br />
      <hr />
    </div>
  )
}

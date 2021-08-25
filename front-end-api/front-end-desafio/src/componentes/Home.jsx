import React, { useEffect, useState, useRef } from 'react'
import axios from 'axios';
import Listagens from './listagem/Listagens'
import Loja from "./lojas/Lojas";
import LupaAzul from '../assets/img/lupa-azul.png'
import {useHistory} from "react-router-dom";

import '../assets/css/home.css'

function Home(){

    const janela = useHistory();

    const [transacoes, setTransacoes] = useState([]);

    const [lojas, setLojas] = useState([]);

    const [idLoja, setIdLoja] = useState(0);

    const filesElement = useRef(null);

    useEffect( () => {

        try{
        axios.get(`http://localhost:8080/transacoes`)
        .then((response) => {
            setTransacoes(response.data)
        });
        } catch (error) {
        console.log(error)
        }
     
        try {
            axios.get('http://localhost:8080/lojas')
              .then((response) => {
                setLojas(response.data);
              });
          } catch (error) {
            console.log(error)
          }

    }, [])


    const handleChangeLoja = (event) => {
        const value = { ...idLoja }
        value[event.target.name] = event.target.value;
        setIdLoja(value.loja)
    };

  const handleSubmit = callback => event => {
    event.preventDefault();
    callback();
  };

    async function filtrarLojas(){

      if(!(idLoja === undefined || idLoja > 0)){
        alert("Selecione uma loja !!!")
      } else{
        sessionStorage.removeItem("idLoja")  
        sessionStorage.clear() 
        sessionStorage.setItem("idLoja", idLoja)
        janela.push('/listagem');
      }
    }

    async function arquivar(){

      const dataForm = new FormData();

      for (const file of filesElement.current.files) {
        dataForm.append('arquivo', file);
      }


      try{
       await  axios.post(`http://localhost:8080/transacoes/upload`, dataForm)
        .then((response) => {    
          window.location.reload();      
        });
        } catch (error) {
        console.log(error)
        }
    }


    return (

        <div className="conteudo">

          <nav className="nav">

              <input id="arquivo" onChange={arquivar} multiple ref={filesElement} className="input-arquivar" 
              type="file" placeholder="Arquivar"/>

            {transacoes.length > 0 ?
            <>
                <form onSubmit={handleSubmit}>  
                  <a onClick={filtrarLojas}><img alt="lupaAzul" src={LupaAzul}/></a>

                    <select name="loja" id="loja" onChange={handleChangeLoja}  placeholder="Selecione uma loja">
                        <option> Selecione uma loja </option>
                        <Loja obj={lojas}/>
                    </select>                  
              
                </form>
            </>

            :         
            <>
            </>
            }
          </nav>

          {transacoes.length > 0 ?

          <>
            <h3>TRANSAÇÕES ARQUIVADAS</h3>

            <div className="listagem">
              <Listagens obj={transacoes}/>
            </div>
        
          </>

          : 
          
          <>

          </>
        }

        

          
        
        </div>
    )
}

export default Home;
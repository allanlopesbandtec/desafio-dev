import React, { useEffect, useState } from 'react'
import axios from 'axios';
import Listagens from './listagem/Listagens'
import Logo from "../assets/img/logo-bycorders.jfif"
import Nav from './navegacao/Nav'

import '../assets/css/listagens.css'


function ListagemLojas(){

    const [saldo, setSaldo] = useState('');

    const [loja, setLoja] = useState('');

    const [lojaHistorico, setLojaHistorico] = useState([]);
    
    useEffect( () => {

        try{
            axios.get(`http://localhost:8080/transacoes/${sessionStorage.getItem("idLoja")}`)
            .then((response) => {

                setSaldo(response.data.saldoLoja)
                setLojaHistorico(response.data.lojasList)
                setLoja(response.data.nomeLoja)
            });
        } catch (error) {
            console.log(error)
        }

    }, [])
   

    

    return (  

        <div className="conteudo">
          <Nav/>

          <img className="img-logo" src={Logo} alt="by-coders" />
          
            {lojaHistorico.length > 0 ? 
                    <>    
                        <h3>{loja}</h3> 
                        <h2>Saldo: {saldo}</h2>
                        <div className="listagem">
                            <Listagens obj={lojaHistorico}/> 
                        </div>
                    </>
                :
                <>
                </>
            }
        </div>



    )
}

export default ListagemLojas;
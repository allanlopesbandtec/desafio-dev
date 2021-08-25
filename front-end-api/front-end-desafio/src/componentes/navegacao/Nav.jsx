import React from 'react'
import '../../assets/css/home.css'
import {useHistory} from "react-router-dom";


function Nav(){

    const janela = useHistory();

    function home(){
        janela.push('/');
    }

    return (

            <div>
                <nav className="nav">
                    <button className="btn-arquivar" onClick={home}>Home</button>    
                </nav>
            </div>
    )

} 

export default Nav;
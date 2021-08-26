import React from 'react'
import '../../assets/css/listagens.css'

function Listagens(props){

    const transacoes = props.obj;

    if(transacoes.length > 0){

        return transacoes.map((transacao) => {

            return(
                    <>
                        <div className="card" key={transacao.id}>
                            <ul>
                                <li> <span>LOJA: </span>{transacao.nomeLoja}</li>
                                <li> <span>DONO DA LOJA: </span>{transacao.donoLoja}</li>
                                <li> <span>DATA: </span>{transacao.data}</li>
                                <li> <span>HORA: </span>{transacao.hora}</li>
                                <li> <span>CPF BENEFICIÁRIO: </span>{transacao.cpfBeneficiario}</li>
                                <li> <span>VALOR: </span>{transacao.valor}</li>
                                <li> <span>DESCRIÇÃO DA TRANSAÇÃO: </span>{transacao.descricaoTipo}</li>
                            </ul>
                        </div>
                    </>
                )
        })

    }else{
        return(    
            <>

            </>
        )    
    }
}

export default Listagens;
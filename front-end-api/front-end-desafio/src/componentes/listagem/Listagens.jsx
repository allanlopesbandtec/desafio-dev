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
                                <li> <span>Loja: </span>{transacao.nomeLoja}</li>
                                <li> <span>Dono da loja: </span>{transacao.donoLoja}</li>
                                <li> <span>Data: </span>{transacao.data}</li>
                                <li> <span>Hora: </span>{transacao.hora}</li>
                                <li> <span>Cpf beneficiario: </span>{transacao.cpfBeneficiario}</li>
                                <li> <span>Valor: </span>{transacao.valor}</li>
                                <li> <span>Descrição da transação: </span>{transacao.descricaoTipo}</li>
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
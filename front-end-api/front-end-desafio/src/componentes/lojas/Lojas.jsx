import React from "react";

function Lojas(props) {

  const obj = props.obj;

  if(obj.length > 0){

    return obj.map((loja) => {
      return (
          <option key={loja.id} value={loja.idLoja}> {loja.nomeLoja} </option>
      );
    });
    
  }else{
    return(
      <>
      
      </>
    )
  }

 
}

export default Lojas;

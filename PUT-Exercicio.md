Faça um metodo para atualizar um carro na lista: 

Para esse metodo é necessário seguir a seguinte regra do protocolo HTTP

VERBO: PUT

URL da REQUISIÇÃO: localhost:8080/carros/{nomeDoCarro}

corpo da REQUISIÇÃO: 

{     
     	 "cor":"Vermelho e Branco",      
    	  "motor":"1.6",      
    	  "ano":1971
	   }


RESPOSTA da API

200 ok

Corpo da Resposta:

{      
    		 "modelo": "Fusca",     
     	    "cor": "Vermelho e Branco",      
    		 "motor": "1.6",     
     		"ano": 1971
      }


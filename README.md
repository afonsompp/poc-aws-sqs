# POC: Utilizando SQS com Spring

## Contexto:
O Amazon Simple Queue Service (SQS) é um serviço de filas de mensagens gerenciado que permite o desacoplamento e a escalabilidade de microsserviços, sistemas distribuídos e aplicativos sem servidor. 
Então utilizando uma API vamos colocar mensagens em uma fila, enquanto isso teremos um objeto que será responsável por ouvir, receber e tratar essas mensagens que serão colocadas na fila, salvando-as em um banco de dados H2.

## Tecnologias:
- Java 11
- Spring boot
- Spring Data
- Spring Validator
- Hibernate validator
- Jackson
- AWS CLI
- Docker
- Maven
- AWS dependencies(Maven)
- Localstack
## Como executar:

#### Requisitos:
- Java 11
- AWS CLI
- Maven
- Docker
---

1. Precisamos subir um container docker do localstack
`docker-compose up'-d --build`.
2. Utilizando o AWS CLI criaremos a fila que será utilizada
`aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name person-queue`.
3. Agora podemos rodar o projeto
`mvn spring-boot:run`.
4. Através do Postman na url `http://localhost:8080/api/person` podemos fazer uma requisição POST com o body seguindo o padrão:
``` JSON
{
    "firstName":"Tom",
    "lastName":"Hanks",
    "cpf":"000.000.000-00",
    "bornDate":"yyyy-mm-dd"
}
```
5. Para verificar se a mensagem foi enviada e ouvida e tratada pela fila, podemos acessar no navegador a url: `http://localhost:8080/h2-console`, através  do  banco de dados será possível validar que as informações foram salvas corretamente.

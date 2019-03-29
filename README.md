## BACK END

 Foi utilizado o Spring Boot que é um projeto da Spring para facilitar o processo de configuração e publicação da API RestFul elaborada neste projeto.

Foram adicionados os seguintes módulos do Spring Boot: 
DevTools

  Ao efetuar alguma altereção e salvar ele reinicia o server automaticamente, sem precisar manualmente parar o serviço e iniciá-lo novamente.

MySql
  
  Dependência responsável por se conectar através de drivers com o banco de dados MySql.
  
Flyway

  Criação da tabela Reserva através de script de utilização.

JPA
  
   Framework para Mapeamento Objeto-Relacional (ORM - Object-Relational Mapping). 
  
Web

  Para desenvolver api Restful.
  
  

 A IDE utilizada foi a Spring Tool Suite. O banco de dado relacional MySql.

Para testar a api foi utilizada a ferramenta Postman.

A API Restful apresentada nesse projeto, faz essas operações com sucesso:

 Edição com id método put http://localhost:8080/reservas/id
 
 Exclusão com id método delete http://localhost:8080/reservas/id
 
 Inclusão de reserva método post http://localhost:8080/reservas
 
 Listagem de reservas: método get http://localhost:8080/reservas
 
 Buscar apenas um elemento no banco de dados: método get http://localhost:8080/reservas/id


O controle de versão utilizado foi GIT, por linha de comando.

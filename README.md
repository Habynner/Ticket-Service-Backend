# 🎟️ Ticket Service API

Uma API RESTful para gerenciamento de tickets, construída com **Java 17**, **Spring Boot 3** e **MongoDB**. Permite criar, listar, buscar, atualizar o status e deletar tickets.

---

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- Spring Data MongoDB
- MongoDB Atlas
- Maven
- REST API
- DTOs
- Swagger

---

## 📦 Requisitos

- Java 17+
- Maven 3.8+
- IDE (IntelliJ, VS Code, Eclipse)

---

## 🛠️ Instalação

1. **Clone o repositório:**

```bash
git clone https://github.com/seu-usuario/ticket-service.git
```

```bash
mvn spring-boot:run
```


<table>
  <thead>
    <tr>
      <th>Método</th>
      <th>Endpoint</th>
      <th>Descrição</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>POST</td>
      <td>/tickets</td>
      <td>Criar novo ticket</td>
    </tr>
    <tr>
      <td>GET</td>
      <td>/tickets</td>
      <td>Listar todos os tickets</td>
    </tr>
    <tr>
      <td>GET</td>
      <td>/tickets/{id}</td>
      <td>Buscar ticket por ID</td>
    </tr>
    <tr>
      <td>PATCH</td>
      <td>/tickets/{id}/status</td>
      <td>Atualizar apenas o status</td>
    </tr>
    <tr>
      <td>DELETE</td>
      <td>/tickets/{id}</td>
      <td>Deletar ticket</td>
    </tr>
  </tbody>
</table>

## 📝 Exemplo de criação (POST /tickets)

```bash
{
  "title": "Erro no login",
  "description": "Usuário não consegue acessar o sistema"
}
```
## 📦 Funcionalidades

- Documentação com *Swagger*
- Cadastro de ticket
- Listar todos os tickets
- Buscar ticket
- Atualizar status do ticket
- Deletar ticket

## 📁 Estrutura do Projeto
```
src/
├── main/
│   ├── java/com/ticket/
│   │   ├── controller/
│   │   ├── dto/
│   │   ├── model/
│   │   ├── repository/
│   │   └── service/
│   └── resources/
│       └── application.properties
```
## 🧪 Testes
Você pode testar os endpoints com ferramentas como:

- Postman

- Insomnia

- [Swagger](http://localhost:8080/swagger-ui/index.html#/)

  ## O Projeto possuí interface
   
   [Frontend](https://github.com/Habynner/Ticket-Service-Frontend)

## 👤 Autor

**Habynner Silva**  
Desenvolvedor Fullstack com expertise em .NET, NestJS, MongoDB, GCP e microsserviços.  

[LinkedIn](linkedin.com/in/habynner-silva-developer)

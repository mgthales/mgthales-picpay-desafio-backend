# PicPay Backend Challenge

Um projeto que implementa uma versão simplificada do PicPay, desenvolvido como solução para o desafio de Backend Sênior. Este sistema permite a realização de transações financeiras entre usuários de forma simples e eficiente.

## 🚀 Tecnologias Utilizadas

- Spring Boot
- Spring MVC
- Spring Data JDBC
- Spring for Apache Kafka
- Docker Compose
- H2 Database

## ⚙️ Pré-requisitos

- Java JDK 17 ou superior
- Docker e Docker Compose
- Maven

## 🔧 Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/giuliana-bezerra/picpay-desafio-backend.git
```

2. Inicie o Kafka usando Docker Compose:
```bash
docker-compose up
```

3. Execute a aplicação Spring Boot:
```bash
./mvnw spring-boot:run
```

4. A aplicação estará disponível em `http://localhost:8080`

## 🔍 API Endpoints

### Criar uma nova transação

```http
POST http://localhost:8080/transaction
Content-Type: application/json

{
    "value": 100.0,
    "payer": 1,
    "payee": 2
}
```

Exemplo de resposta:
```json
{
    "id": 20,
    "value": 100.0,
    "payer": 1,
    "payee": 2,
    "createdAt": "2024-03-05T16:07:50.749774"
}
```

### Listar todas as transações

```http
GET http://localhost:8080/transaction
```

Exemplo de resposta:
```json
[
    {
        "id": 20,
        "value": 100.0,
        "payer": 1,
        "payee": 2,
        "createdAt": "2024-03-05T16:07:50.749774"
    }
]
```

## 🏗️ Arquitetura

O projeto segue uma arquitetura baseada em microserviços, utilizando Kafka para processamento assíncrono de transações. O banco de dados H2 é utilizado para armazenamento em memória, facilitando o desenvolvimento e testes.

## 👨‍💻 Contribuição

Contribuições são sempre bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto está sob a licença MIT.

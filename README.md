# Projeto Pet Shelter API

Este é um projeto em desenvolvimento que visa criar uma API para gerenciar abrigos de animais e seus pets associados.

## Funcionalidades Atuais

- Listar abrigos e seus detalhes.
- Cadastrar abrigo.
- Listar pets por abrigo.
- Cadastrar pet associado a um abrigo.

## Em Desenvolvimento

Este projeto está constantemente evoluindo. Melhorias e novas funcionalidades estão planejadas, incluindo:

- Adição de mais métodos HTTP para operações CRUD.
- Implementação de testes para garantir a robustez do sistema.
- Atualização de abrigos existentes.
- Atualização de informações de pets.
- Remoção de abrigos e pets.

## Tecnologias Utilizadas

- **Spring Boot**: Framework Java para desenvolvimento de aplicações.
- **PostgreSQL**: Banco de dados relacional utilizado para persistência.
- **Docker/Docker Compose**: Utilizados para facilitar a configuração do ambiente de desenvolvimento, incluindo o PostgreSQL e PGAdmin.
- **Insomnia**: Ferramenta para teste de APIs.

## Pré-requisitos

Esse projeto está sendo desenvolvido com JDK 17, então, antes de começar, certifique-se de ter instalado:

- **Java 17**
- **PostgreSQL** (pode ser instalado nativamente ou via Docker.)
- **Insomnia** (ou qualquer ferramenta similar para testar APIs.)
- **Docker** (se você preferir utilizar essa opção ao invés de instalar nativamente o SGBD.)
- **PGAdmin** (se você preferir utilizar de forma GUI ao invés do terminal, essa ferramenta pode te ajudar!)

## Configuração docker-compse.yml

````
version: '3.8'

services:
  postgres:
    image: postgres:16.0
    container_name: my-postgres-apdopet
    networks:
      - my-network
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
      POSTGRES_DB: adopet_db
    ports:
      - 5434:5432
    volumes:
      - postgres_data:/var/lib/postgresql/data

  pgadmin:
    image: dpage/pgadmin4
    container_name: my-pgadmin-apdopet
    networks:
      - my-network
    environment:
      PGADMIN_DEFAULT_EMAIL: admin@example.com
      PGADMIN_DEFAULT_PASSWORD: admin
    ports:
      - 5050:80
    depends_on:
      - postgres

networks:
  my-network:

volumes:
  postgres_data:
````

## Uso

A API expõe endpoints para realizar operações CRUD em abrigos e pets. A documentação da API para obter detalhes sobre os endpoints disponíveis está sendo atualizada, em breve estará disponível.

## Contribuição

Contribuições são bem-vindas! Leia as diretrizes de contribuição antes de enviar um pull request.

## Estrutura do Projeto
```
├───main
│   ├───java
│   │   └───br
│   │       └───com
│   │           └───lasbr
│   │               └───adopetapi
│   │                   ├───controller
│   │                   ├───entity
│   │                   ├───repository
│   │                   └───service
│   │                       └───exception
│   └───resources
│       ├───static
│       └───templates
└───test
    └───java
        └───br
            └───com
                └───lasbr
                    └───adopetapi
                    
````

## Licença

Este projeto é licenciado sob a MIT.

## Contato

- [Luciano Alves](mailto:lasbr_alves@outlook.com)
- [LinkedIn](https://www.linkedin.com/in/lasbrdev/)


**Observação:** Este projeto está em constante desenvolvimento, com melhorias e novas funcionalidades planejadas para futuras versões.

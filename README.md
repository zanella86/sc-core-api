# SPORT CONNECTION - CORE API

---

# GRUPO

- RM346315: Lais Kagawa ([lakagawa](https://github.com/lakagawa))
- RM346511: Jônatha Lacerda Gonzaga ([jhowlacerda](https://github.com/jhowlacerda))
- RM346958: Thiago de Souza Zanella ([zanella86](https://github.com/zanella86))

---

# REPOSITÓRIOS RELACIONADOS

https://github.com/zanella86/SportConnection

---

# FERRAMENTAS / TECNOLOGIAS

- Git / Github
- Gradle 7.6.1
- IntelliJ IDEA Community Edition (2022.2.1)
- MySQL Workbench 8.0 CE
- Spring Framework (Java 17+)
- Swagger

---

# CONSTRUÇÃO/JUSTIFICATIVA

<u>Utilizamos o Spring Framework:</u>

- **Spring Boot:** Para produtividade na configuração do ambiente e desenvovimento.
- **Spring Web:** Para disponibilização dos _endpoints_ (Tomcat embutido).
- **Spring Data JPA:** Persistência via _Hibernate_.
- **Spring Security:** Para gerenciamento de acessos (_Basic Authentication_).
  - **JWT:** Para autenticação com _Token_ (_Header Authorization_).
  - **OAuth2 Client:** Para integração do _Spring Boot_ aos recursos do _OpenID_ do _Spring Security_.

<u>Outros:</u>

- MySQL Driver: Para utilização do MySQL.
- Lombok: Para redução da verbosidade.

![Spring Initializr](docs/spring-initializr-setup.PNG)

---

# PARA TESTAR

## Bancos de dados

### MySQL

- Crie um *database schema* no MySQL chamado `sport-connection`

![MySQL-Create-Schema](docs/mysql-schema-create.PNG)

## Aplicação

### IDE

Adicione as variáveis de ambiente e ajuste os valores conforme as configurações do seu ambiente:

> MYSQL_USERNAME=meu_usuario;MYSQL_PASSWORD=minha_senha;JWT_SECRET=meu_codigo_secreto_com_mais_de_56_caracteres_de_comprimento

![Intellij-bootRun-Arguments](docs/intellij-bootrun-arguments.PNG)

### Swagger

Documentação disponível em: http://localhost:8080/sc-core/swagger-ui/index.html#/

![Swagger - Home](docs/swagger.PNG)

---

# REFERÊNCIAS

- [Spring Initializr](https://start.spring.io/)
- [OAuth 2.0 Login](https://docs.spring.io/spring-security/reference/servlet/oauth2/login/index.html)

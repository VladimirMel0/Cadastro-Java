# Projeto Crud Challenge
Projeto de um sistema tanto front-end quanto back-end, meu foco foi aprimorar minhas habilidades no Java para Back-end.

No front usei JavaScripit puro, para fazer as validações e conexão com a API criada que salva os dados em um Banco de dados (MySQL), no Back-end utilizei o framework Spring, usando o Spring-Boot para a Criação da API, Spring-Security para fazer a criptografia dos dados sensiveis (Senha) e também Spring-Validation para fazer uma nova validação dos dados, direto na API.

Para a Criação do Crud utilizei o JpaRepository.

## How To Use

1. Clonar projeto.
2. Instalar as dependências do maven.
3. Criar banco de dados com o nome "cadastro"

``` docker 
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/cadastro
```
4. Chamar os Endpoints

## Libs
- [Spring Validation](https://spring.io/guides/gs/validating-form-input/) : Fazer a validação dos dados de entrada.
- [Spring Boot](https://spring.io/projects/spring-boot) : Framework para criar aplicação web.
- [Spring Security](https://spring.io/projects/spring-security): Fazer a criptografia de dados sensiveis 
- [Maven](https://maven.apache.org/) : Para gerenciar dependências de objetos.
- [Git](https://git-scm.com/) : Gerenciar versionamento do projeto.

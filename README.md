# CRUD em Java e JDBC utilizando banco de dados Derby

## Arquivos

`pom.xml` - Arquivo de configuração do projeto Maven.

`src/main/webapp` - Diretório web.

## Para executar o Tomcat

`mvn tomcat7:run`

## Para executar o banco de dados Derby

`mvn exec:java@derby-start`

## Banco de Dados

### JDBC

URL: `jdbc:derby://localhost:1527/carrodb;create=true`

Usuário: `app`

Senha: `app`

### Tabelas

`
CREATE TABLE CARRO ( CODIGO INTEGER, MARCA VARCHAR(100), NOME VARCHAR(100), ANO INTEGER, POTENCIA INTEGER )
`
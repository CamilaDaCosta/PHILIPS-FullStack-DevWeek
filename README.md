# PHILIPS-FullStack-Dev-Week
Sistema que permite acesso aos dados, persistidos no MySql, via API Web (DATASUS). Fornece acesso aos dados de exames de mamografia feitos por brasileiras.

Tecnologias
Banco de Dados Relacional (MySql)<br />
SpringBoot <br />
Angular para construção da API Web<br />

IDE utilizada: Intelij

## Criar projeto a partir do Spring Initializr com as seguintes dependencias
Spring Boot DevTools (facilita pois autocomplete e live reload)<br />
Spring Data JPA (persistência de dados)<br />
Spring Web<br />
MySQL Driver<br />

Adicionar a seguinte dependência no "pom.xml" para o Intelij interpretar alguns arquivos xml <br />
jaxb-api maven para rodar no intelij <br />
<!-- https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api -->

## Banco de Dados

- Criar user que irá acessar o banco
```
CREATE USER 'user_bd@localhost' IDENTIFIED BY '123';
```

- Configurar as permissões necessárias
```
GRANT ALL PRIVILEGES ON *.* TO 'user_bd@localhost';
```

- Criar banco de dados
```
CREATE DATABASE db_datasus;
```

- Entrar no banco 
```
USE db_datasus;
```

- Criar Tabelas
```
CREATE TABLE tb_regiao (id INT auto_increment PRIMARY KEY, regiao varchar(20), total_exames int);
```

```
CREATE TABLE tb_faixa_etaria (id INT auto_increment PRIMARY KEY, faixa_i int, faixa_n int, descricao varchar (50));
```

```
CREATE TABLE tb_incidencia_exame (id INT auto_increment PRIMARY KEY, regiao_id int, mes int, faixa_id int, qnt_exames int);
```

- Configurar Chaves Estrangeiras
```
ALTER TABLE tb_incidencia_exame add constraint fk_tb_incidencia_exame foreign key (regiao_id) references tb_regiao (id);
```

```
ALTER TABLE tb_incidencia_exame add constraint fk_tb_faixa_etaria foreign key (faixa_id) references tb_faixa_etaria (id);
```

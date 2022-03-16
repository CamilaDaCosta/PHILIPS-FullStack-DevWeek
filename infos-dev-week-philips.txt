PHILIPS - FullStack Dev Week

Sistema que permite acesso aos dados, persistidos no MySql, via API Web (DATASUS).
Fornece acesso aos dados de exames de mamografia feitos por brasileiras.

BD Relacional
SpringBoot
Angular para construção da API Web

Intelij
MySql

Criar projeto a partir do Spring para gerenciamento de dependencias
Spring Boot DevTools (facilita pois autocomplete e live reload)
Spring Data JPA (persistência de dados)
Spring Web
MySQL Driver
//jaxb-api maven para rodar no intelij 
<!-- https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api -->


- criar user que irá acessar o banco
CREATE USER 'user_bd@localhost' IDENTIFIED BY '123';

- dar as permissões necessárias
GRANT ALL PRIVILEGES ON *.* TO 'user_bd@localhost';

- criar banco
CREATE DATABASE db_datasus;

- verificar banco criado
SHOW DATABASES;

- entrar no banco 
USE db_datasus;

- Criar Tabelas
CREATE TABLE tb_regiao (id INT auto_increment PRIMARY KEY, regiao varchar(20), total_exames int);

CREATE TABLE tb_faixa_etaria (id INT auto_increment PRIMARY KEY, faixa_i int, faixa_n int, descricao varchar (50));

CREATE TABLE tb_incidencia_exame (id INT auto_increment PRIMARY KEY, regiao_id int, mes int, faixa_id int, qnt_exames int);

- Gerar Chaves Estrangeiras
ALTER TABLE tb_incidencia_exame add constraint fk_tb_incidencia_exame foreign key (regiao_id) references tb_regiao (id);

ALTER TABLE tb_incidencia_exame add constraint fk_tb_faixa_etaria foreign key (faixa_id) references tb_faixa_etaria (id);


////////////////////////////////////////////////////////////////


- CRIAR PROJETO ANGULAR

- Verificar versão
ng version

-Criar projeto
ng new nomeprojeto  (angulardevweek)

- Iniciar aplicação
ng serve

- ANGULAR MATERIAL (https://material.angular.io/)
para adicionar:
ng add @angular/material

- criar novo modulo e rota
ng g m nomeModulo --routing

- criar novo component
ng g c caminho/nomeComponent

- criar interface 
ng g interface caminho/nomeInterface

- criar serviço para executar funções de busca de dados
ng g service caminho/service/nomeServico

- iniciar servico depois de criar proxy
npm run start
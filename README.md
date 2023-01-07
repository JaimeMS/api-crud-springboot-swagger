![GitHub repo size](https://img.shields.io/github/repo-size/JaimeDevS/api-crud-springboot?style=plastic)

# Documentação com Swagger

Configurações básicas para documentação da API com Swagger e Spring Boot

![swagger](https://github.com/JaimeMS/JaimeMS/blob/main/img/swagger.png) 

## Pré-requisitos

* [Lombok](https://projectlombok.org/setup/maven "Lombok")  - framework para eliminar a verbosidade.
* [Spring Data JPA](https://spring.io/projects/spring-data-jpa "JPA")  - framework que tornar a integração de aplicações Spring com a JPA (Java Persistence API).  
* [Spring Web](https://mvnrepository.com/artifact/org.springframework/spring-web "Spring Web]")  - framework que permite a visualização de dados geográficos armazenados em um servidor remoto.
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/using-boot-devtools.html "Docker hub")  - ferramenta para reiniciar automaticamente a aplicação durante o desenvolvimento.
* [MySql Driver](https://spring.io/guides/gs/accessing-data-mysql/ "MySql") - Driver de conxão com o Banco de Dado MySql.
* [JDK](https://www.oracle.com/br/java/technologies/downloads/#java17) - JDK necessário para executar a aplicação.
* [Spring Tools](https://spring.io/tools) - Ferramenta para o desenvolvimento.

## Começando
- Acesse o link para fazer o download da aplicação pré estruturada, nele já é possível baixar todas as dependências do projeto.
```
https://start.spring.io/
```

## 1º PASSO - colocar as dependências do swagger
Traz a interface gráfica para visualização da documentação e fazer requisições
```
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
	<version>2.6.1</version>	
</dependency>
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger-ui</artifactId>
	<version>2.6.1</version>
</dependency>
```
A partir da versão 2.6.0 do Spring Boot.
Adicionar a propriedade no application.properties:
```
spring.mvc.pathmatch.matching-strategy=ant-path-matcher
```

## 2º PASSO - criar uma classe de configuração - SwaggerConfig
Fazer as anotações da classe
```
@Configuration
@EnableSwagger2
```
Definir um Bean da instância de Docket
```
@Bean
public Docket docket()
```
O docket precisa de dois objetos, Contact e ApiInfo para retornar as informações do desenvolvedor


## 3º PASSO - customizar as classes controladoras com informações dos métodos
```
@Api("Api de Produto") - informa de qual controller se trata
@ApiOperation("Método para salvar produto.") - informa do que se trata o método
@ApiResponses e @ApiResponse - @ApiResponses recebe o @ApiResponse onde é informado a definição do código de status http e sua mensagem
```

## Link com os códigos HTTP
- https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Status

## Link da documentação do Swagger
- https://swagger.io/docs/specification/api-general-info/
```
spring.mvc.pathmatch.matching-strategy=ant-path-matcher
```

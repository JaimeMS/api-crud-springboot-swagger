# api-crud-springboot-swagger
Configurações básicas para documentação da API com Swagger e Spring Boot

==================================================================================================
http://localhost:8080/swagger-ui.html#/
Swagger
1º PASSO - colocar as dependências do swagger
Traz a interface gráfica para visualização da documentação e fazer requisições
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

A partir da versão 2.6.0 do Spring Boot.
Adiciona a propriedade no application.properties:
spring.mvc.pathmatch.matching-strategy=ant-path-matcher

2º PASSO - criar uma classe de configuração - SwaggerConfig
Fazer as anotações da classe
@Configuration
@EnableSwagger2

Definir um Bean da instância de Docket
@Bean
public Docket docket()

O docket precisa de dois objetos, Contact e ApiInfo para retornar as informações do desenvolvedor


3º PASSO - customizar as classes controladoras com informações dos métodos
@Api("Api de Produto") - informa de qual controller se trata
@ApiOperation("Método para salvar produto.") - informa do que se trata o método
@ApiResponses e @ApiResponse - @ApiResponses recebe o @ApiResponse onde é informado a definição do código de status http e sua mensagem

Link com os código HTTP
https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Status

Link da documentação do Swagger
https://swagger.io/docs/specification/api-general-info/

==================================================================================================

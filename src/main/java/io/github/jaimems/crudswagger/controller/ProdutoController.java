package io.github.jaimems.crudswagger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.jaimems.crudswagger.entity.Produto;
import io.github.jaimems.crudswagger.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("api/produtos")
@Api("Api de Produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation("Método para salvar produto.")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Produto salvo com sucesso."),
		@ApiResponse(code = 400, message = "Erro de validação.")
	})
	public Produto save(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@ApiOperation("Método para alterar produto identificado pelo Id.")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Cliente salvo com sucesso"),
		@ApiResponse(code = 400, message = "Erro de validação")
	})
	public void update(@PathVariable @ApiParam("ID do produto") Integer id, @RequestBody Produto produto) {
		produtoRepository
				.findById(id)
				.map(p -> {
					produto.setId(p.getId());
					produtoRepository.save(produto);
					return produto;
				}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@ApiOperation("Método para exclui produto identificado pelo Id.")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Produto não encontrado")
	})
	public void delete(@PathVariable Integer id) {
		produtoRepository
				.findById(id)
				.map(p -> {
					produtoRepository.delete(p);
					return Void.TYPE;
				}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
	}
	
	@GetMapping("/{id}")
	@ApiOperation("Método para obter detalhes de um produto identificado pelo Id.")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Produto encontrado"),
		@ApiResponse(code = 404, message = "Produto não encontrado")
	})
	public Produto getById(@PathVariable @ApiParam("Id do produto") Integer id) {
		return produtoRepository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
	}
	
}

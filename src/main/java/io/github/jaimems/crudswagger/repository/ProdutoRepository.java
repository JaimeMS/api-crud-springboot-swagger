package io.github.jaimems.crudswagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.jaimems.crudswagger.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}

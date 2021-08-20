package com.Farmacia.Controlador;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Farmacia.Model.Categoria;
import com.Farmacia.Repository.CategoriaRepositorio;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaControlador
{
	@Autowired
	private CategoriaRepositorio repository;

	@GetMapping
	public ResponseEntity<List<Categoria>> findAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id_categoria}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id_categoria)
	{
		return ResponseEntity.status(200).body(repository.findById(id_categoria).get());
	}

	@GetMapping("/descricao/{descricao_categoria}")
	public ResponseEntity<List<Categoria>> findByDescricao(@PathVariable String descricao_categoria)
	{
		return ResponseEntity.status(200).body(repository.findAllByDescricaoContainingIgnoreCase(descricao_categoria));
	}

	@PostMapping("/criar")
	public ResponseEntity<Categoria> saveCategoria(@Valid @RequestBody Categoria categoria)
	{
		return ResponseEntity.status(200).body(repository.save(categoria));
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Categoria> updateCategoria(@Valid @RequestBody Categoria categoria)
	{
		return ResponseEntity.status(200).body(repository.save(categoria));
	}

	@DeleteMapping("/deletar/{id_categoria}")
	public ResponseEntity<String> deleteById(@PathVariable Long id_categoria)
	{

		Optional<Categoria> categoriaExistente = repository.findById(id_categoria);

		if (categoriaExistente.isPresent())
		{
			repository.deleteById(id_categoria);
			return ResponseEntity.status(200).body("Categoria Deletada");
		} else
		{
			return ResponseEntity.status(200).body("Categoria não encontrada");
		}
	}
}

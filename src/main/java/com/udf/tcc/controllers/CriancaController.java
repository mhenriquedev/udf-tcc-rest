package com.udf.tcc.controllers;

import com.udf.tcc.exceptions.ResourceNotFoundException;
import com.udf.tcc.models.Crianca;
import com.udf.tcc.repositories.CriancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CriancaController {

	@Autowired
	CriancaRepository criancaRepository;

	// Busca todas as criancas
	@GetMapping("/criancas")
	public List<Crianca> getAllNotes() {
		return criancaRepository.findAll();
	}

	// Cria uma nova crianca
	@PostMapping("/criancas")
	public Crianca createNote(@Valid @RequestBody Crianca crianca) {
		return criancaRepository.save(crianca);
	}

	// Busca uma crianca por id
	@GetMapping("/criancas/{id}")
	public Crianca getNoteById(@PathVariable(value = "id") Long criancaId) {
		return criancaRepository.findById(criancaId)
				.orElseThrow(() -> new ResourceNotFoundException("Crianca", "id", criancaId));
	}

	// Atualiza os detalhes da crianca
	@PutMapping("/criancas/{id}")
	public Crianca updateNote(@PathVariable(value = "id") Long criancaId, @Valid @RequestBody Crianca criancaDetails) {

		Crianca crianca = criancaRepository.findById(criancaId)
				.orElseThrow(() -> new ResourceNotFoundException("Note", "id", criancaId));

		crianca.setNome(criancaDetails.getNome());
		crianca.setIdade(criancaDetails.getIdade());

		Crianca criancaAtualizada = criancaRepository.save(crianca);
		return criancaAtualizada;
	}

	// Deleta uma crianca
	@DeleteMapping("/criancas/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long criancaId) {
		Crianca crianca = criancaRepository.findById(criancaId)
				.orElseThrow(() -> new ResourceNotFoundException("Note", "id", criancaId));

		criancaRepository.delete(crianca);

		return ResponseEntity.ok().build();
	}
}

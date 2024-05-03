package br.com.AdasJsf.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.AdasJsf.model.Pessoa;

@Named("pessoaBean")
@SessionScoped
public class PessoaBean implements Serializable {

	// Serial implementado pela Interface
	private static final long serialVersionUID = 1L;

	// Injeção de dependência da classe Pessoa do pacote Model
	@Inject
	private Pessoa pessoa;

	List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	private int idSequencia = 1;


	// Declaração dos métodos da Bean
	public String adicionar() {
		pessoa.setId(this.getSequenciaId());
		pessoas.add(pessoa);
		pessoa = new Pessoa();
		return null;
	}

	private int getSequenciaId() {
		//this.idSequencia = this.idSequencia + 1;
		//this.idSequencia++;
		return this.idSequencia++;
	}

	public String editar() {
		int index = pessoas.indexOf(pessoa); 
		Pessoa pessoaEdicao = pessoa; 
		
		pessoas.remove(pessoa); 
		pessoas.add(index, pessoaEdicao);
		
		pessoa = new Pessoa();
		
		return "/pessoa/listar.xhtml"; 

	}
	
	public String telaEdicao() { 
		return "/paginas/editarPessoa.xhtml"; 
	}
	
	public void carregarEdicao(ActionEvent event) {
		Pessoa dadosPessoa = (Pessoa)event.getComponent().getAttributes().get(pessoa); 
		
		pessoa.setId(dadosPessoa.getId());
		pessoa.setNome(dadosPessoa.getNome());
		pessoa.setProfissao(dadosPessoa.getProfissao());
	}

	// Getters e Setters
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

}

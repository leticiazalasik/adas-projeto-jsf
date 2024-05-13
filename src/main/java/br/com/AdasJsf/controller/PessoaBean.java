package br.com.adasJSF.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.adasJSF.model.Pessoa;

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
		return "/pessoa/listar.xhtml";
	}
	
	public String editar() {
		int index = pessoas.indexOf(pessoa);
		Pessoa pessoaEdicao = pessoa;
		
		pessoas.remove(pessoa);
		pessoas.add(index, pessoaEdicao);
		
		// Alternativa de uso para edição da lista
		//pessoas.set(index, pessoaEdicao);
		
		pessoa = new Pessoa();
		
		return "/pessoa/listar.xhtml";
	}
	
	public String excluir(Pessoa pessoaExcluir) {
		pessoas.remove(pessoaExcluir);
		return null;
	}
	
	public String telaEdicao() {
		return "/pessoa/editar.xhtml";
	}
	
	public void carregarEdicao(ActionEvent event) {
		Pessoa dadosPessoa = (Pessoa)event.getComponent().getAttributes().get("pessoa");
		
		pessoa.setId(dadosPessoa.getId());
		pessoa.setNome(dadosPessoa.getNome());
		pessoa.setProfissao(dadosPessoa.getProfissao());
	}
	
	 public List<String> getTodasCidades() {
	        return Arrays.asList("Blumenau", "Pomerode", "Indaial", "Gaspar", "Outra");
	    }
	

	private int getSequenciaId() {
		//this.idSequencia = this.idSequencia + 1;
		//this.idSequencia++;
		return this.idSequencia++;
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
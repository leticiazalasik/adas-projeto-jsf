package br.com.AdasJsf.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.AdasJsf.model.Pessoa;

@Named("pessoaBean")
	@SessionScoped
	public class PessoaBean implements Serializable {
	
	//Serial implememntaçao pela interface 
		private static final long serialVersionUID = 1L;
		
		//Injeçao de dependencia da classe Pessoa do pacote model 
		@Inject 
		private Pessoa pessoa; 
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>(); 
	
		//Declaracao dos métodos da Bean 
		public String adicionar() {
			pessoas.add(pessoa); 
			pessoa=new Pessoa();
			return null; 
		}

		//Getters e setters 
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


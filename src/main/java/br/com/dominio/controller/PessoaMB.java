package br.com.dominio.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.dominio.model.Pessoa;

@Named("bean")
@ConversationScoped
public class PessoaMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pessoa pessoa;
	
	@Inject
	private Conversation conversation;
	
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

	private List<Pessoa> pessoas = new ArrayList<>();
	
	public String adicionar() {
		
		if (pessoas.isEmpty()) {
			conversation.begin();
		}
		
		pessoas.add(pessoa);
		limpar();
		return null;
	}
	
	public String parar() {
		conversation.end();
		return null;
	}
	
	private void limpar() {
		pessoa = new Pessoa();
	}
	
}

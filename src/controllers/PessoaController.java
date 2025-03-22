package controllers;

import java.util.List;
import java.util.Scanner;

import entities.Pessoa;
import repositories.PessoaRepository;

public class PessoaController {
	
	private Scanner scanner = new Scanner(System.in);


	public void cadastrarPessoa() {

		try {

			
			System.out.println("\n*** CADASTRO DE PESSOA*** \n");

			Pessoa pessoa = new Pessoa();

		System.out.print("Entre com o nome da pessoa.....");
		pessoa.setNome(scanner.nextLine());
		
		
		System.out.print("Entre com o email da pessoa.....");
		pessoa.setEmail(scanner.nextLine());

			PessoaRepository pessoaRepository = new PessoaRepository();

			pessoaRepository.save(pessoa);
			
			System.out.println("/nPESSOA CADASTRADO COM SUCESSO!");

		} catch (Exception e) {

			System.out.println("\nFALHA AO CADASTRAR PESSOA.");

			e.printStackTrace();

		}

	}

	
	public void atualizarPessoa() {
		
		
		try {
			System.out.println("\nEDIÇÃO DE PESSOA");
			
			System.out.println("Informe o ID da pessoa desejada.:");
			Integer idPessoa = Integer.parseInt(scanner.nextLine());
			
			PessoaRepository pessoaRepository = new PessoaRepository();
			Pessoa pessoa = pessoaRepository.findById(idPessoa);
			
			if(pessoa != null) {
				
			System.out.println("Altere o nome da pessoa......:");
			pessoa.setNome(scanner.nextLine());
			
			
			System.out.println("Altere o email da pessoa.....:");
			pessoa.setEmail(scanner.nextLine());
			
			pessoaRepository.update(pessoa);
			System.out.println("\nPESSOA ATUALIZADO COM SUCESSO!");
				
				
			}else {
				
				System.out.println("\nREGISTRO NÃO ENCONTRADO.");
				
			}
			
		}catch(Exception e) {
		System.out.println("\nFALHA AO CADASTRAR PESSOA");
		
	}
	
	
}
	
public void excluirPessoa() {
		
		
		try {
			System.out.println("\nEXCLUSÃO DE PESSOA");
			
			System.out.println("Informe o ID da pessoa desejada.:");
			Integer idPessoa = Integer.parseInt(scanner.nextLine());
			
			PessoaRepository pessoaRepository = new PessoaRepository();
			Pessoa pessoa = pessoaRepository.findById(idPessoa);
			
			if(pessoa != null) {
			
			pessoaRepository.delete(pessoa);
			System.out.println("\nPESSOA EXCLUÍDO COM SUCESSO!");
				
				
			}else {
				
				System.out.println("\nREGISTRO NÃO ENCONTRADO.");
				
			}
			
		}catch(Exception e) {
		System.out.println("\nFALHA AO EXCLUIR PESSOA");
		
	}
	
	
}


public void consultarPessoas() {
	
	
	try {
		
		PessoaRepository pessoaRepository = new PessoaRepository();
		List<Pessoa> lista = pessoaRepository.findAll(); 
		
		for(Pessoa pessoa : lista) {
			
			System.out.println(pessoa.toString());
			
			
			
		}
		
	}catch(Exception e ) {
		
		System.out.println("\nFALHA AO CONSULTAR PESSOA");
		e.printStackTrace();
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}






}

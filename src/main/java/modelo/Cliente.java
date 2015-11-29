package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	@Column(name="nome",nullable = false,length=100)
	private String nome;
	
	@NotEmpty
	@org.hibernate.validator.constraints.br.CPF
	@Column(name="CPF", nullable = false, length=80)
	private String CPF;
	
	@NotEmpty
	@Column(name="Endereco", nullable = false, length=200)
	private String endereco;
	
	@NotEmpty
	@Column(name="Cidade", nullable=false,length=60)
	private String cidade;
	
	@NotEmpty
	@Column(name="Estado", nullable=false, length=60)
	private String Estado;
	
	@NotEmpty
    @Email
	@Column(name="Email", nullable = false, length=40)
	private String email;
	
	@NotEmpty
	@Column(name="Telefone", nullable = false, length=40)
	private String telefone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}

package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	long id;
	
	@NotEmpty
	@Column(name="Nome",nullable=false,length=80)
	String nome;
	
	@NotEmpty
	@Column(name="Unidade", nullable = false, length=14)
	String unidade;
	
	@NotEmpty
	@Column(name="Valor_Compra", nullable=false)
	Double valorCompra;
	
	@NotEmpty
	@Column(name="Percentual_Lucro", nullable=false)
	Double percentualLucro;
	
	@NotEmpty
	@Column(name="Valor_Venda", nullable=false)
	Double valor_venda;
	
	
	
	
	
	

	
	
	
}

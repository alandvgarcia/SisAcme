package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Vendedor implements Serializable {

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
	@Column(name="Percentual_Comissao", nullable = false)
	Double percentualComissao;
	
	@NotEmpty
	@Column(name="Valor_Comissao", nullable=false)
	Double valorComissao;
	
	

	
	
}

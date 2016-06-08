package model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario extends Pessoa implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name = "cod_usuario")
	private int id;
	
	//indica se a pessoa é confiavel
	private Boolean eConfiavel = false;
	
	@MapsId 
    @OneToOne(mappedBy="usuario")
    @JoinColumn(name="cod_usuario")
	private Pessoa pessoa;

}

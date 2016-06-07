package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario extends Pessoa implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "cod_usuario")
	private int id;
	
	//indicar se a pessoa é confiavel
	private Boolean eConfiavel = false;

}

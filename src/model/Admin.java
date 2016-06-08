package model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin extends Pessoa implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name = "cod_admin")
	private int id;
	
	@MapsId 
	@OneToOne(mappedBy="usuario")
    @JoinColumn(name="cod_admin") 
	private Pessoa pessoa;
}

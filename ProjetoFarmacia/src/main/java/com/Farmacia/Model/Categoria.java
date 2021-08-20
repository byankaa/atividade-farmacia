package com.Farmacia.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_Categoria")
public class Categoria
{
	


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		
		@NotBlank
		private String descricao;

		public Long getId()
		{
			return id;
		}

		public void setId(Long id)
		{
			this.id = id;
		}

		public String getdescricao()
		{
			return descricao;
		}

		public void setdescricao(String descricao)
		{
			this.descricao = descricao;
		}

		@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
		@JsonIgnoreProperties("categoria")
		private List<Produto> produto;

		public String getDescricao()
		{
			return descricao;
		}

		public void setDescricao(String descricao)
		{
			this.descricao = descricao;
		}

		public List<Produto> getProduto()
		{
			return produto;
		}

		public void setProduto(List<Produto> produto)
		{
			this.produto = produto;
		}
	}


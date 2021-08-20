package com.Farmacia.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_Produto")
public class Produto
{
	
	

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long Id;

		@NotBlank
		private String nome;

		@NotBlank
		private double preco;

		@ManyToOne
		@JsonIgnoreProperties("tb_produtos")
		private Categoria categoria;

		public Long getId()
		{
			return Id;
		}

		public void setId(Long id)
		{
			Id = id;
		}

		public String getNome()
		{
			return nome;
		}

		public void setNome(String nome)
		{
			this.nome = nome;
		}

		public double getPreco()
		{
			return preco;
		}

		public void setPreco(double preco)
		{
			this.preco = preco;
		}

		public Categoria getCategoria()
		{
			return categoria;
		}

		public void setCategoria(Categoria categoria)
		{
			this.categoria = categoria;
		}

	}


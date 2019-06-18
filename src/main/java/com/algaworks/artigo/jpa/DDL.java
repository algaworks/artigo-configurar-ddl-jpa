package com.algaworks.artigo.jpa;

import java.util.HashMap;

import javax.persistence.Persistence;

public class DDL {

	public static void main(String... string) {
		Persistence.generateSchema("GerarDDL-PU", new HashMap<>());
	}
}

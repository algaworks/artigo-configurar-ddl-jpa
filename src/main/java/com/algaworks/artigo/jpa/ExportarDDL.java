package com.algaworks.artigo.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Persistence;

public class ExportarDDL {

	public static void main(String... string) {
		Map<String, String> properties = new HashMap<>();

		properties.put("javax.persistence.schema-generation.scripts.action", "drop-and-create");
		properties.put("javax.persistence.schema-generation.scripts.create-target", "/tmp/ddl/script-criacao-exportado.sql");
		properties.put("javax.persistence.schema-generation.scripts.drop-target", "/tmp/ddl/script-remocao-exportado.sql");
		
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		properties.put("hibernate.format_sql", "true");
		
		Persistence.generateSchema("GerarDDL-PU", properties);
	}
}

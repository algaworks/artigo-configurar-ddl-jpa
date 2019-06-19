package com.algaworks.artigo.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Persistence;

public class ExecutarDDL {

	public static void main(String... string) {
		Map<String, String> properties = new HashMap<>();
		
		properties.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost/sistemaerp?createDatabaseIfNotExist=true");
		properties.put("javax.persistence.jdbc.user", "root");
		properties.put("javax.persistence.jdbc.password", "123");
		
		properties.put("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
		
		properties.put("javax.persistence.schema-generation.database.action", "drop-and-create");

		properties.put("javax.persistence.schema-generation.create-source", "metadata-then-script");
		properties.put("javax.persistence.schema-generation.drop-source", "metadata-then-script");
		
		properties.put("javax.persistence.schema-generation.create-script-source", "META-INF/ddl/script-criacao.sql");
		properties.put("javax.persistence.schema-generation.drop-script-source", "META-INF/ddl/script-remocao.sql");
		
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		Persistence.generateSchema("GerarDDL-PU", properties);
	}
}

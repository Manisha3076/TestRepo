package util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HiberUtil {
	
	static SessionFactory sessionfactory=null;
	static{
		
		Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect"); // Example dialect, change for your DB
        properties.put("hibernate.hbm2ddl.auto", "update"); // Creates or updates the schema
        properties.put("hibernate.show_sql", "true"); // Shows SQL in the console
        properties.put("hibernate.format_sql", "true"); // Formats SQL for better readability
       // properties.put("hibernate.connection.driver_class", "org.h2.Driver"); // Your DB driver
        properties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/test3"); // Your DB URL
        properties.put("hibernate.connection.username", "root"); // Your DB username
        properties.put("hibernate.connection.password", "Root"); // Your DB password
       	properties.put("cache.use_second_level_cache", "true");
		properties.put("cache.region.factory_class", "org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");
        // Configuration object
        Configuration configuration = new Configuration();
        configuration.setProperties(properties);

        // Add annotated classes (entities)
        configuration.addAnnotatedClass(models.Student.class); // Replace with your entity class

        // ServiceRegistry for Hibernate
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        // Build and return the SessionFactory
        sessionfactory= configuration.buildSessionFactory(serviceRegistry);
		
	}

	private HiberUtil() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionfactory;
	}

}

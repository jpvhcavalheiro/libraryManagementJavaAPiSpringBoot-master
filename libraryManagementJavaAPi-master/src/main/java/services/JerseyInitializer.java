package services;

import org.glassfish.jersey.server.ResourceConfig;

public class JerseyInitializer extends ResourceConfig {
	public JerseyInitializer() {
		registerEndpoints();
	}
	
	private void registerEndpoints() {
		register(BookServices.class);
		register(HistoryServices.class);
		register(UserServices.class);
	}
}

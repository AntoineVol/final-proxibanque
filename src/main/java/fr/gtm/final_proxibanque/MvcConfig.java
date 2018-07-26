package fr.gtm.final_proxibanque;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "fr.gtm.final_proxibanque.web", "fr.gtm.final_proxibanque.business" })
@EnableJpaRepositories(basePackages = { "fr.gtm.final_proxibanque.dao" })
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(final CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*").allowCredentials(true)
				.maxAge(3600);
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		final LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setPersistenceUnitName("proxybanque_v4");
		return lcemfb;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		final PlatformTransactionManager tm = new JpaTransactionManager(this.entityManagerFactory().getObject());
		return tm;
	}

}

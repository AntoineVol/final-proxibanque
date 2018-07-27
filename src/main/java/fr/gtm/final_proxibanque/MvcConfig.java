package fr.gtm.final_proxibanque;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Le MvcConfig a pour vocation de parametrer Spring en le lien à sa
 * persistence, au viwResolver, à la gestion des transaction, au container de
 * bean. Un paramétrage du Cors permet aussi l'echange de requête entre le back
 * et le front
 *
 * @author Kamir Elsisi, Steven Roman, Antoine Volatron
 *
 */
@SuppressWarnings("deprecation")
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "fr.gtm.final_proxibanque.web", "fr.gtm.final_proxibanque.business" })
@EnableJpaRepositories(basePackages = { "fr.gtm.final_proxibanque.dao" })
public class MvcConfig extends WebMvcConfigurerAdapter {
	static final int CORS_AGE = 3600;

	/**
	 * Le addCorsMappings permet de receptionner les requêtes venant d'un autres
	 * domaine. Dans notre cas la partie front étant du coté d'angular, ce
	 * paramétrage nous permet d'échanger à travers les deux ports
	 *
	 **/
	@Override
	public void addCorsMappings(final CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*").allowCredentials(true)
				.maxAge(MvcConfig.CORS_AGE);
	}

	/**
	 * Le LocalContainerEntityManagerFactoryBean permet de parametrer le container
	 * de bean à partir de la persistence paramétrer dans le fichier persistence.xml
	 *
	 * @return Le conteneur de bean
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		final LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setPersistenceUnitName("proxibanque_v4");
		return lcemfb;
	}

	/**
	 * La methode internalResourceViewResolver permet de paramétrer ou rechercher
	 * les pages JSP lors de leurs appel dans les controller
	 *
	 * @return Le bean de la JSP
	 */
	@Bean
	public ViewResolver internalResourceViewResolver() {
		final InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/view/");
		bean.setSuffix(".jsp");
		return bean;
	}

	/**
	 * Le transactionManager gère les différentes transaction avec la base de
	 * données
	 *
	 * @return La platform de transaction
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(this.entityManagerFactory().getObject());
	}

}

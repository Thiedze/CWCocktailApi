package de.cw.cwcocktailapi.configuration;

import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager", basePackages = {
    "de.cw.cwcocktailapi.repository"})
@EnableTransactionManagement
@EnableAutoConfiguration
public class JpaConfiguration {

  @Primary
  @Bean(name = "entityManagerFactory")
  public EntityManagerFactory entityManagerFactory(@Qualifier("dataSource") DataSource dataSource) {
    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    vendorAdapter.setGenerateDdl(false);
    vendorAdapter.setShowSql(false);
    vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
    LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
    factoryBean.setJpaVendorAdapter(vendorAdapter);
    factoryBean.setPackagesToScan("de.cw.cwcocktailapi.domain");
    factoryBean.setDataSource(dataSource);
    Properties jpaProperties = new Properties();
    jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
    factoryBean.setJpaProperties(jpaProperties);
    factoryBean.afterPropertiesSet();
    return factoryBean.getObject();
  }

  @Bean(name = "entityManager")
  public EntityManager entityManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
    return entityManagerFactory.createEntityManager();
  }

  @Bean(name = "transactionManager")
  public PlatformTransactionManager transactionManager(
      @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
    jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
    return jpaTransactionManager;
  }

  @Bean(name = "dataSource")
  @ConfigurationProperties("datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().type(BasicDataSource.class).build();
  }
}

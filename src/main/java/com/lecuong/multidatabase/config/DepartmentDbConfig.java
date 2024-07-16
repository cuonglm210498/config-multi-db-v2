package com.lecuong.multidatabase.config;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author CuongLM
 * @created 06/07/2024 - 00:09
 * @project multi-database
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.lecuong.multidatabase.repository.departmentrepository",
        entityManagerFactoryRef = "entityManagerDepartment",
        transactionManagerRef = "transactionManagerDepartment"
)
public class DepartmentDbConfig {

    @Autowired
    private Environment env;
    public static final String PERSISTENCE_UNIT_NAME = "departmentDatasourcePersistence";

    @Bean
    @ConfigurationProperties("spring.datasource.department-service")
    public DataSourceProperties departmentDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.hikari")
    public DataSource departmentDataSource() {
        return departmentDataSourceProperties()
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerDepartment() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(departmentDataSource());
        em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        em.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
        em.setPackagesToScan("com.lecuong.multidatabase.entity.departmentservice");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        return em;
    }

    @Bean
    public JdbcTemplate departmentJdbcTemplate(@Qualifier("departmentDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    @Primary
    public PlatformTransactionManager transactionManagerDepartment() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerDepartment().getObject());
        return transactionManager;
    }
}

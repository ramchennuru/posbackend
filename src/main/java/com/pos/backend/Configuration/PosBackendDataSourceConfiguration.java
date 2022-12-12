package com.pos.backend.Configuration;


import com.pos.backend.ProductDetailsModel.ProductDetailModel;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.pos.backend.ProductDetailsRepository",
        entityManagerFactoryRef = "posbackendEntityManagerFactory",
        transactionManagerRef = "posbackendTransactionManager")
public class PosBackendDataSourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.posbackend")
    public DataSourceProperties posbackendDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.posbackend.configuration")
    public DataSource posbackendDataSource() {
        return posbackendDataSourceProperties().initializeDataSourceBuilder()
                .type( HikariDataSource.class).build();
    }

    @Bean(name = "posbackendEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean posbackendEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(posbackendDataSource())
                .packages(ProductDetailModel.class)
                .build();
    }

    @Bean(name = "posbackendTransactionManager")
    public PlatformTransactionManager posbackendTransactionManager(
            final @Qualifier("posbackendEntityManagerFactory") LocalContainerEntityManagerFactoryBean posbackendEntityManagerFactory) {
        return new JpaTransactionManager(posbackendEntityManagerFactory.getObject());
    }

}

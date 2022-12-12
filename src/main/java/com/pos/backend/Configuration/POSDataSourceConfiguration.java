package com.pos.backend.Configuration;

import com.pos.backend.BOSS.PosModel;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.pos.backend.BOSS",
        entityManagerFactoryRef = "posEntityManagerFactory",
        transactionManagerRef = "posTransactionManager")

public class POSDataSourceConfiguration {
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.pos")
    public DataSourceProperties posDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.pos.configuration")
    public DataSource posDataSource() {
        return posDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Primary
    @Bean(name = "posEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean posEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(posDataSource())
                .packages(PosModel.class, PriceModel.class)
                .build();
    }

    @Primary
    @Bean(name = "posTransactionManager")
    public PlatformTransactionManager posTransactionManager(
            final @Qualifier("posEntityManagerFactory") LocalContainerEntityManagerFactoryBean posEntityManagerFactory) {
        return new JpaTransactionManager(posEntityManagerFactory.getObject());
    }
}

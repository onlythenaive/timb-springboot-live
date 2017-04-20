package ru.tsystems.javaschool.lectures.springboot;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class PersistenceConfiguration {

    // Data Source

    @Bean
    @Profile("dev")
    public DataSource dataSourceHsql() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .generateUniqueName(true)
                .build();
    }

    // Mapping DATA -> CLASSES
    @Bean
    @Profile("dev")
    public HibernateJpaVendorAdapter vendorAdapterHsql() {
        final HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.HSQL);
        adapter.setGenerateDdl(true);
        return adapter;
    }

    @Bean
    @Profile("prod")
    public DataSource dataSourceMysql() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/spring");
        dataSource.setUsername("app");
        dataSource.setPassword("app");
        return dataSource;
    }

    @Bean
    @Profile("prod")
    public HibernateJpaVendorAdapter vendorAdapterMysql() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.MYSQL);
        vendorAdapter.setShowSql(true);
        vendorAdapter.setGenerateDdl(false);
        return vendorAdapter;
    }


    // Controls entities
    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource, HibernateJpaVendorAdapter adapter) {
        final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(adapter);
        factory.setPackagesToScan(Application.class.getPackage().getName());
        factory.setDataSource(dataSource);
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory factory) {
        final JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(factory);
        return manager;
    }
}

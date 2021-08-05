//package me.nglow.springjpabasic.config;
//
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "primaryEntityManagerFactory",
//        transactionManagerRef = "primaryTransactionManager",
//        basePackages = { "com.example.demo.primary.repository" }
//)
//public class PrimaryDataSourceConfig {
//
//    @Primary
//    @Bean
//    @ConfigurationProperties("primary.datasource")
//    public DataSourceProperties primaryDataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Primary
//    @Bean
//    @ConfigurationProperties("primary.datasource.configuration")
//    public DataSource primaryDataSource(@Qualifier("primaryDataSourceProperties") DataSourceProperties dataSourceProperties) {
//        return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
//    }
//
//    @Primary
//    @Bean
//    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(EntityManagerFactoryBuilder builder,
//                                                                              @Qualifier("primaryDataSource") DataSource dataSource) {
//        return builder
//                .dataSource(dataSource)
//                .packages("com.example.demo.primary.model")
//                .persistenceUnit("primaryEntityManager")
//                .build();
//    }
//
//    @Primary
//    @Bean
//    public PlatformTransactionManager primaryTransactionManager(@Qualifier("primaryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//}

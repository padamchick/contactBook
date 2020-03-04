package contactbook.application.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = "contactbook.application.repository.user",
        entityManagerFactoryRef = "userEntityManager",
        transactionManagerRef = "userTransactionManager")
@EnableTransactionManagement
public class PersistenceUserAutoConfiguration {

    @Primary
    @Bean(name="userDataSource")
    @ConfigurationProperties(prefix = "security.datasource")
    public DataSource userDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name="userEntityManager")
    public LocalContainerEntityManagerFactoryBean userEntityManager(EntityManagerFactoryBuilder builder,
                                                                    @Qualifier("userDataSource") DataSource dataSource) {
        Map<String,Object> properties=new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MYSQL5Dialect");

        return builder.dataSource(dataSource).packages("contactbook.application.entity.user").persistenceUnit("User").build();
    }

    @Primary
    @Bean(name="userTransactionManager")
    public PlatformTransactionManager userTransactionManager(@Qualifier("userEntityManager")EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}

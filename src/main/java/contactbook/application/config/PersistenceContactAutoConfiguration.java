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
        basePackages = "contactbook.application.repository.contact",
        entityManagerFactoryRef = "contactEntityManagerFactory",
        transactionManagerRef = "contactTransactionManager")
@EnableTransactionManagement
public class PersistenceContactAutoConfiguration {

    @Bean(name="contactDataSource")
    @ConfigurationProperties(prefix = "app.datasource")
    public DataSource contactDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name="contactEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean contactEntityManager(EntityManagerFactoryBuilder builder,
                                                                    @Qualifier("contactDataSource") DataSource dataSource) {
        Map<String,Object> properties=new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MYSQL5Dialect");

        return builder.dataSource(dataSource).packages("contactbook.application.entity.contact").persistenceUnit("Contact").build();
    }

    @Bean(name="contactTransactionManager")
    public PlatformTransactionManager contactTransactionManager(@Qualifier("contactEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}

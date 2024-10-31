package br.com.eadtt.aula01.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Configuration
public class TransactionConfiguration {

    // Exemplo personalizando todas as transações do spring boot
    @Bean(name = "transactionManager")
    @Primary
    public JpaTransactionManager projetoDefaultTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager platformTransactionManager = new JpaTransactionManager(entityManagerFactory);
        platformTransactionManager.setDefaultTimeout(60 * 60);
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        defaultTransactionDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_SERIALIZABLE);
        return platformTransactionManager;
    }

    // Exemplo de personalização opcional
    @Bean(name = "projetoMapsTransactionManager")
    @Qualifier("projetoMapsTransactionManager")
    public JpaTransactionManager projetoMapsTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager platformTransactionManager = new JpaTransactionManager(entityManagerFactory);
        platformTransactionManager.setDefaultTimeout(60 * 60 * 24) ;
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        defaultTransactionDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        return platformTransactionManager;
    }

}

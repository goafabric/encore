package org.goafabric.encore.xfunctional.auto;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
@Profile("mongodb")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class MongoConfiguration {
    @Configuration
    static class MongoClientConfig extends AbstractMongoClientConfiguration {
        @Value("${spring.data.mongodb.authentication-database}") private String authDb;
        @Value("${spring.data.mongodb.authentication-database}") private String db;
        @Value("${spring.data.mongodb.username}") private String user;
        @Value("${spring.data.mongodb.password}") private String password;

        @Override
        protected String getDatabaseName() {
            return db;
        }

        @Override
        protected void configureClientSettings(MongoClientSettings.Builder builder) {
            builder.credential(MongoCredential.createCredential(user, authDb, password.toCharArray()));
        }
    }
}

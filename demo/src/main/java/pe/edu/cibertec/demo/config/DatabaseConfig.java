package pe.edu.cibertec.demo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    @Value("${DB_FILM_URL}")
    private String dbFilmUrl;

    @Value("${DB_FILM_USER}")
    private String dbFilmUser;

    @Value("${DB_FILM_PASS}")
    private String dbFilmPass;

    @Value("${DB_FILM_DRIVER}")
    private String dbFilmDriver;

    @Bean
    public HikariDataSource hikariDataSource() {
        HikariConfig config = new HikariConfig();


        config.setJdbcUrl(dbFilmUrl);
        config.setUsername(dbFilmUser);
        config.setPassword(dbFilmPass);
        config.setDriverClassName(dbFilmDriver);


        config.setMaximumPoolSize(20);
        config.setMinimumIdle(5);
        config.setIdleTimeout(300000); // 5 minutos
        config.setConnectionTimeout(30000); // 30 segundos

        System.out.println("###### HikariCP initialized for film_db ######");

        return new HikariDataSource(config);
    }
}

package com.example.medical.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableAspectJAutoProxy
@EnableJpaRepositories(basePackages = {"com.example.medical"})
@EnableAsync
@EnableScheduling
public class Config {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource config = new DriverManagerDataSource();
        config.setUrl("jdbc:postgresql://localhost:5432/medical");
        config.setUsername("postgres");
        config.setPassword("7059314");
        config.setDriverClassName("org.postgresql.Driver");
        return config;
    }
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.mail.ru");
        mailSender.setPort(465);

        mailSender.setUsername("mireaspringexample@bk.ru");
        mailSender.setPassword("SqHZWEqdrfmLyFcYKaYp");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtp.auth", "true");
        props.put("smtp.ssl.enable", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    /*
    @Bean
    public EmailService getEmailService(){
        return new EmailService();
    } */
}

package ru.innopolis.publicator.server.config;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.security.core.userdetails.UserDetailsService;

    @Configuration
    @ComponentScan("ru.innopolis.publicator.server")
    public class WebServiceConfig {

        @Bean
        public MapperFacade getMapperFacade() {
            return new DefaultMapperFactory.Builder().build().getMapperFacade();
        }

        @Bean
        public RmiServiceExporter registerServiceUser(UserDetailsService userDetailsService) {
            RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
            rmiServiceExporter.setServiceName("UserDetailsService");
            rmiServiceExporter.setService(userDetailsService);
            rmiServiceExporter.setServiceInterface(UserDetailsService.class);
            rmiServiceExporter.setRegistryPort(5000);
            return rmiServiceExporter;
        }
}

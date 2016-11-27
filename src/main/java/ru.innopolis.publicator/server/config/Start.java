package ru.innopolis.publicator.server.config;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class Start {
    public static void main(String[] args) {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        // Регистрируем в контексте конфигурационный класс MVC, Security
        ctx.register(WebServiceConfig.class);
        ctx.register(JPAConfig.class);
        ctx.refresh();
    }
}

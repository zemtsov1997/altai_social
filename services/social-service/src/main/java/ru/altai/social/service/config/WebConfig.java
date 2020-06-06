package ru.altai.social.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.altai.service.api.converter.DateConverter;
import ru.altai.service.api.converter.LocalDateConverter;
import ru.altai.service.api.converter.LocalDateTimeConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired private DateConverter converterDate;
    @Autowired private LocalDateConverter converterLocalDate;
    @Autowired private LocalDateTimeConverter localDateTimeConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(converterDate);
        registry.addConverter(converterLocalDate);
        registry.addConverter(localDateTimeConverter);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*");
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

}

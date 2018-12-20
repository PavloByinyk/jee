package rootpackage.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;


// Говорим, что это конфигурация
@Configuration
// Включаем MVC
@EnableWebMvc
// Указываем где искать контроллеры и остальные компоненты
@ComponentScan(basePackages = "rootpackage.controller")
public class WebAppConfig {

    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setOrder(1);
        // указываем где будут лежать наши веб-страницы
        resolver.setPrefix("/WEB-INF/pages/");
        // формат View который мы будем использовать
        resolver.setSuffix(".html");
        resolver.setViewClass(JstlView.class);

        return resolver;
    }

}

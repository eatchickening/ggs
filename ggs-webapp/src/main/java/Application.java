import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 */
@SpringBootApplication
@ComponentScan(basePackages ={"io.chicken.ggs"})
//mybatis路劲自动扫面
@MapperScan("io.chicken.ggs.dal")
// @ServletComponentScan(value = "io.chicken.ggs.web.filter")
// @ImportResource({"classpath:spring-bean.xml""})
//@EnableWebMvc
@EnableSwagger2
public class Application extends SpringBootServletInitializer {

    // @RequestMapping("/")
    // @ResponseBody
    // public String index() {
    //     return "Hello World!";
    // }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

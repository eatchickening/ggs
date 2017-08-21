import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@SpringBootApplication
@ComponentScan(basePackages ={"io.checken.ggs"})
//mybatis路劲自动扫面
// @MapperScan("io.checken.ggs.dal")
@ServletComponentScan(value = "io.checken.ggs.web.filter")
// @ImportResource({"classpath:spring-bean.xml""})
public class Application extends SpringBootServletInitializer {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

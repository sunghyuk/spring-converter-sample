package sunghyuk.spring.converter.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.convert.ConversionService;
import sunghyuk.spring.converter.sample.dto.UserDto;
import sunghyuk.spring.converter.sample.entity.UserEntity;

import java.util.Date;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        UserEntity entity = new UserEntity();
        entity.setId(111);
        entity.setName("name");
        entity.setCreatedAt(new Date());

        ConversionService service = context.getBean(ConversionService.class);
        UserDto dto = service.convert(entity, UserDto.class);

        System.out.println("id: " + entity.getId() + " = " + dto.getId());
        System.out.println("name: " + entity.getName() + " = " + dto.getName());
        System.out.println("created at: " + entity.getCreatedAt() + " = " + dto.getCreatedAt());

    }

}

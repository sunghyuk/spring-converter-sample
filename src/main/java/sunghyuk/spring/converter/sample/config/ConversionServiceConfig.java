package sunghyuk.spring.converter.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import sunghyuk.spring.converter.sample.converter.DtoConverterBeanPostProcessor;

@Configuration
public class ConversionServiceConfig {

    @Bean
    public GenericConversionService conversionService() {
        return new GenericConversionService();
    }

    @Bean
    public DtoConverterBeanPostProcessor dtoConverterBeanPostProcessor(GenericConversionService conversionService) {
        DtoConverterBeanPostProcessor processor = new DtoConverterBeanPostProcessor();
        processor.setConversionService(conversionService);
        return processor;
    }

}

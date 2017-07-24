package sunghyuk.spring.converter.sample.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.util.Assert;

public class DtoConverterBeanPostProcessor implements BeanPostProcessor, InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(DtoConverterBeanPostProcessor.class);

    private GenericConversionService conversionService = null;

    public void setConversionService(GenericConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //logger.info("### post process: {}", beanName);
        DtoConverter annotation = AnnotationUtils.findAnnotation(bean.getClass(), DtoConverter.class);
        if (annotation != null) {
            logger.info("### register converter. {}", beanName);
            Converter converter = (Converter) bean;
            conversionService.addConverter(converter);
        }
        return bean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(this.conversionService, "GenericConversionService must be not null");
    }
}

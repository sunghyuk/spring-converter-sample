package sunghyuk.spring.converter.sample.converter;

import org.springframework.core.convert.converter.Converter;
import sunghyuk.spring.converter.sample.dto.UserDto;
import sunghyuk.spring.converter.sample.entity.UserEntity;

@DtoConverter
public class UserDtoConverter implements Converter<UserEntity, UserDto> {

    @Override
    public UserDto convert(UserEntity source) {
        UserDto dto  = new UserDto();
        dto.setId(source.getId());
        dto.setName(source.getName());
        dto.setCreatedAt(source.getCreatedAt());
        return dto;
    }
}

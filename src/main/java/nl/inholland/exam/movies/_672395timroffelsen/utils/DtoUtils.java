package nl.inholland.exam.movies._672395timroffelsen.utils;

import nl.inholland.exam.movies._672395timroffelsen.model.dto.DTOEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DtoUtils
{
    public DTOEntity convertToDto(Object obj, DTOEntity mapper)
    {
        return new ModelMapper().map(obj, mapper.getClass());
    }

    public Object convertToEntity(Object obj, DTOEntity mapper)
    {
        return new ModelMapper().map(mapper, obj.getClass());
    }

    public List<DTOEntity> convertListToDto(List<?> objList, DTOEntity mapper){
        return objList
                .stream()
                .map(source -> new ModelMapper().map(source, mapper.getClass()))
                .collect(Collectors.toList());
    }
}

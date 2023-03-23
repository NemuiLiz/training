package de.allianz.training.config;

import de.allianz.training.dto.ToDoCreateRequest;
import de.allianz.training.entity.ToDo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    /**
     * Creates a ModelMapper which enables us to merge objects
     * This is mainly used to map the data transfer objects to the entities
     *
     * @return ModelMapper
     */

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        return modelMapper;
    }
}

package com.model.sistem.controller;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

import com.model.sistem.exceptions.CopyPropertiesException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
public abstract class GenericMapper<E, D> {

    private static Logger logger = LoggerFactory.getLogger(GenericMapper.class);
	 @Autowired
	 private ModelMapper modelMapper;

	 private Class<E> entityClass;
	 private Class<D> dtoClass;
	 
	 public GenericMapper() {
		Type type = getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) type;
        entityClass = (Class<E>) paramType.getActualTypeArguments()[0];
        dtoClass = (Class<D>) paramType.getActualTypeArguments()[1];
	 }
   
	
	 protected E toEntity(D d) {
			return modelMapper.map(d, this.entityClass);
	}
		
	 protected D toDTO(E entity){
			return modelMapper.map(entity, this.dtoClass);
	}
	
	 protected List<D> toDTOList(List<E> entityList) throws CopyPropertiesException{
        return entityList
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

	 protected List<E> toEntityList(List<D> dtoList) throws CopyPropertiesException{
        return dtoList
                .stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
	 
	 
	 protected String formatMessage(BindingResult result){
	        List<String> errors = result.getFieldErrors().stream()
	                .map(err ->{
	                    return err.getField()+": "+ err.getDefaultMessage();

	                }).collect(Collectors.toList());
	        return errors.stream()
	        	      .collect(Collectors.joining(", "));
	       
	    }

}

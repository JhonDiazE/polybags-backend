package com.model.sistem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.model.sistem.dto.DesarrolloEstructuraDTO;
import com.model.sistem.entities.DesarrolloEstructura;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.service.DesarrolloEstructuraService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping(value="/desarrolloEstructura")
public class DesarrolloEstructuraController  extends GenericMapper<DesarrolloEstructura, DesarrolloEstructuraDTO> {

	@Autowired
	private DesarrolloEstructuraService desarrolloEstructuraService;

	
	@ApiOperation(value = "Dar de alta a los desarrolloEstructuras", notes = "Guardar campos necesarios del desarrolloEstructura")
	@PostMapping("/")
	public ResponseEntity<DesarrolloEstructuraDTO> save(@Valid @RequestBody DesarrolloEstructuraDTO desarrolloEstructuraDTO, BindingResult result) {
		 if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        return new ResponseEntity<>(toDTO(desarrolloEstructuraService.save(toEntity(desarrolloEstructuraDTO))), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Get all DesarrolloEstructuras")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DesarrolloEstructuraDTO>> findAll() {
	        List<DesarrolloEstructura> list = desarrolloEstructuraService.findAll();
	        if(CollectionUtils.isEmpty(list))
	        	return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(toDTOList(list));
	}

	
	@ApiOperation(value = "Get DesarrolloEstructura by id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DesarrolloEstructuraDTO> findById(@PathVariable("id") Integer id) throws ObjectNotFoundException{
		return ResponseEntity.ok(toDTO(desarrolloEstructuraService.findById(id)));
    }


    @ApiOperation(value = "Delete a Nego movement by id")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") Integer id) throws ObjectNotFoundException{
        desarrolloEstructuraService.delete(id);
		return ResponseEntity.ok().build();

    }

	
}

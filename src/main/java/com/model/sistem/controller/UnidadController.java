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

import com.model.sistem.dto.UnidadDTO;
import com.model.sistem.entities.Unidad;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.service.UnidadService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping(value="/unidad")
public class UnidadController  extends GenericMapper<Unidad, UnidadDTO> {

	@Autowired
	private UnidadService UnidadeService;

	
	@ApiOperation(value = "Dar de alta a los Unidades", notes = "Guardar campos necesarios del Unidade")
	@PostMapping("/")
	public ResponseEntity<UnidadDTO> save(@Valid @RequestBody UnidadDTO UnidadeDTO, BindingResult result) {
		 if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        return new ResponseEntity<>(toDTO(UnidadeService.save(toEntity(UnidadeDTO))), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Get all Unidades")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UnidadDTO>> findAll() {
	        List<Unidad> list = UnidadeService.findAll();
	        if(CollectionUtils.isEmpty(list))
	        	return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(toDTOList(list));
	}

	
	@ApiOperation(value = "Get Unidad by id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UnidadDTO> findById(@PathVariable("id") Integer id) throws ObjectNotFoundException{
		return ResponseEntity.ok(toDTO(UnidadeService.findById(id)));
    }


    @ApiOperation(value = "Delete a unidad by id")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") Integer id) throws ObjectNotFoundException{
        UnidadeService.delete(id);
		return ResponseEntity.ok().build();

    }

	
}

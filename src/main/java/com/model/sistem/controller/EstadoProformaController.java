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

import com.model.sistem.dto.EstadoProformaDTO;
import com.model.sistem.entities.EstadoProforma;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.service.EstadoProformaService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping(value="/estadoProforma")
public class EstadoProformaController  extends GenericMapper<EstadoProforma, EstadoProformaDTO> {

	@Autowired
	private EstadoProformaService estadoProformaService;

	
	@ApiOperation(value = "Dar de alta a los estadoProformas", notes = "Guardar campos necesarios del estadoProforma")
	@PostMapping("/")
	public ResponseEntity<EstadoProformaDTO> save(@Valid @RequestBody EstadoProformaDTO estadoProformaDTO, BindingResult result) {
		 if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        return new ResponseEntity<>(toDTO(estadoProformaService.save(toEntity(estadoProformaDTO))), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Get all estadoProforma")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstadoProformaDTO>> findAll() {
	        List<EstadoProforma> list = estadoProformaService.findAll();
	        if(CollectionUtils.isEmpty(list))
	        	return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(toDTOList(list));
	}

	
	@ApiOperation(value = "Get client by id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstadoProformaDTO> findById(@PathVariable("id") Long id) throws ObjectNotFoundException{
		return ResponseEntity.ok(toDTO(estadoProformaService.findById(id)));
    }


    @ApiOperation(value = "Delete a Estado proforma by id")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") Long id) throws ObjectNotFoundException{
        estadoProformaService.delete(id);
		return ResponseEntity.ok().build();

    }

	
}

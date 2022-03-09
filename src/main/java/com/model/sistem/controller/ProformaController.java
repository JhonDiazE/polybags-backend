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

import com.model.sistem.dto.ProformaDTO;
import com.model.sistem.entities.Proforma;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.service.ProformaService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping(value="/proforma")
public class ProformaController  extends GenericMapper<Proforma, ProformaDTO> {

	@Autowired
	private ProformaService proformaService;

	
	@ApiOperation(value = "Dar de alta a los proformas", notes = "Guardar campos necesarios del proforma")
	@PostMapping("/")
	public ResponseEntity<ProformaDTO> save(@Valid @RequestBody ProformaDTO proformaDTO, BindingResult result) {
		 if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        return new ResponseEntity<>(toDTO(proformaService.save(toEntity(proformaDTO))), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Get all proforma")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProformaDTO>> findAll() {
	        List<Proforma> list = proformaService.findAll();
	        if(CollectionUtils.isEmpty(list))
	        	return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(toDTOList(list));
	}

	
	@ApiOperation(value = "Get client by id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProformaDTO> findById(@PathVariable("id") Long id) throws ObjectNotFoundException{
		return ResponseEntity.ok(toDTO(proformaService.findById(id)));
    }


    @ApiOperation(value = "Delete a proforma by id")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") Long id) throws ObjectNotFoundException{
        proformaService.delete(id);
		return ResponseEntity.ok().build();

    }

	
}

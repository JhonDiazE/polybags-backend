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

import com.model.sistem.dto.VendedorDTO;
import com.model.sistem.entities.Vendedor;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.service.VendedorService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping(value="/vendedor")
public class VendedorController  extends GenericMapper<Vendedor, VendedorDTO> {

	@Autowired
	private VendedorService vendedorService;

	
	@ApiOperation(value = "Dar de alta a los vendedors", notes = "Guardar campos necesarios del vendedor")
	@PostMapping("/")
	public ResponseEntity<VendedorDTO> save(@Valid @RequestBody VendedorDTO vendedorDTO, BindingResult result) {
		 if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        return new ResponseEntity<>(toDTO(vendedorService.save(toEntity(vendedorDTO))), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Get all vendedor")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VendedorDTO>> findAll() {
	        List<Vendedor> list = vendedorService.findAll();
	        if(CollectionUtils.isEmpty(list))
	        	return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(toDTOList(list));
	}

	
	@ApiOperation(value = "Get vendedor by id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VendedorDTO> findById(@PathVariable("id") Integer id) throws ObjectNotFoundException{
		return ResponseEntity.ok(toDTO(vendedorService.findById(id)));
    }


    @ApiOperation(value = "Delete vendedor by id")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") Integer id) throws ObjectNotFoundException{
        vendedorService.delete(id);
		return ResponseEntity.ok().build();

    }

	
}

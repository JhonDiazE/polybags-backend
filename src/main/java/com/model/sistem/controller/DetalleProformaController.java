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

import com.model.sistem.dto.DetalleProformaDTO;
import com.model.sistem.entities.DetalleProforma;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.service.DetalleProformaService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping(value="/detalleProforma")
public class DetalleProformaController  extends GenericMapper<DetalleProforma, DetalleProformaDTO> {

	@Autowired
	private DetalleProformaService detalleProformaService;

	
	@ApiOperation(value = "Dar de alta a los detalleProformas", notes = "Guardar campos necesarios del detalleProforma")
	@PostMapping("/")
	public ResponseEntity<DetalleProformaDTO> save(@Valid @RequestBody DetalleProformaDTO detalleProformaDTO, BindingResult result) {
		 if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        return new ResponseEntity<>(toDTO(detalleProformaService.save(toEntity(detalleProformaDTO))), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Get all DetalleProforma")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DetalleProformaDTO>> findAll() {
	        List<DetalleProforma> list = detalleProformaService.findAll();
	        if(CollectionUtils.isEmpty(list))
	        	return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(toDTOList(list));
	}

	
	@ApiOperation(value = "Get client by id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DetalleProformaDTO> findById(@PathVariable("id") Long id) throws ObjectNotFoundException{
		return ResponseEntity.ok(toDTO(detalleProformaService.findById(id)));
    }


    @ApiOperation(value = "Delete a DetalleProforma by id")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") Long id) throws ObjectNotFoundException{
        detalleProformaService.delete(id);
		return ResponseEntity.ok().build();

    }

	
}

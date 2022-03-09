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

import com.model.sistem.dto.CondicionPagoDTO;
import com.model.sistem.entities.CondicionPago;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.service.CondicionPagoService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping(value="/condicionPago")
public class CondicionPagoController  extends GenericMapper<CondicionPago, CondicionPagoDTO> {

	@Autowired
	private CondicionPagoService condicionPagoService;

	
	@ApiOperation(value = "Dar de alta a los condicionPagos", notes = "Guardar campos necesarios del condicionPago")
	@PostMapping("/")
	public ResponseEntity<CondicionPagoDTO> save(@Valid @RequestBody CondicionPagoDTO condicionPagoDTO, BindingResult result) {
		 if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        return new ResponseEntity<>(toDTO(condicionPagoService.save(toEntity(condicionPagoDTO))), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Get all CondicionPagos")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CondicionPagoDTO>> findAll() {
	        List<CondicionPago> list = condicionPagoService.findAll();
	        if(CollectionUtils.isEmpty(list))
	        	return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(toDTOList(list));
	}

	
	@ApiOperation(value = "Get CondicionPago by id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CondicionPagoDTO> findById(@PathVariable("id") Integer id) throws ObjectNotFoundException{
		return ResponseEntity.ok(toDTO(condicionPagoService.findById(id)));
    }


    @ApiOperation(value = "Delete a COndicionPago by id")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") Integer id) throws ObjectNotFoundException{
        condicionPagoService.delete(id);
		return ResponseEntity.ok().build();

    }

	
}

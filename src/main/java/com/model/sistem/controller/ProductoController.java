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

import com.model.sistem.dto.ProductoDTO;
import com.model.sistem.entities.Producto;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.service.ProductoService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping(value="/producto")
public class ProductoController  extends GenericMapper<Producto, ProductoDTO> {

	@Autowired
	private ProductoService productoService;

	
	@ApiOperation(value = "Dar de alta a los productos", notes = "Guardar campos necesarios del producto")
	@PostMapping("/")
	public ResponseEntity<ProductoDTO> save(@Valid @RequestBody ProductoDTO productoDTO, BindingResult result) {
		 if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        return new ResponseEntity<>(toDTO(productoService.save(toEntity(productoDTO))), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Get all producto")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductoDTO>> findAll() {
	        List<Producto> list = productoService.findAll();
	        if(CollectionUtils.isEmpty(list))
	        	return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(toDTOList(list));
	}

	
	@ApiOperation(value = "Get producto by id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductoDTO> findById(@PathVariable("id") String id) throws ObjectNotFoundException{
		return ResponseEntity.ok(toDTO(productoService.findById(id)));
    }


    @ApiOperation(value = "Delete a producto by id")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") String id) throws ObjectNotFoundException{
        productoService.delete(id);
		return ResponseEntity.ok().build();

    }

	
}

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.model.sistem.dto.CategoriaDTO;
import com.model.sistem.entities.Categoria;
import com.model.sistem.entities.Linea;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.service.CategoriaService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping(value="/categoria")
public class CategoriaController  extends GenericMapper<Categoria, CategoriaDTO> {

	@Autowired
	private CategoriaService categoriaService;

	
	@ApiOperation(value = "Dar de alta a los categorias", notes = "Guardar campos necesarios del categoria")
	@PostMapping("/")
	public ResponseEntity<CategoriaDTO> save(@Valid @RequestBody CategoriaDTO categoriaDTO, BindingResult result) {
		 if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        return new ResponseEntity<>(toDTO(categoriaService.save(toEntity(categoriaDTO))), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Get all Categorias")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoriaDTO>> findAll() {
	        List<Categoria> list = categoriaService.findAll();
	        if(CollectionUtils.isEmpty(list))
	        	return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(toDTOList(list));
	}
	
	@ApiOperation(value = "Get all categorias for especialidad")
	@GetMapping(value = "/linea", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoriaDTO>> findForLinea(@RequestParam("idLinea") Integer idLinea) {
	        List<Categoria> list = categoriaService.findByEstadoAndLinea(new Linea(idLinea));
	        if(CollectionUtils.isEmpty(list))
	        	return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(toDTOList(list));
	}

	
	@ApiOperation(value = "Get Categoria by id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoriaDTO> findById(@PathVariable("id") Integer id) throws ObjectNotFoundException{
		return ResponseEntity.ok(toDTO(categoriaService.findById(id)));
    }


    @ApiOperation(value = "Delete a Categoria by id")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") Integer id) throws ObjectNotFoundException{
        categoriaService.delete(id);
		return ResponseEntity.ok().build();
    }

	
}

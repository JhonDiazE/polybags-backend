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

import com.model.sistem.dto.DetalleConfiguracionCotizacionDTO;
import com.model.sistem.entities.ConfiguracionCotizacion;
import com.model.sistem.entities.DetalleConfiguracionCotizacion;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.service.DetalleConfiguracionCotizacionService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping(value="/detalleConfiguracionCotizacion")
public class DetalleConfiguracionCotizacionController  extends GenericMapper<DetalleConfiguracionCotizacion, DetalleConfiguracionCotizacionDTO> {

	@Autowired
	private DetalleConfiguracionCotizacionService detalleConfiguracionCotizacionService;

	
	@ApiOperation(value = "Dar de alta a los detalleConfiguracionCotizacions", notes = "Guardar campos necesarios del detalleConfiguracionCotizacion")
	@PostMapping("/")
	public ResponseEntity<DetalleConfiguracionCotizacionDTO> save(@Valid @RequestBody DetalleConfiguracionCotizacionDTO detalleConfiguracionCotizacionDTO, BindingResult result) {
		 if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        return new ResponseEntity<>(toDTO(detalleConfiguracionCotizacionService.save(toEntity(detalleConfiguracionCotizacionDTO))), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Get all DetalleConfiguracionCotizacion")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DetalleConfiguracionCotizacionDTO>> findAll() {
	        List<DetalleConfiguracionCotizacion> list = detalleConfiguracionCotizacionService.findAll();
	        if(CollectionUtils.isEmpty(list))
	        	return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(toDTOList(list));
	}

	
	@ApiOperation(value = "Get DetalleConfiguracionCotizacion by id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DetalleConfiguracionCotizacionDTO> findById(@PathVariable("id") Long id) throws ObjectNotFoundException{
		return ResponseEntity.ok(toDTO(detalleConfiguracionCotizacionService.findById(id)));
    }

	@ApiOperation(value = "Get all DetalleConfiguracionCotizacion for ConfiguracionCotizacion")
	@GetMapping(value = "/configuracionCotizacion", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DetalleConfiguracionCotizacionDTO>> findForCotizacion(@RequestParam("idConfiguracionCotizacion") Integer idConfiguracionCotizacion) {
			ConfiguracionCotizacion configuracionCotizacion = new ConfiguracionCotizacion();
			configuracionCotizacion.setId(idConfiguracionCotizacion);
	        List<DetalleConfiguracionCotizacion> list = detalleConfiguracionCotizacionService.findByConfiguracionCotizacion(configuracionCotizacion);
	        if(CollectionUtils.isEmpty(list))
	        	return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(toDTOList(list));
	}

    @ApiOperation(value = "Delete a DetalleConfiguracionCotizacion by id")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") Long id) throws ObjectNotFoundException{
        detalleConfiguracionCotizacionService.delete(id);
		return ResponseEntity.ok().build();

    }

	
}

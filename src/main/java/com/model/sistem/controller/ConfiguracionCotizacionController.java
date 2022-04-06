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

import com.model.sistem.dto.ConfiguracionCotizacionDTO;
import com.model.sistem.entities.ConfiguracionCotizacion;
import com.model.sistem.entities.ParametroEstadoGeneral;
import com.model.sistem.enums.EstadoEnum;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.service.ConfiguracionCotizacionService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping(value="/configuracionCotizacion")
public class ConfiguracionCotizacionController  extends GenericMapper<ConfiguracionCotizacion, ConfiguracionCotizacionDTO> {

	@Autowired
	private ConfiguracionCotizacionService configuracionCotizacionService;

	
	@ApiOperation(value = "Dar de alta a los configuracionCotizacions", notes = "Guardar campos necesarios del configuracionCotizacion")
	@PostMapping("/")
	public ResponseEntity<ConfiguracionCotizacionDTO> save(@Valid @RequestBody ConfiguracionCotizacionDTO configuracionCotizacionDTO, BindingResult result) {
		 if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        return new ResponseEntity<>(toDTO(configuracionCotizacionService.save(toEntity(configuracionCotizacionDTO))), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Get all ConfiguracionCotizacions")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ConfiguracionCotizacionDTO>> findAll() {
	        List<ConfiguracionCotizacion> list = configuracionCotizacionService.findAll();
	        if(CollectionUtils.isEmpty(list))
	        	return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(toDTOList(list));
	}
	
	@ApiOperation(value = "Get all configuracionCotizacions for tablaParametro")
	@GetMapping(value = "/parametroEstadoGeneral", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ConfiguracionCotizacionDTO>> findByParametroEstadoGeneral(@RequestParam("idParametroEstadoGeneral") Integer idParametroEstadoGeneral,
			@RequestParam("estadoImpresion") String estadoImpresion) {
			ParametroEstadoGeneral parametroEstadogeneral = new ParametroEstadoGeneral();
			parametroEstadogeneral.setId(idParametroEstadoGeneral);
	        List<ConfiguracionCotizacion> list = configuracionCotizacionService.findByEstadoNotAndParametroEstadoGeneralAndEstadoImpresionOrderByDescripcion(EstadoEnum.INACTIVO.getEstado(), parametroEstadogeneral, estadoImpresion);
	        if(CollectionUtils.isEmpty(list))
	        	return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(toDTOList(list));
	}

	
	@ApiOperation(value = "Get ConfiguracionCotizacion by id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConfiguracionCotizacionDTO> findById(@PathVariable("id") Integer id) throws ObjectNotFoundException{
		return ResponseEntity.ok(toDTO(configuracionCotizacionService.findById(id)));
    }


    @ApiOperation(value = "Delete a ConfiguracionCotizacion by id")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") Integer id) throws ObjectNotFoundException{
        configuracionCotizacionService.delete(id);
		return ResponseEntity.ok().build();

    }

	
}

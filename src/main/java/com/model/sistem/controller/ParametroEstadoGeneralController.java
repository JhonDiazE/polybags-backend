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

import com.model.sistem.dto.ParametroEstadoGeneralDTO;
import com.model.sistem.entities.ParametroEstadoGeneral;
import com.model.sistem.enums.EstadoEnum;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.service.ParametroEstadoGeneralService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping(value="/parametroEstadoGeneral")
public class ParametroEstadoGeneralController  extends GenericMapper<ParametroEstadoGeneral, ParametroEstadoGeneralDTO> {

	@Autowired
	private ParametroEstadoGeneralService parametroEstadoGeneralService;

	
	@ApiOperation(value = "Dar de alta a los parametroEstadoGenerals", notes = "Guardar campos necesarios del parametroEstadoGeneral")
	@PostMapping("/")
	public ResponseEntity<ParametroEstadoGeneralDTO> save(@Valid @RequestBody ParametroEstadoGeneralDTO parametroEstadoGeneralDTO, BindingResult result) {
		 if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        return new ResponseEntity<>(toDTO(parametroEstadoGeneralService.save(toEntity(parametroEstadoGeneralDTO))), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Get all ParametroEstadoGenerals")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ParametroEstadoGeneralDTO>> findAll() {
	        List<ParametroEstadoGeneral> list = parametroEstadoGeneralService.findAll();
	        if(CollectionUtils.isEmpty(list))
	        	return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(toDTOList(list));
	}
	
	@ApiOperation(value = "Get all parametroEstadoGenerals for tablaParametro")
	@GetMapping(value = "/cotizacion", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ParametroEstadoGeneralDTO>> findForCotizacion(@RequestParam("tablaParametro") String tablaParametro) {
	        List<ParametroEstadoGeneral> list = parametroEstadoGeneralService.findByEstadoAndTablaParametro(EstadoEnum.ACTIVO.getEstado(), tablaParametro);
	        if(CollectionUtils.isEmpty(list))
	        	return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(toDTOList(list));
	}

	
	@ApiOperation(value = "Get ParametroEstadoGeneral by id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ParametroEstadoGeneralDTO> findById(@PathVariable("id") Integer id) throws ObjectNotFoundException{
		return ResponseEntity.ok(toDTO(parametroEstadoGeneralService.findById(id)));
    }


    @ApiOperation(value = "Delete a ParametroEstadoGeneral by id")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") Integer id) throws ObjectNotFoundException{
        parametroEstadoGeneralService.delete(id);
		return ResponseEntity.ok().build();

    }

	
}

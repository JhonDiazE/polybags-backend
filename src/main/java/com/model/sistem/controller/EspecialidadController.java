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

import com.model.sistem.dto.EspecialidadDTO;
import com.model.sistem.entities.Empresa;
import com.model.sistem.entities.Especialidad;
import com.model.sistem.enums.EstadoEnum;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.service.EspecialidadService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping(value="/especialidad")
public class EspecialidadController  extends GenericMapper<Especialidad, EspecialidadDTO> {

	@Autowired
	private EspecialidadService especialidadService;

	
	@ApiOperation(value = "Dar de alta a los especialidads", notes = "Guardar campos necesarios del especialidad")
	@PostMapping("/")
	public ResponseEntity<EspecialidadDTO> save(@Valid @RequestBody EspecialidadDTO especialidadDTO, BindingResult result) {
		 if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        return new ResponseEntity<>(toDTO(especialidadService.save(toEntity(especialidadDTO))), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Get all especialidad for cotizacion")
	@GetMapping(value = "/cotizacion", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EspecialidadDTO>> findForCotizacion(@RequestParam("idEmpresa") Integer idEmpresa, @RequestParam("estadoPt") String estadoPt) {
	        List<Especialidad> list = especialidadService.findByEstadoAndEstadoCamposPtAndEmpresa(EstadoEnum.ACTIVO.getEstado(), estadoPt, new Empresa(idEmpresa));
	        if(CollectionUtils.isEmpty(list))
	        	return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(toDTOList(list));
	}

	
	@ApiOperation(value = "Get client by id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EspecialidadDTO> findById(@PathVariable("id") Integer id) throws ObjectNotFoundException{
		return ResponseEntity.ok(toDTO(especialidadService.findById(id)));
    }


    @ApiOperation(value = "Delete a Nego movement by id")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") Integer id) throws ObjectNotFoundException{
        especialidadService.delete(id);
		return ResponseEntity.ok().build();

    }

	
}

package com.datasys.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.datasys.dto.ViaDTO;
import com.datasys.model.Via;
import com.datasys.service.IViaService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/vias")
@RequiredArgsConstructor
public class ViaController {

    //@Autowired
    private final IViaService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ViaDTO>> findAll(){
        List<ViaDTO> list = service.findAll().stream().map(this::convertToDto).collect(Collectors.toList());

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViaDTO> findById(@PathVariable("id") Integer id){
        ViaDTO dto = this.convertToDto(service.findById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ViaDTO> save(@Valid @RequestBody ViaDTO dto){
        Via obj = service.save(this.convertToEntity(dto));
        //localhost:8080/specialtys/3
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdVia()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ViaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ViaDTO dto){
        dto.setIdVia(id);
        Via obj = service.update(this.convertToEntity(dto), id);
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Min(1) @PathVariable("id") Integer id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<ViaDTO> findByIdHateoas(@PathVariable("id") Integer id){
        EntityModel<ViaDTO> resource = EntityModel.of(this.convertToDto(service.findById(id)));
        //localhost:8080/specialtys/4
        WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).findById(id));
        WebMvcLinkBuilder link2 = linkTo(methodOn(this.getClass()).findById(id));
        resource.add(link1.withRel("specialty-info1"));
        resource.add(link2.withRel("specialty-info2"));

        return resource;
    }

    private ViaDTO convertToDto(Via obj){
        return modelMapper.map(obj, ViaDTO.class);
    }

    private Via convertToEntity(ViaDTO dto){
        return modelMapper.map(dto, Via.class);
    }

}

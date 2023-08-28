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

import com.datasys.dto.SectorDTO;
import com.datasys.model.Sector;
import com.datasys.service.ISectorService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/sectores")
@RequiredArgsConstructor
public class SectorController {

    //@Autowired
    private final ISectorService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<SectorDTO>> findAll(){
        List<SectorDTO> list = service.findAll().stream().map(this::convertToDto).collect(Collectors.toList());

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SectorDTO> findById(@PathVariable("id") Integer id){
        SectorDTO dto = this.convertToDto(service.findById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SectorDTO> save(@Valid @RequestBody SectorDTO dto){
        Sector obj = service.save(this.convertToEntity(dto));
        //localhost:8080/specialtys/3
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdSector()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SectorDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody SectorDTO dto){
        dto.setIdSector(id);
        Sector obj = service.update(this.convertToEntity(dto), id);
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Min(1) @PathVariable("id") Integer id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<SectorDTO> findByIdHateoas(@PathVariable("id") Integer id){
        EntityModel<SectorDTO> resource = EntityModel.of(this.convertToDto(service.findById(id)));
        //localhost:8080/specialtys/4
        WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).findById(id));
        WebMvcLinkBuilder link2 = linkTo(methodOn(this.getClass()).findById(id));
        resource.add(link1.withRel("specialty-info1"));
        resource.add(link2.withRel("specialty-info2"));

        return resource;
    }

    private SectorDTO convertToDto(Sector obj){
        return modelMapper.map(obj, SectorDTO.class);
    }

    private Sector convertToEntity(SectorDTO dto){
        return modelMapper.map(dto, Sector.class);
    }

}

package com.datasys.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.datasys.dto.ConsultDTO;
import com.datasys.dto.MedicDTO;
import com.datasys.dto.ViaDTO;
import com.datasys.model.Consult;
import com.datasys.model.Medic;
import com.datasys.model.Via;

@Configuration
public class MapperConfig {

    @Bean("defaultMapper")
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean("medicMapper")
    public ModelMapper medicMapper(){
        ModelMapper mapper = new ModelMapper();

        //Escritura
        TypeMap<MedicDTO, Medic> typeMap1 = mapper.createTypeMap(MedicDTO.class, Medic.class);
        typeMap1.addMapping(MedicDTO::getPrimaryName, (dest, v) -> dest.setFirstName((String) v));
        typeMap1.addMapping(MedicDTO::getSurname, (dest, v) -> dest.setLastName((String) v));
        typeMap1.addMapping(MedicDTO::getPhoto, (dest, v) -> dest.setPhotoUrl((String) v));

        //Lectura
        TypeMap<Medic, MedicDTO> typeMap2 = mapper.createTypeMap(Medic.class, MedicDTO.class);
        typeMap2.addMapping(Medic::getFirstName, (dest, v)-> dest.setPrimaryName((String) v));
        typeMap2.addMapping(Medic::getLastName, (dest, v)-> dest.setSurname((String) v));

        return mapper;
    }

    @Bean("consultMapper")
    public ModelMapper consultMapper(){
        ModelMapper mapper = new ModelMapper();
        TypeMap<Consult, ConsultDTO> typeMap1 = mapper.createTypeMap(Consult.class, ConsultDTO.class);

        typeMap1.addMapping(e-> e.getMedic().getFirstName(), (dest, v) -> dest.getMedic().setPrimaryName((String) v));
        typeMap1.addMapping(e-> e.getMedic().getLastName(), (dest, v) -> dest.getMedic().setSurname((String) v));
        typeMap1.addMapping(e-> e.getMedic().getPhotoUrl(), (dest, v) -> dest.getMedic().setPhoto((String) v));

        return mapper;
    }

    @Bean("medicMapper")
    public ModelMapper viaMapper(){
        ModelMapper mapper = new ModelMapper();

        //Escritura
        TypeMap<ViaDTO, Via> typeMap1 = mapper.createTypeMap(ViaDTO.class, Via.class);
        typeMap1.addMapping(ViaDTO::getIdVia, (dest, v) -> dest.setIdVia((Integer) v));
        typeMap1.addMapping(ViaDTO::getNombreVia, (dest, v) -> dest.setNombreVia((String) v));
        
        //Lectura
        TypeMap<Via, ViaDTO> typeMap2 = mapper.createTypeMap(Via.class, ViaDTO.class);
        typeMap2.addMapping(Via::getIdVia, (dest, v)-> dest.setIdVia((Integer) v));
        typeMap2.addMapping(Via::getNombreVia, (dest, v)-> dest.setNombreVia((String) v));

        return mapper;
    }
}

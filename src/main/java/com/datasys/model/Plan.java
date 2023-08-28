package com.datasys.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
// import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "planes")
public class Plan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idPlan;

    @Column(nullable = false, length = 100)
    private String nombrePlan;

    @Column(nullable = false)
    private BigDecimal precioDia;

    @Column(nullable = false)
    private BigDecimal precioPeriodo;

    @Column(nullable = false, length = 1)
    private String estado;

    @PrePersist
    public void prePersisten(){
        this.estado = "A";
    }    

    // @PreUpdate
    // public void preModify(){
    //     this.updatedAt = new Date();
    // }       
}

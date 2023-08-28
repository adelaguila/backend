package com.datasys.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class PaginationModel {

    private Integer pageNumber;
    private Integer rowsPerPage;

    
}

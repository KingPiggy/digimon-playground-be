package com.kingpiggy.digimon.pg.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Pagination {

    private Integer totalPages;
    private Integer currentPage;

    private Long totalElements;
    private Integer currentElements;
}

package com.jxareas.petfinder.core.data.api.mappers

import com.jxareas.petfinder.core.data.api.model.pagination.ApiPagination
import com.jxareas.petfinder.core.domain.model.pagination.Pagination

class ApiPaginationMapper : ApiMapper<ApiPagination?, Pagination> {
    override fun mapToDomain(apiEntity: ApiPagination?): Pagination =
        Pagination(
            currentPage = apiEntity?.currentPage ?: 0,
            totalPages = apiEntity?.totalPages ?: 0,
        )

}

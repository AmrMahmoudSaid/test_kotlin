package app.demo.service

import app.demo.dtos.BasisResponse
import app.demo.dtos.CustomerDto

interface CustomerService {
    fun addCustomer(customerDto: CustomerDto) : BasisResponse
    fun deleteCustomer(id: Long) : BasisResponse
    fun listCustomer(pageNo : Int, pageSize: Int, sortBy: String?) : BasisResponse
    fun editCustomer(id: Long, customerDto: CustomerDto) : BasisResponse
}
package app.demo.service.imp

import app.demo.dtos.BasisResponse
import app.demo.dtos.CustomerDto
import app.demo.entity.Customer
import app.demo.repository.CustomerRepo
import app.demo.service.CustomerService
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class CustomerServiceImp(private val customerRepo: CustomerRepo) : CustomerService {
    override fun addCustomer(customerDto: CustomerDto): BasisResponse {
        val customer = Customer(
            name = customerDto.name,
            email = customerDto.email
        )

        val savedCustomer = customerRepo.save(customer)

        return BasisResponse().apply {
            data = savedCustomer
            status = "Customer Created"
        }
    }

    override fun deleteCustomer(id: Long): BasisResponse {

        customerRepo.deleteById(id)

        return BasisResponse().apply {
            status = "success"
            data = "Customer Deleted successfully"
        }
    }

    override fun listCustomer(pageNo2: Int, pageSize2: Int, sortBy: String?): BasisResponse {

        val pageable = PageRequest.of(pageNo2, pageSize2,Sort.by(sortBy))
        val usersPage = customerRepo.findAll(pageable)

        return BasisResponse().apply {
            data = usersPage.content
            totalElements = usersPage.totalElements
            totalPage = usersPage.totalPages
            pageNo = usersPage.number
            pageSize = usersPage.size
            last = usersPage.isLast
        }
    }

    override fun editCustomer(id: Long, customerDto: CustomerDto): BasisResponse {

        val customer = customerRepo.findById(id)
            .orElseThrow { throw RuntimeException("User not found with id: $id") }

        customer.name = customerDto.name ?: customer.name
        customer.email = customerDto.email ?: customer.email

        val savedCustomer = customerRepo.save(customer)
        return BasisResponse().apply {
            data = savedCustomer
        }
    }
}
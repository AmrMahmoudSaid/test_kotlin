package app.demo.controller

import app.demo.dtos.BasisResponse
import app.demo.dtos.CustomerDto
import app.demo.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/customer")
class CustomerController(private val customerService: CustomerService) {

    @GetMapping
    fun getCustomers(
        @RequestParam(value = "pageNo", defaultValue = "0", required = false) pageNo: Int,
        @RequestParam(value = "pageSize", defaultValue = "5", required = false) pageSize: Int,
        @RequestParam(value = "sortBy", defaultValue = "name", required = false) sortBy: String,

    ) : ResponseEntity<BasisResponse>{
        return ResponseEntity.ok(customerService.listCustomer(pageNo, pageSize, sortBy))
    }

    @PostMapping
    fun addCustomer(@RequestBody customerDto: CustomerDto) : ResponseEntity<BasisResponse>{
        return ResponseEntity(customerService.addCustomer(customerDto),HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun udateCustomer(
        @PathVariable id: Long,
        @RequestBody updatedCustomer: CustomerDto
    ): ResponseEntity<BasisResponse>{
        return ResponseEntity.ok(customerService.editCustomer(id, updatedCustomer))
    }
    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable(name = "id") id : Long) : ResponseEntity<BasisResponse> {
        return ResponseEntity.ok(customerService.deleteCustomer(id))
    }

}
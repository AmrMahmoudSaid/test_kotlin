package app.demo.repository

import app.demo.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepo : JpaRepository<Customer, Long>  {
}
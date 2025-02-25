package app.demo.dtos
import com.fasterxml.jackson.annotation.JsonInclude
import lombok.Builder



@JsonInclude(JsonInclude.Include.NON_NULL)
data class BasisResponse(
    var data: Any? = null,
    var timestamp: String? = null,
    var status: String? = null,
    var pageNo: Int? = null,
    var pageSize: Int? = null,
    var totalElements: Long? = null,
    var totalPage: Int? = null,
    var last: Boolean? = null
)
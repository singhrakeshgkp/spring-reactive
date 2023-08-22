import org.springframework.cloud.contract.spec.Contract
import org.springframework.cloud.contract.spec.internal.HttpMethods
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

Contract.make {
    description("return all reservations")
    request {
        url("/reservations")
        method("GET")
    }
    response {
        body(
            [
                    [id:1,name:"rakesh"],
                    [id:2,name:"rajesh"]
            ]
        )
      status(HttpStatus.OK.value())
      headers {
          contentType(MediaType.APPLICATION_JSON_VALUE)

      }
    }
}
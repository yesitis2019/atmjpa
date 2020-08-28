package th.go.rd.atm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import th.go.rd.atm.model.Customer;
import th.go.rd.atm.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customer")

public class CustomerRestController {

    private CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    // คืนต่าเป็น list customer
    public List<Customer> getAll() {
        return customerService.getCustomers();
    }

    @GetMapping("/{id}") // pass by variable ให้แสดงเป็นราย

    public Customer getOne(@PathVariable int id) {
        return customerService.findCustomer(id);
    }

}


package th.go.rd.atm.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.go.rd.atm.model.BankAccount;

import java.util.Arrays;
import java.util.List;

@Service
public class BankAccountService {
    private RestTemplate restTemplate;
    public BankAccountService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public List<BankAccount> getBankAccount(int customerId) {
        String url = "http://localhost:8090/api/bankaccount/customer/" +
                customerId;

        ResponseEntity<BankAccount[]> response =
                restTemplate.getForEntity(url, BankAccount[].class);
        BankAccount[] accounts = response.getBody();

        return Arrays.asList(accounts);
    }
}


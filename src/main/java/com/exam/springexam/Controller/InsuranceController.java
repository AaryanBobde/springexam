package com.exam.springexam.Controller;


import com.exam.springexam.Entities.ApplicationUser;
import com.exam.springexam.Entities.InsurancePolicy;
import com.exam.springexam.Repositories.ApplicationUserRepository;
import com.exam.springexam.Services.InsurancePolicyRejected;
import com.exam.springexam.Services.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/insurance")
public class InsuranceController {

    @Autowired
    private ApplicationUserRepository userRepository;

    @Autowired
    private InsuranceService insuranceService;

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody ApplicationUser user) {
        try {
            ApplicationUser createdUser = insuranceService.createUser(user, user.getMedicalHistory());
            return ResponseEntity.ok(createdUser);
        } catch (InsurancePolicyRejected e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping("/policies")
    public ResponseEntity<InsurancePolicy> createPolicy(@RequestBody InsurancePolicy policy) {
        return ResponseEntity.ok(insuranceService.createPolicy(policy));
    }

}
package com.exam.springexam.Services;



import com.exam.springexam.Entities.ApplicationUser;
import com.exam.springexam.Entities.InsurancePolicy;
import com.exam.springexam.Repositories.ApplicationUserRepository;
import com.exam.springexam.Repositories.InsurancePolicyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class InsuranceService {

    private static final Logger logger = LoggerFactory.getLogger(InsuranceService.class);
    private static final List<String> REJECTED_CONDITIONS = Arrays.asList("heart", "kidney", "liver", "brain", "eyes");

    @Autowired
    private ApplicationUserRepository userRepository;

    @Autowired
    private InsurancePolicyRepository policyRepository;


    public void validateInsuranceApplication(ApplicationUser user) {
        String medicalHistory = user.getMedicalHistory() != null ? user.getMedicalHistory().toLowerCase() : "";
        List<String> allConditions = new ArrayList<>(user.getExistingMedicalConditions());
        allConditions.addAll(Arrays.asList(medicalHistory.split("\\s+")));

        for (String condition : allConditions) {
            if (REJECTED_CONDITIONS.contains(condition.toLowerCase())) {
                logger.warn("Insurance application rejected for user {} due to condition: {}", user.getName(), condition);
                throw new InsurancePolicyRejected("The following pre-existing condition can't be covered with a new policy: " + condition);
            }
        }
        logger.info("Insurance application validated successfully for user: {}", user.getName());
    }

    public ApplicationUser createUser(ApplicationUser user, String medicalHistory) {
        logger.info("Attempting to create new user: {}", user.getName());
        validateInsuranceApplication(user);
        logger.info("User validated. Creating new user: {}", user.getName());
        return userRepository.save(user);
    }
    public Optional<ApplicationUser> getUserById(Long id) {
        logger.info("Fetching user with id: {}", id);
        return userRepository.findById(id);
    }

    public List<ApplicationUser> getAllUsers() {
        logger.info("Fetching all users");
        return userRepository.findAll();
    }

    public ApplicationUser updateUser(ApplicationUser user) {
        logger.info("Updating user: {}", user.getName());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        logger.info("Deleting user with id: {}", id);
        userRepository.deleteById(id);
    }

    // Insurance Policy CRUD operations
    public InsurancePolicy createPolicy(InsurancePolicy policy) {
        logger.info("Creating new policy: {}", policy.getPolicyName());
        return policyRepository.save(policy);
    }

    public Optional<InsurancePolicy> getPolicyById(Long id) {
        logger.info("Fetching policy with id: {}", id);
        return policyRepository.findById(id);
    }

    public List<InsurancePolicy> getAllPolicies() {
        logger.info("Fetching all policies");
        return policyRepository.findAll();
    }

    public InsurancePolicy updatePolicy(InsurancePolicy policy) {
        logger.info("Updating policy: {}", policy.getPolicyName());
        return policyRepository.save(policy);
    }

    public void deletePolicy(Long id) {
        logger.info("Deleting policy with id: {}", id);
        policyRepository.deleteById(id);
    }
}

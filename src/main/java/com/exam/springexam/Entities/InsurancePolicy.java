package com.exam.springexam.Entities;

import jakarta.persistence.*;

@Entity
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String policyName;
    private String policyInsurer;
    private double premium;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getPolicyInsurer() {
        return policyInsurer;
    }

    public void setPolicyInsurer(String policyInsurer) {
        this.policyInsurer = policyInsurer;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public InsurancePolicy(Long id, String policyName, String policyInsurer, double premium) {
        this.id = id;
        this.policyName = policyName;
        this.policyInsurer = policyInsurer;
        this.premium = premium;
    }
}

package com.exam.springexam.Services;

public class InsurancePolicyRejected extends RuntimeException {
    public InsurancePolicyRejected(String message) {
        super(message);
    }
}
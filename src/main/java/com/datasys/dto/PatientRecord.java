package com.datasys.dto;

public record PatientRecord(
        int idPatient,
        String firstName,
        String lastName,
        String dni,
        String email,
        String phone,
        String address
) {
}

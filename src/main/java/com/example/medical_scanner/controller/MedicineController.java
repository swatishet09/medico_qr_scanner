package com.example.medical_scanner.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.medical_scanner.model.Medicine;
import com.example.medical_scanner.repository.MedicineRepository;

@RestController  //  Marks this as a REST API class
@RequestMapping("/medicine")  //  routes will start with /medicine
public class MedicineController {

    @Autowired
    private MedicineRepository medicineRepository;

    //  POST - Add new medicine
    @PostMapping
    public Medicine addMedicine(@RequestBody Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    // GET - Get all medicines
    @GetMapping
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    // GET - Get medicine by ID
// @GetMapping("/{id}")
// public ResponseEntity<?> getMedicineById(@PathVariable Long id) {
//     try {
//         Medicine medicine = medicineRepository.findById(id).orElse(null);

//         if (medicine == null) {
//             return ResponseEntity.status(404).body("Medicine not found with ID: " + id);
//         } else {
//             System.out.println("Found Medicine: " + medicine); // 💥 Print object to console
//             return ResponseEntity.ok(medicine);
//         }

//     } catch (Exception e) {
//         e.printStackTrace(); // 💥 Print full error in terminal
//         return ResponseEntity.status(500).body("Error: " + e.getMessage());
//     }
// }

@GetMapping("/{id}")
public ResponseEntity<?> getMedicineById(@PathVariable Long id) {
    try {
        Medicine medicine = medicineRepository.findById(id).orElse(null);

        if (medicine == null) {
            return ResponseEntity.status(404).body("Medicine not found with ID: " + id);
        }

        // Check if expired
        LocalDate today = LocalDate.now();
        boolean isExpired = medicine.getExpiryDate().isBefore(today);

        // Create custom response
        Map<String, Object> response = new HashMap<>();
        response.put("medicine", medicine.getName());
        response.put("expiryDate", medicine.getExpiryDate());
        response.put("status", isExpired ? "Expired Do not use" : " Safe to use");

        return ResponseEntity.ok(response);

    } catch (Exception e) {
        return ResponseEntity.status(500).body("Error: " + e.getMessage());
    }
}


}
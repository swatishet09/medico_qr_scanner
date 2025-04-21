package com.example.medical_scanner;

import com.example.medical_scanner.model.Medicine;
import com.example.medical_scanner.repository.MedicineRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

// it makes class a spring managed beans
@Component
public class DataLoader implements CommandLineRunner {

    private final MedicineRepository medicineRepository;

    public DataLoader(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //prevent re-entering
        if (medicineRepository.count() > 0) {
            System.out.println("Database already contains data. Skipping seeding.");
            return;
        }

        String[] names = {
            "Paracetamol", "Ibuprofen", "Amoxicillin", "Cetirizine", "Metformin",
            "Amlodipine", "Omeprazole", "Simvastatin", "Atorvastatin", "Azithromycin"
        };

        String[] uses = {
            "Pain relief", "Anti-inflammatory", "Antibiotic", "Allergy relief", "Blood sugar control",
            "Blood pressure management", "Acid reflux", "Cholesterol control", "Infection treatment", "Cold and flu"
        };

        Random random = new Random();

        for (int i = 1; i <= 100; i++) {
            String name = names[random.nextInt(names.length)] + " " + i;
            String use = uses[random.nextInt(uses.length)];

            LocalDate manufactureDate = LocalDate.now().minusDays(random.nextInt(700) + 100);
            LocalDate expiryDate = manufactureDate.plusDays(random.nextInt(900) + 365);

            Medicine med = new Medicine(name, expiryDate, manufactureDate, use);
            medicineRepository.save(med);
        }
    }
}

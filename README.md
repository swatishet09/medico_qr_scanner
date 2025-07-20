
# Medicine QR Scanner App

A full-stack application that allows users to add medicines, generate QR codes for each one, and scan them using a mobile device to instantly view detailed information such as name, expiry date, and usage.

---

##  Technologies Used

### Backend (Spring Boot)
- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- MySQL
- Maven

### Frontend (React)
- React 17
- Axios
- qrcode.react
- react-router-dom
- react-scripts
- Custom CSS

---

## Features

-  Add new medicine details via REST API
-  Generate QR code for each medicine
-  Scan QR code using a mobile camera
-  Fetch and display full medicine details
-  MySQL integration with Spring JPA
-  CORS handled for cross-origin access

---


### 🔧 Backend (Spring Boot)
1. Go to `medicine_app/medical_scanner`
2. Create database:  
   ```sql
   CREATE DATABASE medicinedb;
   ```
3. Update `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/medicinedb
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

### Frontend (React)
1. Go to `medicine_app/medicine-frontend`
2. Install dependencies:
   ```bash
   npm install --legacy-peer-deps
   ```
3. Start frontend server:
   ```bash
   npm start
   ```
4. App will run at: `http://localhost:3000`

---

## How It Works

1. **Add Medicine** from the backend or via POST request.
2. **MedicineList Component** displays all medicines.
3. Clicking a medicine generates a **QR Code** with its detail URL.
4. Scan QR Code using **mobile camera** or any QR scanner.
5. **Mobile view fetches medicine data** via API call to backend.
6. Display medicine info in structured and styled frontend.

---

## API Endpoints

| Method | Endpoint               | Description               |
|--------|------------------------|---------------------------|
| GET    | `/medicine`            | List all medicines        |
| POST   | `/medicine`            | Add new medicine          |
| GET    | `/medicine/{id}`       | Get details by ID         |

---

## Author

**Swati Shet**    
GitHub: [@swatishet09](https://github.com/swatishet09)

---

## ✅ To Do

- [ ] Add delete/update endpoints
- [ ] Add authentication (optional)
- [ ] Improve UI with Material UI or Tailwind

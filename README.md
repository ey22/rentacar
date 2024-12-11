Before starting, some tools are necessary to run this website.
1. Install Java JDK (version 17 or later)
2. Install Maven
3. Install MariaDB
4. Recommended browser:Firefox
5. Postman or any REST Client (Optional)
   
`git clone <https://github.com/ey22/rentacar>`
After clone GitHub repository:
1. Set up database. Import the `rentacar_database.sql` file
   ```bash
    cd database/rentacar_database.sql
    mysql -u root -p
    CREATE DATABASE RentaCar;
    USE RentaCar;
    source rentacar_database.sql;
    exit;
   ```   
2. Configure the backend and run SpringBoot Application with Maven for backend
   ```bash
   cd backend
   mvn spring-boot:run
   ```
3. To run the API, `backend/src/main/eylul.rentacar/RentaCarApplication` program should be run
4. Interact with ui
   ```bash
    cd ui/mainPage.html file on your computer and run it in you Firefox browser
   ```
5. You can use Postman to test the API points. For example GET method for reservations:
   ```bash
   http://localhost:8080/reservations/user/5
   ```
6. Interact with the ui through your browser. You can start with signin if you don't have an account
  



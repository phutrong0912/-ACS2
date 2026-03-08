# E-Commerce Application

A full-featured e-commerce web application built with Spring Boot, featuring user management, product catalog, shopping cart, order management, and an admin dashboard.

## Features

### 🛒 Core E-Commerce Features

- **Product Management**: Add, edit, and manage products with categories and brands
- **Shopping Cart**: Add/remove products, quantity management
- **Order Management**: Place orders, track order status, order history
- **User Authentication**: Registration, login, password reset
- **Product Reviews & Ratings**: Customer feedback system
- **Blog/News System**: Content management for announcements

### 👨‍💼 Admin Dashboard

- **Product Management**: CRUD operations for products, categories, brands
- **Order Management**: View and update order status
- **User Management**: Manage user accounts and permissions
- **Content Management**: Manage news/blog posts
- **Analytics**: View ratings and reviews

### 👤 User Dashboard

- **Profile Management**: Update personal information
- **Order History**: View past orders and current status
- **Shopping Cart**: Manage cart items
- **Wishlist**: Save favorite products

## Technology Stack

- **Backend**: Spring Boot 3.3.4
- **Database**: MySQL 8.0
- **ORM**: Spring Data JPA with Hibernate
- **Frontend**: Thymeleaf templates, Bootstrap, jQuery
- **Build Tool**: Maven
- **Java Version**: 17
- **Additional Libraries**:
  - Spring Boot Starter Web
  - Spring Boot Starter Data JPA
  - Spring Boot Starter Thymeleaf
  - MySQL Connector/J

## Prerequisites

Before running this application, make sure you have the following installed:

- **Java 17** or higher
- **MySQL Server** 8.0 or higher
- **Maven** 3.6+ (or use the included Maven wrapper)

## Installation & Setup

### 1. Clone the Repository

```bash
git clone <repository-url>
cd DACS2-main
```

### 2. Database Setup

#### Option A: Using MySQL Command Line

```bash
# Create database
mysql -u root -p -e "CREATE DATABASE ecommerce_db;"

# Import database schema and data
mysql -u root -p ecommerce_db < ecommerce_db_backup.sql
```

#### Option B: Using MySQL Workbench or phpMyAdmin

1. Create a new database named `ecommerce_db`
2. Import the `ecommerce_db_backup.sql` file

### 3. Configure Database Connection

Update the database credentials in `src/main/resources/application.properties` if needed:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=root
spring.datasource.password=your_password_here
```

### 4. Build and Run the Application

#### Using Maven Wrapper (Recommended)

```bash
# On Windows
.\mvnw.cmd spring-boot:run

# On Linux/Mac
./mvnw spring-boot:run
```

#### Using Maven (if installed globally)

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## Project Structure

```
src/
├── main/
│   ├── java/com/dacs2/
│   │   ├── api/          # REST API endpoints
│   │   ├── config/       # Configuration classes
│   │   ├── controller/   # Web controllers
│   │   │   ├── AdminController.java
│   │   │   ├── HomeController.java
│   │   │   └── UserController.java
│   │   ├── ecom/         # Main application class
│   │   ├── model/        # JPA entities
│   │   ├── repository/   # Data access layer
│   │   ├── service/      # Business logic
│   │   └── util/         # Utility classes
│   └── resources/
│       ├── static/       # CSS, JS, Images
│       │   ├── css/
│       │   ├── js/
│       │   ├── img/
│       │   └── libs/
│       ├── templates/    # Thymeleaf templates
│       │   ├── admin/    # Admin pages
│       │   ├── user/     # User dashboard pages
│       │   └── *.html    # Public pages
│       └── application.properties
└── test/
    └── java/com/dacs2/
```

## Configuration

### Email Configuration

The application is configured to send emails via Gmail SMTP. Update the email settings in `application.properties`:

```properties
spring.mail.host=smtp.gmail.com
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password
spring.mail.port=587
```

### File Upload Configuration

File upload settings are configured for 10MB max file size:

```properties
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB
```

## API Endpoints

The application includes REST API endpoints for various operations. Key endpoints include:

- `/api/**` - REST API routes
- `/admin/**` - Admin dashboard
- `/user/**` - User dashboard
- `/` - Public pages

## Default Credentials

### Admin Access

- **URL**: `http://localhost:8080/admin/`
- Create admin users through the registration process or database

### Database

- **Host**: localhost:3306
- **Database**: ecommerce_db
- **Username**: root
- **Password**: Demonhunter0912@ (configured in application.properties)

## Development

### Running in Development Mode

The application includes Spring DevTools for hot reloading:

```properties
spring.devtools.restart.enabled=true
spring.devtools.livereload.enabled=true
```

### Building for Production

```bash
# Create JAR file
.\mvnw.cmd clean package

# Run the JAR
java -jar target/ecom-0.0.1-SNAPSHOT.jar
```

## Troubleshooting

### Common Issues

1. **Database Connection Error**
   - Ensure MySQL is running
   - Verify database credentials in `application.properties`
   - Check if `ecommerce_db` database exists

2. **Port Already in Use**
   - Change the port in `application.properties`:
     ```properties
     server.port=8081
     ```

3. **Java Version Issues**
   - Ensure Java 17 is installed and set as default
   - Check with: `java -version`

4. **Email Not Sending**
   - Verify Gmail credentials
   - Enable "Less secure app access" or use App Passwords
   - Check Gmail SMTP settings

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

For support and questions, please open an issue in the repository or contact the development team.

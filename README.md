# 🔐 VaultX - Secure Password Manager

<div align="center">

![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=openjdk)
![Swing](https://img.shields.io/badge/GUI-Java%20Swing-blue?style=for-the-badge)
![MySQL](https://img.shields.io/badge/Database-MySQL-blue?style=for-the-badge&logo=mysql)
![JDBC](https://img.shields.io/badge/Connectivity-JDBC-success?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Active-brightgreen?style=for-the-badge)

### A Desktop-Based Password Management System Developed Using Java Swing and MySQL

</div>

---

## 📖 Overview

**VaultX** is a desktop-based password management application developed using **Java Swing** for the graphical user interface and **MySQL** for database management.

The application enables users to securely manage and organize credentials for multiple websites and online platforms in one centralized location. Each user authenticates using a master account and can store, access, and manage credentials associated with various websites.

VaultX is designed as an educational project to demonstrate concepts such as:

- Java GUI development using Swing
- Database connectivity using JDBC
- User authentication
- CRUD (Create, Read, Update, Delete) operations
- Object-Oriented Programming (OOP)
- Desktop application development

---

# ✨ Key Features

### 🔑 User Authentication

- Secure login using username and master password.
- Verifies user credentials from the database.
- Prevents unauthorized access.

### 👤 User-Specific Access

- Each user can view only their own stored credentials.
- Credentials are linked using a unique user ID.

### ➕ Add Website Credentials

Users can store:

- Website name
- Website username/email
- Website password

### 📋 View Stored Credentials

Displays all saved credentials in a tabular format.

### 🖥️ Interactive Graphical User Interface

- Built entirely using Java Swing.
- User-friendly desktop interface.

### 🗄️ Database Integration

- Uses MySQL for persistent storage.
- JDBC is used for communication between the application and the database.

---

# 🏗️ System Architecture

```text
+----------------+
|    home.java   |
+--------+-------+
         |
         v
+----------------+
|   Login.java   |
+--------+-------+
         |
         v
+----------------+
|   Dash.java    |
+--------+-------+
         |
         v
+------------------------+
| AddPasswordForm.java   |
+------------------------+
```

---

# 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| Java | Core programming language |
| Java Swing | GUI development |
| JDBC | Database connectivity |
| MySQL | Data storage |
| OOP | Software design |
| SQL | Database queries |

---

# 📂 Project Structure

```text
VaultX/
│
├── UserInterface/
│   ├── home.java
│   ├── Login.java
│   ├── Dash.java
│   ├── AddPasswordForm.java
│   └── DBConnection.java
│
├── mysql-connector-j-x.x.x.jar
│
└── README.md
```

---

# 🗄️ Database Design

## Database Name

```sql
password_manager
```

---

## Table 1: users

Stores information related to registered users.

| Column Name | Type | Description |
|------------|------|-------------|
| id | INT | Primary Key |
| username | VARCHAR(50) | Unique username |
| master_pass | VARCHAR(100) | User password |

### SQL Script

```sql
CREATE TABLE users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    master_pass VARCHAR(100) NOT NULL
);
```

---

## Table 2: passwords

Stores website credentials of individual users.

| Column Name | Type | Description |
|------------|------|-------------|
| id | INT | Primary Key |
| user_id | INT | Foreign Key |
| website | VARCHAR(100) | Website name |
| site_username | VARCHAR(100) | Website username |
| site_password | VARCHAR(100) | Website password |

### SQL Script

```sql
CREATE TABLE passwords(
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    website VARCHAR(100),
    site_username VARCHAR(100),
    site_password VARCHAR(100),

    FOREIGN KEY(user_id)
    REFERENCES users(id)
    ON DELETE CASCADE
);
```

---

# 🔄 Database Relationship

```text
users
------
id (PK)
username
master_pass
      |
      | One-to-Many
      |
passwords
-----------
id (PK)
user_id (FK)
website
site_username
site_password
```

A single user can store multiple website credentials.

---

# ⚙️ Installation and Setup

## Step 1: Clone the Repository

```bash
git clone https://github.com/your-username/VaultX.git
```

Move into the project directory:

```bash
cd VaultX
```

---

## Step 2: Install MySQL

Download and install MySQL Server from:

:contentReference[oaicite:0]{index=0}

---

## Step 3: Create Database

Open MySQL Command Line Client or MySQL Workbench.

Execute:

```sql
CREATE DATABASE password_manager;

USE password_manager;
```

Create required tables using the SQL scripts provided above.

---

## Step 4: Insert Sample User

```sql
INSERT INTO users(username, master_pass)
VALUES('admin','admin123');
```

---

## Step 5: Download MySQL JDBC Driver

Download MySQL Connector/J:

:contentReference[oaicite:1]{index=1}

Extract the downloaded ZIP file and add:

```text
mysql-connector-j-x.x.x.jar
```

to your project's build path.

---

## Step 6: Configure Database Connection

Open:

```text
DBConnection.java
```

Update credentials:

```java
DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/password_manager",
    "root",
    "your_password"
);
```

---

## Step 7: Run the Application

Execute:

```text
home.java
```

---

# 🚀 Application Workflow

## User Login

1. Launch the application.
2. Enter username.
3. Enter master password.
4. Click **LOGIN**.
5. Credentials are verified from the database.

---

## Dashboard

After successful login:

- User dashboard opens.
- Displays all saved website credentials.

---

## Add Password

1. Click **Add Password**.
2. Enter:
   - Website Name
   - Website Username
   - Website Password
3. Click **Save**.
4. Data is stored in the database.

---



# 🔒 Security Considerations

Current version stores passwords as plain text for academic demonstration purposes.

Recommended improvements:

- Encrypt stored passwords using AES.
- Hash master passwords.
- Implement password strength validation.
- Add auto logout.
- Add session management.

---

# 🌟 Future Enhancements

- [ ] User Registration Module
- [ ] Update Credentials
- [ ] Delete Credentials
- [ ] Search Functionality
- [ ] Password Encryption
- [ ] Dark Theme
- [ ] Password Generator
- [ ] Export Credentials
- [ ] Two-Factor Authentication
- [ ] Backup and Restore Feature

---

# 🧪 Testing

Test Cases:

| Test Case | Expected Result |
|------------|----------------|
| Valid Login | Login Successful |
| Invalid Login | Error Message |
| Add Credential | Credential Saved |
| View Dashboard | Stored Data Displayed |
| Empty Fields | Validation Message |

---

# 🤝 Contribution

Contributions are welcome.

### Steps:

1. Fork the repository.
2. Create a feature branch.

```bash
git checkout -b feature-name
```

3. Commit your changes.

```bash
git commit -m "Added new feature"
```

4. Push changes.

```bash
git push origin feature-name
```

5. Create a Pull Request.

---

# 👨‍💻 Author

**Ajith P A**

---

# 📄 License

This project is developed for educational and learning purposes.

---

<div align="center">

## ⭐ If you found this project useful, consider giving it a star!

</div>

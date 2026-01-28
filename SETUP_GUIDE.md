# NBSF Website - Setup and Connection Guide

## 🔗 Connection Status

Your NBSF website has been configured to connect:
- **Frontend (React)** ↔ **Backend (Spring Boot)** ↔ **Database (MySQL)**

---

## 📋 Prerequisites

1. **Node.js** (v14 or higher)
2. **Java JDK 17**
3. **MySQL Server** (running on port 3305)
4. **Maven** (for Spring Boot)

---

## 🗄️ Database Setup

### Step 1: Start MySQL Server
Make sure MySQL is running on port **3305** (as configured in your `application.properties`).

### Step 2: Create Database
Run the SQL schema file to create the database and tables:

```bash
mysql -u root -p -P 3305 < database/schema.sql
```

Or manually:
1. Open MySQL Workbench or command line
2. Connect to MySQL on port 3305
3. Execute the `database/schema.sql` file

This will:
- Create `nbsf_db` database
- Create all necessary tables (students, courses, enquiries, contacts, partners, placements)
- Insert sample course data
- Insert sample partner data

### Database Configuration
- **Host**: localhost
- **Port**: 3305
- **Database**: nbsf_db
- **Username**: root
- **Password**: 1122

---

## 🚀 Backend Setup (Spring Boot)

### Step 1: Navigate to Backend Directory
```bash
cd backends
```

### Step 2: Build the Project
```bash
mvn clean install
```

### Step 3: Run the Backend Server
```bash
mvn spring-boot:run
```

The backend will start on **http://localhost:8080**

### Available API Endpoints:

#### Students
- `POST /api/students/register` - Register a new student
- `GET /api/students` - Get all students
- `GET /api/students/{id}` - Get student by ID
- `GET /api/students/stats` - Get statistics

#### Courses
- `GET /api/courses` - Get all courses
- `GET /api/courses/{id}` - Get course by ID
- `POST /api/courses` - Create new course (admin)
- `PUT /api/courses/{id}` - Update course (admin)
- `DELETE /api/courses/{id}` - Delete course (admin)

#### Enquiries
- `POST /api/enquiries` - Submit enquiry
- `GET /api/enquiries` - Get all enquiries (admin)

#### Contact
- `POST /api/contact` - Submit contact message
- `GET /api/contact` - Get all messages (admin)

---

## 💻 Frontend Setup (React)

### Step 1: Navigate to Frontend Directory
```bash
cd "Frontend (React.js)"
```

### Step 2: Install Dependencies
```bash
npm install
```

### Step 3: Create Environment File (Optional)
```bash
cp .env.example .env
```

The frontend is configured with a **proxy** to automatically route API calls to the backend.

### Step 4: Start the Development Server
```bash
npm start
```

The frontend will start on **http://localhost:3000**

---

## 🔧 Connection Details

### Frontend ↔ Backend Connection

✅ **Configured via `package.json` proxy:**
```json
"proxy": "http://localhost:8080"
```

This means:
- Frontend API calls to `/api/*` automatically route to `http://localhost:8080/api/*`
- No CORS issues during development
- Example: `axios.post('/api/students/register', data)` → `http://localhost:8080/api/students/register`

### Backend ↔ Database Connection

✅ **Configured in `application.properties`:**
```properties
spring.datasource.url=jdbc:mysql://localhost:3305/nbsf_db
spring.datasource.username=root
spring.datasource.password=1122
server.port=8080
```

### CORS Configuration

✅ **Backend allows all origins:**
All controllers have `@CrossOrigin(origins = "*")` annotation, allowing requests from any origin.

---

## 📁 Project Structure

```
nbsf-website/
├── Frontend (React.js)/
│   ├── src/
│   │   ├── components/      # React components (Navbar, Footer, etc.)
│   │   ├── pages/           # Page components (Home, About, Courses, etc.)
│   │   ├── services/        # API service layer (NEW!)
│   │   └── App.js           # Main app with routing
│   ├── package.json         # Contains proxy configuration
│   └── .env.example         # Environment variables template
├── backends/
│   ├── src/main/
│   │   ├── java/com/jaydip/backends/
│   │   │   ├── controller/  # REST API controllers
│   │   │   ├── model/       # Entity models
│   │   │   ├── repository/  # JPA repositories
│   │   │   └── service/     # Business logic
│   │   └── resources/
│   │       └── application.properties  # Database & server config
│   └── pom.xml              # Maven dependencies
└── database/
    └── schema.sql           # Database schema with sample data
```

---

## 🧪 Testing the Connection

### 1. Test Backend Health
Once backend is running, visit:
```
http://localhost:8080/api/courses
```
You should see the list of courses in JSON format.

### 2. Test Frontend
Once frontend is running, visit:
```
http://localhost:3000
```

### 3. Test Full Integration
1. Go to the **Courses** page on the frontend
2. Click **"Register Now"** button
3. Fill out the registration form
4. Submit the form
5. Check if the data is saved to the database:
   ```sql
   SELECT * FROM nbsf_db.students;
   ```

---

## ✨ What's Been Fixed

### ✅ Database Configuration
- Changed from `pet` database to `nbsf_db`
- Created proper schema with all required tables
- Added sample data for courses and partners

### ✅ Frontend-Backend Connection
- Added proxy configuration in `package.json`
- Created centralized API service layer in `src/services/api.js`
- All API calls now properly route to backend

### ✅ Backend Configuration
- Explicitly set server port to 8080
- CORS enabled for all endpoints
- JPA configured for automatic schema updates

### ✅ API Service Layer
Created `src/services/api.js` with organized endpoints:
- studentAPI (register, getAll, getById, getStats)
- courseAPI (CRUD operations)
- enquiryAPI (submit, getAll, getById)
- contactAPI (submit, getAll)

---

## 🚨 Troubleshooting

### Issue: "Cannot connect to database"
**Solution**: 
- Make sure MySQL is running on port 3305
- Verify credentials in `application.properties`
- Create the `nbsf_db` database using the schema file

### Issue: "API call failed" or "Network Error"
**Solution**:
- Ensure backend is running on port 8080
- Check if proxy is configured in `package.json`
- Verify CORS is enabled in controllers

### Issue: "404 Not Found" on API calls
**Solution**:
- Check if the API endpoint exists in the controller
- Verify the controller is properly annotated with `@RestController` and `@RequestMapping`

---

## 📧 Email Configuration (Optional)

To enable email notifications, update in `application.properties`:

```properties
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password
```

**Note**: For Gmail, you need to generate an App Password from your Google Account settings.

---

## 🎯 Next Steps

1. **Run Database Setup**: Execute the `schema.sql` file
2. **Start Backend**: Run Spring Boot application
3. **Start Frontend**: Run React development server
4. **Test**: Try registering a student through the website
5. **Verify**: Check if data appears in the database

Your frontend, backend, and database are now fully connected! 🎉

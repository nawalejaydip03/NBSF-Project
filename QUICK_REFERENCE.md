# Quick Reference - NBSF Website

## 🚀 Quick Commands

### Start Everything (3 terminals needed)

**Terminal 1 - Database**
```bash
# Make sure MySQL is running on port 3305
mysql -u root -p1122 -P 3305
```

**Terminal 2 - Backend**
```bash
cd backends
mvn spring-boot:run
# Wait for: "Started BackendsApplication"
```

**Terminal 3 - Frontend**
```bash
cd "Frontend (React.js)"
npm start
# Opens: http://localhost:3000
```

---

## 🔗 Quick Connection Check

| Component | Address | Status Check |
|-----------|---------|--------------|
| Frontend | http://localhost:3000 | Open in browser |
| Backend API | http://localhost:8080/api/courses | Should return JSON |
| Database | localhost:3305 | `mysql -u root -p1122 -P 3305 -e "SHOW DATABASES;"` |

---

## 📂 Important Files

| File | Purpose |
|------|---------|
| `SETUP_GUIDE.md` | Complete setup instructions |
| `CONNECTION_STATUS.md` | Connection details and testing |
| `database/schema.sql` | Database schema |
| `setup-database.bat` | Auto database setup |
| `backends/src/main/resources/application.properties` | Backend config |
| `Frontend (React.js)/package.json` | Frontend config (has proxy) |
| `Frontend (React.js)/src/services/api.js` | API service layer |

---

## 🗄️ Database Quick Setup

**Option 1: Auto Script (Windows)**
```bash
setup-database.bat
```

**Option 2: Manual**
```bash
mysql -u root -p1122 -P 3305 < database/schema.sql
```

---

## 🧪 Test API Endpoints

```bash
# Get all courses
curl http://localhost:8080/api/courses

# Get all students
curl http://localhost:8080/api/students

# Get statistics
curl http://localhost:8080/api/students/stats
```

---

## 📊 Database Tables

- `students` - Student registrations
- `courses` - Available courses (6 sample courses inserted)
- `enquiries` - Student enquiries
- `contact_messages` - Contact form messages
- `partners` - Partner companies (4 sample partners inserted)
- `placements` - Student placement records

---

## ⚙️ Configuration Summary

### Backend (Port 8080)
```properties
spring.datasource.url=jdbc:mysql://localhost:3305/nbsf_db
spring.datasource.username=root
spring.datasource.password=1122
server.port=8080
```

### Frontend (Port 3000)
```json
"proxy": "http://localhost:8080"
```

### Database (Port 3305)
```
Host: localhost
Port: 3305
Database: nbsf_db
User: root
Password: 1122
```

---

## 🎯 Page Routes

| Route | Page | Connected to Backend? |
|-------|------|----------------------|
| `/` | Home | - |
| `/about` | About | - |
| `/courses` | Courses | ✅ Yes (displays courses) |
| `/placement` | Placement | ✅ Yes (shows placements) |
| `/partners` | Partners | ✅ Yes (shows partners) |
| `/contact` | Contact | ✅ Yes (submits to API) |
| `/legal` | Legal | - |
| `/admin` | Admin | ✅ Yes (admin features) |

---

## 🔧 Troubleshooting Quick Fixes

**Issue**: Cannot connect to MySQL
```bash
# Check if MySQL is running
mysql -u root -p1122 -P 3305 -e "SELECT 1;"
```

**Issue**: Backend port already in use
```bash
# Find what's using port 8080 (Windows)
netstat -ano | findstr :8080
# Kill the process if needed
```

**Issue**: Frontend API calls fail
- Ensure backend is running on 8080
- Check `package.json` has `"proxy": "http://localhost:8080"`
- Clear React cache: `rm -rf node_modules/.cache`

---

## 📦 Dependencies Check

```bash
# Check Node.js
node --version  # Should be v14 or higher

# Check Java
java -version   # Should be JDK 17

# Check Maven
mvn --version   # Should be 3.x

# Check MySQL
mysql --version # Should be 5.7 or 8.x
```

---

## ✅ Connection Status

```
┌─────────────────┐
│   React App     │ localhost:3000
│  (Frontend)     │
└────────┬────────┘
         │ proxy
         ↓
┌─────────────────┐
│  Spring Boot    │ localhost:8080
│   (Backend)     │
└────────┬────────┘
         │ JDBC
         ↓
┌─────────────────┐
│     MySQL       │ localhost:3305
│   (Database)    │ nbsf_db
└─────────────────┘
```

**Status**: ✅ FULLY CONNECTED

---

## 💡 Pro Tips

1. **Always start in this order**: Database → Backend → Frontend
2. **Check backend logs** if API calls fail
3. **Use SETUP_GUIDE.md** for detailed instructions
4. **Database script** creates sample data automatically
5. **Admin page** is intentionally hidden from navbar (security)

---

For complete documentation, see:
- **SETUP_GUIDE.md** - Detailed setup instructions
- **CONNECTION_STATUS.md** - Connection testing and verification
- **README.md** - Project overview

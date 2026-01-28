@echo off
echo ================================================
echo NBSF Website - Database Setup Script
echo ================================================
echo.

REM Set MySQL connection details
set MYSQL_USER=root
set MYSQL_PASS=1122
set MYSQL_PORT=3305
set DB_NAME=nbsf_db
set SCHEMA_FILE=database\schema.sql

echo Checking if MySQL is accessible...
echo.

REM Check if MySQL is running
mysql -u %MYSQL_USER% -p%MYSQL_PASS% -P %MYSQL_PORT% -e "SELECT 1;" >nul 2>&1
if %errorlevel% neq 0 (
    echo [ERROR] Cannot connect to MySQL on port %MYSQL_PORT%
    echo Please ensure MySQL server is running.
    pause
    exit /b 1
)

echo [SUCCESS] MySQL connection established!
echo.

echo Creating database and importing schema...
mysql -u %MYSQL_USER% -p%MYSQL_PASS% -P %MYSQL_PORT% < %SCHEMA_FILE%

if %errorlevel% equ 0 (
    echo.
    echo ================================================
    echo [SUCCESS] Database setup completed!
    echo ================================================
    echo.
    echo Database: %DB_NAME%
    echo Tables Created:
    echo   - students
    echo   - courses
    echo   - enquiries
    echo   - contact_messages
    echo   - partners
    echo   - placements
    echo.
    echo Sample data inserted for:
    echo   - 6 Courses
    echo   - 4 Partner Companies
    echo.
) else (
    echo.
    echo [ERROR] Database setup failed!
    echo Please check the schema file and try again.
    echo.
)

pause

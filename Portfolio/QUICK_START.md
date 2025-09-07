# Quick Start Guide

## 🚀 Fastest Way to Get Started

### Prerequisites Check
```bash
# Check installations
node --version      # Should be 18+
python --version    # Should be 3.11+
java --version      # Should be 17+
git --version       # Any recent version
```

## 📦 Step 1: Clone and Setup

```bash
# Clone repository (once you create it)
git clone https://github.com/yourusername/portfolio.git
cd portfolio

# Create main branches
git checkout -b develop
git checkout -b feature/backend
git checkout -b feature/frontend
git checkout -b feature/algorithm-service
```

## 🐍 Step 2: Python Backend Setup

```bash
# Navigate to backend
cd backend

# Create virtual environment
python -m venv venv

# Activate virtual environment
# Windows:
venv\Scripts\activate
# Mac/Linux:
source venv/bin/activate

# Install dependencies
pip install fastapi uvicorn python-dotenv
pip install sqlalchemy python-multipart email-validator
pip install PyGithub requests httpx
pip install pytest pytest-asyncio

# Create initial files
touch main.py
touch requirements.txt
touch .env

# Save dependencies
pip freeze > requirements.txt

# Run the server
uvicorn main:app --reload --port 8000
```

### Quick Backend Starter Code

Create `backend/main.py`:
```python
from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware

app = FastAPI(title="Portfolio API")

app.add_middleware(
    CORSMiddleware,
    allow_origins=["http://localhost:4200"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

@app.get("/")
def read_root():
    return {"message": "Portfolio API is running!"}

@app.get("/api/test")
def test_endpoint():
    return {"status": "success", "data": "Test endpoint working"}
```

## ☕ Step 3: Java Algorithm Service Setup

```bash
# Navigate to algorithm-service
cd ../algorithm-service

# Create Spring Boot project using Spring Initializr
# Or use this command if you have Spring Boot CLI:
spring init --dependencies=web,devtools --build=maven --java-version=17 --packaging=jar --name=AlgorithmService --package-name=com.portfolio algorithm-service

# If no Spring CLI, create manually:
# 1. Go to https://start.spring.io/
# 2. Select: Maven, Java 17, Spring Boot 3.x
# 3. Add dependencies: Spring Web, Spring Boot DevTools
# 4. Generate and extract here

# Run the application
mvn spring-boot:run
# Or
./mvnw spring-boot:run
```

## 🅰️ Step 4: Angular Frontend Setup

```bash
# Navigate to portfolio root
cd ..

# Install Angular CLI globally (if not installed)
npm install -g @angular/cli

# Create Angular project
ng new frontend --routing --style=scss --skip-git

# Navigate to frontend
cd frontend

# Install additional packages
npm install @angular/material @angular/cdk @angular/animations
npm install chart.js ng2-charts
npm install aos
npm install prismjs @types/prismjs

# Add Angular Material
ng add @angular/material

# Start development server
ng serve --open
```

## 🔧 Step 5: Quick Configuration

### Frontend Environment Setup

Create `frontend/src/environments/environment.ts`:
```typescript
export const environment = {
  production: false,
  pythonApiUrl: 'http://localhost:8000',
  javaApiUrl: 'http://localhost:8080'
};
```

### Backend Environment Variables

Create `backend/.env`:
```env
# Server
HOST=0.0.0.0
PORT=8000

# GitHub (optional)
GITHUB_TOKEN=your_github_token_here

# Email (optional)
EMAIL_HOST=smtp.gmail.com
EMAIL_PORT=587
EMAIL_USER=your.email@gmail.com
EMAIL_PASSWORD=your_app_password
```

## 🏃 Step 6: Run Everything

Open 3 terminal windows:

### Terminal 1 - Python Backend
```bash
cd backend
venv\Scripts\activate  # or source venv/bin/activate
uvicorn main:app --reload
# Runs on http://localhost:8000
```

### Terminal 2 - Java Service
```bash
cd algorithm-service
mvn spring-boot:run
# Runs on http://localhost:8080
```

### Terminal 3 - Angular Frontend
```bash
cd frontend
ng serve
# Runs on http://localhost:4200
```

## ✅ Step 7: Verify Everything Works

1. **Python API**: Navigate to http://localhost:8000/docs
2. **Java API**: Navigate to http://localhost:8080
3. **Angular App**: Navigate to http://localhost:4200

## 🎯 Next Steps

### Immediate Tasks
1. Create your first API endpoint in Python
2. Create your first component in Angular
3. Setup your first algorithm in Java
4. Connect frontend to backend

### Quick Wins
- [ ] Create a simple "Hello World" endpoint in each service
- [ ] Display data from Python API in Angular
- [ ] Create a basic sorting visualization
- [ ] Setup GitHub repository
- [ ] Deploy one service to test deployment process

## 🆘 Common Issues & Solutions

### Issue: CORS errors
**Solution**: Make sure CORS is configured in all backend services

### Issue: Port already in use
**Solution**: Change port numbers or kill existing processes
```bash
# Windows
netstat -ano | findstr :8000
taskkill /PID <PID> /F

# Mac/Linux
lsof -i :8000
kill -9 <PID>
```

### Issue: Module not found errors
**Solution**: Make sure you're in the virtual environment (Python) or have run npm install (Angular)

### Issue: Java version mismatch
**Solution**: Ensure JAVA_HOME points to Java 17
```bash
# Windows
set JAVA_HOME=C:\Program Files\Java\jdk-17
# Mac/Linux
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk
```

## 📚 Helpful Commands

### Git Commands
```bash
git add .
git commit -m "feat: add new feature"
git push origin feature/branch-name
git checkout develop
git merge feature/branch-name
```

### Angular Commands
```bash
ng generate component components/home
ng generate service services/api
ng generate interface models/project
ng build --prod
```

### Python Commands
```bash
pip install package-name
pip freeze > requirements.txt
python -m pytest
```

### Maven Commands
```bash
mvn clean install
mvn test
mvn package
```

## 🔗 Useful Links

- [Angular Documentation](https://angular.io/docs)
- [FastAPI Documentation](https://fastapi.tiangolo.com/)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Angular Material](https://material.angular.io/)
- [GitHub Pages](https://pages.github.com/)
- [Render Deployment](https://render.com/docs)

## 💡 Pro Tips

1. **Use VS Code Extensions**:
   - Angular Language Service
   - Python
   - Java Extension Pack
   - GitLens
   - Prettier

2. **Setup Hot Reload**: All three services support hot reload during development

3. **Use Postman/Thunder Client**: Test your APIs before integrating with frontend

4. **Commit Often**: Make small, frequent commits with clear messages

5. **Branch Strategy**: Use feature branches for new features

---

Ready to start coding! 🚀 Follow the TODO.md for detailed task tracking.

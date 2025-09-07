# Portfolio Project

A modern full-stack developer portfolio showcasing proficiency in Angular, Python, and Java.

## 🏗️ Architecture Overview

```
Portfolio System
├── Frontend (Angular) → GitHub Pages
├── Backend API (Python FastAPI) → Render/Railway
└── Algorithm Service (Java Spring Boot) → Render/Railway
```

## 🚀 Tech Stack

### Frontend
- **Framework**: Angular 17+
- **UI Library**: Angular Material
- **Styling**: SCSS
- **Charts**: Chart.js / ng2-charts
- **Animations**: AOS (Animate on Scroll)
- **Hosting**: GitHub Pages

### Backend (Python)
- **Framework**: FastAPI
- **Database**: PostgreSQL (optional)
- **Authentication**: JWT (if needed)
- **Email**: SMTP / SendGrid
- **Hosting**: Render.com / Railway

### Algorithm Service (Java)
- **Framework**: Spring Boot
- **Build Tool**: Maven
- **API**: RESTful
- **Hosting**: Render.com / Railway

## 📁 Project Structure

```
Portfolio/
├── frontend/                 # Angular application
│   ├── src/
│   │   ├── app/
│   │   │   ├── components/
│   │   │   ├── services/
│   │   │   └── models/
│   │   └── environments/
│   └── package.json
├── backend/                  # Python FastAPI
│   ├── app/
│   │   ├── main.py
│   │   ├── routes/
│   │   └── models/
│   └── requirements.txt
├── algorithm-service/        # Java Spring Boot
│   ├── src/
│   │   └── main/java/
│   └── pom.xml
└── docs/                    # Documentation
```

## 🎯 Key Features

1. **Interactive Algorithm Visualizer**
   - Sorting algorithms with step-by-step visualization
   - Pathfinding algorithms on grids
   - Time/Space complexity display

2. **Dynamic Project Showcase**
   - Featured projects with live demos
   - GitHub integration for real-time stats
   - Technology stack badges

3. **Skills Dashboard**
   - Interactive skill charts
   - Categorized by languages, frameworks, tools
   - Proficiency levels

4. **Contact System**
   - Form validation
   - Email integration
   - Response confirmation

5. **GitHub Statistics**
   - Repository count
   - Language distribution
   - Contribution graph
   - Total stars

## 🔧 Development Setup

### Prerequisites
- Node.js 18+ and npm
- Python 3.11+
- Java 17+
- Git

### Quick Start

1. Clone the repository
```bash
git clone https://github.com/yourusername/portfolio.git
cd portfolio
```

2. Setup Frontend
```bash
cd frontend
npm install
ng serve
# Navigate to http://localhost:4200
```

3. Setup Python Backend
```bash
cd backend
python -m venv venv
source venv/bin/activate  # On Windows: venv\Scripts\activate
pip install -r requirements.txt
uvicorn app.main:app --reload
# API at http://localhost:8000
```

4. Setup Java Service
```bash
cd algorithm-service
mvn spring-boot:run
# API at http://localhost:8080
```

## 🚀 Deployment

### Frontend (GitHub Pages)
```bash
cd frontend
ng build --base-href /portfolio/
# Push to gh-pages branch
```

### Backend Services (Render/Railway)
- Connect GitHub repository
- Configure environment variables
- Deploy with Dockerfile

## 📊 API Endpoints

### Python Backend
- `GET /api/projects` - Get all projects
- `GET /api/skills` - Get skills list
- `GET /api/github/stats` - Get GitHub statistics
- `POST /api/contact` - Send contact message

### Java Algorithm Service
- `GET /api/algorithms/sorting` - Get sorting algorithms
- `POST /api/algorithms/sort` - Execute sorting with steps
- `POST /api/algorithms/pathfinding` - Find path in grid

## 🧪 Testing

```bash
# Frontend tests
cd frontend
ng test

# Python tests
cd backend
pytest

# Java tests
cd algorithm-service
mvn test
```

## 📝 Environment Variables

### Frontend
```typescript
// environments/environment.ts
export const environment = {
  production: false,
  pythonApiUrl: 'http://localhost:8000',
  javaApiUrl: 'http://localhost:8080'
};
```

### Python Backend
```env
DATABASE_URL=postgresql://...
EMAIL_HOST=smtp.gmail.com
EMAIL_PORT=587
EMAIL_USER=your-email@gmail.com
EMAIL_PASSWORD=your-app-password
GITHUB_TOKEN=ghp_...
```

### Java Service
```properties
server.port=8080
spring.profiles.active=dev
```

## 📈 Performance Targets

- Lighthouse Score: 90+
- First Contentful Paint: < 1.5s
- Time to Interactive: < 3.5s
- API Response Time: < 200ms

## 🤝 Contributing

1. Fork the repository
2. Create feature branch
3. Commit changes
4. Push to branch
5. Open pull request

## 📄 License

MIT License - feel free to use this project as a template!

## 👤 Author

**Tristan Bookhan**
- GitHub: [@yourusername](https://github.com/yourusername)
- LinkedIn: [Your LinkedIn](https://linkedin.com/in/yourusername)

## 🙏 Acknowledgments

- Angular team for the amazing framework
- FastAPI for the modern Python web framework
- Spring Boot for enterprise-ready Java framework

# Project Structure Guide

## 📁 Complete Directory Structure

```
Portfolio/
│
├── 📂 frontend/                      # Angular Application
│   ├── 📂 src/
│   │   ├── 📂 app/
│   │   │   ├── 📂 components/       # UI Components
│   │   │   │   ├── 📂 layout/
│   │   │   │   │   ├── header/
│   │   │   │   │   │   ├── header.component.ts
│   │   │   │   │   │   ├── header.component.html
│   │   │   │   │   │   ├── header.component.scss
│   │   │   │   │   │   └── header.component.spec.ts
│   │   │   │   │   ├── footer/
│   │   │   │   │   └── sidebar/
│   │   │   │   ├── 📂 pages/
│   │   │   │   │   ├── home/
│   │   │   │   │   ├── about/
│   │   │   │   │   ├── projects/
│   │   │   │   │   ├── skills/
│   │   │   │   │   ├── algorithm-viz/
│   │   │   │   │   └── contact/
│   │   │   │   └── 📂 shared/
│   │   │   │       ├── loading-spinner/
│   │   │   │       ├── error-message/
│   │   │   │       └── confirmation-dialog/
│   │   │   ├── 📂 services/         # Business Logic
│   │   │   │   ├── api.service.ts
│   │   │   │   ├── auth.service.ts
│   │   │   │   ├── projects.service.ts
│   │   │   │   ├── skills.service.ts
│   │   │   │   ├── github.service.ts
│   │   │   │   ├── algorithm.service.ts
│   │   │   │   └── theme.service.ts
│   │   │   ├── 📂 models/           # TypeScript Interfaces
│   │   │   │   ├── project.model.ts
│   │   │   │   ├── skill.model.ts
│   │   │   │   ├── algorithm.model.ts
│   │   │   │   └── contact.model.ts
│   │   │   ├── 📂 guards/           # Route Guards
│   │   │   │   └── auth.guard.ts
│   │   │   ├── 📂 interceptors/     # HTTP Interceptors
│   │   │   │   ├── auth.interceptor.ts
│   │   │   │   └── error.interceptor.ts
│   │   │   ├── 📂 pipes/            # Custom Pipes
│   │   │   │   └── truncate.pipe.ts
│   │   │   ├── 📂 directives/       # Custom Directives
│   │   │   │   └── scroll-animation.directive.ts
│   │   │   ├── app-routing.module.ts
│   │   │   ├── app.component.ts
│   │   │   ├── app.component.html
│   │   │   ├── app.component.scss
│   │   │   └── app.module.ts
│   │   ├── 📂 assets/               # Static Assets
│   │   │   ├── 📂 images/
│   │   │   │   ├── projects/
│   │   │   │   ├── skills/
│   │   │   │   └── profile/
│   │   │   ├── 📂 icons/
│   │   │   ├── 📂 fonts/
│   │   │   └── 📂 data/
│   │   │       └── mock-data.json
│   │   ├── 📂 environments/         # Environment Configs
│   │   │   ├── environment.ts
│   │   │   └── environment.prod.ts
│   │   ├── 📂 styles/               # Global Styles
│   │   │   ├── _variables.scss
│   │   │   ├── _mixins.scss
│   │   │   ├── _animations.scss
│   │   │   └── _themes.scss
│   │   ├── index.html
│   │   ├── main.ts
│   │   ├── polyfills.ts
│   │   └── styles.scss
│   ├── 📂 e2e/                      # End-to-End Tests
│   ├── angular.json
│   ├── package.json
│   ├── package-lock.json
│   ├── tsconfig.json
│   ├── tsconfig.app.json
│   ├── tsconfig.spec.json
│   ├── .browserslistrc
│   ├── .editorconfig
│   └── karma.conf.js
│
├── 📂 backend/                       # Python FastAPI
│   ├── 📂 app/
│   │   ├── 📂 api/                  # API Routes
│   │   │   ├── 📂 v1/
│   │   │   │   ├── 📂 endpoints/
│   │   │   │   │   ├── projects.py
│   │   │   │   │   ├── skills.py
│   │   │   │   │   ├── github.py
│   │   │   │   │   ├── contact.py
│   │   │   │   │   └── health.py
│   │   │   │   └── api.py
│   │   │   └── deps.py
│   │   ├── 📂 core/                 # Core Functionality
│   │   │   ├── config.py
│   │   │   ├── security.py
│   │   │   └── logging.py
│   │   ├── 📂 models/               # Data Models
│   │   │   ├── project.py
│   │   │   ├── skill.py
│   │   │   └── contact.py
│   │   ├── 📂 schemas/              # Pydantic Schemas
│   │   │   ├── project.py
│   │   │   ├── skill.py
│   │   │   └── contact.py
│   │   ├── 📂 services/             # Business Logic
│   │   │   ├── email_service.py
│   │   │   ├── github_service.py
│   │   │   └── cache_service.py
│   │   ├── 📂 db/                   # Database
│   │   │   ├── base.py
│   │   │   ├── session.py
│   │   │   └── init_db.py
│   │   ├── 📂 utils/                # Utilities
│   │   │   ├── validators.py
│   │   │   └── helpers.py
│   │   ├── __init__.py
│   │   └── main.py                  # FastAPI App
│   ├── 📂 tests/                    # Tests
│   │   ├── 📂 unit/
│   │   ├── 📂 integration/
│   │   └── conftest.py
│   ├── 📂 alembic/                  # Database Migrations
│   │   └── versions/
│   ├── 📂 scripts/                  # Utility Scripts
│   │   └── init_data.py
│   ├── .env.example
│   ├── .env
│   ├── requirements.txt
│   ├── requirements-dev.txt
│   ├── Dockerfile
│   ├── docker-compose.yml
│   ├── alembic.ini
│   └── pytest.ini
│
├── 📂 algorithm-service/             # Java Spring Boot
│   ├── 📂 src/
│   │   ├── 📂 main/
│   │   │   ├── 📂 java/
│   │   │   │   └── 📂 com/
│   │   │   │       └── 📂 portfolio/
│   │   │   │           ├── 📂 config/
│   │   │   │           │   ├── WebConfig.java
│   │   │   │           │   └── SwaggerConfig.java
│   │   │   │           ├── 📂 controllers/
│   │   │   │           │   ├── AlgorithmController.java
│   │   │   │           │   ├── SortingController.java
│   │   │   │           │   └── PathfindingController.java
│   │   │   │           ├── 📂 services/
│   │   │   │           │   ├── AlgorithmService.java
│   │   │   │           │   ├── SortingService.java
│   │   │   │           │   └── PathfindingService.java
│   │   │   │           ├── 📂 models/
│   │   │   │           │   ├── SortingStep.java
│   │   │   │           │   ├── SortingResult.java
│   │   │   │           │   ├── PathNode.java
│   │   │   │           │   └── AlgorithmInfo.java
│   │   │   │           ├── 📂 algorithms/
│   │   │   │           │   ├── 📂 sorting/
│   │   │   │           │   │   ├── BubbleSort.java
│   │   │   │           │   │   ├── QuickSort.java
│   │   │   │           │   │   ├── MergeSort.java
│   │   │   │           │   │   └── HeapSort.java
│   │   │   │           │   └── 📂 pathfinding/
│   │   │   │           │       ├── AStar.java
│   │   │   │           │       ├── Dijkstra.java
│   │   │   │           │       └── BFS.java
│   │   │   │           ├── 📂 exceptions/
│   │   │   │           │   └── AlgorithmException.java
│   │   │   │           ├── 📂 utils/
│   │   │   │           │   └── AlgorithmUtils.java
│   │   │   │           └── AlgorithmServiceApplication.java
│   │   │   └── 📂 resources/
│   │   │       ├── application.properties
│   │   │       ├── application-dev.properties
│   │   │       ├── application-prod.properties
│   │   │       └── logback.xml
│   │   └── 📂 test/
│   │       └── 📂 java/
│   │           └── 📂 com/
│   │               └── 📂 portfolio/
│   │                   ├── 📂 unit/
│   │                   └── 📂 integration/
│   ├── pom.xml
│   ├── Dockerfile
│   └── .gitignore
│
├── 📂 docs/                          # Documentation
│   ├── API.md
│   ├── ARCHITECTURE.md
│   ├── DEPLOYMENT.md
│   ├── CONTRIBUTING.md
│   └── diagrams/
│
├── 📂 scripts/                       # Build & Deploy Scripts
│   ├── deploy-frontend.sh
│   ├── deploy-backend.sh
│   ├── deploy-java.sh
│   └── setup-local.sh
│
├── 📂 .github/                       # GitHub Configuration
│   ├── 📂 workflows/
│   │   ├── frontend-deploy.yml
│   │   ├── backend-test.yml
│   │   └── java-test.yml
│   ├── ISSUE_TEMPLATE/
│   └── PULL_REQUEST_TEMPLATE.md
│
├── .gitignore
├── README.md
├── LICENSE
├── TODO.md
├── IMPLEMENTATION_PLAN.md
├── QUICK_START.md
└── PROJECT_STRUCTURE.md
```

## 📝 File Naming Conventions

### Angular (TypeScript)
- **Components**: `kebab-case` (e.g., `user-profile.component.ts`)
- **Services**: `kebab-case` (e.g., `api.service.ts`)
- **Models**: `kebab-case` (e.g., `project.model.ts`)
- **Modules**: `kebab-case` (e.g., `app-routing.module.ts`)

### Python
- **Files**: `snake_case` (e.g., `email_service.py`)
- **Classes**: `PascalCase` (e.g., `ProjectModel`)
- **Functions**: `snake_case` (e.g., `get_projects`)
- **Constants**: `UPPER_SNAKE_CASE` (e.g., `MAX_RETRIES`)

### Java
- **Files**: `PascalCase` (e.g., `AlgorithmService.java`)
- **Packages**: `lowercase` (e.g., `com.portfolio.services`)
- **Classes**: `PascalCase` (e.g., `SortingController`)
- **Methods**: `camelCase` (e.g., `sortArray`)

## 🎨 Style Guidelines

### SCSS Structure
```scss
// _variables.scss
$primary-color: #007bff;
$secondary-color: #6c757d;
$font-family-base: 'Roboto', sans-serif;

// _mixins.scss
@mixin flex-center {
  display: flex;
  justify-content: center;
  align-items: center;
}

// Component styles
.component-name {
  @include flex-center;
  color: $primary-color;
  
  &__element {
    // BEM naming convention
  }
  
  &--modifier {
    // BEM modifier
  }
}
```

## 🔧 Configuration Files

### Angular Environment
```typescript
// environment.ts
export const environment = {
  production: false,
  apiUrl: 'http://localhost:8000/api/v1',
  algorithmApiUrl: 'http://localhost:8080/api',
  githubToken: 'your-dev-token'
};
```

### Python Configuration
```python
# core/config.py
from pydantic import BaseSettings

class Settings(BaseSettings):
    PROJECT_NAME: str = "Portfolio API"
    VERSION: str = "1.0.0"
    API_V1_STR: str = "/api/v1"
    DATABASE_URL: str
    SECRET_KEY: str
    
    class Config:
        env_file = ".env"
```

### Java Properties
```properties
# application.properties
server.port=8080
spring.application.name=algorithm-service
spring.profiles.active=dev

# CORS
cors.allowed.origins=http://localhost:4200,https://yourdomain.com
```

## 📦 Module Organization

### Angular Modules
1. **Core Module**: Singleton services, guards
2. **Shared Module**: Common components, pipes, directives
3. **Feature Modules**: Page-specific modules
4. **Routing Module**: Application routing

### Python Packages
1. **api**: REST endpoints
2. **core**: Configuration, security
3. **models**: Database models
4. **schemas**: Request/Response schemas
5. **services**: Business logic

### Java Packages
1. **controllers**: REST controllers
2. **services**: Business logic
3. **models**: Data models
4. **algorithms**: Algorithm implementations
5. **utils**: Helper classes

## 🚀 Best Practices

1. **Keep components small and focused**
2. **Use dependency injection**
3. **Follow SOLID principles**
4. **Write unit tests alongside code**
5. **Document complex logic**
6. **Use meaningful variable names**
7. **Implement error handling**
8. **Add logging for debugging**
9. **Version your APIs**
10. **Keep secrets in environment variables**

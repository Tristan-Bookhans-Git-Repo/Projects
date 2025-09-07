# Portfolio Backend API

FastAPI backend for the portfolio website.

## 🚀 Quick Start

### Prerequisites
- Python 3.11+
- pip

### Installation

1. Create virtual environment:
```bash
python -m venv venv
# Windows
venv\Scripts\activate
# Mac/Linux
source venv/bin/activate
```

2. Install dependencies:
```bash
pip install -r requirements.txt
```

3. Copy environment variables:
```bash
cp .env.example .env
# Edit .env with your settings
```

4. Run the server:
```bash
uvicorn app.main:app --reload
```

The API will be available at `http://localhost:8000`

## 📚 API Documentation

Once running, visit:
- Swagger UI: `http://localhost:8000/docs`
- ReDoc: `http://localhost:8000/redoc`

## 🔧 API Endpoints

### Projects
- `GET /api/v1/projects` - Get all projects
- `GET /api/v1/projects/{id}` - Get project by ID
- `GET /api/v1/projects/featured` - Get featured projects

### Skills
- `GET /api/v1/skills` - Get all skills
- `GET /api/v1/skills/by-category` - Get skills grouped by category
- `GET /api/v1/skills/categories` - Get skill categories

### GitHub
- `GET /api/v1/github/stats` - Get GitHub statistics
- `GET /api/v1/github/repos` - Get repositories
- `GET /api/v1/github/languages` - Get language distribution
- `GET /api/v1/github/contributions` - Get contribution data

### Contact
- `POST /api/v1/contact` - Send contact message

## 🐳 Docker

Build and run with Docker:
```bash
docker build -t portfolio-backend .
docker run -p 8000:8000 --env-file .env portfolio-backend
```

## 🧪 Testing

Run tests:
```bash
pytest
```

With coverage:
```bash
pytest --cov=app
```

## 📝 Environment Variables

See `.env.example` for all available configuration options.

Key variables:
- `GITHUB_USERNAME` - Your GitHub username
- `GITHUB_TOKEN` - GitHub personal access token (optional, for higher rate limits)
- `EMAIL_*` - Email configuration for contact form

## 🏗️ Project Structure

```
backend/
├── app/
│   ├── api/          # API endpoints
│   ├── core/         # Core configuration
│   ├── schemas/      # Pydantic models
│   ├── services/     # Business logic
│   └── main.py       # FastAPI app
├── tests/            # Test files
├── .env              # Environment variables
└── requirements.txt  # Dependencies
```

## 🚀 Deployment

### Render.com
1. Connect GitHub repository
2. Set environment variables
3. Deploy

### Railway
1. Connect GitHub repository
2. Add environment variables
3. Deploy

### Heroku
```bash
heroku create your-app-name
heroku config:set KEY=value
git push heroku main
```

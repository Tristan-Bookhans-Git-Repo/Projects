"""
Project service for business logic
"""
from typing import List, Optional
from app.schemas.project import Project, ProjectResponse


class ProjectService:
    """Service for managing projects"""
    
    def __init__(self):
        # Mock data for now - replace with database later
        self.projects = [
            {
                "id": 1,
                "title": "Trading Bot",
                "description": "An automated trading bot using machine learning algorithms to predict forex market movements and execute trades.",
                "short_description": "ML-powered forex trading system",
                "technologies": ["Python", "TensorFlow", "pandas", "NumPy", "Flask"],
                "github_url": "https://github.com/yourusername/trading-bot",
                "live_url": None,
                "image_url": "/assets/images/trading-bot.png",
                "featured": True
            },
            {
                "id": 2,
                "title": "Discord Bot",
                "description": "A feature-rich Discord bot with AI capabilities, including natural language processing and automated moderation.",
                "short_description": "AI-powered Discord bot",
                "technologies": ["Python", "Discord.py", "OpenAI API", "SQLite"],
                "github_url": "https://github.com/yourusername/discord-bot",
                "live_url": None,
                "image_url": "/assets/images/discord-bot.png",
                "featured": False
            },
            {
                "id": 3,
                "title": "Game of Life",
                "description": "An interactive implementation of Conway's Game of Life with customizable rules and patterns.",
                "short_description": "Conway's Game of Life simulation",
                "technologies": ["JavaScript", "HTML5", "CSS3", "Canvas API"],
                "github_url": "https://github.com/yourusername/game-of-life",
                "live_url": "https://yourusername.github.io/game-of-life",
                "image_url": "/assets/images/game-of-life.png",
                "featured": True
            },
            {
                "id": 4,
                "title": "Arduino Projects",
                "description": "Collection of IoT projects using Arduino, including home automation and sensor monitoring systems.",
                "short_description": "IoT and embedded systems projects",
                "technologies": ["C++", "Arduino", "IoT", "Sensors"],
                "github_url": "https://github.com/yourusername/arduino-projects",
                "live_url": None,
                "image_url": "/assets/images/arduino.png",
                "featured": False
            }
        ]
    
    async def get_all_projects(self) -> List[ProjectResponse]:
        """Get all projects"""
        return [ProjectResponse(**project) for project in self.projects]
    
    async def get_project_by_id(self, project_id: int) -> Optional[ProjectResponse]:
        """Get a specific project by ID"""
        for project in self.projects:
            if project["id"] == project_id:
                return ProjectResponse(**project)
        return None
    
    async def get_featured_projects(self) -> List[ProjectResponse]:
        """Get featured projects"""
        featured = [p for p in self.projects if p.get("featured", False)]
        return [ProjectResponse(**project) for project in featured]

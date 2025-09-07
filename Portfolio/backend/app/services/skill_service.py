"""
Skill service for business logic
"""
from typing import List, Dict
from app.schemas.skill import Skill, SkillResponse, SkillCategory


class SkillService:
    """Service for managing skills"""
    
    def __init__(self):
        # Mock data for now - replace with database later
        self.skills = [
            # Languages
            {"id": 1, "name": "Python", "category": "Languages", "level": 90, "icon": "python", "years_experience": 4},
            {"id": 2, "name": "Java", "category": "Languages", "level": 85, "icon": "java", "years_experience": 3},
            {"id": 3, "name": "C++", "category": "Languages", "level": 75, "icon": "cplusplus", "years_experience": 2},
            {"id": 4, "name": "TypeScript", "category": "Languages", "level": 70, "icon": "typescript", "years_experience": 1},
            {"id": 5, "name": "JavaScript", "category": "Languages", "level": 80, "icon": "javascript", "years_experience": 3},
            
            # Frameworks
            {"id": 6, "name": "Angular", "category": "Frameworks", "level": 65, "icon": "angular", "years_experience": 0.5},
            {"id": 7, "name": "FastAPI", "category": "Frameworks", "level": 80, "icon": "fastapi", "years_experience": 2},
            {"id": 8, "name": "Flask", "category": "Frameworks", "level": 85, "icon": "flask", "years_experience": 3},
            {"id": 9, "name": "Spring Boot", "category": "Frameworks", "level": 70, "icon": "spring", "years_experience": 1},
            {"id": 10, "name": "React", "category": "Frameworks", "level": 60, "icon": "react", "years_experience": 1},
            
            # Databases
            {"id": 11, "name": "PostgreSQL", "category": "Databases", "level": 75, "icon": "postgresql", "years_experience": 2},
            {"id": 12, "name": "MongoDB", "category": "Databases", "level": 70, "icon": "mongodb", "years_experience": 1.5},
            {"id": 13, "name": "Redis", "category": "Databases", "level": 65, "icon": "redis", "years_experience": 1},
            
            # Tools
            {"id": 14, "name": "Git", "category": "Tools", "level": 85, "icon": "git", "years_experience": 4},
            {"id": 15, "name": "Docker", "category": "Tools", "level": 70, "icon": "docker", "years_experience": 2},
            {"id": 16, "name": "VS Code", "category": "Tools", "level": 90, "icon": "vscode", "years_experience": 4},
            
            # Cloud
            {"id": 17, "name": "AWS", "category": "Cloud", "level": 60, "icon": "aws", "years_experience": 1},
            {"id": 18, "name": "GitHub Actions", "category": "Cloud", "level": 75, "icon": "github", "years_experience": 2},
        ]
    
    async def get_all_skills(self) -> List[SkillResponse]:
        """Get all skills"""
        return [SkillResponse(**skill) for skill in self.skills]
    
    async def get_skills_by_category(self) -> Dict[str, List[SkillResponse]]:
        """Get skills grouped by category"""
        grouped = {}
        for skill in self.skills:
            category = skill["category"]
            if category not in grouped:
                grouped[category] = []
            grouped[category].append(SkillResponse(**skill))
        return grouped
    
    async def get_categories(self) -> List[str]:
        """Get all unique categories"""
        categories = set(skill["category"] for skill in self.skills)
        return sorted(list(categories))

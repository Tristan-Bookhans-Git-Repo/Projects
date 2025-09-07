"""
API Router that combines all endpoint routers
"""
from fastapi import APIRouter
from app.api.v1.endpoints import projects, skills, github, contact

api_router = APIRouter()

# Include all endpoint routers
api_router.include_router(projects.router, prefix="/projects", tags=["projects"])
api_router.include_router(skills.router, prefix="/skills", tags=["skills"])
api_router.include_router(github.router, prefix="/github", tags=["github"])
api_router.include_router(contact.router, prefix="/contact", tags=["contact"])

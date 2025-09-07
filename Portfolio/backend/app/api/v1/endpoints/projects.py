"""
Projects API endpoints
"""
from typing import List
from fastapi import APIRouter, HTTPException
from app.schemas.project import Project, ProjectCreate, ProjectResponse
from app.services.project_service import ProjectService

router = APIRouter()
project_service = ProjectService()


@router.get("/", response_model=List[ProjectResponse])
async def get_projects():
    """Get all projects"""
    try:
        projects = await project_service.get_all_projects()
        return projects
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))


@router.get("/{project_id}", response_model=ProjectResponse)
async def get_project(project_id: int):
    """Get a specific project by ID"""
    try:
        project = await project_service.get_project_by_id(project_id)
        if not project:
            raise HTTPException(status_code=404, detail="Project not found")
        return project
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))


@router.get("/featured/", response_model=List[ProjectResponse])
async def get_featured_projects():
    """Get featured projects"""
    try:
        projects = await project_service.get_featured_projects()
        return projects
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))

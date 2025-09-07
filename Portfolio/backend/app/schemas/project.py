"""
Project schemas for request/response validation
"""
from typing import List, Optional
from pydantic import BaseModel, Field
from datetime import datetime


class ProjectBase(BaseModel):
    """Base project schema"""
    title: str = Field(..., min_length=1, max_length=200)
    description: str = Field(..., min_length=1)
    short_description: Optional[str] = None
    technologies: List[str] = []
    featured: bool = False


class ProjectCreate(ProjectBase):
    """Schema for creating a project"""
    pass


class Project(ProjectBase):
    """Project schema with all fields"""
    id: int
    github_url: Optional[str] = None
    live_url: Optional[str] = None
    image_url: Optional[str] = None
    created_at: Optional[datetime] = None
    updated_at: Optional[datetime] = None
    
    class Config:
        from_attributes = True


class ProjectResponse(BaseModel):
    """Project response schema"""
    id: int
    title: str
    description: str
    short_description: Optional[str]
    technologies: List[str]
    github_url: Optional[str]
    live_url: Optional[str]
    image_url: Optional[str]
    featured: bool
    
    class Config:
        from_attributes = True

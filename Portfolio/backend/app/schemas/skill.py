"""
Skill schemas for request/response validation
"""
from typing import Optional
from pydantic import BaseModel, Field
from enum import Enum


class SkillCategory(str, Enum):
    """Skill categories"""
    LANGUAGES = "Languages"
    FRAMEWORKS = "Frameworks"
    DATABASES = "Databases"
    TOOLS = "Tools"
    CLOUD = "Cloud"
    OTHER = "Other"


class SkillBase(BaseModel):
    """Base skill schema"""
    name: str = Field(..., min_length=1, max_length=100)
    category: SkillCategory
    level: int = Field(..., ge=0, le=100)  # 0-100 proficiency
    icon: Optional[str] = None


class SkillCreate(SkillBase):
    """Schema for creating a skill"""
    pass


class Skill(SkillBase):
    """Skill schema with all fields"""
    id: int
    years_experience: Optional[float] = None
    
    class Config:
        from_attributes = True


class SkillResponse(BaseModel):
    """Skill response schema"""
    id: int
    name: str
    category: str
    level: int
    icon: Optional[str]
    years_experience: Optional[float]
    
    class Config:
        from_attributes = True

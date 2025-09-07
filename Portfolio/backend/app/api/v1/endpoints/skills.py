"""
Skills API endpoints
"""
from typing import List, Dict
from fastapi import APIRouter, HTTPException
from app.schemas.skill import Skill, SkillCategory, SkillResponse
from app.services.skill_service import SkillService

router = APIRouter()
skill_service = SkillService()


@router.get("/", response_model=List[SkillResponse])
async def get_skills():
    """Get all skills"""
    try:
        skills = await skill_service.get_all_skills()
        return skills
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))


@router.get("/by-category", response_model=Dict[str, List[SkillResponse]])
async def get_skills_by_category():
    """Get skills grouped by category"""
    try:
        skills = await skill_service.get_skills_by_category()
        return skills
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))


@router.get("/categories", response_model=List[str])
async def get_skill_categories():
    """Get all skill categories"""
    try:
        categories = await skill_service.get_categories()
        return categories
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))

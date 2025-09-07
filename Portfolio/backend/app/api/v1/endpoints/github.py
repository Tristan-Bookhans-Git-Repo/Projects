"""
GitHub API endpoints for fetching repository statistics
"""
from typing import Dict, Any
from fastapi import APIRouter, HTTPException
from app.services.github_service import GitHubService

router = APIRouter()
github_service = GitHubService()


@router.get("/stats", response_model=Dict[str, Any])
async def get_github_stats():
    """Get GitHub statistics for the user"""
    try:
        stats = await github_service.get_user_stats()
        return stats
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))


@router.get("/repos")
async def get_repositories():
    """Get all public repositories"""
    try:
        repos = await github_service.get_repositories()
        return repos
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))


@router.get("/languages")
async def get_language_stats():
    """Get programming language statistics"""
    try:
        languages = await github_service.get_language_distribution()
        return languages
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))


@router.get("/contributions")
async def get_contribution_graph():
    """Get contribution graph data"""
    try:
        contributions = await github_service.get_contributions()
        return contributions
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))

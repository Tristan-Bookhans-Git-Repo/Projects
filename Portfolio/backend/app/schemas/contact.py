"""
Contact schemas for request/response validation
"""
from pydantic import BaseModel, EmailStr, Field


class ContactMessage(BaseModel):
    """Contact message schema"""
    name: str = Field(..., min_length=1, max_length=100)
    email: EmailStr
    subject: str = Field(..., min_length=1, max_length=200)
    message: str = Field(..., min_length=10, max_length=5000)
    phone: str = Field(default=None, max_length=20)
    company: str = Field(default=None, max_length=100)


class ContactResponse(BaseModel):
    """Contact response schema"""
    success: bool
    message: str

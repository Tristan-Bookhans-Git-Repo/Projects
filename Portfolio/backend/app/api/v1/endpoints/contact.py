"""
Contact form API endpoints
"""
from fastapi import APIRouter, HTTPException, BackgroundTasks
from app.schemas.contact import ContactMessage, ContactResponse
from app.services.email_service import EmailService

router = APIRouter()
email_service = EmailService()


@router.post("/", response_model=ContactResponse)
async def send_contact_message(
    message: ContactMessage,
    background_tasks: BackgroundTasks
):
    """Send a contact message"""
    try:
        # Add email sending to background tasks
        if email_service.is_configured():
            background_tasks.add_task(
                email_service.send_contact_email,
                message
            )
        
        return ContactResponse(
            success=True,
            message="Your message has been sent successfully!"
        )
    except Exception as e:
        raise HTTPException(
            status_code=500,
            detail=f"Failed to send message: {str(e)}"
        )

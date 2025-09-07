"""
Email service for sending contact messages
"""
import smtplib
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart
from app.core.config import settings
from app.schemas.contact import ContactMessage


class EmailService:
    """Service for sending emails"""
    
    def __init__(self):
        self.enabled = settings.EMAIL_ENABLED
        self.host = settings.EMAIL_HOST
        self.port = settings.EMAIL_PORT
        self.user = settings.EMAIL_USER
        self.password = settings.EMAIL_PASSWORD
        self.from_email = settings.EMAIL_FROM or settings.EMAIL_USER
        self.to_email = settings.EMAIL_TO or settings.EMAIL_USER
    
    def is_configured(self) -> bool:
        """Check if email service is properly configured"""
        return (
            self.enabled and
            self.host and
            self.user and
            self.password
        )
    
    async def send_contact_email(self, message: ContactMessage) -> bool:
        """Send contact form email"""
        if not self.is_configured():
            print(f"Email service not configured. Message from {message.name}: {message.message}")
            return False
        
        try:
            # Create message
            msg = MIMEMultipart()
            msg['From'] = self.from_email
            msg['To'] = self.to_email
            msg['Subject'] = f"Portfolio Contact: {message.subject}"
            
            # Create email body
            body = f"""
            New contact message from your portfolio website:
            
            Name: {message.name}
            Email: {message.email}
            Phone: {message.phone or 'Not provided'}
            Company: {message.company or 'Not provided'}
            
            Subject: {message.subject}
            
            Message:
            {message.message}
            """
            
            msg.attach(MIMEText(body, 'plain'))
            
            # Send email
            with smtplib.SMTP(self.host, self.port) as server:
                server.starttls()
                server.login(self.user, self.password)
                server.send_message(msg)
            
            print(f"Email sent successfully to {self.to_email}")
            return True
            
        except Exception as e:
            print(f"Failed to send email: {str(e)}")
            return False

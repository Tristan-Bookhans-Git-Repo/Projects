# Fairylights Controller

A Python script to control WiFi-enabled LED fairy lights via the Tuya smart home cloud API.

## What it does

Sends commands to a Tuya-compatible smart light device to control power, colour (HSV), brightness, scene animations, and auto-shutoff timers — all from the command line.

## Tech stack

- **Python 3**
- **tinytuya** — Tuya cloud API wrapper

## Setup

1. Install dependencies:
   ```bash
   pip install tinytuya python-dotenv
   ```

2. Copy `.env.example` to `.env` and fill in your Tuya credentials:
   ```bash
   cp .env.example .env
   ```

3. Run:
   ```bash
   python test.py
   ```

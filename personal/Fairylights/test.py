import os
import tinytuya

# Load .env file
from dotenv import load_dotenv
load_dotenv()

API_REGION = os.getenv("TUYA_API_REGION", "eu")
API_KEY = os.getenv("TUYA_API_KEY")
API_SECRET = os.getenv("TUYA_API_SECRET")
DEVICE_ID = os.getenv("TUYA_DEVICE_ID")
LOCAL_KEY = os.getenv("TUYA_LOCAL_KEY")
DEVICE_IP = os.getenv("TUYA_DEVICE_IP")

# Local device connection (alternative to cloud)
# device = tinytuya.OutletDevice(
#     dev_id=DEVICE_ID,
#     address=DEVICE_IP,
#     local_key=LOCAL_KEY,
#     version=3.3
# )

cloud = tinytuya.Cloud(
    apiRegion=API_REGION,
    apiKey=API_KEY,
    apiSecret=API_SECRET,
    apiDeviceID=DEVICE_ID
)

# # Check status
# result = cloud.getstatus(DEVICE_ID)
# print(result)

# # Turn on
cloud.sendcommand(DEVICE_ID, {"commands": [{"code": "switch_led", "value": True}]})

# # Turn off
# cloud.sendcommand(DEVICE_ID, {"commands": [{"code": "switch_led", "value": False}]})
# result = cloud.getfunctions(DEVICE_ID)
# print(result)

# import json

# def send(commands):
#     cloud.sendcommand(DEVICE_ID, {"commands": commands})

# # On / Off
# def turn_on():
#     send([{"code": "switch_led", "value": True}])

# def turn_off():
#     send([{"code": "switch_led", "value": False}])

# # Solid colour — h=hue (0-360), s=saturation (0-1000), v=brightness (0-1000)
# def set_colour(h, s=1000, v=1000):
#     send([
#         {"code": "work_mode", "value": "colour"},
#         {"code": "colour_data_v2", "value": json.dumps({"h": h, "s": s, "v": v})}
#     ])

# # Built-in scene (1-8)
# def set_scene(scene_num):
#     send([
#         {"code": "work_mode", "value": "scene"},
#         {"code": "scene_data_v2", "value": json.dumps({"scene_num": scene_num, "scene_units": []})}
#     ])

# # Turn off after N seconds
# def set_countdown(seconds):
#     send([{"code": "countdown_1", "value": seconds}])


# # Example usage
# turn_on()
# set_colour(120)   # green
# set_colour(0)     # red
# set_colour(240)   # blue
# set_scene(1)      # built-in scene 1
# set_countdown(3600)  # turn off in 1 hour
# turn_off()

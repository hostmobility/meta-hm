#!/bin/sh

/bin/echo "netdev" > /sys/class/leds/mx4-wifi/trigger
/bin/echo "wlan0" > /sys/class/leds/mx4-wifi/device_name
/bin/echo "link tx rx" > /sys/class/leds/mx4-wifi/mode

/bin/echo "netdev" > /sys/class/leds/mx4-ct-wifi/trigger
/bin/echo "wlan0" > /sys/class/leds/mx4-ct-wifi/device_name
/bin/echo "link tx rx" > /sys/class/leds/mx4-ct-wifi/mode

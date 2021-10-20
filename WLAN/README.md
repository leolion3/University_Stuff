# Uni Wifi Setup

## Windows 8/10/11

*This guide uses Windows 11, it should be identical in other windows versions*

### Configuring Eduroam as WPA2-Enterprise

- Navigate to Settings > Network and Internet > Wi-Fi > Manage known networks 
- Click on "Add Network"
- Set the "Network name" to "eduroam"
- Set the "Security Type" to "WPA2-Enterprise AES"
- Set the "EAP Method" to "EAP-TTLS"
- Set the "Authentication method" to "Microsoft CHAP Version 2 (MS-CHAP v2)"
- Set "Your private identifier" to "eduroam@uni-bremen.de"
- Save the network

### Logging in

- Open your available Wi-Fi networks
- Click on "eduroam" and connect
- Click the "yes" button if asked whether or not you think this is the right network
- In the "Username" field enter "your_studip_name@uni-bremen.de"
- In the "Password" field enter your WLAN password (NOT your University password), which you can get on <a href="https://oracle-web.zfn.uni-bremen.de/secure/wlanpw">Here</a> (Link takes a while to load, Uni systems are slow af)
- You're all connected! Well done!

### Troubleshooting

- If required to enter a domain name on certain systems, enter "wlan.radius.uni-bremen.de"
- If the authentication method doesn't word, try PEAP with MS-CHAPv2 (Happens sometimes on Linux/Android)

## Android

- Open Wi-Fi settings
- Select "eduroam" and connect
- Android will open the Network's security settings
- Expand the "View more settings" at the bottom
- Set the "EAP method" to "PEAP"
- Set the "Identity" to "your_studip_name@uni-bremen.de"
- Set the "Password" to your WLAN Password (See above)
- Set "CA certificate" to "Don't validate"
- Set the "Domain" to "wlan.radius.uni-bremen.de"
- Set the "Phase 2 authentication" to "MSCHAPV2"
- Set the "Anonymous identity" to "eduroam@uni-bremen.de"
- Optional for further security: Set the "MAC address type" to "Randomized MAC" (Automatic on Android 9+)
- Hit the "Connect" button

### Troubleshooting

- On some devices you might have to choose "TTLS" instead of "PEAP" in the "EAP Method"
- You might have to set "CA certificate" to "Use system certificates"
- You might have to set the "Online certificate status" to "Request status" or a different validation type
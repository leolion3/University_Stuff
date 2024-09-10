
<h1 id="uni-wifi-setup">Uni Wifi Setup</h1>

## Windows 8/10

- Open `Settings` and navigate to `Network & Internet > Wi-Fi`.
- On the right, click on `Network and Sharing Center`.
- Click on `Set up a new connection or network`.
- Click on `Manually connect to a wireless network`.
- Set the `Network name` to `eduroam`.
- Set `Security type` to `WPA2-Enterprise`.
- Click `Next` and then on `Change connection settings`.
- Click on `Security`.
- Set `Choose a network authentication protocol` to `Microsoft: EAP-TTLS`.
- Click on `Settings` right next to it.
- Set the `Enable identity privacy` from `anonymous` to `eduroam@uni-bremen.de`.
- Set `Connect to these servers` to `wlan.radius.uni-bremen.de`.
- Under `Client authentication` set `Select a non-EAP method for authentication` to `Microsoft CHAP Version 2 (MS-CHAP v2)`.
- Exit by clicking `ok`.
- Click on `Advanced settings`.
- Tick the `Specify authentication mode` if it is unticked and set it to `User authentication`.
- Click `Ok` and close all remaining windows.
- Show the available Wifi networks and connect to `eduroam`.
- When prompted, enter your uni email and wifi password and hit connect.

## Windows 11

*This guide uses Windows 11, it should be identical in other windows versions*

### Configuring Eduroam as WPA2-Enterprise

- Navigate to `Settings > Network and Internet > Wi-Fi > Manage known networks`
- Click on `Add Network`
- Set the `Network name` to `eduroam`
- Set the `Security Type` to `WPA2-Enterprise AES`
- Set the `EAP Method` to `EAP-TTLS`
- Set the `Authentication method` to `Microsoft CHAP Version 2 (MS-CHAP v2)`
- Set `Your private identifier` to `eduroam@uni-bremen.de` (*)
- Save the network

(\*) If the private identifier is not available, you need to click save, then while connecting to the network click on `Network Settings > Advanced Network Settings > Network Adapter Options` then Double Click on the Wifi Adapter in the legacy Network Connections Menu and navigate to `Wireless Properties > Security` > Hit the `Settings` Button next to the `Network Authentication Method`. Check the `Enable identity privacy` option and enter `eduroam@uni-bremen.de` instead of `anonymous` and `wlan.radius.uni-bremen.de` under `Connect to these servers`. Save and exit, then log into the network again.

### Logging in

- Open your available Wi-Fi networks
- Click on `eduroam` and connect
- Click the `yes` button if asked whether or not you think this is the right network
- In the `Username` field enter `your_studip_name@uni-bremen.de`
- In the `Password` field enter your WLAN password (NOT your University password), which you can get on <a href="https://oracle-web.zfn.uni-bremen.de/secure/wlanpw">Here</a> (Link takes a while to load, Uni systems are slow af)
- You're all connected! Well done!

### Troubleshooting

- If required to enter a domain name on certain systems, enter `wlan.radius.uni-bremen.de`
- If the authentication method doesn't work, try PEAP with MS-CHAPv2 (Happens sometimes on Linux/Android)

## Android

- Open Wi-Fi settings
- Select `eduroam` and connect
- Android will open the Network's security settings
- Expand the `View more settings` at the bottom
- Set the `EAP method` to `PEAP`
- Set the `Identity` to `your_studip_name@uni-bremen.de`
- Set the `Password` to your WLAN Password (See above)
- Set `CA certificate` to `Don't validate`
- Set the `Domain` to `radius.wlan.uni-bremen.de`
- Set the `Phase 2 authentication` to `MSCHAPV2`
- Set the `Anonymous identity` to `eduroam@uni-bremen.de`
- Optional for further security: Set the `MAC address type` to `Randomized MAC` (Automatic on Android 9+)
- Hit the `Connect` button

### Troubleshooting

- On some devices you might have to choose `TTLS` instead of `PEAP` in the `EAP Method`
- You might have to set `CA certificate` to `Use system certificates` (or download the certificate manually)
- You might have to set the `Online certificate status` to `Request status` or a different validation type

## MacOS

On MacOS (11+) the setup process is quite straightforward:

- Download the [eduroam Configuration file](https://raw.githubusercontent.com/leolion3/University_Stuff/master/WLAN/data/eduroam-OS_X-Universitat_Bremen-eduroam_@uni-bremen.de.mobileconfig)
- Double click the file to install the wifi profile. 
	- It will prompt you for your username and password, enter the full email address as the username and your WiFi password (NOT your university password!).
- If prompted for setting up the anonymity setting, set the anonymous username to `eduroam@uni-bremen.de` 
- If prompted for the authentication server, enter `wlan.radius.uni-bremen.de`
- Connect to the eduroam WiFi network.

<a href="#uni-wifi-setup">Back to top</a>

# 🧠 EmoTitan

Web Service Integration: EMOTIV Insight EEG Headset with the ServiceNow Platform

Walkthrough Video https://youtu.be/fdpKAHlztZQ

EmoTitan is a groundbreaking project developed in 2017 using an Emotiv 5-channel EEG headset and its Java-based SDK. The system was designed to detect steady-state brainwave patterns — essentially cognitive "triggers" — and convert them into REST API calls to automate cloud-based tasks.

This project predates modern low-code tools like Node-RED, making it one of the first real-world examples of EEG-to-internet automation using direct neural input.

# 🚀 What It Does

Reads cognitive brainwave activity via Emotiv EEG

Detects stable patterns (e.g., focused or calm mental states)

Converts mental triggers into REST API calls

Sends those calls to cloud platforms (e.g., ServiceNow) to:

Create tasks

Approve requests

Trigger other automated workflows

# 🧠 Tech Stack

| Layer            | Technology                      |
|------------------|---------------------------------|
| Brain Interface  | Emotiv EEG (5-channel Insight)  |
| SDK              | Emotiv Java SDK                 |
| Backend Logic    | Custom-built Java App (EmoTitan)|
| REST Framework   | Java Spring Dot Library         |
| Transport        | Bluetooth / USB Stream          |
| Target Platform  | ServiceNow (or similar PaaS)    |


# 🧠 Architecture Diagram

           +---------------------+
           |   Human Mind        |
           |  (Focused State)    |
           +----------+----------+
                      |
                      v
           +---------------------+
           |  Emotiv EEG Device  |
           | (5-Channel Headset) |
           +----------+----------+
                      |
          Bluetooth / USB Data Stream
                      |
                      v
        +-----------------------------+
        |  Java Application (EmoTitan) |
        |------------------------------|
        | - Uses Emotiv Java SDK       |
        | - Detects steady brainwave   |
        |   patterns                   |
        | - Maps mental triggers to    |
        |   REST actions               |
        | - Built with Spring Dot Lib  |
        +--------------+--------------+
                       |
                       |  HTTP REST Call
                       v
        +-------------------------------+
        |   PaaS Platform (e.g.         |
        |   ServiceNow, Custom APIs)    |
        |-------------------------------|
        | - Creates Tasks               |
        | - Approves Requests           |
        | - Triggers Automations        |
        +-------------------------------+

# ✨ Why It Matters

Mind-as-Interface: Enables mental focus to trigger action

First-of-its-Kind: Built before tools like Node-RED were widely used

Platform-Agnostic: Can connect to any REST-capable system

Real Use Cases: Demonstrated in task approval and automation for enterprise systems

# 📜 Legacy & Vision

The project was inspired by the idea of becoming a real-world Jeti — someone who could control digital environments using thought alone.

“I didn’t want to push a button. I wanted to think — and have it happen.”

EmoTitan was the first step in proving that vision possible.

# 📘 Original Tutorial (Archived)

This is a tutorial to setup this Java application. An integration with Emotiv EEG headset - Insight and its SDK to send RESTful POST calls to a ServiceNow instance. Essentially, utilizing your cognitive thoughts to create an action that generates an incident ticket in ServiceNow.

Assumptions

You are a developer and/or have a working knowledge of a Java IDE tool coding with Java, REST APIs, and JSON formatting. This Java application is not exclusive to any one platform, but ServiceNow is my playground and the environment that I’m in day and day out. My App. EmoTitan has no UI — it is all code-based. I’m leaving the UI design creativity to you the developers! 😄

This is just the fundamentals to get you started in understanding the Emotiv APIs that I worked with. I’m very excited to share the work I’ve done — I hope you find it useful and/or feel inspired to create something on your own and share it.

Emotiv Website and GitHub

There are a few things that you’re going to need for this integration. You’ll need to head over to Emotiv and get an EEG headset. I used the Emotiv Insight. If your setup/workstation does not have Bluetooth, you may need to purchase a USB receiver which is also available from Emotiv.

You also need the Xavier Control Panel application as well as the emulator — Xavier Composer. The emulator is quite handy when you do not want to wear the headset all the time during testing. The composer can be downloaded from the Emotiv GitHub under tools and/or it comes with the Xavier Control Panel download from the Emotiv site. The versions that I’m using are 3.3.3 for both applications. I encourage you to get an understanding of how the Emotiv applications and the EEG headset work before attempting this integration — things will go smoother in my opinion.

Note: This IDE setup is for macOS and Windows 7 / 10

Thanks for playing and good luck!

EMOTIV INC: https://www.emotiv.com

CreatorCon Project Details: https://community.servicenow.com/docs/DOC-7069

👨‍💻 Created By Matthew Funderburg (@Force01)Innovator • Technologist • Creator of the first EEG-to-PaaS automation interface

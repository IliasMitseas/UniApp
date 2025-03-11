UniApp is a Java application developed as part of a project for the Hellenic Open University (HOU). 
It processes global university data using the University Domains and Names Data List API and provides a graphical user interface (GUI) for searching and managing universities.

![Desktop](https://github.com/user-attachments/assets/7386cddb-dd48-4e3f-ab4d-692641613ca3)

Features

Search for universities by name

Filter universities by country and apply additional criteria

Update university details and add extra information

Delete universities from the list

View and export search statistics as a PDF





Technologies Used

Java – Core implementation

Swing – GUI development

Java Persistence API (JPA) – Data storage

Apache Derby DB – Embedded database

Java.net.Http – Handling HTTP requests

The application retrieves university data via the University Domains and Names Data List API. 
For example, searching for universities in Greece uses the following API call:
http://universities.hipolabs.com/search?country=greece
The response is returned in JSON format.

How to Run

Clone the repository:
git clone https://github.com/Mitseas-Ilias/Uni_App.git
Open the project in NetBeans
Run UniApp.java

Notes

All necessary libraries are included locally within the project, so no additional installation is required.

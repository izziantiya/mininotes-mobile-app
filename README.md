# Mininotes - mobile application for taking notes

## About
The project was created as the final project of the Digital Department of the RTU MIREA.
It offers clean and efficient functionality, and is designed to distract the user as little as possible.

<br />

## :zap: Package Structure 

    com.izziantiya.mininotes # Root Package
    ├── di                   # Koin DI Modules 
    ├── domain               # Local Data Storage
    │   ├── database         # Database Instance and the Data Access Object for Room
    ├── model                # Model classes [Notes]
    ├── repo                 # Used to handle all data operations
    ├── view                 # Activity/Fragment View layer
    │   ├── about            # App's summary
    │   ├── home             # App's Home
    │   ├── notes            # Create and Edit notes
    │   ├── utils            # Base classes and extensions
    ├── helpers              # All extension functions and utilities

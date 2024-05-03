# Device Price Prediction System

This project integrates a Python-trained Logistic Regression Classifier model with a Spring Boot application to predict the prices of electronic devices based on their specifications. The model, trained in Python, is exposed as a Flask web service, which the Spring Boot application consumes to provide predictions through RESTful APIs.

## Prerequisites

- **Java JDK 11 or later**
- **Maven 3.6 or later**
- **Python 3.7 or later**
- **Flask**
- **Pandas**
- **Scikit-learn**
- **NumPy**

## Setup Instructions

### Setting Up the Python Service

1. **Install the required Python packages**:
   ```bash
   pip install flask pandas scikit-learn numpy

2. **Start the Flask server**:
- Navigate to the directory containing the Flask application.
- Run the application:
    ```bash
    python app.py


### Setting Up the Spring Boot Application

1.**Clone the repository**:

    git clone <repository-url>
    cd <repository-directory>

2.**Build the project with Maven**:

    mvn clean install
    
3.**Run the Spring Boot application**:

    mvn spring-boot:run

### API Endpoints
- **GET '/api/devices/'**: Retrieves a list of all devices.
- **GET '/api/devices/{id}'**: Retrieves details of a specific device by ID.
- **POST '/api/devices'**: Adds a new device.
- **POST '/api/predict/{id}'**: Predicts the price for a specific device and updates the device entity - with the predicted price.


### Usage Example
To predict the price of a device using the system, send a POST request with the device ID:

    curl -X POST http://localhost:8080/api/predict/{id}
    
Replace {id} with the actual ID of the device.

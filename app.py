from flask import Flask, request, jsonify
import pickle
import pandas as pd

app = Flask(__name__)

# Load your trained model
model = pickle.load(open('saved_models/device_price_model.joblib', 'rb'))

@app.route('/predict', methods=['POST'])
def predict():
    data = request.get_json(force=True)
    # Assuming data comes in as a JSON with appropriate features for the model
    df = pd.DataFrame(data, index=[0])
    prediction = model.predict(df)
    return jsonify(prediction.tolist())

if __name__ == '__main__':
    app.run(port=5000)


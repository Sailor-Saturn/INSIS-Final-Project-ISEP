var json = {
    "message": "startEvent",
    "tenantId": "-1234",
    "variables": [
        {
            "name": "problem",
            "value": "problem_csv_2"
        },
        {
            "name": "goals",
            "value": "goals_csv_2"
        },
        {
            "name": "title",
            "value": "title_csv_2"
        },
        {
            "name": "keywords",
            "value": "k1,k2,k3,k4"
        },
        {
            "name": "approaches",
            "value": "approaches_csv_2"
        },
        {
            "name": "technologies",
            "value": "k1,k2,k3,4"
        },
        {
            "name": "proponentUsername",
            "value": "proponent1"
        }
    ]
}
console.log('json', json);

json.variables.forEach(function(varObject) {
  var varName = varObject.name;
  if (varName == 'keywords' || varName == 'approaches' || varName == 'technologies') {
    var newValue = varObject.value.split(',');
  }
});

console.log('new json', json);



var log=mc.getServiceLog();
var jsonPayload=mc.getPayloadJSON();
jsonPayload.variables.forEach(function(varObject) {
var varName = varObject.name;
if (varName == 'keywords' || varName == 'approaches' || varName == 'technologies') {
    varObject.value = varObject.value.split(',');
  }
});
setPayloadJSON(jsonPayload);
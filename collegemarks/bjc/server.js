var express = require('express'),
    app = express();

var mysql = require('mysql');

 var connection = mysql.createConnection({
  host     : '127.0.0.1',
  port     : '3306',
  user     : 'root',
  password : 'root',
  database : 'bjc'
 });

 connection.connect( function(err){
if (err){ 
    throw err;
}
else {
    console.log('Connected');
}
 });

//Express 4
app.use(express.static(__dirname, '/'));

app.get('/allmarks', function(req, res) {
var marks = null;

 var queryString = 'SELECT * FROM results';
        connection.query(queryString, function(err, rows, fields) {
        if (err) throw err;
            marks = rows;
             res.json(marks);
    });
    //res.json(500, { error: 'An error has occurred!' });
});


app.listen(8080);
console.log('Express listening on port  amllik 8080');


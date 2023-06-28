const mysql = require('mysql');

const Connexion = mysql.createConnection({
    host:'localhost',
    user:'root',
    password:'',
    database:'internship'
});


module.exports = { Connexion } ;
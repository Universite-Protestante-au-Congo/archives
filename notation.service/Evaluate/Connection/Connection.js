const mysql = require('mysql');

const Connexion = mysql.createConnection({
    host:'localhost',
    user:'root',
    password:'',
    database:'archives'
});


module.exports = { Connexion } ;
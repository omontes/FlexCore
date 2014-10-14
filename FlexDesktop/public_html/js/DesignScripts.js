// se carga de la consulta de numero de paginas
//var paginas = 10;
// se carga de la consulta de datos
/**var datastring = [
    {
      "name": "Tiger Nixon",
      "position": "System Architect",
      "salary": "$320,800",
      "start_date": "2011/04/25",
      "office": "Edinburgh",
      "extn": "5421"
    },
    {
      "name": "Garrett Winters",
      "position": "Accountant",
      "salary": "$170,750",
      "start_date": "2011/07/25",
      "office": "Tokyo",
      "extn": "8422"
    },
    {
      "name": "Ashton Cox",
      "position": "Junior Technical Author",
      "salary": "$86,000",
      "start_date": "2009/01/12",
      "office": "San Francisco",
      "extn": "1562"
    },
    {
      "name": "Cedric Kelly",
      "position": "Senior Javascript Developer",
      "salary": "$433,060",
      "start_date": "2012/03/29",
      "office": "Edinburgh",
      "extn": "6224"
    },
    {
      "name": "Airi Satou",
      "position": "Accountant",
      "salary": "$162,700",
      "start_date": "2008/11/28",
      "office": "Tokyo",
      "extn": "5407"
    },
    {
      "name": "Brielle Williamson",
      "position": "Integration Specialist",
      "salary": "$372,000",
      "start_date": "2012/12/02",
      "office": "New York",
      "extn": "4804"
    },
    {
      "name": "Herrod Chandler",
      "position": "Sales Assistant",
      "salary": "$137,500",
      "start_date": "2012/08/06",
      "office": "San Francisco",
      "extn": "9608"
    },
    {
      "name": "Rhona Davidson",
      "position": "Integration Specialist",
      "salary": "$327,900",
      "start_date": "2010/10/14",
      "office": "Tokyo",
      "extn": "6200"
    },
    {
      "name": "Colleen Hurst",
      "position": "Javascript Developer",
      "salary": "$205,500",
      "start_date": "2009/09/15",
      "office": "San Francisco",
      "extn": "2360"
    },
    {
      "name": "Sonya Frost",
      "position": "Software Engineer",
      "salary": "$103,600",
      "start_date": "2008/12/13",
      "office": "Edinburgh",
      "extn": "1667"
    }
];**/
// cada tabla tiene un array de objetos que tiene dentro
//var datastringaux = [];

$(document).ready(function() {
    
    
});


// crea paginas vacias para dataTables
//atributos: array de strings con el nombre de los atributos que se muestran en la tabla
//data: json
//antes, despues: numero de paginas vacias a insertar antes y despues
function emptyPages(atributos, data, antes, despues) {
    var res = [];
    var emptyJSON = '{';
    var i = 0;
    for (i; i < atributos.length - 1; i++) {
        emptyJSON += atributos[i] + ': "", ';
    }
    emptyJSON += atributos[i] + ': "" }';
    var emptyJSONobj = JSON.parse(emptyJSON);
    while (data.length < 10)
        data.push(emptyJSONobj);
    for (j = 0; j < antes; j++) {
        for (i = 0; i < 10; i++) {
            res.push(emptyJSONobj);
        }
    }
    for (i = 0; i < data.length; i++) {
        res.push(data[i]);
    }
    for (j = 0; j < despues; j++) {
        for (i = 0; i < 10; i++) {
            res.push(emptyJSONobj);
        }
    }
    return(res);
}


////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////



$(document).ready(function() {
    $("#mytable #checkall").click(function() {
        if ($("#mytable #checkall").is(':checked')) {
            $("#mytable input[type=checkbox]").each(function() {
                $(this).prop("checked", true);
            });

        } else {
            $("#mytable input[type=checkbox]").each(function() {
                $(this).prop("checked", false);
            });
        }
    });
});

$(function() {
    $("[rel='tooltip']").tooltip();
});


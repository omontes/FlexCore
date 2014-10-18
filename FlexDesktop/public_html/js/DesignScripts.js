
    var rootURL = "http://192.168.43.53:8080/FlexCoreWS/webresources/";

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


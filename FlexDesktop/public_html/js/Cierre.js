
    //var rootURL = "http://192.168.0.28:8080/FlexCoreWS/webresources/";
    var rootURL = "http://localhost:8080/FlexCoreWS/webresources/";
    


function cierre(){
    postCierre();
    modalCierre();
}

function iniciar(){
    postIniciar();
    modalIniciar();
    
}




function modalCierre(){
    $('.ui.basic.small.modal.transition')
        .modal('show')
;
}


function modalIniciar(){
    $('#mode2')
        .modal('show')
;
}


function irVentanaPrincipal(){
    location.replace("index.html");
}



// POST un cuenta
    function postIniciar() {
        console.log('postIniciar');
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: rootURL + "cierre/crearCierre",
            dataType: "json",
            data: cuentaCierreToJSON(),
            success: function() {
            }
        });
    }
    
    // POST un cuenta
    function postCierre() {
        console.log('postCierre');
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: rootURL + "cierre/cerrarCierre",
            dataType: "json",
            data: cuentaCierreToJSON(),
            success: function() {
            }
        });
    }






function cuentaCierreToJSON() {
    return JSON.stringify({
        "fecha": "2014-11-05 14:42:21",
        "estadoCierre": "0"
    });
}

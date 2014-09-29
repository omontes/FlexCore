 // The root URL for the RESTful services
var rootURL = "http://localhost:8080/FlexCoreWS/webresources";

// Retrieve Employees list when application starts 
postClienteFisico();
//GET
function getClientes() {
    //console.log('getClientes');
    $.ajax({
        
        type: 'GET',
        url: rootURL + "/propositos/getPropositos",
        dataType: "json",
        success: function(data) {
            $('#h1').append("Consulta Realizada");
            //renderClientes(data);
        }
    });
}

//POST un cliente fisico
function postClienteFisico() {
    console.log('postCliente');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: rootURL + "/clientes/crearClientesFisicos",
        dataType: "json",
        data: clienteFisicoToJSON(),
         success: function(data) {
            $('#h1').append("Consulta Realizada");
            //renderClientes(data);
        }
       
    });
}

//JSON de cliente Fisico
function clienteFisicoToJSON() {
    var ol = JSON.stringify({
        "customerIF": "003",
        "nombre": "Maria",
        "direccion": "Barrio Escalante",
        "telCasa": "22920",
        "telOficina": "311821",
        "celular": "343354",
        "cedula": "198211",
        "fotografia": "not available",
        "primerApellido": "del",
        "segundoApellido": "mar",
    });
    alert(ol);
    return ol;
}

// POST un cliente cliente juridico
function postClienteJuridico() {
    console.log('postCliente');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: rootURL + "/clientes/crearClientesJuridicos",
        dataType: "json",
        data: clienteJuridicoToJSON(),
         success: function(data) {
            $('#h1').append("Consulta Realizada");
            //renderClientes(data);
        }
       
    });
}

//JSON de cliente Juridico
function clienteJuridicoToJSON() {
    var ol = JSON.stringify({
        "customerIF": "999",
        "nombre": "POLICE",
        "direccion": "casa azul",
        "telCasa": "2290",
        "telOficina": "311221",
        "celular": "343324",
        "cedulaJuridica": "192211"
    });
    alert(ol);
    return ol;
}

// POST un cuentaAhorroVIsta
function postCuentaAhorroVista() {
    console.log('postCliente');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: rootURL + "/cuentaAhorroVista/cuentaAhorroVista",
        dataType: "json",
        data: clienteJuridicoToJSON(),
         success: function(data) {
            $('#h1').append("Consulta Realizada");
            //renderClientes(data);
        }
       
    });
}

//JSON de cliente Juridico
function cuentaAhorroVistaToJSON() {
    var ol = JSON.stringify({
        "customerIF": "999",
        "nombre": "POLICE",
        "direccion": "casa azul",
        "telCasa": "2290",
        "telOficina": "311221",
        "celular": "343324",
        "cedulaJuridica": "192211"
    });
    alert(ol);
    return ol;
}
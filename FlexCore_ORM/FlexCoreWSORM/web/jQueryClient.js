// The root URL for the RESTful services
var rootURL = "http://localhost:8080/FlexCoreWSORM/webresources";

// Retrieve Employees list when application starts 

//postClienteFisico();

postClienteFisico();
//GET
function getClientes() {
    //console.log('getClientes');
    $.ajax({
        //ff
        
        type: 'GET',
        //url: rootURL + "/cuentaAhorroAutomatico/getCuentasAhorroAutomatico/1/1"
        //url: rootURL + "/cuentaAhorroAutomatico/getCuentasAutoPaginadosBusqueda/1/ALL/1234",
        //url: rootURL + "/cuenta/getCuentas/30",
        url: rootURL + "/tiempos/getTiempos",
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
        url: rootURL + "/cuentaAhorroAutomatico/crearCuentaAhorroAutomatico",
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
        "@type":"cuentaahorroautomatico",
        "isNULL":false,
        "cuenta":
                {   "cliente":{
                       "customerIF":1234,
                     },
                    "estadoCuenta":true,
                    "isNULL":false,
                    "saldoReal":1000,
                    "saldoTemporal":1000},
         "estadoAhorro":true,
         "montoAhorro":7777,
         "numCuentaDeduccion":25,
         "propositos":
                 {  "idcuentaPropositos":1
                },
        "tiempoAhorroMeses":10,
        "tiempoDeducciones":10,
        "tipostiempo":{"idTiempo":3}
    }
    );
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
    console.log('postCuentaAhorroVista');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: rootURL + "/cuentaAhorroVista/crearCuentaAhorroVista",
        dataType: "json",
        data: cuentaAhorroVistaToJSON(),
         success: function(data) {
            $('#h1').append("Consulta Realizada");
            //renderClientes(data);
        }
       
    });
}

//JSON de cliente Juridico
function cuentaAhorroVistaToJSON() {
    var ol = JSON.stringify({
        "numCuenta": "1",
        "descripcion": "Dinero de Drogas",
        "tipoMoneda": "1"
    });
    alert(ol);
    return ol;
}

// POST un cuentaAhorroVIsta
function postCuentaAhorroAutomatico() {
    console.log('postCuentaAhorroAutomatico');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: rootURL + "/cuentaAhorroAutomatico/crearCuentaAhorroAutomatico",
        dataType: "json",
        data: cuentaAhorroAutomaticoToJSON(),
         success: function(data) {
            $('#h1').append("Consulta Realizada");
            //renderClientes(data);
        }
       
    });
}

//JSON de cliente Juridico
function cuentaAhorroAutomaticoToJSON() {
    var ol = JSON.stringify({
        "numCuenta": "1",
        "tiempoDeducciones": "4",
        "tipoTiempo": "1",
        "fechaInicio": new java.sql.Date(cal.getTimeInMillis()),
        "tiempoAhorroMeses": "10",
        "numCuentaDeducciones": "1",
        "montoAhorro": "12.22",
        "estadoAhorro": "1"
    });
    alert(ol);
    return ol;
}

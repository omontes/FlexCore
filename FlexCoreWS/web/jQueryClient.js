 // The root URL for the RESTful services
var rootURL = "http://localhost:8080/FlexCoreWS/webresources";

// Retrieve Employees list when application starts 
getClientes();

function getClientes() {
    //console.log('getClientes');
    $.ajax({
        
        type: 'GET',
        url: rootURL + "/clientes/getClientes",
        dataType: "json",
        success: function(data) {
            $('#h1').append("Consulta Realizada");
            //renderClientes(data);
        }
    });
}
$(document).ready(function() {
    var rootURL = "http://localhost:8080/FlexCoreWS/webresources/";
    var paginas;
    var cliente_actual = 0;
    var stringBusqueda = "ALL";


    // GET paginas de los clientes fisicos
    function getPaginasFisicos(busqueda) {
        console.log('getCantidadClientesFisicos');
        $.ajax({
            type: 'GET',
            url: rootURL + "clientes/getCantidadClientesFisicosBusqueda/" + busqueda,
            dataType: "json",
            success: function(data) {
                paginas = Math.ceil(data / 10);
            }
        });
    }

// GET  clientes fisicos por pagina y busqueda
    function getClientesFisicos(pagina, busqueda) {
        console.log('getClientesFisicos');
        $.ajax({
            type: 'GET',
            url: rootURL + "clientes/getClientesFisicosPaginadosBusqueda/" + pagina + "/" + busqueda,
            dataType: "json",
            success: function(data) {
                var datastring = data;
                var datastringaux = [];
                datastringaux = emptyPages(['"customerIF"', '"cedula"', '"nombre"', '"direccion"', '"telCasa"'],
                        datastring, table_fisicos.page.info().page, paginas - 1 - table_fisicos.page.info().page);
                alert(datastring);
                table_fisicos.clear();
                table_fisicos.rows.add(datastringaux).draw(false);
            }
        });
    }




// GET paginas de los clientes juridicos
    function getPaginasJuridicos(busqueda) {
        console.log('getCantidadClientesJuridicos');
        $.ajax({
            type: 'GET',
            url: rootURL + "clientes/getCantidadClientesJuridicosBusqueda/" + busqueda,
            dataType: "json",
            success: function(data) {
                paginas = Math.ceil(data / 10);
            }
        });
    }

// GET todos los clientes juridicos
    function getClientesJuridicos(pagina, busqueda) {
        console.log('getClientesJuridicos');
        $.ajax({
            type: 'GET',
            url: rootURL + "clientes/getClientesJuridicosPaginadosBusqueda/" + pagina + "/" + busqueda,
            dataType: "json",
            success: function(data) {/**
             var datastring = data;
             var datastringaux = [];
             datastringaux = emptyPages(['"customerIF"', '"cedula"', '"nombre"', '"direccion"', '"telCasa"'],
             datastring, table_fisicos.page.info().page, paginas - 1 - table_fisicos.page.info().page);
             alert(datastring);
             table_fisicos.clear();
             table_fisicos.rows.add(datastringaux).draw(false);**/
            }
        });
    }

    var table_fisicos = $('#cli-fisicos-table').DataTable({
        "info": false,
        "lengthChange": false,
        "ordering": false,
        "bFilter": false,
        "columns": [
            {"data": "customerIF"},
            {"data": "cedula"},
            {"data": "nombre"},
            {"data": "direccion"},
            {"data": "telCasa"},
            {
                "class": 'photo',
                "data": null,
                "defaultContent": '',
                "width": "5%"
            },
            {
                "class": 'files',
                "data": null,
                "defaultContent": '',
                "width": "5%"
            },
            {
                "class": 'edit',
                "data": null,
                "defaultContent": '',
                "width": "5%"
            },
            {
                "class": 'delete',
                "data": null,
                "defaultContent": '',
                "width": "5%"
            }
        ]
    });
    getPaginasFisicos(stringBusqueda);
    getClientesFisicos(1, stringBusqueda);


    var table_juridicos = $('#cli-juridicos-table').DataTable({
        "info": false,
        "lengthChange": false,
        "ordering": false,
        "bFilter": false,
        "columns": [
            {"data": "name"},
            {"data": "position"},
            {"data": "salary"},
            {"data": "start_date"},
            {
                "class": 'files',
                "data": null,
                "defaultContent": '',
                "width": "5%"
            },
            {
                "class": 'edit',
                "data": null,
                "defaultContent": '',
                "width": "5%"
            },
            {
                "class": 'delete',
                "data": null,
                "defaultContent": '',
                "width": "5%"
            }
        ]
    });
    getPaginasJuridicos(stringBusqueda);
    getClientesJuridicos(1, stringBusqueda);

    $('#cli-fisicos-table').on('page.dt', function() {
        getClientesFisicos(table_fisicos.page.info().page, stringBusqueda);
    });
    $('#cli-fisicos-radio').on('click', function() {
        if (cliente_actual !== 0)
            cliente_actual = 0;
        getPaginasFisicos(stringBusqueda);
        getClientesFisicos(1, stringBusqueda);
    });

    $("#delete-value").hide();
    $(".cli-add").click(function() {
        $("#edit-cliente #Heading").html("Agregar Cliente");
        $("#edit-cliente #cedula").prop('disabled', false);
        $("#edit-cliente #cedula").val("");
        $("#edit-cliente #cuenta").val("");
        $("#edit-cliente #nombre").val("");
        $("#edit-cliente #telefono").val("");
        $("#edit-cliente #ruta").val("");
        $("#edit-cliente #puntos").val("");
        $("#edit-cliente #tipo").val("");
        $("#edit-cliente .btn-cli-post").show();
        $("#edit-cliente .btn-cli-update").hide();
    });
    $('#cli-fisicos tbody').on('click', 'td.edit', function() {
        console.log('gg');
        $('#edit-cliente').modal();
        var tr = $(this).closest('tr');
        var row = table_fisicos.row(tr);
        $("#edit-cliente #Heading").html("Editar Cliente");
        $("#edit-cliente #nombre").val(row.data().name);
        $("#edit-cliente .btn-cli-post").hide();
        $("#edit-cliente .btn-cli-update").show();
    });
    $(".btn-cli-post").click(function() {
        $('#edit-cliente').modal('hide');
        postCliente();
    });
    $(".btn-cli-update").click(function() {
        $('#edit-cliente').modal('hide');
        updateCliente();
    });
    $('body').on('click', '.cli-delete', function() {
        $("#delete-value").val($(this).parents("tr").children("#campo-cedula").html());
    });
    $(".btn-cli-delete").click(function() {
        $('#delete-cliente').modal('hide');
        deleteCliente();
    });
});



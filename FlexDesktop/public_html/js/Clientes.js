$(document).ready(function() {
    var paginasfisicos;
    var paginasjuridicos;
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
                paginasfisicos = Math.ceil(data / 10);
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
                datastringaux = emptyPages(['"customerIF"', '"cedula"', '"nombre"', '"primerApellido"', '"segundoApellido"', '"direccion"', '"telCasa"', '"telOficina"', '"celular"'],
                        datastring, table_fisicos.page.info().page, paginasfisicos - 1 - table_fisicos.page.info().page);
                table_fisicos.clear();
                table_fisicos.rows.add(datastringaux).draw(false);
            }
        });
    }

// POST un cliente
    function postClienteFisico() {
        console.log('postCliente');
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: rootURL + "clientes/crearClientesFisicos",
            dataType: "json",
            data: clienteFisicoToJSON(),
            success: function() {
                getPaginasFisicos(stringBusqueda);
                getClientesFisicos(table_juridicos.page.info().page + 1, stringBusqueda);
            }
        });
    }

// UPDATE un cliente
    function updateClienteFisico() {
        console.log('updateCliente');
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: rootURL + "clientes/updateFisico",
            dataType: "json",
            data: clienteFisicoToJSON(),
            success: function() {
                getPaginasFisicos(stringBusqueda);
                getClientesFisicos(table_juridicos.page.info().page + 1, stringBusqueda);
            }
        });
    }

// DELETE un cliente
    function deleteCliente() {
        console.log('deleteCliente');
        $.ajax({
            type: 'DELETE',
            url: rootURL + 'clientes/' + $("#delete-value").val(),
            success: function() {
                if (cliente_actual === 0) {
                    getPaginasFisicos(stringBusqueda);
                    getClientesFisicos(1, stringBusqueda);
                }
                if (cliente_actual === 1) {
                    getPaginasJuridicos(stringBusqueda);
                    getClientesJuridicos(1, stringBusqueda);
                }
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
                paginasjuridicos = Math.ceil(data / 10);
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
            success: function(data) {
                var datastring = data;
                var datastringaux = [];
                datastringaux = emptyPages(['"customerIF"', '"cedulaJuridica"', '"nombre"', '"direccion"', '"telCasa"', '"telOficina"', '"celular"'],
                        datastring, table_juridicos.page.info().page, paginasjuridicos - 1 - table_juridicos.page.info().page);
                table_juridicos.clear();
                table_juridicos.rows.add(datastringaux).draw(false);
            }
        });
    }

    // POST un cliente
    function postClienteJuridico() {
        console.log('postCliente');
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: rootURL + "clientes/crearClientesJuridicos",
            dataType: "json",
            data: clienteJuridicoToJSON(),
            success: function() {
                getPaginasJuridicos(stringBusqueda);
                getClientesJuridicos(table_juridicos.page.info().page + 1, stringBusqueda);
            }
        });
    }

// UPDATE un cliente
    function updateClienteJuridico() {
        console.log('updateCliente');
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: rootURL + "clientes/updateJuridico",
            dataType: "json",
            data: clienteJuridicoToJSON(),
            success: function() {
                getPaginasJuridicos(stringBusqueda);
                getClientesJuridicos(table_juridicos.page.info().page + 1, stringBusqueda);
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
            {"data": "primerApellido"},
            {"data": "segundoApellido"},
            {"data": "direccion"},
            {"data": "telCasa"},
            {"data": "telOficina"},
            {"data": "celular"},
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
            {"data": "customerIF"},
            {"data": "cedulaJuridica"},
            {"data": "nombre"},
            {"data": "direccion"},
            {"data": "telCasa"},
            {"data": "telOficina"},
            {"data": "celular"},
            {
                "class": 'files',
                "data": null,
                "defaultContent": '',
                "width": "15%"
            },
            {
                "class": 'edit',
                "data": null,
                "defaultContent": '',
                "width": "15%"
            },
            {
                "class": 'delete',
                "data": null,
                "defaultContent": '',
                "width": "15%"
            }
        ]
    });

    $('#cli-fisicos-table').on('page.dt', function() {
        getPaginasFisicos(stringBusqueda);
        getClientesFisicos(table_fisicos.page.info().page + 1, stringBusqueda);
    });
    $('#cli-juridicos-table').on('page.dt', function() {
        getPaginasJuridicos(stringBusqueda);
        getClientesJuridicos(table_juridicos.page.info().page + 1, stringBusqueda);
    });
    $('#cli-fisicos-radio').on('click', function() {
        if (cliente_actual !== 0)
            cliente_actual = 0;
        getPaginasFisicos(stringBusqueda);
        getClientesFisicos(1, stringBusqueda);
        table_fisicos.draw();
    });

    $('#cli-juridicos-radio').on('click', function() {
        if (cliente_actual !== 1)
            cliente_actual = 1;
        getPaginasJuridicos(stringBusqueda);
        getClientesJuridicos(1, stringBusqueda);
        table_juridicos.draw();
    });

    (function() {
        'use strict';
        var $ = jQuery;
        $.fn.extend({
            filterTable: function() {
                return this.each(function() {
                    $(this).on('keyup', function(e) {
                        $('.filterTable_no_results').remove();
                        stringBusqueda = $(this).val().toLowerCase();
                        if (stringBusqueda === "")
                            stringBusqueda = "ALL";
                        if (cliente_actual === 0) {
                            getPaginasFisicos(stringBusqueda);
                            getClientesFisicos(1, stringBusqueda);
                            table_fisicos.draw();
                        }
                        else {
                            getPaginasJuridicos(stringBusqueda);
                            getClientesJuridicos(1, stringBusqueda);
                            table_juridicos.draw();
                        }
                    });
                });
            }
        });
        $('[data-action="filter"]').filterTable();
    })(jQuery);

    $(function() {
        // attach table filter plugin to inputs
        $('[data-action="filter"]').filterTable();

        $('.container').on('click', '.panel-heading span.filter', function(e) {
            var $this = $(this),
                    $panel = $this.parents('.panel');

            $panel.find('.panel-body').slideToggle();
            if ($this.css('display') !== 'none') {
                $panel.find('.panel-body input').focus();
            }
        });
        $('[data-toggle="tooltip"]').tooltip();
    });


    $("#delete-value").hide();
    $(".cli-add").click(function() {
        if (cliente_actual === 0) {
            $("#edit-cliente #Heading").html("Agregar Cliente Fisico");
            $("#edit-cliente #apellido1").prop('disabled', false);
            $("#edit-cliente #apellido2").prop('disabled', false);
        }
        if (cliente_actual === 1) {
            $("#edit-cliente #Heading").html("Agregar Cliente Juridico");
            $("#edit-cliente #apellido1").prop('disabled', true);
            $("#edit-cliente #apellido2").prop('disabled', true);
        }
        $("#edit-cliente #cif").val("");
        $("#edit-cliente #cedula").val("");
        $("#edit-cliente #nombre").val("");
        $("#edit-cliente #apellido1").val("");
        $("#edit-cliente #apellido2").val("");
        $("#edit-cliente #direccion").val("");
        $("#edit-cliente #telcasa").val("");
        $("#edit-cliente #telofi").val("");
        $("#edit-cliente #celular").val("");
        $("#edit-cliente .btn-cli-post").show();
        $("#edit-cliente .btn-cli-update").hide();
    });
    $('#cli-fisicos tbody').on('click', 'td.edit', function() {
        var tr = $(this).closest('tr');
        var row = table_fisicos.row(tr);
        $("#edit-cliente #apellido1").prop('disabled', false);
        $("#edit-cliente #apellido1").prop('disabled', false);
        $("#edit-cliente #Heading").html("Editar Cliente");
        $("#edit-cliente #cif").val(row.data().customerIF);
        $("#edit-cliente #cedula").val(row.data().cedula);
        $("#edit-cliente #nombre").val(row.data().nombre);
        $("#edit-cliente #apellido1").val(row.data().primerApellido);
        $("#edit-cliente #apellido2").val(row.data().segundoApellido);
        $("#edit-cliente #direccion").val(row.data().direccion);
        $("#edit-cliente #telcasa").val(row.data().telCasa);
        $("#edit-cliente #telofi").val(row.data().telOficina);
        $("#edit-cliente #celular").val(row.data().celular);
        $("#edit-cliente .btn-cli-post").hide();
        $("#edit-cliente .btn-cli-update").show();
        if ($("#edit-cliente #nombre").val() !== "")
            $('#edit-cliente').modal();
    });
    $('#cli-juridicos tbody').on('click', 'td.edit', function() {
        var tr = $(this).closest('tr');
        var row = table_juridicos.row(tr);
        $("#edit-cliente #apellido1").prop('disabled', true);
        $("#edit-cliente #apellido1").prop('disabled', true);
        $("#edit-cliente #Heading").html("Editar Cliente");
        $("#edit-cliente #cif").val(row.data().customerIF);
        $("#edit-cliente #cedula").val(row.data().cedulaJuridica);
        $("#edit-cliente #nombre").val(row.data().nombre);
        $("#edit-cliente #apellido1").val("");
        $("#edit-cliente #apellido2").val("");
        $("#edit-cliente #direccion").val(row.data().direccion);
        $("#edit-cliente #telcasa").val(row.data().telCasa);
        $("#edit-cliente #telofi").val(row.data().telOficina);
        $("#edit-cliente #celular").val(row.data().celular);
        $("#edit-cliente .btn-cli-post").hide();
        $("#edit-cliente .btn-cli-update").show();
        if ($("#edit-cliente #nombre").val() !== "")
            $('#edit-cliente').modal();
    });
    $(".btn-cli-post").click(function() {
        $('#edit-cliente').modal('hide');
        if (cliente_actual === 0) {
            postClienteFisico();
        }
        if (cliente_actual === 1) {
            postClienteJuridico();
        }
    });
    $(".btn-cli-update").click(function() {
        $('#edit-cliente').modal('hide');
        if (cliente_actual === 0) {
            updateClienteFisico();
        }
        if (cliente_actual === 1) {
            updateClienteJuridico();
        }
    });
    $('#cli-fisicos tbody').on('click', 'td.delete', function() {
        var tr = $(this).closest('tr');
        var row = table_fisicos.row(tr);
        $("#delete-value").val(row.data().customerIF);
        if ($("#delete-value").val() !== "")
            $('#delete-cliente').modal();
    });
    $('#cli-juridicos tbody').on('click', 'td.delete', function() {
        var tr = $(this).closest('tr');
        var row = table_juridicos.row(tr);
        $("#delete-value").val(row.data().customerIF);
        if ($("#delete-value").val() !== "")
            $('#delete-cliente').modal();
    });
    $(".btn-cli-delete").click(function() {
        $('#delete-cliente').modal('hide');
        deleteCliente();
    });
    $('#cli-fisicos tbody').on('click', 'td.photo', function() {
        var tr = $(this).closest('tr');
        var row = table_fisicos.row(tr);
        if (row.data().nombre !== "")
            $('#photo-cliente').modal();
    });
    $('#cli-fisicos tbody').on('click', 'td.files', function() {
        var tr = $(this).closest('tr');
        var row = table_fisicos.row(tr);
        if (row.data().nombre !== "")
            $('#files-cliente').modal();
    });
    $('#cli-juridicos tbody').on('click', 'td.files', function() {
        var tr = $(this).closest('tr');
        var row = table_juridicos.row(tr);
        if (row.data().nombre !== "")
            $('#files-cliente').modal();
    });
});

function clienteFisicoToJSON() {
    return JSON.stringify({
        "customerIF": $("#edit-cliente #cif").val(),
        "cedula": $("#edit-cliente #cedula").val(),
        "nombre": $("#edit-cliente #nombre").val(),
        "primerApellido": $("#edit-cliente #apellido1").val(),
        "segundoApellido": $("#edit-cliente #apellido2").val(),
        "direccion": $("#edit-cliente #direccion").val(),
        "telCasa": $("#edit-cliente #telcasa").val(),
        "telOficina": $("#edit-cliente #telofi").val(),
        "celular": $("#edit-cliente #celular").val()
    });
}

function clienteJuridicoToJSON() {
    return JSON.stringify({
        "customerIF": $("#edit-cliente #cif").val(),
        "cedulaJuridica": $("#edit-cliente #cedula").val(),
        "nombre": $("#edit-cliente #nombre").val(),
        "direccion": $("#edit-cliente #direccion").val(),
        "telCasa": $("#edit-cliente #telcasa").val(),
        "telOficina": $("#edit-cliente #telofi").val(),
        "celular": $("#edit-cliente #celular").val()
    });
}
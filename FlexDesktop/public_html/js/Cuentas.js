$(document).ready(function() {
    var rootURL = "http://localhost:8080/FlexCoreWS/webresources/";
    var paginasauto;
    var paginasvista;
    var cuenta_actual = 0;
    var stringBusqueda = "ALL";
    var stringCIF;


// GET paginas de los cuentas auto
    function login(CIF) {
        $.ajax({
            type: 'GET',
            url: rootURL + "clientes/verificarCliente/" + CIF,
            dataType: "json",
            success: function(data) {
                if (data === 1) {
                    getPaginasAuto(stringBusqueda, CIF);
                    getCuentasAuto(1, stringBusqueda, CIF);
                    $("#container-login").hide();
                    $("#container-cuentas").show();
                }
            }
        });
    }
    // GET paginas de los cuentas auto
    function getPaginasAuto(busqueda, CIF) {
        console.log('getCantidadCuentasAuto');
        $.ajax({
            type: 'GET',
            url: rootURL + "cuentas/getCantidadCuentasAutoBusqueda/" + busqueda + "/" + CIF,
            dataType: "json",
            success: function(data) {
                paginasauto = Math.ceil(data / 10);
            }
        });
    }

// GET  cuentas auto por pagina y busqueda
    function getCuentasAuto(pagina, busqueda, CIF) {
        console.log('getCuentasAuto');
        $.ajax({
            type: 'GET',
            url: rootURL + "cuentas/getCuentasAutoPaginadosBusqueda/" + pagina + "/" + busqueda + "/" + CIF,
            dataType: "json",
            success: function(data) {
                var datastring = data;
                var datastringaux = [];
                datastringaux = emptyPages(['"numCuenta"', '"fechaInicio"', '"idProposito"', '"montoAhorro"', '"numCuentaDeduccion"', '"tiempoAhorroMeses"', '"tiempoDeducciones"', '"tipoTiempo"'],
                        datastring, table_auto.page.info().page, paginasauto - 1 - table_auto.page.info().page);
                table_auto.clear();
                table_auto.rows.add(datastringaux).draw(false);
            }
        });
    }

// POST un cuenta
    function postCuentaAuto() {
        console.log('postCuenta');
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: rootURL + "cuentas/crearCuentasAuto",
            dataType: "json",
            data: cuentaAutoToJSON(),
            success: function() {
                getPaginasAuto(stringBusqueda);
                getCuentasAuto(1, stringBusqueda);
            }
        });
    }

// UPDATE un cuenta
    function updateCuentaAuto() {
        console.log('updateCuenta');
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: rootURL + "cuentas/updateAuto",
            dataType: "json",
            data: cuentaAutoToJSON(),
            success: function() {
                getPaginasAuto(stringBusqueda);
                getCuentasAuto(1, stringBusqueda);
            }
        });
    }

// DELETE un cuenta
    function deleteCuenta() {
        console.log('deleteCuenta');
        $.ajax({
            type: 'DELETE',
            url: rootURL + 'cuentas/' + $("#delete-value").val(),
            success: function() {
                if (cuenta_actual === 0) {
                    getPaginasAuto(stringBusqueda);
                    getCuentasAuto(1, stringBusqueda);
                }
                if (cuenta_actual === 1) {
                    getPaginasVista(stringBusqueda);
                    getCuentasVista(1, stringBusqueda);
                }
            }
        });
    }


// GET paginas de los cuentas vista
    function getPaginasVista(busqueda, CIF) {
        console.log('getCantidadCuentasVista');
        $.ajax({
            type: 'GET',
            url: rootURL + "cuentas/getCantidadCuentasVistaBusqueda/" + busqueda + "/" + CIF,
            dataType: "json",
            success: function(data) {
                paginasvista = Math.ceil(data / 10);
            }
        });
    }

// GET todos los cuentas vista
    function getCuentasVista(pagina, busqueda, CIF) {
        console.log('getCuentasVista');
        $.ajax({
            type: 'GET',
            url: rootURL + "cuentas/getCuentasVistaPaginadosBusqueda/" + pagina + "/" + busqueda + "/" + CIF,
            dataType: "json",
            success: function(data) {
                var datastring = data;
                var datastringaux = [];
                datastringaux = emptyPages(['"numCuenta"', '"descripcion"', '"tipoMoneda"'],
                        datastring, table_vista.page.info().page, paginasvista - 1 - table_vista.page.info().page);
                table_vista.clear();
                table_vista.rows.add(datastringaux).draw(false);
            }
        });
    }
    // POST un cuenta
    function postCuentaVista() {
        console.log('postCuenta');
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: rootURL + "cuentas/crearCuentasVista",
            dataType: "json",
            data: cuentaVistaToJSON(),
            success: function() {
                getPaginasVista(stringBusqueda);
                getCuentasVista(1, stringBusqueda);
            }
        });
    }

// UPDATE un cuenta
    function updateCuentaVista() {
        console.log('updateCuenta');
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: rootURL + "cuentas/updateVista",
            dataType: "json",
            data: cuentaVistaToJSON(),
            success: function() {
                getPaginasVista(stringBusqueda);
                getCuentasVista(1, stringBusqueda);
            }
        });
    }

    var table_auto = $('#cue-auto-table').DataTable({
        "info": false,
        "lengthChange": false,
        "ordering": false,
        "bFilter": false,
        "columns": [
            {"data": "numCuenta"},
            {"data": "fechaInicio"},
            {"data": "idProposito"},
            {"data": "montoAhorro"},
            {"data": "numCuentaDeduccion"},
            {"data": "tiempoAhorroMeses"},
            {"data": "tiempoDeducciones"},
            {"data": "tipoTiempo"},
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


    var table_vista = $('#cue-vista-table').DataTable({
        "info": false,
        "lengthChange": false,
        "ordering": false,
        "bFilter": false,
        "columns": [
            {"data": "numCuenta"},
            {"data": "descripcion"},
            {"data": "tipoMoneda"},
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

    $("#container-cuentas").hide();
    $('#login-cliente').on('click', function() {
        stringCIF=$('#cif').val();
        login(stringCIF);
    });

    $('#cue-auto-table').on('page.dt', function() {
        getPaginasAuto(stringBusqueda);
        getCuentasAuto(table_auto.page.info().page + 1, stringBusqueda);
    });
    $('#cue-vista-table').on('page.dt', function() {
        getPaginasVista(stringBusqueda);
        getCuentasVista(table_vista.page.info().page + 1, stringBusqueda);
    });
    $('#cue-auto-radio').on('click', function() {
        if (cuenta_actual !== 0)
            cuenta_actual = 0;
        getPaginasAuto(stringBusqueda);
        getCuentasAuto(1, stringBusqueda);
        table_auto.draw();
    });

    $('#cue-vista-radio').on('click', function() {
        if (cuenta_actual !== 1)
            cuenta_actual = 1;
        getPaginasVista(stringBusqueda);
        getCuentasVista(1, stringBusqueda);
        table_vista.draw();
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
                        if (cuenta_actual === 0) {
                            getPaginasAuto(stringBusqueda);
                            getCuentasAuto(1, stringBusqueda);
                            table_auto.draw();
                        }
                        else {
                            getPaginasVista(stringBusqueda);
                            getCuentasVista(1, stringBusqueda);
                            table_vista.draw();
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
    $(".cue-add").click(function() {
        if (cuenta_actual === 0) {
            $("#edit-cuenta #Heading").html("Agregar Cuenta Auto");
            $("#edit-cuenta #apellido1").prop('disabled', false);
            $("#edit-cuenta #apellido2").prop('disabled', false);
        }
        if (cuenta_actual === 1) {
            $("#edit-cuenta #Heading").html("Agregar Cuenta Vista");
            $("#edit-cuenta #apellido1").prop('disabled', true);
            $("#edit-cuenta #apellido2").prop('disabled', true);
        }
        $("#edit-cuenta #cif").val("");
        $("#edit-cuenta #cedula").val("");
        $("#edit-cuenta #nombre").val("");
        $("#edit-cuenta #apellido1").val("");
        $("#edit-cuenta #apellido2").val("");
        $("#edit-cuenta #direccion").val("");
        $("#edit-cuenta #telcasa").val("");
        $("#edit-cuenta #telofi").val("");
        $("#edit-cuenta #celular").val("");
        $("#edit-cuenta .btn-cue-post").show();
        $("#edit-cuenta .btn-cue-update").hide();
    });
    $('#cue-auto tbody').on('click', 'td.edit', function() {
        var tr = $(this).closest('tr');
        var row = table_auto.row(tr);
        $("#edit-cuenta #apellido1").prop('disabled', false);
        $("#edit-cuenta #apellido1").prop('disabled', false);
        $("#edit-cuenta #Heading").html("Editar Cuenta");
        $("#edit-cuenta #cif").val(row.data().customerIF);
        $("#edit-cuenta #cedula").val(row.data().cedula);
        $("#edit-cuenta #nombre").val(row.data().nombre);
        $("#edit-cuenta #apellido1").val(row.data().primerApellido);
        $("#edit-cuenta #apellido2").val(row.data().segundoApellido);
        $("#edit-cuenta #direccion").val(row.data().direccion);
        $("#edit-cuenta #telcasa").val(row.data().telCasa);
        $("#edit-cuenta #telofi").val(row.data().telOficina);
        $("#edit-cuenta #celular").val(row.data().celular);
        $("#edit-cuenta .btn-cue-post").hide();
        $("#edit-cuenta .btn-cue-update").show();
        if ($("#edit-cuenta #nombre").val() !== "")
            $('#edit-cuenta').modal();
    });
    $('#cue-vista tbody').on('click', 'td.edit', function() {
        var tr = $(this).closest('tr');
        var row = table_vista.row(tr);
        $("#edit-cuenta #apellido1").prop('disabled', true);
        $("#edit-cuenta #apellido1").prop('disabled', true);
        $("#edit-cuentacuenta #Heading").html("Editar Cuenta");
        $("#edit-cuenta #cif").val(row.data().customerIF);
        $("#edit-cuenta #cedula").val(row.data().cedulaJuridica);
        $("#edit-cuenta #nombre").val(row.data().nombre);
        $("#edit-cuenta #apellido1").val("");
        $("#edit-cuenta #apellido2").val("");
        $("#edit-cuenta #direccion").val(row.data().direccion);
        $("#edit-cuenta #telcasa").val(row.data().telCasa);
        $("#edit-cuenta #telofi").val(row.data().telOficina);
        $("#edit-cuenta #celular").val(row.data().celular);
        $("#edit-cuenta .btn-cue-post").hide();
        $("#edit-cuenta .btn-cue-update").show();
        if ($("#edit-cuenta #nombre").val() !== "")
            $('#edit-cuenta').modal();
    });
    $(".btn-cue-post").click(function() {
        $('#edit-cuenta').modal('hide');
        if (cuenta_actual === 0) {
            postCuentaAuto();
        }
        if (cuenta_actual === 1) {
            postCuentaVista();
        }
    });
    $(".btn-cue-update").click(function() {
        $('#edit-cuenta').modal('hide');
        if (cuenta_actual === 0) {
            updateCuentaAuto();
        }
        if (cuenta_actual === 1) {
            updateCuentaVista();
        }
    });
    $('#cue-auto tbody').on('click', 'td.delete', function() {
        var tr = $(this).closest('tr');
        var row = table_auto.row(tr);
        $("#delete-value").val(row.data().customerIF);
        if ($("#delete-value").val() !== "")
            $('#delete-cuenta').modal();
    });
    $('#cue-vista tbody').on('click', 'td.delete', function() {
        var tr = $(this).closest('tr');
        var row = table_vista.row(tr);
        $("#delete-value").val(row.data().customerIF);
        if ($("#delete-value").val() !== "")
            $('#delete-cuenta').modal();
    });
    $(".btn-cue-delete").click(function() {
        $('#delete-cuenta').modal('hide');
        deleteCuenta();
    });
    $('#cue-auto tbody').on('click', 'td.photo', function() {
        var tr = $(this).closest('tr');
        var row = table_auto.row(tr);
        if (row.data().nombre !== "")
            $('#photo-cuenta').modal();
    });
    $('#cue-auto tbody').on('click', 'td.files', function() {
        var tr = $(this).closest('tr');
        var row = table_auto.row(tr);
        if (row.data().nombre !== "")
            $('#files-cuenta').modal();
    });
    $('#cue-vista tbody').on('click', 'td.files', function() {
        var tr = $(this).closest('tr');
        var row = table_vista.row(tr);
        if (row.data().nombre !== "")
            $('#files-cuenta').modal();
    });
});

function cuentaAutoToJSON() {
    return JSON.stringify({
        "customerIF": $("#edit-cuenta #cif").val(),
        "cedula": $("#edit-cuenta #cedula").val(),
        "nombre": $("#edit-cuenta #nombre").val(),
        "primerApellido": $("#edit-cuenta #apellido1").val(),
        "segundoApellido": $("#edit-cuenta #apellido2").val(),
        "direccion": $("#edit-cuenta #direccion").val(),
        "telCasa": $("#edit-cuenta #telcasa").val(),
        "telOficina": $("#edit-cuenta #telofi").val(),
        "celular": $("#edit-cuenta #celular").val()
    });
}

function cuentaVistaToJSON() {
    return JSON.stringify({
        "customerIF": $("#edit-cuenta #cif").val(),
        "cedulaJuridica": $("#edit-cuenta #cedula").val(),
        "nombre": $("#edit-cuenta #nombre").val(),
        "direccion": $("#edit-cuenta #direccion").val(),
        "telCasa": $("#edit-cuenta #telcasa").val(),
        "telOficina": $("#edit-cuenta #telofi").val(),
        "celular": $("#edit-cuenta #celular").val()
    });
}
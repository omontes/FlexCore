$(document).ready(function() {
    var rootURL = "http://192.168.0.28:8080/FlexCoreWS/webresources/";
    var paginasauto;
    var paginasvista;
    var cuenta_actual = 0;
    var stringBusqueda = "ALL";
    var stringCIF;
    getTiempos();
    getPropositos();
    getMonedas();


// getPropositos
    function getPropositos() {
        $.ajax({
            type: 'GET',
            url: rootURL + "propositos/getPropositos",
            dataType: "json",
            success: function(data) {
                var out = "";
                for (var i = 0; i < data.length; i++) {
                    out += '<option value=' + data[i].idcuentaPropositos + '>' + data[i].descripcion + '</option>';
                }
                $("#propositos").html(out);
            }
        });
    }

// getTiempos
    function getTiempos() {
        $.ajax({
            type: 'GET',
            url: rootURL + "tiempos/getTiempos",
            dataType: "json",
            success: function(data) {
                var out = "";
                for (var i = 0; i < data.length; i++) {
                    out += '<option value=' + data[i].idTiempo + '>' + data[i].Descripcion + '</option>';
                }
                $("#tipotiempo").html(out);
            }
        });
    }

    // getPropositos
    function getMonedas() {
        $.ajax({
            type: 'GET',
            url: rootURL + "monedas/getMonedas",
            dataType: "json",
            success: function(data) {
                var out = "";
                for (var i = 0; i < data.length; i++) {
                    out += '<option value=' + data[i].idMoneda + '>' + data[i].descripcion + '</option>';
                }
                $("#tipomoneda").html(out);
            }
        });
    }

    // getCuentas
    function getCuentas(CIF) {
        $.ajax({
            type: 'GET',
            url: rootURL + "cuenta/getCuentas/" + CIF,
            dataType: "json",
            success: function(data) {
                var out = "";
                for (var i = 0; i < data.length; i++) {
                    out += '<option value=' + data[i].numCuenta + '>' + '#Cuenta: ' + data[i].numCuenta + '</option>';
                }
                $("#cuentadeduccion").html(out);
            }
        });
    }

// login
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
            url: rootURL + "cuentaAhorroAutomatico/getCantidadCuentasAutoBusqueda/" + busqueda + "/" + CIF,
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
            url: rootURL + "cuentaAhorroAutomatico/getCuentasAutoPaginadosBusqueda/" + pagina + "/" + busqueda + "/" + CIF,
            dataType: "json",
            success: function(data) {
                var datastring = data;
                var datastringaux = [];
                datastringaux = emptyPages(['"numCuenta"', '"fechaInicio"', '"idPropositoDescripcion"', '"saldoReal"', '"saldoTemporal"', '"montoAhorro"', '"numCuentaDeduccion"', '"tiempoAhorroMeses"', '"tiempoDeducciones"', '"tipoTiempoDescripcion"'],
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
            url: rootURL + "cuentaAhorroAutomatico/crearCuentaAhorroAutomatico",
            dataType: "json",
            data: cuentaAutoToJSON(),
            success: function() {
                getPaginasAuto(stringBusqueda, stringCIF);
                getCuentasAuto(1, stringBusqueda, stringCIF);
            }
        });
    }

// UPDATE un cuenta
    function updateCuentaAuto() {
        console.log('updateCuenta');
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: rootURL + "cuentaAhorroAutomatico/updateAuto",
            dataType: "json",
            data: cuentaAutoToJSON(),
            success: function() {
                getPaginasAuto(stringBusqueda, stringCIF);
                getCuentasAuto(1, stringBusqueda, stringCIF);
            }
        });
    }

// DELETE un cuenta
    function deleteCuenta() {
        console.log('deleteCuenta');
        $.ajax({
            type: 'DELETE',
            url: rootURL + 'cuenta/' + $("#delete-value").val(),
            success: function() {
                if (cuenta_actual === 0) {
                    getPaginasAuto(stringBusqueda, stringCIF);
                    getCuentasAuto(1, stringBusqueda, stringCIF);
                }
                if (cuenta_actual === 1) {
                    getPaginasVista(stringBusqueda, stringCIF);
                    getCuentasVista(1, stringBusqueda, stringCIF);
                }
            }
        });
    }


// GET paginas de los cuentas vista
    function getPaginasVista(busqueda, CIF) {
        console.log('getCantidadCuentasVista');
        $.ajax({
            type: 'GET',
            url: rootURL + "cuentaAhorroVista/getCantidadCuentasVistaBusqueda/" + busqueda + "/" + CIF,
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
            url: rootURL + "cuentaAhorroVista/getCuentasVistaPaginadosBusqueda/" + pagina + "/" + busqueda + "/" + CIF,
            dataType: "json",
            success: function(data) {
                var datastring = data;
                var datastringaux = [];
                datastringaux = emptyPages(['"numCuenta"', '"descripcion"', '"saldoReal"', '"saldoTemporal"', '"tipoMonedaDescripcion"'],
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
            url: rootURL + "cuentaAhorroVista/crearCuentasVista",
            dataType: "json",
            data: cuentaVistaToJSON(),
            success: function() {
                getPaginasVista(stringBusqueda, stringCIF);
                getCuentasVista(1, stringBusqueda, stringCIF);
            }
        });
    }

// UPDATE un cuenta
    function updateCuentaVista() {
        console.log('updateCuenta');
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: rootURL + "cuentaAhorroVista/updateVista",
            dataType: "json",
            data: cuentaVistaToJSON(),
            success: function() {
                getPaginasVista(stringBusqueda, stringCIF);
                getCuentasVista(1, stringBusqueda, stringCIF);
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
            {"data": "idPropositoDescripcion"},
            {"data": "saldoReal"},
            {"data": "saldoTemporal"},
            {"data": "montoAhorro"},
            {"data": "numCuentaDeduccion"},
            {"data": "tiempoAhorroMeses"},
            {"data": "tiempoDeducciones"},
            {"data": "tipoTiempoDescripcion"},
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
            {"data": "saldoReal"},
            {"data": "saldoTemporal"},
            {"data": "tipoMonedaDescripcion"},
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
        stringCIF = $('#cif').val();
        login(stringCIF);
    });

    $('#cue-auto-table').on('page.dt', function() {
        getPaginasAuto(stringBusqueda, stringCIF);
        getCuentasAuto(table_auto.page.info().page + 1, stringBusqueda, stringCIF);
    });
    $('#cue-vista-table').on('page.dt', function() {
        getPaginasVista(stringBusqueda, stringCIF);
        getCuentasVista(table_vista.page.info().page + 1, stringBusqueda, stringCIF);
    });
    $('#cue-auto-radio').on('click', function() {
        if (cuenta_actual !== 0)
            cuenta_actual = 0;
        getPaginasAuto(stringBusqueda, stringCIF);
        getCuentasAuto(1, stringBusqueda, stringCIF);
        table_auto.draw();
    });

    $('#cue-vista-radio').on('click', function() {
        if (cuenta_actual !== 1)
            cuenta_actual = 1;
        getPaginasVista(stringBusqueda, stringCIF);
        getCuentasVista(1, stringBusqueda, stringCIF);
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
                            getPaginasAuto(stringBusqueda, stringCIF);
                            getCuentasAuto(1, stringBusqueda, stringCIF);
                            table_auto.draw();
                        }
                        else {
                            getPaginasVista(stringBusqueda, stringCIF);
                            getCuentasVista(1, stringBusqueda, stringCIF);
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
            $("label").hide();
            $(".auto").show();
        }
        if (cuenta_actual === 1) {
            $("#edit-cuenta #Heading").html("Agregar Cuenta Vista");
            $("label").hide();
            $(".vista").show();
        }
        $("#edit-cuenta #cuenta").val('');
        $("#edit-cuenta #fecha").val('');
        $("#edit-cuenta #real").val('');
        $("#edit-cuenta #temporal").val('');
        $("#edit-cuenta #monto").val('');
        $("#edit-cuenta #meses").val('');
        $("#edit-cuenta #tiempo").val('');
        $("#edit-cuenta #descripcion").val('');
        $("#edit-cuenta .btn-cue-post").show();
        $("#edit-cuenta .btn-cue-update").hide();
    });
    $('#cue-auto tbody').on('click', 'td.edit', function() {
        var tr = $(this).closest('tr');
        var row = table_auto.row(tr);
        $("#edit-cuenta #Heading").html("Editar Cuenta");
        $("#edit-cuenta #cuenta").val(row.data().numCuenta);
        $("#edit-cuenta #fecha").val(row.data().fechaInicio);
        $("#edit-cuenta #real").val(row.data().saldoReal);
        $("#edit-cuenta #temporal").val(row.data().saldoTemporal);
        $("#edit-cuenta #monto").val(row.data().montoAhorro);
        $("#edit-cuenta #meses").val(row.data().tiempoAhorroMeses);
        $("#edit-cuenta #tiempo").val(row.data().tiempoDeducciones);
        $("label").hide();
        $(".auto").show();
        $("#edit-cuenta .btn-cue-post").hide();
        $("#edit-cuenta .btn-cue-update").show();
        if ($("#edit-cuenta #cuenta").val() !== "") {
            getCuentas(stringCIF);
            $('#edit-cuenta').modal();
        }
    });
    $('#cue-vista tbody').on('click', 'td.edit', function() {
        var tr = $(this).closest('tr');
        var row = table_vista.row(tr);
        $("#edit-cuenta #Heading").html("Editar Cuenta");
        $("#edit-cuenta #cuenta").val(row.data().numCuenta);
        $("#edit-cuenta #descripcion").val(row.data().descripcion);
        $("#edit-cuenta #real").val(row.data().saldoReal);
        $("#edit-cuenta #temporal").val(row.data().saldoTemporal);
        $("label").hide();
        $(".vista").show();
        $("#edit-cuenta .btn-cue-post").hide();
        $("#edit-cuenta .btn-cue-update").show();
        if ($("#edit-cuenta #cuenta").val() !== "")
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
        $("#delete-value").val(row.data().numCuenta);
        if ($("#delete-value").val() !== "")
            $('#delete-cuenta').modal();
    });
    $('#cue-vista tbody').on('click', 'td.delete', function() {
        var tr = $(this).closest('tr');
        var row = table_vista.row(tr);
        $("#delete-value").val(row.data().numCuenta);
        if ($("#delete-value").val() !== "")
            $('#delete-cuenta').modal();
    });
    
    
    $(".btn-cue-delete").click(function() {
        $('#delete-cuenta').modal('hide');
        deleteCuenta();
    });

});

function cuentaAutoToJSON() {
    return JSON.stringify({
        "numCuenta": $("#edit-cuenta #cuenta").val(),
        "idProposito": $('#propositos').find('option:selected').attr('value'),
        "saldoReal": $("#edit-cuenta #real").val(),
        "saldoTemporal": $("#edit-cuenta #temporal").val(),
        "montoAhorro": $("#edit-cuenta #monto").val(),
        "numCuentaDeduccion": $('#cuentadeduccion').find('option:selected').attr('value'),
        "tiempoAhorroMeses": $("#edit-cuenta #meses").val(),
        "tiempoDeducciones": $("#edit-cuenta #tiempo").val(),
        "tipoTiempo": $('#tipotiempo').find('option:selected').attr('value'),
        "idCliente": $('#cif').val()
        
    });
}

function cuentaVistaToJSON() {
    return JSON.stringify({
        "numCuenta": $("#edit-cuenta #cuenta").val(),
        "descripcion": $("#edit-cuenta #descripcion").val(),
        "saldoReal": $("#edit-cuenta #real").val(),
        "saldoTemporal": $("#edit-cuenta #temporal").val(),
        "tipoMoneda": $('#tipomoneda').find('option:selected').attr('value'),
        "idCliente": $('#cif').val()
    });
}
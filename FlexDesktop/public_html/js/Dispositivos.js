$(document).ready(function() {
    var rootURL = "http://192.168.0.28:8080/FlexCoreWS/webresources/";
    var stringCIF = "";
    var paginasDispositivos;
    



   
    // GET paginas de los cuentas vista
    function getPaginasDispositivos(CIF) {
        console.log('getCantidadCuentasVista');
        $.ajax({
            type: 'GET',
            url: rootURL + "cuentaAhorroVista/getCantidadCuentasVistaBusqueda/" + CIF,
            dataType: "json",
            success: function(data) {
                paginasDispositivos = Math.ceil(data / 10);
            }
        });
    }
    
    // POST un cuenta
    function postDispositivos() {
        console.log('postDispositivo');
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: rootURL + "dispositivoAfiliado/crearDispositivoAfiliado",
            dataType: "json",
            data: cuentaDispositivosToJSON(),
            success: function() {
                
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
            }
        });
    }
    
    
    
    $('#cue-auto tbody').on('click', 'td.delete', function() {
        var tr = $(this).closest('tr');
        var row = table_auto.row(tr);
        $("#delete-value").val(row.data().numCuenta);
        if ($("#delete-value").val() !== "")
            $('#delete-cuenta').modal();
    });
    
    
    
    var table_auto = $('#cue-auto-table').DataTable({
        "info": false,
        "lengthChange": false,
        "ordering": false,
        "bFilter": false,
        "columns": [
            {"data": "numCuenta"},
            {"data": "idTarjeta"},
            {
                "class": 'delete',
                "data": null,
                "defaultContent": '',
                "width": "5%"
            }
        ]
    });
    
    
    
    $(".btn-cue-delete").click(function() {
        $('#delete-cuenta').modal('hide');
        deleteCuenta();
    });
    
    
    $("#bt_AceptarModal").click(function() {
        postDispositivos();
        $('#edit-cuenta').modal('hide');
        $('#id_tarjeta').val("");
        $('#num_cuenta').val("");
        
    });

    
    
    });
    
    
    function cuentaDispositivosToJSON() {
    return JSON.stringify({
        "idCuenta": $('#id_tarjeta').val(),
        "idTarjeta": $('#num_cuenta').val()
        
    });
}
$(document).ready(function() {
    getDispositivos();

    // GET todos los dispositivoes
    function getDispositivos() {
        console.log('getDispositivos');
        $.ajax({
            type: 'GET',
            url: rootURL + "dispositivoAfiliado/getDispositivos",
            dataType: "json",
            success: function(data) {
                renderDispositivos(data);
            }
        });
    }

// POST un dispositivo
    function postDispositivo() {
        console.log('postDispositivo');
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: rootURL + "dispositivoAfiliado/crearDispositivoAfiliado",
            dataType: "json",
            data: dispositivoToJSON(),
            success: function() {
                getDispositivos();
            }
        });
    }

    $(".con-add").click(function() {
        $("#edit-dispositivo #Heading").html("Agregar dispositivo");
        $("#edit-dispositivo #tarjeta").val("");
        $("#edit-dispositivo #cuenta").val("");
        $("#edit-dispositivo #estado").val("");
        $("#edit-dispositivo .btn-con-post").show();
    });

    $(".btn-con-post").click(function() {
        $('#edit-dispositivo').modal('hide');
        postDispositivo();
    });

    function renderDispositivos(data) {
        var i;
        var out = "";
        for (i = 0; i < data.length; i++) {
            out += "<tr>";
            out += "<td id=\"campo-tarjeta\">" + data[i].idTarjeta + "</td>";
            out += "<td id=\"campo-cuenta\">" + data[i].idCuenta + "</td>";
            out += "</tr>";
        }
        $("#con-table-body").html(out);
    }

    function dispositivoToJSON() {
        return JSON.stringify({
            "idTarjeta": $("#edit-dispositivo #tarjeta").val(),
            "idCuenta": $("#edit-dispositivo #cuenta").val()
        });
    }
});
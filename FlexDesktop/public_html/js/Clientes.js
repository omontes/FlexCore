
            $(document).ready(function() {
                var cliente_actual = 0;
                datastringaux = emptyPages(['"name"', '"position"', '"salary"', '"start_date"', '"office"'],
                        datastring, 0, paginas - 1);
                var table_fisicos = $('#cli-fisicos-table').DataTable({
                    "info": false,
                    "lengthChange": false,
                    "ordering": false,
                    "bFilter": false,
                    "data": datastringaux,
                    "columns": [
                        {"data": "name"},
                        {"data": "position"},
                        {"data": "salary"},
                        {"data": "start_date"},
                        {"data": "office"},
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


                var table_juridicos = $('#cli-juridicos-table').DataTable({
                    "info": false,
                    "lengthChange": false,
                    "ordering": false,
                    "bFilter": false,
                    "data": datastringaux,
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

                $('#cli-fisicos-table').on('page.dt', function() {
                    datastringaux = emptyPages(['"name"', '"position"', '"salary"', '"start_date"', '"office"'],
                            datastring, table_fisicos.page.info().page, paginas - 1 - table_fisicos.page.info().page);
                    table_fisicos.clear();
                    table_fisicos.rows.add(datastringaux).draw(false);
                });
                $('#cli-juridicos-table').on('page.dt', function() {
                    datastringaux = emptyPages(['"name"', '"position"', '"salary"', '"start_date"'],
                            datastring, table_juridicos.page.info().page, paginas - 1 - table_juridicos.page.info().page);
                    table_juridicos.clear();
                    table_juridicos.rows.add(datastringaux).draw(false);
                });
                $('#cli-fisicos-radio').on('click', function() {
                    if (cliente_actual !== 0)
                        cliente_actual = 0;
                    console.log(cliente_actual);
                });
                $('#cli-juridicos-radio').on('click', function() {
                    if (cliente_actual !== 1)
                        cliente_actual = 1;
                    console.log(cliente_actual);
                });
                $("#delete-value").hide();
                //getClientes();
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
                $('body').on('click', '.cli-edit', function() {
                    $("#edit-cliente #Heading").html("Editar Cliente");
                    $("#edit-cliente #cedula").prop('disabled', true);
                    $("#edit-cliente #cedula").val($(this).parents("tr").children("#campo-cedula").html());
                    $("#edit-cliente #cuenta").val($(this).parents("tr").children("#campo-cuenta").html());
                    $("#edit-cliente #nombre").val($(this).parents("tr").children("#campo-nombre").html());
                    $("#edit-cliente #telefono").val($(this).parents("tr").children("#campo-telefono").html());
                    $("#edit-cliente #ruta").val($(this).parents("tr").children("#campo-ruta").html());
                    $("#edit-cliente #puntos").val($(this).parents("tr").children("#campo-puntos").html());
                    $("#edit-cliente #tipo").val($(this).parents("tr").children("#campo-tipo").html());
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




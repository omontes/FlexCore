/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao_interfaces;

import com.flexcore.dto.ClienteDTO;
import com.flexcore.dto.ClienteFisicoDTO;
import com.flexcore.dto.ClienteJuridicoDTO;
import java.util.ArrayList;

/**
 *
 * @author Oscar Montes
 */
public interface TransaccionesCliente {
    ArrayList<ClienteDTO> verClientes() throws Exception;
    ClienteFisicoDTO crearClienteFisico(ClienteFisicoDTO cliente) throws Exception;
    ClienteJuridicoDTO crearClienteJuridico(ClienteJuridicoDTO cliente) throws Exception;
    ClienteFisicoDTO actualizarClienteFisico(ClienteFisicoDTO cliente) throws Exception;
    ClienteJuridicoDTO actualizarClienteJuridico(ClienteJuridicoDTO cliente) throws Exception;
}
